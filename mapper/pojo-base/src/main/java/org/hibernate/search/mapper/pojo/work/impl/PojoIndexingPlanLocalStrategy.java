/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.work.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.hibernate.search.engine.backend.common.spi.MultiEntityOperationExecutionReport;
import org.hibernate.search.engine.backend.work.execution.DocumentCommitStrategy;
import org.hibernate.search.engine.backend.work.execution.DocumentRefreshStrategy;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.engine.backend.work.execution.spi.IndexIndexingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoWorkSessionContext;

/**
 * A strategy for handling indexing locally (as opposed to sending events to a remote processor).
 */
public class PojoIndexingPlanLocalStrategy implements PojoIndexingPlanStrategy {

    final DocumentCommitStrategy commitStrategy;

    final DocumentRefreshStrategy refreshStrategy;

    public PojoIndexingPlanLocalStrategy(DocumentCommitStrategy commitStrategy, DocumentRefreshStrategy refreshStrategy) {
        this.commitStrategy = commitStrategy;
        this.refreshStrategy = refreshStrategy;
    }

    @Override
    public boolean shouldResolveDirtyForDeleteOnly() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<MultiEntityOperationExecutionReport> doExecuteAndReport(Collection<PojoIndexedTypeIndexingPlan<?, ?>> indexedTypeDelegates, PojoLoadingPlanProvider loadingPlanProvider, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void doDiscard(Collection<PojoIndexedTypeIndexingPlan<?, ?>> indexedTypeDelegates) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <I, E> PojoIndexedTypeIndexingPlan<I, E> createIndexedDelegate(PojoWorkIndexedTypeContext<I, E> typeContext, PojoWorkSessionContext sessionContext, PojoIndexingPlanImpl root) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <I, E> PojoContainedTypeIndexingPlan<I, E> createDelegate(PojoWorkContainedTypeContext<I, E> typeContext, PojoWorkSessionContext sessionContext, PojoIndexingPlanImpl root) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
