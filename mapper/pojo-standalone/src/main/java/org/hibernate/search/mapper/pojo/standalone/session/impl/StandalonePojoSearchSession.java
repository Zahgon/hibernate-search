/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.standalone.session.impl;

import static org.hibernate.search.util.common.impl.CollectionHelper.asSetIgnoreNull;
import java.util.Collection;
import java.util.function.Consumer;
import org.hibernate.search.engine.common.EntityReference;
import org.hibernate.search.engine.search.common.NonStaticMetamodelScope;
import org.hibernate.search.engine.search.query.dsl.SearchQuerySelectStep;
import org.hibernate.search.mapper.pojo.loading.spi.PojoSelectionLoadingContext;
import org.hibernate.search.mapper.pojo.model.spi.PojoRuntimeIntrospector;
import org.hibernate.search.mapper.pojo.session.spi.AbstractPojoSearchSession;
import org.hibernate.search.mapper.pojo.standalone.loading.dsl.SelectionLoadingOptionsStep;
import org.hibernate.search.mapper.pojo.standalone.loading.impl.StandalonePojoLoadingContext;
import org.hibernate.search.mapper.pojo.standalone.loading.impl.StandalonePojoLoadingSessionContext;
import org.hibernate.search.mapper.pojo.standalone.loading.impl.StandalonePojoSelectionLoadingContextBuilder;
import org.hibernate.search.mapper.pojo.standalone.logging.impl.SessionLog;
import org.hibernate.search.mapper.pojo.standalone.mapping.impl.ConfiguredIndexingPlanSynchronizationStrategyHolder;
import org.hibernate.search.mapper.pojo.standalone.massindexing.MassIndexer;
import org.hibernate.search.mapper.pojo.standalone.massindexing.impl.StandalonePojoMassIndexingSessionContext;
import org.hibernate.search.mapper.pojo.standalone.reporting.impl.StandalonePojoMapperHints;
import org.hibernate.search.mapper.pojo.standalone.schema.management.SearchSchemaManager;
import org.hibernate.search.mapper.pojo.standalone.scope.SearchScope;
import org.hibernate.search.mapper.pojo.standalone.scope.StandalonePojoRootReferenceScope;
import org.hibernate.search.mapper.pojo.standalone.scope.TypedSearchScope;
import org.hibernate.search.mapper.pojo.standalone.scope.impl.SearchScopeImpl;
import org.hibernate.search.mapper.pojo.standalone.session.SearchSession;
import org.hibernate.search.mapper.pojo.standalone.session.SearchSessionBuilder;
import org.hibernate.search.mapper.pojo.standalone.work.SearchIndexer;
import org.hibernate.search.mapper.pojo.standalone.work.SearchIndexingPlan;
import org.hibernate.search.mapper.pojo.standalone.work.SearchWorkspace;
import org.hibernate.search.mapper.pojo.standalone.work.impl.SearchIndexerImpl;
import org.hibernate.search.mapper.pojo.standalone.work.impl.SearchIndexingPlanImpl;
import org.hibernate.search.mapper.pojo.work.IndexingPlanSynchronizationStrategy;
import org.hibernate.search.mapper.pojo.work.spi.ConfiguredIndexingPlanSynchronizationStrategy;
import org.hibernate.search.mapper.pojo.work.spi.ConfiguredSearchIndexingPlanFilter;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexer;

public class StandalonePojoSearchSession extends AbstractPojoSearchSession implements SearchSession, StandalonePojoMassIndexingSessionContext, StandalonePojoLoadingSessionContext {

    private static final ConfiguredSearchIndexingPlanFilter ACCEPT_ALL = typeIdentifier -> true;

    private final StandalonePojoSearchSessionMappingContext mappingContext;

    private final StandalonePojoSearchSessionTypeContextProvider typeContextProvider;

    private final String tenantId;

    private final Consumer<SelectionLoadingOptionsStep> loadingOptionsContributor;

    private final ConfiguredIndexingPlanSynchronizationStrategyHolder synchronizationStrategyHolder;

    private final ConfiguredSearchIndexingPlanFilter configuredIndexingPlanFilter;

    private SearchIndexingPlanImpl indexingPlan;

    private SearchIndexer indexer;

    private boolean open = true;

    private ConfiguredIndexingPlanSynchronizationStrategy indexingPlanSynchronizationStrategy;

