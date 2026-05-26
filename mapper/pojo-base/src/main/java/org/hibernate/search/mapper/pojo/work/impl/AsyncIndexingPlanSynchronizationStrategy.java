/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.work.impl;

import org.hibernate.search.engine.backend.work.execution.DocumentCommitStrategy;
import org.hibernate.search.engine.backend.work.execution.DocumentRefreshStrategy;
import org.hibernate.search.engine.common.EntityReference;
import org.hibernate.search.engine.reporting.EntityIndexingFailureContext;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.mapper.pojo.reporting.impl.PojoMassIndexerMessages;
import org.hibernate.search.mapper.pojo.work.IndexingPlanSynchronizationStrategy;
import org.hibernate.search.mapper.pojo.work.IndexingPlanSynchronizationStrategyConfigurationContext;
import org.hibernate.search.util.common.annotation.Incubating;
import org.hibernate.search.util.common.impl.Futures;

@Incubating
public final class AsyncIndexingPlanSynchronizationStrategy implements IndexingPlanSynchronizationStrategy {

    public static final IndexingPlanSynchronizationStrategy INSTANCE = new AsyncIndexingPlanSynchronizationStrategy();

    private AsyncIndexingPlanSynchronizationStrategy() {
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void apply(IndexingPlanSynchronizationStrategyConfigurationContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
