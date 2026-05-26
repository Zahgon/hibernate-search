/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.aws.impl;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequestInterceptorContext;
import software.amazon.awssdk.http.ContentStreamProvider;

public class HttpEntityContentStreamProvider implements ContentStreamProvider, Closeable {

    private final ElasticsearchRequestInterceptorContext requestContext;

    private InputStream previousStream;

    public HttpEntityContentStreamProvider(ElasticsearchRequestInterceptorContext requestContext) {
        this.requestContext = requestContext;
    }

    public static HttpEntityContentStreamProvider create(ElasticsearchRequestInterceptorContext requestContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public InputStream newStream() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
