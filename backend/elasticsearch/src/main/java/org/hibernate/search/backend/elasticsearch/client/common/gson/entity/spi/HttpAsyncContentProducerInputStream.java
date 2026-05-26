/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.client.common.gson.entity.spi;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.hibernate.search.util.common.annotation.Incubating;

@Incubating
public final class HttpAsyncContentProducerInputStream extends InputStream {

    private final ContentProducer contentProducer;

    private final ByteBuffer buffer;

    private final ContentEncoder contentEncoder;

    public HttpAsyncContentProducerInputStream(ContentProducer contentProducer, int bufferSize) {
        this.contentProducer = contentProducer;
        this.buffer = ByteBuffer.allocate(bufferSize);
        this.buffer.limit(0);
        this.contentEncoder = new ByteBufferContentEncoder(buffer);
    }

    @Override
    public int read() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void writeToBuffer() throws IOException {
        buffer.clear();
        contentProducer.produceContent(contentEncoder);
        buffer.flip();
    }

    private int readFromBuffer() {
        if (buffer.hasRemaining()) {
            return buffer.get();
        } else {
            return -1;
        }
    }

    private int readFromBuffer(byte[] bytes, int offset, int length) {
        int toRead = Math.min(buffer.remaining(), length);
        if (toRead > 0) {
            buffer.get(bytes, offset, toRead);
        }
        return toRead;
    }
}
