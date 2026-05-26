/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.work.impl;

import java.util.BitSet;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import org.hibernate.search.engine.backend.common.spi.MultiEntityOperationExecutionReport;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.mapper.pojo.route.DocumentRouteDescriptor;
import org.hibernate.search.mapper.pojo.route.DocumentRoutesDescriptor;
import org.hibernate.search.mapper.pojo.work.spi.DirtinessDescriptor;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingQueueEventPayload;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingQueueEventSendingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoWorkSessionContext;
import org.hibernate.search.util.common.AssertionFailure;

/**
 * A {@link PojoTypeIndexingPlanDelegate} that sends indexing events to an external queue,
 * to process them externally.
 *
 * @param <I> The type of identifiers of entities in this plan.
 * @param <E> The type of entities in this plan.
 */
final class PojoTypeIndexingPlanEventQueueDelegate<I, E> implements PojoTypeIndexingPlanDelegate<I, E> {

    private final PojoWorkTypeContext<I, E> typeContext;

    private final PojoWorkSessionContext sessionContext;

    private final PojoIndexingQueueEventSendingPlan sendingPlan;

    PojoTypeIndexingPlanEventQueueDelegate(PojoWorkTypeContext<I, E> typeContext, PojoWorkSessionContext sessionContext, PojoIndexingQueueEventSendingPlan sendingPlan) {
        this.typeContext = typeContext;
        this.sessionContext = sessionContext;
        this.sendingPlan = sendingPlan;
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
