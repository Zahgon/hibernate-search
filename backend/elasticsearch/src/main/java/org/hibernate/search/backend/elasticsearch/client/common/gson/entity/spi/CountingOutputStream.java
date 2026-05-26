/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.client.common.gson.entity.spi;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.hibernate.search.util.common.annotation.Incubating;

@Incubating
final class CountingOutputStream extends FilterOutputStream {

    private long bytesWritten = 0L;

    public CountingOutputStream(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void write(byte[] b) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void count(int written) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getBytesWritten() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
