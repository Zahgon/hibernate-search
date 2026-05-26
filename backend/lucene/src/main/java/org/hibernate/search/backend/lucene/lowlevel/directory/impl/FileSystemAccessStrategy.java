/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.directory.impl;

import java.io.IOException;
import java.nio.file.Path;
import org.hibernate.search.backend.lucene.lowlevel.directory.FileSystemAccessStrategyName;
import org.hibernate.search.util.common.AssertionFailure;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockFactory;
import org.apache.lucene.store.MMapDirectory;
import org.apache.lucene.store.NIOFSDirectory;

enum FileSystemAccessStrategy {

    AUTO {

        @Override
        public FSDirectory createDirectory(Path indexDir, LockFactory factory) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    , NIO {

        @Override
        public FSDirectory createDirectory(Path indexDir, LockFactory factory) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    , MMAP {

        @Override
        public FSDirectory createDirectory(Path indexDir, LockFactory factory) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ;

    public abstract FSDirectory createDirectory(Path indexDir, LockFactory factory) throws IOException;

    public static FileSystemAccessStrategy get(FileSystemAccessStrategyName name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
