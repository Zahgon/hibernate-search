/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.client.rest5.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.search.backend.elasticsearch.client.common.gson.entity.spi.ContentEncoder;
import org.hibernate.search.backend.elasticsearch.client.common.gson.entity.spi.ContentProducer;
import org.hibernate.search.backend.elasticsearch.client.common.gson.entity.spi.HttpAsyncContentProducerInputStream;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequestInterceptor;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequestInterceptorContext;
import org.hibernate.search.util.common.AssertionFailure;
import org.apache.hc.client5.http.protocol.HttpClientContext;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpEntityContainer;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestInterceptor;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.net.URIBuilder;

record ClientRest5HttpRequestInterceptor(ElasticsearchRequestInterceptor elasticsearchRequestInterceptor) implements HttpRequestInterceptor {

    @Override
    public void process(HttpRequest request, EntityDetails entity, HttpContext context) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private record ClientRest5RequestContext(HttpRequest request, EntityDetails entity, HttpClientContext clientContext) implements ElasticsearchRequestInterceptorContext {

        private ClientRest5RequestContext(HttpRequest request, EntityDetails entity, HttpContext context) {
            this(request, entity, HttpClientContext.cast(context));
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

    private static class GsonEncoderDataStreamChannel implements DataStreamChannel {

        private final ContentEncoder encoder;

        public GsonEncoderDataStreamChannel(ContentEncoder encoder) {
            this.encoder = encoder;
        }

        @Override
        public void requestOutput() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int write(ByteBuffer src) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void endStream(List<? extends Header> trailers) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void endStream() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class ClientRest5GsonContentProducer implements ContentProducer {

        private final AsyncEntityProducer producer;

        public ClientRest5GsonContentProducer(AsyncEntityProducer producer) {
            this.producer = producer;
        }

        @Override
        public void produceContent(ContentEncoder encoder) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void close() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
