/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.orchestration.impl;

import java.util.concurrent.CompletableFuture;
import org.hibernate.search.backend.elasticsearch.link.impl.ElasticsearchLink;
import org.hibernate.search.backend.elasticsearch.work.impl.ElasticsearchWorkExecutionContext;
import org.hibernate.search.backend.elasticsearch.work.impl.NonBulkableWork;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;

public class ElasticsearchSimpleWorkOrchestrator extends AbstractElasticsearchWorkOrchestrator<ElasticsearchSimpleWorkOrchestrator.WorkExecution<?>> implements ElasticsearchParallelWorkOrchestrator {

    private ElasticsearchWorkExecutionContext executionContext;

    public ElasticsearchSimpleWorkOrchestrator(String name, ElasticsearchLink link) {
        super(name, link);
    }

    @Override
    public <T> CompletableFuture<T> submit(NonBulkableWork<T> work, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void doStart(ConfigurationPropertySource propertySource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void doSubmit(WorkExecution<?> work, OperationSubmitter ignore) {
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

    static class WorkExecution<T> {

        private final NonBulkableWork<T> work;

        private CompletableFuture<T> result;

        WorkExecution(NonBulkableWork<T> work) {
            this.work = work;
        }

        public void execute(ElasticsearchWorkExecutionContext executionContext) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public CompletableFuture<T> getResult() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
