/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.automaticindexing.session.impl;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import org.hibernate.search.engine.backend.work.execution.DocumentCommitStrategy;
import org.hibernate.search.engine.backend.work.execution.DocumentRefreshStrategy;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.engine.common.EntityReference;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.mapper.pojo.work.IndexingPlanSynchronizationStrategy;
import org.hibernate.search.mapper.pojo.work.IndexingPlanSynchronizationStrategyConfigurationContext;
import org.hibernate.search.mapper.pojo.work.SearchIndexingPlanExecutionReport;

@SuppressWarnings("deprecation")
public class DelegatingAutomaticIndexingSynchronizationStrategy implements org.hibernate.search.mapper.orm.automaticindexing.session.AutomaticIndexingSynchronizationStrategy {

    private final IndexingPlanSynchronizationStrategy delegate;

    public DelegatingAutomaticIndexingSynchronizationStrategy(IndexingPlanSynchronizationStrategy delegate) {
        this.delegate = delegate;
    }

    @Override
    public void apply(org.hibernate.search.mapper.orm.automaticindexing.session.AutomaticIndexingSynchronizationConfigurationContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IndexingPlanSynchronizationStrategy delegate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class HibernateOrmDelegatingSearchIndexingPlanExecutionReport implements SearchIndexingPlanExecutionReport {

        private final org.hibernate.search.mapper.orm.work.SearchIndexingPlanExecutionReport report;

        private HibernateOrmDelegatingSearchIndexingPlanExecutionReport(org.hibernate.search.mapper.orm.work.SearchIndexingPlanExecutionReport report) {
            this.report = report;
        }

        @Override
        public Optional<Throwable> throwable() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public List<? extends EntityReference> failingEntities() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
