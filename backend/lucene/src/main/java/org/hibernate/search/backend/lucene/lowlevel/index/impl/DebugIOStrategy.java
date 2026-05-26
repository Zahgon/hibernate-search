/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.index.impl;

import org.hibernate.search.backend.lucene.lowlevel.directory.spi.DirectoryHolder;
import org.hibernate.search.backend.lucene.lowlevel.reader.impl.IndexReaderProvider;
import org.hibernate.search.backend.lucene.lowlevel.reader.impl.NotSharedIndexReaderProvider;
import org.hibernate.search.backend.lucene.lowlevel.writer.impl.IndexWriterConfigSource;
import org.hibernate.search.backend.lucene.lowlevel.writer.impl.IndexWriterProvider;
import org.hibernate.search.backend.lucene.resources.impl.BackendThreads;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.util.common.reporting.EventContext;

public class DebugIOStrategy extends IOStrategy {

    public static DebugIOStrategy create(BackendThreads threads, FailureHandler failureHandler) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private DebugIOStrategy(BackendThreads threads, FailureHandler failureHandler) {
        super(threads, failureHandler);
    }

    @Override
    IndexWriterProvider createIndexWriterProvider(String indexName, EventContext eventContext, DirectoryHolder directoryHolder, IndexWriterConfigSource configSource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    IndexReaderProvider createIndexReaderProvider(DirectoryHolder directoryHolder, IndexWriterProvider indexWriterProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
