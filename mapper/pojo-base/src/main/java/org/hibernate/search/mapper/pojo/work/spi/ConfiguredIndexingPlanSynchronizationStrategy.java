/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.work.spi;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import org.hibernate.search.engine.backend.work.execution.DocumentCommitStrategy;
import org.hibernate.search.engine.backend.work.execution.DocumentRefreshStrategy;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.mapper.pojo.work.IndexingPlanSynchronizationStrategyConfigurationContext;
import org.hibernate.search.mapper.pojo.work.SearchIndexingPlanExecutionReport;
import org.hibernate.search.mapper.pojo.work.impl.DelegatingSearchIndexingPlanExecutionReport;
import org.hibernate.search.util.common.annotation.Incubating;
import org.hibernate.search.util.common.impl.Contracts;

@Incubating
public class ConfiguredIndexingPlanSynchronizationStrategy {

    private final DocumentCommitStrategy documentCommitStrategy;

    private final DocumentRefreshStrategy documentRefreshStrategy;

    private final Consumer<? super CompletableFuture<? extends SearchIndexingPlanExecutionReport>> indexingFutureHandler;

    private final OperationSubmitter operationSubmitter;

    protected ConfiguredIndexingPlanSynchronizationStrategy(Builder configurationContext) {
        this.documentCommitStrategy = configurationContext.documentCommitStrategy;
        this.documentRefreshStrategy = configurationContext.documentRefreshStrategy;
        this.indexingFutureHandler = configurationContext.indexingFutureHandler;
        this.operationSubmitter = configurationContext.operationSubmitter;
    }

    public DocumentCommitStrategy documentCommitStrategy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public DocumentRefreshStrategy documentRefreshStrategy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void executeAndSynchronize(PojoIndexingPlan indexingPlan) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static final class Builder implements IndexingPlanSynchronizationStrategyConfigurationContext {

        private final FailureHandler failureHandler;

        private DocumentCommitStrategy documentCommitStrategy = DocumentCommitStrategy.NONE;

        private DocumentRefreshStrategy documentRefreshStrategy = DocumentRefreshStrategy.NONE;

        private Consumer<? super CompletableFuture<? extends SearchIndexingPlanExecutionReport>> indexingFutureHandler = future -> {
        };

        private OperationSubmitter operationSubmitter = OperationSubmitter.blocking();

        public Builder(FailureHandler failureHandler) {
            this.failureHandler = failureHandler;
        }

        @Override
        public void documentCommitStrategy(DocumentCommitStrategy strategy) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void documentRefreshStrategy(DocumentRefreshStrategy strategy) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void indexingFutureHandler(Consumer<? super CompletableFuture<? extends SearchIndexingPlanExecutionReport>> handler) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public FailureHandler failureHandler() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void operationSubmitter(OperationSubmitter operationSubmitter) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ConfiguredIndexingPlanSynchronizationStrategy build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
