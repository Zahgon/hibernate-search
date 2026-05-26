/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.client.opensearch.rest.impl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Set;
import org.hibernate.search.backend.elasticsearch.client.common.gson.entity.spi.ContentEncoder;
import org.hibernate.search.backend.elasticsearch.client.common.gson.entity.spi.GsonHttpEntityContentProvider;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.hc.core5.function.Supplier;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
import org.apache.hc.core5.http.nio.DataStreamChannel;

/**
 * Optimised adapter to encode GSON objects into HttpEntity instances.
 * The naive approach was using various StringBuilders; the objects we
 * need to serialise into JSON might get large and this was causing the
 * internal StringBuilder buffers to need frequent resizing and cause
 * problems with excessive allocations.
 *
 * Rather than trying to guess reasonable default sizes for these buffers,
 * we can defer the serialisation to write directly into the ByteBuffer
 * of the HTTP client, this has the additional benefit of making the
 * intermediary buffers short lived.
 *
 * The one complexity to watch for is flow control: when writing into
 * the output buffer chances are that not all bytes are accepted; in
 * this case we have to hold on the remaining portion of data to
 * be written when the flow control is re-enabled.
 *
 * A side effect of this strategy is that the total content length which
 * is being produced is not known in advance. Not reporting the length
 * in advance to the Apache Http client causes it to use chunked-encoding,
 * which is great for large blocks but not optimal for small messages.
 * For this reason we attempt to start encoding into a small buffer
 * upfront: if all data we need to produce fits into that then we can
 * report the content length; if not the encoding completion will be deferred
 * but not resetting so to avoid repeating encoding work.
 *
 * @author Sanne Grinovero (C) 2017 Red Hat Inc.
 */
final class ClientOpenSearchGsonHttpEntity extends GsonHttpEntityContentProvider implements HttpEntity, AsyncEntityProducer {

    private static final String CONTENT_TYPE = ContentType.APPLICATION_JSON.toString();

    public static HttpEntity toEntity(Gson gson, ElasticsearchRequest request) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ClientOpenSearchGsonHttpEntity(Gson gson, List<JsonObject> bodyParts) throws IOException {
        super(gson, bodyParts);
    }

    @Override
    public boolean isRepeatable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void failed(Exception cause) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isChunked() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<String> getTrailerNames() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getContentType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getContentEncoding() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isStreaming() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Supplier<List<? extends Header>> getTrailers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int available() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void produce(DataStreamChannel channel) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void releaseResources() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class ClientOpenSearchContentEncoder implements ContentEncoder {

        private final DataStreamChannel channel;

        public ClientOpenSearchContentEncoder(DataStreamChannel channel) {
            this.channel = channel;
        }

        @Override
        public int write(ByteBuffer src) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void complete() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean isCompleted() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
