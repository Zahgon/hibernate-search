/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.build.enforcer;

import static org.hibernate.search.build.enforcer.MavenProjectUtils.isAnyParentPublicParent;
import static org.hibernate.search.build.enforcer.MavenProjectUtils.isAnyParentRelocationParent;
import static org.hibernate.search.build.enforcer.MavenProjectUtils.isProjectDeploySkipped;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HexFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Named;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.maven.enforcer.rule.api.AbstractEnforcerRule;
import org.apache.maven.enforcer.rule.api.EnforcerRuleException;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;

// rule name - must start with lowercase character
@Named("dependencyManagementIncludesAllGroupIdArtifactsRule")
public class DependencyManagementIncludesAllGroupIdArtifactsRule extends AbstractEnforcerRule {

    /**
     * See <a href="https://central.sonatype.org/search/rest-api-guide/">Maven Central REST API</a>
     */
    private static final String BASE_URL_FORMAT = "https://central.sonatype.com/solrsearch/select?q=%s&core=gav&start=%d&rows=%d&wt=json";

    // This one here is more for a test purpose rather than to be used in "prod":
    private static final String CENTRAL_SEARCH_INTERNAL_URL = "https://central.sonatype.com/api/internal/browse/components";

    private static final String MAVEN_STATUS_URL = "https://status.maven.org/api/v2/summary.json";

    private static final int ROWS_PER_PAGE = 100;

    private static final int MAX_RETRIES = 5;

    private static final int RETRY_DELAY_SECONDS = 2;

    private static final String GAV_FORMAT = "%s:%s:%s";

    private static final String CACHE_DIR = ".cache/enforcer";

    private static final String CACHE_FILE_NAME = "dependency-management-includes-all.json";

    // Inject needed Maven components
    @Inject
    private MavenSession session;

    /**
     * Set of project to scan for dependencies. If empty -- all published project are included.
     */
    private Set<Dependency> includedProjects = new HashSet<>();

    /**
     * Set of extra dependencies to include in queries and hence the ones expected in the pom
     */
    private Set<Dependency> includedDependencies = new HashSet<>();

    /**
     * set of "found" dependencies that can be ignored.
     */
    private Set<Dependency> dependenciesToSkip = new HashSet<>();

    private HttpClient client = HttpClient.newBuilder().build();