    private StandalonePojoSearchSession(Builder builder) {
        super(builder.mappingContext);
        this.mappingContext = builder.mappingContext;
        this.typeContextProvider = builder.typeContextProvider;
        this.tenantId = builder.tenantId;
        this.loadingOptionsContributor = builder.loadingOptionsContributor;
        this.synchronizationStrategyHolder = builder.synchronizationStrategyHolder;
        this.indexingPlanSynchronizationStrategy = this.synchronizationStrategyHolder.configureOverriddenSynchronizationStrategy(builder.synchronizationStrategy);
        this.configuredIndexingPlanFilter = ACCEPT_ALL;
    }

    private void checkOpenAndThrow() {
        if (!open) {
            throw SessionLog.INSTANCE.hibernateSessionAccessError(StandalonePojoMapperHints.INSTANCE.closedSession());
        }
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isOpen() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer massIndexer(Collection<? extends Class<?>> classes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("removal")
    public String tenantIdentifier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object tenantIdentifierValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void indexingPlanSynchronizationStrategy(IndexingPlanSynchronizationStrategy synchronizationStrategy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoIndexer createIndexer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoRuntimeIntrospector runtimeIntrospector() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> SearchQuerySelectStep<NonStaticMetamodelScope, ?, EntityReference, T, ?, ?, ?> search(Collection<? extends Class<? extends T>> classes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> SearchQuerySelectStep<?, ?, EntityReference, T, ?, ?, ?> search(SearchScope<T> scope) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <SR, T> SearchQuerySelectStep<SR, ?, EntityReference, T, ?, ?, ?> search(TypedSearchScope<SR, T> scope) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <SR, T> SearchQuerySelectStep<SR, ?, EntityReference, T, ?, ?, ?> search(StandalonePojoRootReferenceScope<SR, T> referenceScope) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchSchemaManager schemaManager(Collection<? extends Class<?>> classes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchWorkspace workspace(Collection<? extends Class<?>> classes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> SearchScopeImpl<NonStaticMetamodelScope, T> scope(Collection<? extends Class<? extends T>> types) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> SearchScopeImpl<NonStaticMetamodelScope, T> scope(Class<T> expectedSuperType, Collection<String> entityNames) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <SR, T> SearchScopeImpl<SR, T> typedScope(Class<SR> rootScope, Collection<? extends Class<? extends T>> classes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchIndexingPlan indexingPlan() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchIndexer indexer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoSelectionLoadingContext defaultLoadingContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConfiguredSearchIndexingPlanFilter configuredIndexingPlanFilter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandalonePojoSearchSessionMappingContext mappingContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private <SR, T> SearchQuerySelectStep<SR, ?, EntityReference, T, ?, ?, ?> search(SearchScopeImpl<SR, T> scope) {
        return scope.search(this, loadingContextBuilder());
    }

    private StandalonePojoSelectionLoadingContextBuilder loadingContextBuilder() {
        StandalonePojoLoadingContext.Builder builder = mappingContext.loadingContextBuilder();
        if (loadingOptionsContributor != null) {
            loadingOptionsContributor.accept(builder);
        }
        return builder;
    }

    public static class Builder implements SearchSessionBuilder {

        private final StandalonePojoSearchSessionMappingContext mappingContext;

        private final StandalonePojoSearchSessionTypeContextProvider typeContextProvider;

        private final ConfiguredIndexingPlanSynchronizationStrategyHolder synchronizationStrategyHolder;

        private IndexingPlanSynchronizationStrategy synchronizationStrategy;

        private String tenantId;

        private Consumer<SelectionLoadingOptionsStep> loadingOptionsContributor;

        public Builder(StandalonePojoSearchSessionMappingContext mappingContext, ConfiguredIndexingPlanSynchronizationStrategyHolder synchronizationStrategyHolder, StandalonePojoSearchSessionTypeContextProvider typeContextProvider) {
            this.synchronizationStrategyHolder = synchronizationStrategyHolder;
            this.mappingContext = mappingContext;
            this.typeContextProvider = typeContextProvider;
        }

        @Override
        @SuppressWarnings("removal")
        public Builder tenantId(String tenantId) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchSessionBuilder tenantId(Object tenantId) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchSessionBuilder indexingPlanSynchronizationStrategy(IndexingPlanSynchronizationStrategy synchronizationStrategy) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchSessionBuilder loading(Consumer<SelectionLoadingOptionsStep> loadingOptionsContributor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public StandalonePojoSearchSession build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
