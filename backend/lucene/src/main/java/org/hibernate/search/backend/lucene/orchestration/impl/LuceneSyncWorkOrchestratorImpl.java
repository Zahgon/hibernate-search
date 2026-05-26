/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.orchestration.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import org.hibernate.search.backend.lucene.cache.impl.LuceneQueryCachingContext;
import org.hibernate.search.backend.lucene.logging.impl.LuceneMiscLog;
import org.hibernate.search.backend.lucene.logging.impl.QueryLog;
import org.hibernate.search.backend.lucene.lowlevel.reader.impl.HibernateSearchMultiReader;
import org.hibernate.search.backend.lucene.lowlevel.reader.impl.IndexReaderMetadataResolver;
import org.hibernate.search.backend.lucene.lowlevel.reader.impl.ReadIndexManagerContext;
import org.hibernate.search.backend.lucene.work.impl.ReadWork;
import org.hibernate.search.backend.lucene.work.impl.ReadWorkExecutionContext;
import org.hibernate.search.engine.backend.orchestration.spi.AbstractWorkOrchestrator;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.util.common.impl.SuppressingCloser;
import org.hibernate.search.util.common.reporting.EventContext;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.similarities.Similarity;

public class LuceneSyncWorkOrchestratorImpl extends AbstractWorkOrchestrator<LuceneSyncWorkOrchestratorImpl.WorkExecution<?>> implements LuceneSyncWorkOrchestrator {

    private final Similarity similarity;

    private final LuceneQueryCachingContext cachingContext;

    public LuceneSyncWorkOrchestratorImpl(String name, Similarity similarity, LuceneQueryCachingContext cachingContext) {
        super(name);
        this.similarity = similarity;
        // Nothing to start, just force the superclass to go to the right state.
        start(null);
        this.cachingContext = cachingContext;
    }

    @Override
    public <T> T submit(Set<String> indexNames, Collection<? extends ReadIndexManagerContext> indexManagerContexts, Set<String> routingKeys, ReadWork<T> work, HibernateSearchMultiReader indexReader) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void doStart(ConfigurationPropertySource propertySource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void doSubmit(WorkExecution<?> work, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected CompletableFuture<?> completion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void doStop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class WorkExecution<T> implements AutoCloseable, ReadWorkExecutionContext {

        private final Similarity similarity;

        private final Set<String> indexNames;

        private final HibernateSearchMultiReader indexReader;

        private final ReadWork<T> work;

        private final boolean closeIndexReader;

        private final LuceneQueryCachingContext cachingContext;

        private T result;

        WorkExecution(Similarity similarity, Set<String> indexNames, Collection<? extends ReadIndexManagerContext> indexManagerContexts, Set<String> routingKeys, ReadWork<T> work, HibernateSearchMultiReader indexReader, LuceneQueryCachingContext cachingContext) {
            this.similarity = similarity;
            this.indexNames = indexNames;
            this.work = work;
            if (indexReader == null) {
                this.indexReader = HibernateSearchMultiReader.open(indexNames, indexManagerContexts, routingKeys);
                this.closeIndexReader = true;
            } else {
                this.indexReader = indexReader;
                this.closeIndexReader = false;
            }
            this.cachingContext = cachingContext;
        }

        @Override
        public IndexSearcher createSearcher() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public IndexReaderMetadataResolver getIndexReaderMetadataResolver() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public EventContext getEventContext() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void execute() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public T getResult() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void close() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