    public void execute() throws EnforcerRuleException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private String computeInputHash(Set<Artifact> toQuery, Set<String> dependencies, Set<String> include) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            new TreeSet<>(toQuery).forEach(a -> digestEntry(digest, a.formattedString()));
            new TreeSet<>(dependencies).forEach(s -> digestEntry(digest, s));
            new TreeSet<>(include).forEach(s -> digestEntry(digest, s));
            dependenciesToSkip.stream().map(DependencyManagementIncludesAllGroupIdArtifactsRule::dependencyString).sorted().forEach(s -> digestEntry(digest, s));
            return HexFormat.of().formatHex(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            getLog().warn("SHA-256 not available, skipping cache");
            return "";
        }
    }

    private static void digestEntry(MessageDigest digest, String value) {
        digest.update(value.getBytes(StandardCharsets.UTF_8));
        digest.update((byte) 0);
    }

    private CacheData loadCache(Path cacheFile, Gson gson) {
        try {
            if (Files.exists(cacheFile)) {
                String json = Files.readString(cacheFile);
                return gson.fromJson(json, CacheData.class);
            }
        } catch (IOException | RuntimeException e) {
            getLog().warn("Failed to read enforcer cache, will re-fetch: " + e.getMessage());
        }
        return null;
    }

    private void writeCache(Path cacheFile, Gson gson, String inputHash, Set<Artifact> foundArtifacts) {
        try {
            Files.createDirectories(cacheFile.getParent());
            CacheData data = new CacheData(inputHash, foundArtifacts.stream().map(Artifact::formattedString).sorted().collect(Collectors.toList()));
            Files.writeString(cacheFile, gson.toJson(data));
            getLog().info("Enforcer cache written to " + cacheFile);
        } catch (IOException e) {
            getLog().warn("Failed to write enforcer cache: " + e.getMessage());
        }
    }

    private void mavenCentralInternalSearch(Artifact filter, Gson gson, Set<Artifact> foundArtifacts) throws EnforcerRuleException {
        CentralSearchRequest request = new CentralSearchRequest(filter);
        getLog().info("Fetching information for " + request);
        do {
            CentralSearchResponse response = post(gson, client, CENTRAL_SEARCH_INTERNAL_URL, request, CentralSearchResponse.class, CentralSearchResponse::empty);
            foundArtifacts.addAll(response.components.stream().map(Artifact::new).toList());
            if (request.nextPage() >= response.pageCount) {
                break;
            }
        } while (true);
    }

    private void mavenCentralSolrSearch(Artifact filter, Gson gson, Set<Artifact> foundArtifacts) throws EnforcerRuleException {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("g:").append(encodeValue(filter.g));
        if (filter.a != null && !filter.a.trim().isEmpty()) {
            queryBuilder.append("+AND+a:").append(encodeValue(filter.a));
        }
        if (filter.v != null && !filter.v.trim().isEmpty()) {
            queryBuilder.append("+AND+v:").append(encodeValue(filter.v));
        }
        int start = 0;
        int collectedSoFar = 0;
        do {
            String url = String.format(Locale.ROOT, BASE_URL_FORMAT, queryBuilder, start, ROWS_PER_PAGE);
            SearchResponse response = fetch(gson, url, SearchResponse.class, SearchResponse::empty);
            collectedSoFar += response.response.docs.size();
            foundArtifacts.addAll(response.response.docs);
            if (collectedSoFar == response.response.numFound || response.response.docs.isEmpty()) {
                break;
            }
            start++;
        } while (true);
    }

    private static String dependencyString(Dependency d) {
        return String.format(Locale.ROOT, GAV_FORMAT, d.getGroupId(), d.getArtifactId(), d.getVersion());
    }

    private static boolean shouldSkip(String gav, Set<Pattern> skipPatterns) {
        for (Pattern skipPattern : skipPatterns) {
            if (skipPattern.matcher(gav).matches()) {
                return true;
            }
        }
        return false;
    }

    private <T> T fetch(Gson gson, String url, Class<T> klass, Supplier<T> empty) throws EnforcerRuleException {
        return withRetry(() -> {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json").GET().build();
            getLog().info("Fetching from " + url);
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), klass);
        }, empty);
    }

    private <T> T post(Gson gson, HttpClient client, String url, CentralSearchRequest searchRequest, Class<T> klass, Supplier<T> empty) throws EnforcerRuleException {
        return withRetry(() -> {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(gson.toJson(searchRequest))).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), klass);
        }, empty);
    }

    private <T> T withRetry(ThrowingSupplier<T> action, Supplier<T> empty) throws EnforcerRuleException {
        for (int i = 0; i < MAX_RETRIES; i++) {
            try {
                return action.get();
            } catch (IOException e) {
                getLog().warn("Fetching failed. Retrying in " + RETRY_DELAY_SECONDS + "s... (Attempt " + (i + 1) + "/" + (MAX_RETRIES) + "): " + e.getMessage());
                try {
                    TimeUnit.SECONDS.sleep(RETRY_DELAY_SECONDS);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new EnforcerRuleException(ie);
                }
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                throw new EnforcerRuleException(ie);
            }
        }
        getLog().warn("Fetching from failed after " + (MAX_RETRIES) + " attempts.");
        return empty.get();
    }

    private String encodeValue(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

    private static class Artifact implements Comparable<Artifact> {

        String g;

        String a;

        String v;

        public Artifact(String g, String a, String v) {
            this.g = g;
            this.a = a;
            this.v = v;
        }

        public Artifact() {
        }

        public Artifact(CentralComponent centralComponent) {
            this.g = centralComponent.namespace;
            this.a = centralComponent.name;
            this.v = centralComponent.version;
        }

        public String formattedString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean equals(Object o) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int compareTo(Artifact o) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class SearchResponse {

        ResponseData response;

        static SearchResponse empty() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private record CacheData(String inputHash, List<String> foundArtifacts) {
    }

    public static class ResponseData {

        int numFound;

        int start;

        List<Artifact> docs;
    }

    private static class StatusSummary {

        public List<Component> components;

        private static class Component {

            public String id;

            public String name;

            // e.g., "operational", "degraded_performance", "major_outage"
            public String status;
        }

        boolean isSearchAvailable() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        static StatusSummary empty() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    // Central search API DTOs:
    static class CentralSearchRequest {

        public int page;

        public int size;

        public String searchTerm;

        public List<Object> filter;

        CentralSearchRequest(Artifact filter) {
            this.page = 0;
            this.size = 20;
            this.filter = null;
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("namespace:").append(filter.g);
            if (filter.a != null && !filter.a.trim().isEmpty()) {
                queryBuilder.append(" name:").append(filter.a);
            }
            if (filter.v != null && !filter.v.trim().isEmpty()) {
                queryBuilder.append(" version:").append(filter.v);
            }
            this.searchTerm = queryBuilder.toString();
        }

        int nextPage() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static class CentralSearchResponse {

        public List<CentralComponent> components;

        public int page;

        public int pageSize;

        public int pageCount;

        public int totalResultCount;

        public int totalCount;

        static CentralSearchResponse empty() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static class CentralComponent {

        public String id;

        public String namespace;

        public String name;

        public String version;
    }

    private interface ThrowingSupplier<T> {

        T get() throws IOException, InterruptedException;
    }
}
