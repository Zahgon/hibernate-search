/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.directory.impl;

import java.io.IOException;
import org.hibernate.search.backend.lucene.lowlevel.directory.spi.DirectoryHolder;
import org.apache.lucene.store.ByteBuffersDirectory;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.LockFactory;

final class LocalHeapDirectoryHolder implements DirectoryHolder {

    private final LockFactory lockFactory;

    private Directory directory;

    LocalHeapDirectoryHolder(LockFactory lockFactory) {
        this.lockFactory = lockFactory;
    }

    @Override
    public void start() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Directory get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
