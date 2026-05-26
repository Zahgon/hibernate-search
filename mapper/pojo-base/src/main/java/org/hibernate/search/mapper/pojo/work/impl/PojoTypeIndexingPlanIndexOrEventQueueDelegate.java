/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.work.impl;

import java.util.BitSet;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import org.hibernate.search.engine.backend.common.spi.MultiEntityOperationExecutionReport;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.engine.backend.work.execution.spi.IndexIndexingPlan;
import org.hibernate.search.mapper.pojo.processing.spi.PojoIndexingProcessorRootContext;
import org.hibernate.search.mapper.pojo.route.DocumentRouteDescriptor;
import org.hibernate.search.mapper.pojo.route.DocumentRoutesDescriptor;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingQueueEventSendingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoWorkSessionContext;

/**
 * A {@link PojoTypeIndexingPlanDelegate} that sends indexing events to the index,
 * to process them locally,
 * except when those events were caused exclusively by a change in a contained entity,
 * in which case it sends indexing events to an external queue,
 * to process them externally.
 *
 * @param <I> The type of identifiers of entities in this plan.
 * @param <E> The type of entities in this plan.
 */
final class PojoTypeIndexingPlanIndexOrEventQueueDelegate<I, E> implements PojoTypeIndexingPlanDelegate<I, E> {

    private final PojoWorkIndexedTypeContext<I, E> typeContext;

    private final PojoTypeIndexingPlanIndexDelegate<I, E> indexDelegate;

    private final PojoTypeIndexingPlanEventQueueDelegate<I, E> eventQueueDelegate;

    PojoTypeIndexingPlanIndexOrEventQueueDelegate(PojoWorkIndexedTypeContext<I, E> typeContext, PojoWorkSessionContext sessionContext, PojoIndexingProcessorRootContext processorRootContext, IndexIndexingPlan indexPlan, PojoIndexingQueueEventSendingPlan sendingPlan) {
        this.typeContext = typeContext;
        this.indexDelegate = new PojoTypeIndexingPlanIndexDelegate<>(typeContext, sessionContext, processorRootContext, indexPlan);
        this.eventQueueDelegate = new PojoTypeIndexingPlanEventQueueDelegate<>(typeContext, sessionContext, sendingPlan);
    }

    @Override
    public boolean isDirtyForAddOrUpdate(boolean forceSelfDirty, boolean forceContainingDirty, BitSet dirtyPathsOrNull) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void add(I identifier, DocumentRouteDescriptor route, Supplier<E> entitySupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addOrUpdate(I identifier, DocumentRoutesDescriptor routes, Supplier<E> entitySupplier, boolean forceSelfDirty, boolean forceContainingDirty, BitSet dirtyPaths, boolean updatedBecauseOfContained, boolean updateBecauseOfDirty) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void delete(I identifier, DocumentRoutesDescriptor routes, Supplier<E> entitySupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void discard() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<MultiEntityOperationExecutionReport> executeAndReport(OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
