/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.standalone.mapping.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.hibernate.search.engine.backend.Backend;
import org.hibernate.search.engine.backend.index.IndexManager;
import org.hibernate.search.engine.backend.reporting.spi.BackendMappingHints;
import org.hibernate.search.engine.common.EntityReference;
import org.hibernate.search.engine.common.spi.SearchIntegration;
import org.hibernate.search.engine.mapper.mapping.spi.MappingPreStopContext;
import org.hibernate.search.engine.mapper.mapping.spi.MappingStartContext;
import org.hibernate.search.engine.search.common.NonStaticMetamodelScope;
import org.hibernate.search.mapper.pojo.mapping.spi.AbstractPojoMappingImplementor;
import org.hibernate.search.mapper.pojo.mapping.spi.PojoMappingDelegate;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingDefaultCleanOperation;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexerAgent;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexerAgentCreateContext;
import org.hibernate.search.mapper.pojo.model.spi.PojoRuntimeIntrospector;
import org.hibernate.search.mapper.pojo.schema.management.spi.PojoScopeSchemaManager;
import org.hibernate.search.mapper.pojo.scope.spi.PojoScopeDelegate;
import org.hibernate.search.mapper.pojo.standalone.entity.SearchIndexedEntity;
import org.hibernate.search.mapper.pojo.standalone.loading.impl.StandalonePojoLoadingContext;
import org.hibernate.search.mapper.pojo.standalone.mapping.CloseableSearchMapping;
import org.hibernate.search.mapper.pojo.standalone.massindexing.impl.StandalonePojoMassIndexingSessionContext;
import org.hibernate.search.mapper.pojo.standalone.reporting.impl.StandalonePojoMappingHints;
import org.hibernate.search.mapper.pojo.standalone.schema.management.impl.SchemaManagementListener;
import org.hibernate.search.mapper.pojo.standalone.scope.SearchScope;
import org.hibernate.search.mapper.pojo.standalone.scope.TypedSearchScope;
import org.hibernate.search.mapper.pojo.standalone.scope.impl.SearchScopeImpl;
import org.hibernate.search.mapper.pojo.standalone.session.SearchSession;
import org.hibernate.search.mapper.pojo.standalone.session.SearchSessionBuilder;
import org.hibernate.search.mapper.pojo.standalone.session.impl.StandalonePojoSearchSession;
import org.hibernate.search.mapper.pojo.standalone.session.impl.StandalonePojoSearchSessionMappingContext;
import org.hibernate.search.mapper.pojo.standalone.tenancy.impl.TenancyConfiguration;
import org.hibernate.search.util.common.impl.Closer;

public class StandalonePojoMapping extends AbstractPojoMappingImplementor<StandalonePojoMapping> implements CloseableSearchMapping, StandalonePojoSearchSessionMappingContext {

    private final StandalonePojoTypeContextContainer typeContextContainer;

    private final SchemaManagementListener schemaManagementListener;

    private final ConfiguredIndexingPlanSynchronizationStrategyHolder configuredIndexingPlanSynchronizationStrategyHolder;

    private final MassIndexingDefaultCleanOperation massIndexingDefaultCleanOperation;

    private SearchIntegration.Handle integrationHandle;

    private TenancyConfiguration tenancyConfiguration;

    private boolean active;

    StandalonePojoMapping(PojoMappingDelegate mappingDelegate, StandalonePojoTypeContextContainer typeContextContainer, SchemaManagementListener schemaManagementListener, MassIndexingDefaultCleanOperation massIndexingDefaultCleanOperation) {
        super(mappingDelegate);
        this.typeContextContainer = typeContextContainer;
        this.schemaManagementListener = schemaManagementListener;
        this.configuredIndexingPlanSynchronizationStrategyHolder = new ConfiguredIndexingPlanSynchronizationStrategyHolder(this);
        this.active = true;
        this.massIndexingDefaultCleanOperation = massIndexingDefaultCleanOperation;
    }

    @Override
    public CompletableFuture<?> start(MappingStartContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> preStop(MappingPreStopContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BackendMappingHints hints() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoRuntimeIntrospector runtimeIntrospector() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexingDefaultCleanOperation massIndexingDefaultCleanOperation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> SearchScope<T> scope(Collection<? extends Class<? extends T>> targetedTypes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> SearchScope<T> scope(Class<T> expectedSuperType, Collection<String> entityNames) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <SR, T> TypedSearchScope<SR, T> typedScope(Class<SR> rootScope, Collection<? extends Class<? extends T>> classes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandalonePojoMapping toConcreteType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchSession createSession() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchSessionBuilder createSessionWithOptions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <SR, T> SearchScopeImpl<SR, T> createScope(Class<SR> rootScope, Collection<? extends Class<? extends T>> classes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <SR, T> SearchScopeImpl<SR, T> createScope(Class<SR> rootScope, Class<T> expectedSuperType, Collection<String> entityNames) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <E> SearchIndexedEntity<E> indexedEntity(Class<E> entityType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchIndexedEntity<?> indexedEntity(String entityName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Collection<SearchIndexedEntity<?>> allIndexedEntities() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexManager indexManager(String indexName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Backend backend() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Backend backend(String backendName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandalonePojoLoadingContext.Builder loadingContextBuilder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoMassIndexerAgent createMassIndexerAgent(PojoMassIndexerAgentCreateContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandalonePojoMassIndexingSessionContext createSession(String tenantIdentifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TenancyConfiguration tenancyConfiguration() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private SearchIntegration searchIntegration() {
        return integrationHandle.getOrFail();
    }

    private Optional<SearchScopeImpl<?, Object>> createAllScope() {
        return delegate().<NonStaticMetamodelScope, EntityReference, SearchIndexedEntity<?>>createPojoAllScope(this, NonStaticMetamodelScope.class, typeContextContainer::indexedForExactType).map(scopeDelegate -> new SearchScopeImpl<>(this, tenancyConfiguration, scopeDelegate));
    }

    private StandalonePojoSearchSession.Builder createSessionBuilder() {
        return new StandalonePojoSearchSession.Builder(this, configuredIndexingPlanSynchronizationStrategyHolder, typeContextContainer);
    }
}
