/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.search.backend.elasticsearch.client.common.gson.spi.GsonProvider;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequest;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchResponse;
import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.aliases.impl.IndexAliasDefinition;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.impl.IndexMetadata;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.RootTypeMapping;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.settings.impl.IndexSettings;
import org.hibernate.search.backend.elasticsearch.work.result.impl.ExistingIndexMetadata;
import org.hibernate.search.util.common.AssertionFailure;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class GetIndexMetadataWork extends AbstractNonBulkableWork<List<ExistingIndexMetadata>> {

    private GetIndexMetadataWork(Builder builder) {
        super(builder);
    }

    @Override
    protected List<ExistingIndexMetadata> generateResult(ElasticsearchWorkExecutionContext context, ElasticsearchResponse response) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Map<String, IndexAliasDefinition> getAliases(ElasticsearchWorkExecutionContext context, JsonObject index) {
        JsonElement aliases = index.get("aliases");
        if (aliases == null || !aliases.isJsonObject()) {
            throw new AssertionFailure("Elasticsearch API call succeeded, but the aliases weren't mentioned in the result: " + index);
        }
        GsonProvider gsonProvider = context.getGsonProvider();
        Map<String, IndexAliasDefinition> result = new LinkedHashMap<>();
        for (Map.Entry<String, JsonElement> entry : aliases.getAsJsonObject().entrySet()) {
            IndexAliasDefinition aliasDefinition = gsonProvider.getGson().fromJson(entry.getValue(), IndexAliasDefinition.class);
            result.put(entry.getKey(), aliasDefinition);
        }
        return result;
    }

    private IndexSettings getSettings(ElasticsearchWorkExecutionContext context, JsonObject index) {
        JsonElement settings = index.get("settings");
        if (settings == null || !settings.isJsonObject()) {
            throw new AssertionFailure("Elasticsearch API call succeeded, but the requested settings weren't mentioned in the result: " + index);
        }
        JsonElement indexSettings = settings.getAsJsonObject().get("index");
        if (indexSettings != null) {
            GsonProvider gsonProvider = context.getGsonProvider();
            return gsonProvider.getGson().fromJson(indexSettings, IndexSettings.class);
        } else {
            // Empty settings
            return new IndexSettings();
        }
    }

    private RootTypeMapping getMapping(ElasticsearchWorkExecutionContext context, JsonObject index) {
        JsonElement mappings = index.get("mappings");
        if (mappings != null) {
            GsonProvider gsonProvider = context.getGsonProvider();
            return gsonProvider.getGson().fromJson(mappings, RootTypeMapping.class);
        } else {
            return null;
        }
    }

    public static class Builder extends AbstractBuilder<Builder> {

        private final Set<URLEncodedString> indexNames = new LinkedHashSet<>();

        public static Builder create() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private Builder() {
            super(ElasticsearchRequestSuccessAssessor.DEFAULT_INSTANCE);
        }

        public Builder index(URLEncodedString indexName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected ElasticsearchRequest buildRequest() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public GetIndexMetadataWork build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
