/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.writer.impl;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import org.hibernate.search.backend.lucene.logging.impl.IndexingLog;
import org.hibernate.search.backend.lucene.logging.impl.LuceneMiscLog;
import org.hibernate.search.engine.backend.orchestration.spi.SingletonTask;
import org.hibernate.search.engine.common.execution.spi.SimpleScheduledExecutor;
import org.hibernate.search.engine.common.timing.spi.TimingSource;
import org.hibernate.search.engine.reporting.FailureContext;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.reporting.EventContext;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;

/**
 * @author Sanne Grinovero (C) 2011 Red Hat Inc.
 */
public class IndexWriterDelegatorImpl implements IndexWriterDelegator {

    private final IndexWriter delegate;

    private final EventContext eventContext;

    private final TimingSource timingSource;

    private final int commitInterval;

    private final FailureHandler failureHandler;

    private final SingletonTask delayedCommitTask;

    private final ReentrantLock commitLock = new ReentrantLock();

    private long commitExpiration;

    public IndexWriterDelegatorImpl(IndexWriter delegate, EventContext eventContext, SimpleScheduledExecutor delayedCommitExecutor, TimingSource timingSource, int commitInterval, FailureHandler failureHandler, DelayedCommitFailureHandler delayedCommitFailureHandler) {
        this.delegate = delegate;
        this.eventContext = eventContext;
        this.timingSource = timingSource;
        this.commitInterval = commitInterval;
        this.failureHandler = failureHandler;
        if (commitInterval == 0L) {
            delayedCommitTask = null;
        } else {
            delayedCommitTask = new SingletonTask("Delayed commit for " + eventContext.render(), new LuceneDelayedCommitWorker(delayedCommitFailureHandler), new LuceneDelayedCommitScheduler(delayedCommitExecutor), failureHandler);
        }
        updateCommitExpiration();
    }

    @Override
    public long addDocuments(Iterable<? extends Iterable<? extends IndexableField>> docs) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long updateDocuments(Term term, Iterable<? extends Iterable<? extends IndexableField>> docs) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long deleteDocuments(Term term) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long deleteDocuments(Query query) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void mergeSegments() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void commit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void commitOrDelay() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public DirectoryReader openReader() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public DirectoryReader openReaderIfChanged(DirectoryReader oldReader) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IndexWriter getDelegateForTests() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void close() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void closeAfterFailure(Throwable throwable, Object failingOperation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void doCommit() {
        commitLock.lock();
        try {
            // NOTE: underlying Lucene code is using this pattern to sync on object block,
            // which could be a problem with Loom:
            // synchronized(commitLock)
            delegate.commit();
            updateCommitExpiration();
        } catch (RuntimeException | IOException e) {
            throw IndexingLog.INSTANCE.unableToCommitIndex(e.getMessage(), eventContext, e);
        } finally {
            commitLock.unlock();
        }
    }

    /**
     * @return {@code true} if the commit was delayed, {@code false} if it wasn't and must happen now.
     */
    private boolean delayCommit() {
        long timeToCommit = getTimeToCommit();
        if (timeToCommit <= 0L) {
            // The commit must happen now.
            return false;
        }
        // There's still time before we must commit.
        // Just make sure the commit will happen eventually.
        delayedCommitTask.ensureScheduled();
        return true;
    }

    private long getTimeToCommit() {
        if (commitInterval == 0L) {
            // We never delay anything in this case,
            // so there's no need to query the timing source (which is probably null in this case).
            return 0L;
        }
        return commitExpiration - timingSource.monotonicTimeEstimate();
    }

    private void updateCommitExpiration() {
        commitExpiration = commitInterval == 0 ? 0L : timingSource.monotonicTimeEstimate() + commitInterval;
    }

    private class LuceneDelayedCommitWorker implements SingletonTask.Worker {

        private final CompletableFuture<?> completedFuture = CompletableFuture.completedFuture(null);

        private final DelayedCommitFailureHandler delayedCommitFailureHandler;

        public LuceneDelayedCommitWorker(DelayedCommitFailureHandler delayedCommitFailureHandler) {
            this.delayedCommitFailureHandler = delayedCommitFailureHandler;
        }

        @Override
        public CompletableFuture<?> work() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void complete() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private class LuceneDelayedCommitScheduler implements SingletonTask.Scheduler {

        private final SimpleScheduledExecutor delegate;

        private LuceneDelayedCommitScheduler(SimpleScheduledExecutor delegate) {
            this.delegate = delegate;
        }

        @Override
        public Future<?> schedule(Runnable runnable) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    interface DelayedCommitFailureHandler {

        void handle(Throwable throwable, Object failingOperation);
    }
}
