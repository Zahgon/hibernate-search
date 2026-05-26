/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.index.impl;

import org.hibernate.search.backend.lucene.lowlevel.directory.spi.DirectoryHolder;
import org.hibernate.search.backend.lucene.lowlevel.reader.impl.IndexReaderProvider;
import org.hibernate.search.backend.lucene.lowlevel.writer.impl.IndexWriterConfigSource;
import org.hibernate.search.backend.lucene.lowlevel.writer.impl.IndexWriterProvider;
import org.hibernate.search.backend.lucene.resources.impl.BackendThreads;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.util.common.impl.SuppressingCloser;
import org.hibernate.search.util.common.reporting.EventContext;

public abstract class IOStrategy {

    final BackendThreads threads;

    final FailureHandler failureHandler;

    protected IOStrategy(BackendThreads threads, FailureHandler failureHandler) {
        this.threads = threads;
        this.failureHandler = failureHandler;
    }

    public IndexAccessorImpl createIndexAccessor(String indexName, EventContext eventContext, DirectoryHolder directoryHolder, IndexWriterConfigSource writerConfigSource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract IndexWriterProvider createIndexWriterProvider(String indexName, EventContext eventContext, DirectoryHolder directoryHolder, IndexWriterConfigSource configSource);

    abstract IndexReaderProvider createIndexReaderProvider(DirectoryHolder directoryHolder, IndexWriterProvider indexWriterProvider);
}
