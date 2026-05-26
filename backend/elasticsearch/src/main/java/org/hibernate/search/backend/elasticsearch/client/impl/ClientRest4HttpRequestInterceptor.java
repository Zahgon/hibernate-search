/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.client.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequestInterceptor;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequestInterceptorContext;
import org.hibernate.search.util.common.AssertionFailure;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpCoreContext;

record ClientRest4HttpRequestInterceptor(ElasticsearchRequestInterceptor elasticsearchRequestInterceptor) implements HttpRequestInterceptor {

    @Override
    public void process(HttpRequest request, HttpContext context) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private record ClientRestRequestContext(HttpRequest request, HttpCoreContext coreContext) implements ElasticsearchRequestInterceptorContext {

        private ClientRestRequestContext(HttpRequest request, HttpContext coreContext) {
            this(request, HttpCoreContext.adapt(coreContext));
        }

        @Override
        public boolean hasContent() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public InputStream content() throws IOException {
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
