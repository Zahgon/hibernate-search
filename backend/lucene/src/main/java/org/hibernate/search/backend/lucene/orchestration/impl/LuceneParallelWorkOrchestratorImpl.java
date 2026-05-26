/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.orchestration.impl;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import org.hibernate.search.backend.lucene.lowlevel.index.impl.IndexAccessor;
import org.hibernate.search.backend.lucene.resources.impl.BackendThreads;
import org.hibernate.search.backend.lucene.work.impl.IndexManagementWork;
import org.hibernate.search.backend.lucene.work.impl.IndexManagementWorkExecutionContext;
import org.hibernate.search.engine.backend.orchestration.spi.AbstractWorkOrchestrator;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.common.execution.spi.SimpleScheduledExecutor;
import org.hibernate.search.util.common.reporting.EventContext;

public class LuceneParallelWorkOrchestratorImpl extends AbstractWorkOrchestrator<LuceneParallelWorkOrchestratorImpl.WorkExecution<?>> implements LuceneParallelWorkOrchestrator {

    private static final BiConsumer<WorkExecution<?>, Throwable> ASYNC_FAILURE_REPORTER = WorkExecution::markAsFailed;

    private final IndexAccessor indexAccessor;

    private final IndexAccessorWorkExecutionContext context;

    private final BackendThreads threads;

    private SimpleScheduledExecutor executor;

    public LuceneParallelWorkOrchestratorImpl(String name, EventContext eventContext, IndexAccessor indexAccessor, BackendThreads threads) {
        super(name);
        this.indexAccessor = indexAccessor;
        this.context = new IndexAccessorWorkExecutionContext(eventContext, indexAccessor);
        this.threads = threads;
    }

    @Override
    public <T> void submit(CompletableFuture<T> future, IndexManagementWork<T> work, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void forceCommitInCurrentThread() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void doStart(ConfigurationPropertySource propertySource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void doSubmit(WorkExecution<?> workExecution, OperationSubmitter operationSubmitter) throws InterruptedException {
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

    static class WorkExecution<T> implements Runnable {

        private final CompletableFuture<T> result;

        private final IndexManagementWork<T> work;

        private final IndexManagementWorkExecutionContext context;

        WorkExecution(CompletableFuture<T> result, IndexManagementWork<T> work, IndexManagementWorkExecutionContext context) {
            this.result = result;
            this.work = work;
            this.context = context;
        }

        @Override
        public void run() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void markAsFailed(Throwable throwable) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
