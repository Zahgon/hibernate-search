/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.work.impl;

import java.util.BitSet;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import org.hibernate.search.engine.backend.common.spi.MultiEntityOperationExecutionReport;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.engine.backend.work.execution.spi.DocumentReferenceProvider;
import org.hibernate.search.engine.backend.work.execution.spi.IndexIndexingPlan;
import org.hibernate.search.mapper.pojo.processing.spi.PojoIndexingProcessorRootContext;
import org.hibernate.search.mapper.pojo.route.DocumentRouteDescriptor;
import org.hibernate.search.mapper.pojo.route.DocumentRoutesDescriptor;
import org.hibernate.search.mapper.pojo.work.spi.PojoWorkSessionContext;

/**
 * A {@link PojoTypeIndexingPlanDelegate} that sends indexing events to the index,
 * to process them locally.
 *
 * @param <I> The type of identifiers of entities in this plan.
 * @param <E> The type of entities in this plan.
 */
final class PojoTypeIndexingPlanIndexDelegate<I, E> implements PojoTypeIndexingPlanDelegate<I, E> {

    private final PojoWorkIndexedTypeContext<I, E> typeContext;

    private final PojoWorkSessionContext sessionContext;

    private final PojoIndexingProcessorRootContext processorContext;

    private final IndexIndexingPlan indexPlan;

    PojoTypeIndexingPlanIndexDelegate(PojoWorkIndexedTypeContext<I, E> typeContext, PojoWorkSessionContext sessionContext, PojoIndexingProcessorRootContext processorContext, IndexIndexingPlan indexPlan) {
        this.typeContext = typeContext;
        this.sessionContext = sessionContext;
        this.processorContext = processorContext;
        this.indexPlan = indexPlan;
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

    private void delegateDeletePrevious(I identifier, String documentIdentifier, Collection<DocumentRouteDescriptor> previousRoutes) {
        for (DocumentRouteDescriptor route : previousRoutes) {
            DocumentReferenceProvider referenceProvider = new PojoDocumentReferenceProvider(documentIdentifier, route.routingKey(), identifier);
            indexPlan.delete(referenceProvider);
        }
    }
}
