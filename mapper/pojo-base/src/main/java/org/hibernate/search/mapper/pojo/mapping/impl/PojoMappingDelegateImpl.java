/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.impl;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import org.hibernate.search.engine.backend.common.spi.EntityReferenceFactory;
import org.hibernate.search.engine.backend.work.execution.DocumentCommitStrategy;
import org.hibernate.search.engine.backend.work.execution.DocumentRefreshStrategy;
import org.hibernate.search.engine.common.EntityReference;
import org.hibernate.search.engine.environment.thread.spi.ThreadPoolProvider;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.engine.search.projection.definition.spi.ProjectionRegistry;
import org.hibernate.search.engine.search.projection.spi.ProjectionMappedTypeContext;
import org.hibernate.search.engine.tenancy.spi.TenancyMode;
import org.hibernate.search.mapper.pojo.common.spi.PojoEntityReferenceFactoryDelegate;
import org.hibernate.search.mapper.pojo.loading.spi.PojoLoadingTypeContextProvider;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.mapping.spi.PojoMappingDelegate;
import org.hibernate.search.mapper.pojo.mapping.spi.PojoRawTypeIdentifierResolver;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.scope.impl.PojoScopeDelegateImpl;
import org.hibernate.search.mapper.pojo.scope.impl.PojoScopeIndexedTypeContext;
import org.hibernate.search.mapper.pojo.scope.spi.PojoScopeDelegate;
import org.hibernate.search.mapper.pojo.scope.spi.PojoScopeMappingContext;
import org.hibernate.search.mapper.pojo.scope.spi.PojoScopeTypeExtendedContextProvider;
import org.hibernate.search.mapper.pojo.search.definition.impl.PojoSearchQueryElementRegistry;
import org.hibernate.search.mapper.pojo.work.SearchIndexingPlanFilter;
import org.hibernate.search.mapper.pojo.work.impl.PojoIndexerImpl;
import org.hibernate.search.mapper.pojo.work.impl.PojoIndexingPlanEventProcessingStrategy;
import org.hibernate.search.mapper.pojo.work.impl.PojoIndexingPlanEventSendingStrategy;
import org.hibernate.search.mapper.pojo.work.impl.PojoIndexingPlanImpl;
import org.hibernate.search.mapper.pojo.work.impl.PojoIndexingPlanLocalStrategy;
import org.hibernate.search.mapper.pojo.work.impl.PojoIndexingQueueEventProcessingPlanImpl;
import org.hibernate.search.mapper.pojo.work.impl.SearchIndexingPlanFilterContextImpl;
import org.hibernate.search.mapper.pojo.work.spi.ConfiguredSearchIndexingPlanFilter;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexer;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingQueueEventProcessingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingQueueEventSendingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoWorkSessionContext;

public class PojoMappingDelegateImpl implements PojoMappingDelegate {

    private final ThreadPoolProvider threadPoolProvider;

    private final FailureHandler failureHandler;

    private final TenancyMode tenancyMode;

    private final PojoTypeManagerContainer typeManagers;

    private final PojoSearchQueryElementRegistry searchQueryElementRegistry;

    public PojoMappingDelegateImpl(ThreadPoolProvider threadPoolProvider, FailureHandler failureHandler, TenancyMode tenancyMode, PojoTypeManagerContainer typeManagers, PojoSearchQueryElementRegistry searchQueryElementRegistry) {
        this.threadPoolProvider = threadPoolProvider;
        this.failureHandler = failureHandler;
        this.tenancyMode = tenancyMode;
        this.typeManagers = typeManagers;
        this.searchQueryElementRegistry = searchQueryElementRegistry;
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ThreadPoolProvider threadPoolProvider() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FailureHandler failureHandler() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoRawTypeIdentifierResolver typeIdentifierResolver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoLoadingTypeContextProvider typeContextProvider() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TenancyMode tenancyMode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectionRegistry projectionRegistry() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectionMappedTypeContext mappedTypeContext(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EntityReferenceFactory createEntityReferenceFactory(PojoEntityReferenceFactoryDelegate delegate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <SR, R extends EntityReference, E, C> PojoScopeDelegate<SR, R, E, C> createPojoScopeForClasses(PojoScopeMappingContext mappingContext, Class<SR> rootScope, Collection<? extends Class<? extends E>> classes, PojoScopeTypeExtendedContextProvider<E, C> indexedTypeExtendedContextProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    // The cast is checked through reflection
    @SuppressWarnings("unchecked")
    public <SR, R extends EntityReference, E, C> PojoScopeDelegate<SR, R, E, C> createPojoScopeForEntityNames(PojoScopeMappingContext mappingContext, Class<SR> rootScope, Class<E> expectedSuperType, Collection<String> entityNames, PojoScopeTypeExtendedContextProvider<E, C> indexedTypeExtendedContextProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @Deprecated(since = "7.1")
    public <SR, R extends EntityReference, E, C> PojoScopeDelegate<SR, R, E, C> createPojoScope(PojoScopeMappingContext mappingContext, Class<SR> rootScope, Collection<? extends PojoRawTypeIdentifier<? extends E>> targetedTypes, PojoScopeTypeExtendedContextProvider<E, C> indexedTypeExtendedContextProvider) {
        if (targetedTypes.isEmpty()) {
            throw MappingLog.INSTANCE.invalidEmptyTargetForScope();
        }
        return PojoScopeDelegateImpl.create(mappingContext, rootScope, typeManagers, (Set<? extends PojoScopeIndexedTypeContext<?, ? extends E>>) typeManagers.indexedForSuperTypes(targetedTypes), indexedTypeExtendedContextProvider);
    }

    @Override
    public <SR, R extends EntityReference, C> Optional<PojoScopeDelegate<SR, R, Object, C>> createPojoAllScope(PojoScopeMappingContext mappingContext, Class<SR> rootScope, PojoScopeTypeExtendedContextProvider<Object, C> indexedTypeExtendedContextProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoIndexingPlan createIndexingPlan(PojoWorkSessionContext context, DocumentCommitStrategy commitStrategy, DocumentRefreshStrategy refreshStrategy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoIndexingPlan createIndexingPlan(PojoWorkSessionContext context, PojoIndexingQueueEventSendingPlan sendingPlan) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoIndexingQueueEventProcessingPlan createEventProcessingPlan(PojoWorkSessionContext context, DocumentCommitStrategy commitStrategy, DocumentRefreshStrategy refreshStrategy, PojoIndexingQueueEventSendingPlan sendingPlan) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoIndexer createIndexer(PojoWorkSessionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConfiguredSearchIndexingPlanFilter configuredSearchIndexingPlanFilter(SearchIndexingPlanFilter filter, ConfiguredSearchIndexingPlanFilter fallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
