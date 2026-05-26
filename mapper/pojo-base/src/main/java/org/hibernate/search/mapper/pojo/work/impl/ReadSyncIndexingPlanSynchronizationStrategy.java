/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.work.impl;

import org.hibernate.search.engine.backend.work.execution.DocumentCommitStrategy;
import org.hibernate.search.engine.backend.work.execution.DocumentRefreshStrategy;
import org.hibernate.search.mapper.pojo.logging.impl.IndexingLog;
import org.hibernate.search.mapper.pojo.work.IndexingPlanSynchronizationStrategy;
import org.hibernate.search.mapper.pojo.work.IndexingPlanSynchronizationStrategyConfigurationContext;
import org.hibernate.search.mapper.pojo.work.SearchIndexingPlanExecutionReport;
import org.hibernate.search.util.common.annotation.Incubating;
import org.hibernate.search.util.common.impl.Futures;

@Incubating
public final class ReadSyncIndexingPlanSynchronizationStrategy implements IndexingPlanSynchronizationStrategy {

    public static final IndexingPlanSynchronizationStrategy INSTANCE = new ReadSyncIndexingPlanSynchronizationStrategy();

    private ReadSyncIndexingPlanSynchronizationStrategy() {
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
