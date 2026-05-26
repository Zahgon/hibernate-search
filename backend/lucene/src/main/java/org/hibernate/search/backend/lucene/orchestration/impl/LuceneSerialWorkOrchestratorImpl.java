/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.orchestration.impl;

import java.util.concurrent.CompletableFuture;
import org.hibernate.search.backend.lucene.cfg.LuceneIndexSettings;
import org.hibernate.search.backend.lucene.resources.impl.BackendThreads;
import org.hibernate.search.engine.backend.orchestration.spi.AbstractWorkOrchestrator;
import org.hibernate.search.engine.backend.orchestration.spi.BatchingExecutor;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.util.common.data.impl.HashTable;
import org.hibernate.search.util.common.data.impl.ModuloHashTable;
import org.hibernate.search.util.common.data.impl.SimpleHashFunction;
import org.hibernate.search.util.common.impl.Closer;

public class LuceneSerialWorkOrchestratorImpl extends AbstractWorkOrchestrator<LuceneBatchedWork<?>> implements LuceneSerialWorkOrchestrator {

    private static final ConfigurationProperty<Integer> QUEUE_COUNT = ConfigurationProperty.forKey(LuceneIndexSettings.INDEXING_QUEUE_COUNT).asIntegerStrictlyPositive().withDefault(LuceneIndexSettings.Defaults.INDEXING_QUEUE_COUNT).build();

    private static final ConfigurationProperty<Integer> QUEUE_SIZE = ConfigurationProperty.forKey(LuceneIndexSettings.INDEXING_QUEUE_SIZE).asIntegerStrictlyPositive().withDefault(LuceneIndexSettings.Defaults.INDEXING_QUEUE_SIZE).build();

    private final LuceneBatchedWorkProcessor processor;

    private final BackendThreads threads;

    private final FailureHandler failureHandler;

    private HashTable<BatchingExecutor<LuceneBatchedWorkProcessor, LuceneBatchedWork<?>>> executors;

    /**
     * @param name The name of the orchestrator thread (and of this orchestrator when reporting errors)
     * @param processor A processor to use in the background thread.
     * @param threads The threads for this backend.
     * @param failureHandler A failure handler to report failures of the background thread.
     */
    public LuceneSerialWorkOrchestratorImpl(String name, LuceneBatchedWorkProcessor processor, BackendThreads threads, FailureHandler failureHandler) {
        super(name);
        this.processor = processor;
        this.threads = threads;
        this.failureHandler = failureHandler;
    }

    @Override
    public void forceCommitInCurrentThread() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void forceRefreshInCurrentThread() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void doStart(ConfigurationPropertySource propertySource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void doSubmit(LuceneBatchedWork<?> work, OperationSubmitter operationSubmitter) throws InterruptedException {
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
}
