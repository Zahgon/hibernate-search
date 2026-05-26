/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.work;

import org.hibernate.search.mapper.pojo.work.impl.AsyncIndexingPlanSynchronizationStrategy;
import org.hibernate.search.mapper.pojo.work.impl.ReadSyncIndexingPlanSynchronizationStrategy;
import org.hibernate.search.mapper.pojo.work.impl.SyncIndexingPlanSynchronizationStrategy;
import org.hibernate.search.mapper.pojo.work.impl.WriteSyncIndexingPlanSynchronizationStrategy;
import org.hibernate.search.util.common.annotation.Incubating;

/**
 * Determines how the thread will block upon committing a transaction
 * where indexed entities were modified.
 *
 * {@code SearchSession#indexingPlanSynchronizationStrategy(IndexingPlanSynchronizationStrategy)}
 */
@Incubating
public interface IndexingPlanSynchronizationStrategy {

    void apply(IndexingPlanSynchronizationStrategyConfigurationContext context);

    /**
     * @return A strategy that only waits for index changes to be queued in the backend.
     * See the reference documentation for details.
     */
    static IndexingPlanSynchronizationStrategy async() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return A strategy that waits for index changes to be queued and applied, forces a commit, and waits for the commit to complete.
     * See the reference documentation for details.
     */
    static IndexingPlanSynchronizationStrategy writeSync() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return A strategy that waits for index changes to be queued and applied, forces a refresh, and waits for the refresh to complete.
     * See the reference documentation for details.
     */
    static IndexingPlanSynchronizationStrategy readSync() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return A strategy that waits for index changes to be queued and applied, forces a commit and a refresh,
     * and waits for the commit and refresh to complete.
     * See the reference documentation for details.
     */
    static IndexingPlanSynchronizationStrategy sync() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
