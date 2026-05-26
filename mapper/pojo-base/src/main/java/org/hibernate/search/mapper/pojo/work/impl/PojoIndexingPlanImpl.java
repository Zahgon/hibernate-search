/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.work.impl;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.hibernate.search.engine.backend.common.spi.MultiEntityOperationExecutionReport;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoReindexingAssociationInverseSideCollector;
import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoReindexingCollector;
import org.hibernate.search.mapper.pojo.loading.impl.PojoLoadingPlan;
import org.hibernate.search.mapper.pojo.loading.impl.PojoMultiLoaderLoadingPlan;
import org.hibernate.search.mapper.pojo.logging.impl.IndexingLog;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.model.spi.PojoRuntimeIntrospector;
import org.hibernate.search.mapper.pojo.processing.spi.PojoIndexingProcessorRootContext;
import org.hibernate.search.mapper.pojo.processing.spi.PojoIndexingProcessorSessionContext;
import org.hibernate.search.mapper.pojo.route.DocumentRoutesDescriptor;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoWorkSessionContext;
import org.hibernate.search.util.common.AssertionFailure;

public class PojoIndexingPlanImpl implements PojoIndexingPlan, PojoLoadingPlanProvider, PojoReindexingCollector, PojoReindexingAssociationInverseSideCollector, PojoIndexingProcessorRootContext {

    private final PojoWorkTypeContextProvider typeContextProvider;

    private final PojoWorkSessionContext sessionContext;

    private final PojoRuntimeIntrospector introspector;

    private final PojoIndexingPlanStrategy strategy;

    // Use a LinkedHashMap for deterministic iteration
    protected final Map<PojoRawTypeIdentifier<?>, PojoIndexedTypeIndexingPlan<?, ?>> indexedTypeDelegates = new LinkedHashMap<>();

    protected final Map<PojoRawTypeIdentifier<?>, PojoContainedTypeIndexingPlan<?, ?>> containedTypeDelegates = new LinkedHashMap<>();

    private boolean isProcessing = false;

    private PojoLoadingPlan<Object> loadingPlan = null;

    public PojoIndexingPlanImpl(PojoWorkTypeContextProvider typeContextProvider, PojoWorkSessionContext sessionContext, PojoIndexingPlanStrategy strategy) {
        this.typeContextProvider = typeContextProvider;
        this.sessionContext = sessionContext;
        this.introspector = sessionContext.runtimeIntrospector();
        this.strategy = strategy;
    }

    @Override
    @Deprecated(since = "6.2")
    public void add(PojoRawTypeIdentifier<?> typeIdentifier, Object providedId, DocumentRoutesDescriptor providedRoutes, Object entity) {
        AbstractPojoTypeIndexingPlan<?, ?, ?> delegate = typeIfIncludedOrNull(typeIdentifier);
        if (delegate == null) {
            return;
        }
        delegate.add(providedId, providedRoutes, entity);
    }

    @Override
    @Deprecated(since = "6.2")
    public void addOrUpdate(PojoRawTypeIdentifier<?> typeIdentifier, Object providedId, DocumentRoutesDescriptor providedRoutes, Object entity, boolean forceSelfDirty, boolean forceContainingDirty, BitSet dirtyPaths) {
        AbstractPojoTypeIndexingPlan<?, ?, ?> delegate = typeIfIncludedOrNull(typeIdentifier);
        if (delegate == null) {
            return;
        }
        delegate.addOrUpdate(providedId, providedRoutes, entity, forceSelfDirty, forceContainingDirty, dirtyPaths);
    }

    @Override
    @Deprecated(since = "6.2")
    public void delete(PojoRawTypeIdentifier<?> typeIdentifier, Object providedId, DocumentRoutesDescriptor providedRoutes, Object entity) {
        AbstractPojoTypeIndexingPlan<?, ?, ?> delegate = typeIfIncludedOrNull(typeIdentifier);
        if (delegate == null) {
            return;
        }
        delegate.delete(providedId, providedRoutes, entity);
    }

