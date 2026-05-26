/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.client.common.gson.entity.spi;

import java.nio.ByteBuffer;
import org.hibernate.search.util.common.annotation.Incubating;

@Incubating
final class ByteBufferContentEncoder implements ContentEncoder {

    private final ByteBuffer buffer;

    private boolean complete = false;

    ByteBufferContentEncoder(ByteBuffer buffer) {
        this.buffer = buffer;
        if (!buffer.hasArray()) {
            throw new IllegalArgumentException(getClass().getName() + " requires a ByteBuffer backed by an array.");
        }
    }

    @Override
    public int write(ByteBuffer src) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void complete() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompleted() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
