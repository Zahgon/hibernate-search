/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.work.impl;

import java.util.BitSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import org.hibernate.search.engine.backend.common.spi.MultiEntityOperationExecutionReport;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.engine.common.EntityReference;
import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoImplicitReindexingAssociationInverseSideResolverRootContext;
import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoImplicitReindexingResolverRootContext;
import org.hibernate.search.mapper.pojo.automaticindexing.spi.PojoImplicitReindexingResolverSessionContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.impl.DocumentRouter;
import org.hibernate.search.mapper.pojo.bridge.runtime.impl.NoOpDocumentRouter;
import org.hibernate.search.mapper.pojo.logging.impl.IndexingLog;
import org.hibernate.search.mapper.pojo.model.path.spi.PojoPathFilter;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.model.spi.PojoRuntimeIntrospector;
import org.hibernate.search.mapper.pojo.route.DocumentRouteDescriptor;
import org.hibernate.search.mapper.pojo.route.DocumentRoutesDescriptor;
import org.hibernate.search.mapper.pojo.work.spi.PojoTypeIndexingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoWorkSessionContext;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.SearchException;

/**
 * @param <I> The type of identifiers of entities in this plan.
 * @param <E> The type of entities in this plan.
 * @param <S> The type of per-instance state.
 */
abstract class AbstractPojoTypeIndexingPlan<I, E, S extends AbstractPojoTypeIndexingPlan<I, E, S>.AbstractEntityState> implements PojoImplicitReindexingAssociationInverseSideResolverRootContext, PojoTypeIndexingPlan {

    final PojoWorkSessionContext sessionContext;

    final PojoIndexingPlanImpl root;

    final PojoTypeIndexingPlanDelegate<I, E> delegate;

    // Use a LinkedHashMap for deterministic iteration
    final Map<I, S> statesPerId = new LinkedHashMap<>();

    private boolean mayRequireLoading = false;

    AbstractPojoTypeIndexingPlan(PojoWorkSessionContext sessionContext, PojoIndexingPlanImpl root, PojoTypeIndexingPlanDelegate<I, E> delegate) {
        this.sessionContext = sessionContext;
        this.root = root;
        this.delegate = delegate;
    }

    @Override
    public void add(Object providedId, DocumentRoutesDescriptor providedRoutes, Object entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addOrUpdate(Object providedId, DocumentRoutesDescriptor providedRoutes, Object entity, boolean forceSelfDirty, boolean forceContainingDirty, BitSet dirtyPaths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void delete(Object providedId, DocumentRoutesDescriptor providedRoutes, Object entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addOrUpdateOrDelete(Object providedId, DocumentRoutesDescriptor providedRoutes, boolean forceSelfDirty, boolean forceContainingDirty, BitSet dirtyPaths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void updateAssociationInverseSide(BitSet dirtyAssociationPaths, Object[] oldState, Object[] newState) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Should only be called on indexed types,
    // but it's simpler to implement this method for both indexed and contained types.
    void updateBecauseOfContained(Object entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void updateBecauseOfContainedAssociation(Object entity, int dirtyAssociationPathOrdinal) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void planLoading() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void resolveDirty(boolean deleteOnly) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void discard() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void clearStates() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void process(PojoLoadingPlanProvider loadingPlanProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    CompletableFuture<MultiEntityOperationExecutionReport> executeAndReport(OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract PojoWorkTypeContext<I, E> typeContext();

    abstract DocumentRouter<? super E> router();

    I toIdentifier(Object providedId, Supplier<E> entitySupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    final S getState(I identifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoRuntimeIntrospector runtimeIntrospector() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoRawTypeIdentifier<?> detectContainingEntityType(Object containingEntity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // This is used for reindexing resolution only:
    // for indexing, we always propagate exceptions.
    @Override
    public void propagateOrIgnoreContainerExtractionException(RuntimeException exception) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // This is used for reindexing resolution only:
    // for indexing, we always propagate exceptions.
    @Override
    public void propagateOrIgnorePropertyAccessException(RuntimeException exception) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean isIgnorableDataAccessThrowable(RuntimeException exception) {
        Throwable firstNonSearchThrowable = exception;
        while (firstNonSearchThrowable instanceof SearchException) {
            firstNonSearchThrowable = exception.getCause();
        }
        return firstNonSearchThrowable != null && sessionContext.runtimeIntrospector().isIgnorableDataAccessThrowable(firstNonSearchThrowable);
    }

    protected abstract S createState(I identifier);

    boolean isDeleted(Object unproxiedObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract class AbstractEntityState implements PojoImplicitReindexingResolverRootContext {

        final I identifier;

        private Supplier<E> entitySupplier;

        private Integer loadingOrdinal;

        EntityStatus initialStatus = EntityStatus.UNKNOWN;

        EntityStatus currentStatus = EntityStatus.UNKNOWN;

        private boolean updatedBecauseOfContained;

        private boolean forceSelfDirty;

        private boolean forceContainingDirty;

        private BitSet dirtyPaths;

        AbstractEntityState(I identifier) {
            this.identifier = identifier;
        }

        @Override
        public PojoImplicitReindexingResolverSessionContext sessionContext() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public boolean isDirtyForAddOrUpdate() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean isDirtyForReindexingResolution(PojoPathFilter filter) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public PojoRawTypeIdentifier<?> detectContainingEntityType(Object containingEntity) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        // This is used for reindexing resolution only:
        // for indexing, we always propagate exceptions.
        @Override
        public void propagateOrIgnoreContainerExtractionException(RuntimeException exception) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        // This is used for reindexing resolution only:
        // for indexing, we always propagate exceptions.
        @Override
        public void propagateOrIgnorePropertyAccessException(RuntimeException exception) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void add(Supplier<E> entitySupplier) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void addOrUpdate(Supplier<E> entitySupplier, BitSet dirtyPaths, boolean forceSelfDirty, boolean forceContainingDirty) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        // Should only be called on indexed types,
        // but it's simpler to implement this method for both indexed and contained types.
        void updateBecauseOfContained(Supplier<E> entitySupplier) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void doAddOrUpdate(Supplier<E> entitySupplier) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void delete(Supplier<E> entitySupplier) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void addOrUpdateOrDelete(BitSet dirtyPaths, boolean forceSelfDirty, boolean forceContainingDirty) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected void doUpdateDirty(BitSet dirtyPaths, boolean forceSelfDirty, boolean forceContainingDirty) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        abstract void providedRoutes(DocumentRoutesDescriptor routes);

        abstract DocumentRoutesDescriptor providedRoutes();

        void planLoading() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void resolveDirty(boolean deleteOnly) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void sendCommandsToDelegate(PojoLoadingPlanProvider loadingPlanProvider) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void delegateAdd(PojoLoadingPlanProvider loadingPlanProvider) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void delegateAddOrUpdate(PojoLoadingPlanProvider loadingPlanProvider) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void delegateDelete() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        Supplier<E> entitySupplierNoLoad() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        Supplier<E> entitySupplierOrLoad(PojoLoadingPlanProvider loadingPlanProvider) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void addDirtyPaths(BitSet newDirtyPaths) {
            if (newDirtyPaths == null) {
                return;
            }
            if (dirtyPaths == null) {
                dirtyPaths = new BitSet();
            }
            dirtyPaths.or(newDirtyPaths);
        }
    }

    protected enum EntityStatus {

        UNKNOWN, PRESENT, ABSENT
    }
}
