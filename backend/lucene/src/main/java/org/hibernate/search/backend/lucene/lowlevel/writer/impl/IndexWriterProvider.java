/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.writer.impl;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import org.hibernate.search.backend.lucene.logging.impl.LuceneMiscLog;
import org.hibernate.search.backend.lucene.lowlevel.directory.spi.DirectoryHolder;
import org.hibernate.search.backend.lucene.resources.impl.BackendThreads;
import org.hibernate.search.engine.common.timing.spi.TimingSource;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.util.common.reporting.EventContext;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.MergeScheduler;

/**
 * @author Sanne Grinovero (C) 2011 Red Hat Inc.
 */
public class IndexWriterProvider {

    private final String indexName;

    private final EventContext eventContext;

    private final DirectoryHolder directoryHolder;

    private final IndexWriterConfigSource configSource;

    private final TimingSource timingSource;

    private final int commitInterval;

    private BackendThreads threads;

    private final FailureHandler failureHandler;

    /**
     * Current open IndexWriter, or null when closed.
     */
    private final AtomicReference<IndexWriterDelegatorImpl> currentWriter = new AtomicReference<>();

    /**
     * Protects from multiple initialization attempts of IndexWriter
     */
    private final ReentrantLock currentWriterModificationLock = new ReentrantLock();

    public IndexWriterProvider(String indexName, EventContext eventContext, DirectoryHolder directoryHolder, IndexWriterConfigSource configSource, TimingSource timingSource, int commitInterval, BackendThreads threads, FailureHandler failureHandler) {
        this.indexName = indexName;
        this.eventContext = eventContext;
        this.directoryHolder = directoryHolder;
        this.configSource = configSource;
        this.timingSource = timingSource;
        this.commitInterval = commitInterval;
        this.threads = threads;
        this.failureHandler = failureHandler;
    }

    /**
     * Closes and drops any cached resources (index writer in particular).
     * <p>
     * Should be used when stopping the index.
     */
    public void clear() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Closes and drops any cached resources (index writer in particular).
     * <p>
     * Should be used to clean up upon error.
     */
    public void clearAfterFailure(Throwable throwable, Object failingOperation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IndexWriterDelegatorImpl getOrNull() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IndexWriterDelegatorImpl getOrCreate() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private IndexWriter createNewIndexWriter() throws IOException {
        // Each writer config can be attached only once to an IndexWriter
        final IndexWriterConfig indexWriterConfig = createWriterConfig();
        return new IndexWriter(directoryHolder.get(), indexWriterConfig);
    }

    private IndexWriterConfig createWriterConfig() {
        IndexWriterConfig writerConfig = configSource.createIndexWriterConfig();
        MergeScheduler mergeScheduler = new HibernateSearchConcurrentMergeScheduler(indexName, eventContext.render(), threads.getThreadProvider(), failureHandler);
        writerConfig.setMergeScheduler(mergeScheduler);
        writerConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);
        return writerConfig;
    }
}