    @Override
    @Deprecated(since = "6.2")
    public void addOrUpdateOrDelete(PojoRawTypeIdentifier<?> typeIdentifier, Object providedId, DocumentRoutesDescriptor providedRoutes, boolean forceSelfDirty, boolean forceContainingDirty, BitSet dirtyPaths) {
        AbstractPojoTypeIndexingPlan<?, ?, ?> delegate = typeIfIncludedOrNull(typeIdentifier);
        if (delegate == null) {
            return;
        }
        delegate.addOrUpdateOrDelete(providedId, providedRoutes, forceSelfDirty, forceContainingDirty, dirtyPaths);
    }

    @Override
    @Deprecated(since = "6.2")
    public void updateAssociationInverseSide(PojoRawTypeIdentifier<?> typeIdentifier, BitSet dirtyAssociationPaths, Object[] oldState, Object[] newState) {
        AbstractPojoTypeIndexingPlan<?, ?, ?> delegate = typeIfIncludedOrNull(typeIdentifier);
        if (delegate == null) {
            return;
        }
        delegate.updateAssociationInverseSide(dirtyAssociationPaths, oldState, newState);
    }

    @Override
    public AbstractPojoTypeIndexingPlan<?, ?, ?> typeIfIncludedOrNull(PojoRawTypeIdentifier<?> typeIdentifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private AbstractPojoTypeIndexingPlan<?, ?, ?> typeOrNull(PojoRawTypeIdentifier<?> typeIdentifier) {
        AbstractPojoTypeIndexingPlan<?, ?, ?> delegate = indexedTypeDelegates.get(typeIdentifier);
        if (delegate == null) {
            delegate = containedTypeDelegates.get(typeIdentifier);
        }
        return delegate;
    }

    @Override
    public void process() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<MultiEntityOperationExecutionReport> executeAndReport(OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void discard() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void discardNotProcessed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void clearStates() {
        for (PojoIndexedTypeIndexingPlan<?, ?> delegate : indexedTypeDelegates.values()) {
            delegate.clearStates();
        }
        for (PojoContainedTypeIndexingPlan<?, ?> delegate : containedTypeDelegates.values()) {
            delegate.clearStates();
        }
    }

    @Override
    public void updateBecauseOfContained(PojoRawTypeIdentifier<?> typeIdentifier, Object containingEntity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void updateBecauseOfContainedAssociation(PojoRawTypeIdentifier<?> typeIdentifier, Object containingEntity, int dirtyAssociationPathOrdinal) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoIndexingProcessorSessionContext sessionContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isDeleted(Object unproxiedObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private AbstractPojoTypeIndexingPlan<?, ?, ?> createDelegate(PojoRawTypeIdentifier<?> typeIdentifier) {
        if (!sessionContext.configuredIndexingPlanFilter().isIncluded(typeIdentifier)) {
            throw IndexingLog.INSTANCE.attemptToCreateIndexingPlanForExcludedType(typeIdentifier);
        }
        PojoWorkTypeContext<?, ?> typeContext = typeContextProvider.forExactType(typeIdentifier);
        Optional<? extends PojoWorkIndexedTypeContext<?, ?>> indexedTypeContextOptional = typeContext.asIndexed();
        if (indexedTypeContextOptional.isPresent()) {
            // extracting a variable to work around an Eclipse compiler issue
            PojoWorkIndexedTypeContext<?, ?> indexedTypeContext = indexedTypeContextOptional.get();
            PojoIndexedTypeIndexingPlan<?, ?> delegate = createDelegate(indexedTypeContext);
            indexedTypeDelegates.put(typeIdentifier, delegate);
            return delegate;
        } else {
            // extracting a variable to work around an Eclipse compiler issue
            PojoWorkContainedTypeContext<?, ?> containedTypeContext = typeContext.asContained().orElseThrow(() -> new AssertionFailure("Type is neither indexed nor contained"));
            PojoContainedTypeIndexingPlan<?, ?> delegate = createDelegate(containedTypeContext);
            containedTypeDelegates.put(typeIdentifier, delegate);
            return delegate;
        }
    }

    @Override
    public PojoLoadingPlan<Object> loadingPlan() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private <I, E> PojoIndexedTypeIndexingPlan<I, E> createDelegate(PojoWorkIndexedTypeContext<I, E> typeContext) {
        return strategy.createIndexedDelegate(typeContext, sessionContext, this);
    }

    private PojoContainedTypeIndexingPlan<?, ?> createDelegate(PojoWorkContainedTypeContext<?, ?> typeContext) {
        return strategy.createDelegate(typeContext, sessionContext, this);
    }
}
