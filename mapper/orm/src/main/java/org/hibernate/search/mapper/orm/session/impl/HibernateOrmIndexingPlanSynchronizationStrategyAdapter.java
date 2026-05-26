/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.session.impl;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.hibernate.search.engine.backend.work.execution.DocumentCommitStrategy;
import org.hibernate.search.engine.backend.work.execution.DocumentRefreshStrategy;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.mapper.pojo.work.IndexingPlanSynchronizationStrategy;
import org.hibernate.search.mapper.pojo.work.IndexingPlanSynchronizationStrategyConfigurationContext;

@SuppressWarnings("deprecation")
public class HibernateOrmIndexingPlanSynchronizationStrategyAdapter implements IndexingPlanSynchronizationStrategy {

    private final org.hibernate.search.mapper.orm.automaticindexing.session.AutomaticIndexingSynchronizationStrategy delegate;

    public HibernateOrmIndexingPlanSynchronizationStrategyAdapter(org.hibernate.search.mapper.orm.automaticindexing.session.AutomaticIndexingSynchronizationStrategy delegate) {
        this.delegate = delegate;
    }

    @Override
    public void apply(IndexingPlanSynchronizationStrategyConfigurationContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
