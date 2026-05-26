/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.client.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequestInterceptor;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequestInterceptorContext;

record ClientJdkHttpRequestInterceptor(ElasticsearchRequestInterceptor elasticsearchRequestInterceptor) implements HttpRequestInterceptor {

    // https://docs.oracle.com/en/java/javase/25/docs/api/java.net.http/module-summary.html
    //
    // Host header is one of the restricted ^ so we skip it here:
    private static final Set<String> HEADERS_TO_IGNORE = Set.of("host");

    @Override
    public void process(HttpRequest.Builder request, HttpRequest.BodyPublisher bodyPublisher, HttpRequestInterceptorContext context) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private record ClientJavaRequestContext(HttpRequest request, HttpRequest.Builder original, HttpRequest.BodyPublisher bodyPublisher, HttpRequestInterceptorContext context) implements ElasticsearchRequestInterceptorContext {

        @Override
        public boolean hasContent() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public InputStream content() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String scheme() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String host() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Integer port() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String method() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String path() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Map<String, String> queryParameters() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void overrideHeaders(Map<String, List<String>> headers) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
