/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.mapping.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.search.engine.backend.Backend;
import org.hibernate.search.engine.backend.index.IndexManager;
import org.hibernate.search.engine.backend.reporting.spi.BackendMappingHints;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.common.spi.SearchIntegration;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.mapper.mapping.spi.MappingImplementor;
import org.hibernate.search.engine.mapper.mapping.spi.MappingPreStopContext;
import org.hibernate.search.engine.mapper.mapping.spi.MappingStartContext;
import org.hibernate.search.engine.search.common.NonStaticMetamodelScope;
import org.hibernate.search.mapper.orm.automaticindexing.impl.AutomaticIndexingQueueEventProcessingPlanImpl;
import org.hibernate.search.mapper.orm.automaticindexing.spi.AutomaticIndexingMappingContext;
import org.hibernate.search.mapper.orm.automaticindexing.spi.AutomaticIndexingQueueEventProcessingPlan;
import org.hibernate.search.mapper.orm.cfg.HibernateOrmMapperSettings;
import org.hibernate.search.mapper.orm.common.EntityReference;
import org.hibernate.search.mapper.orm.common.impl.HibernateOrmUtils;
import org.hibernate.search.mapper.orm.coordination.common.spi.CoordinationStrategy;
import org.hibernate.search.mapper.orm.entity.SearchIndexedEntity;
import org.hibernate.search.mapper.orm.event.impl.HibernateOrmListenerContextProvider;
import org.hibernate.search.mapper.orm.logging.impl.OrmMiscLog;
import org.hibernate.search.mapper.orm.mapping.SearchMapping;
import org.hibernate.search.mapper.orm.mapping.context.HibernateOrmMappingContext;
import org.hibernate.search.mapper.orm.mapping.spi.CoordinationStrategyContext;
import org.hibernate.search.mapper.orm.reporting.impl.HibernateOrmMappingHints;
import org.hibernate.search.mapper.orm.schema.management.SchemaManagementStrategyName;
import org.hibernate.search.mapper.orm.schema.management.impl.SchemaManagementListener;
import org.hibernate.search.mapper.orm.scope.TypedSearchScope;
import org.hibernate.search.mapper.orm.scope.impl.HibernateOrmScopeMappingContext;
import org.hibernate.search.mapper.orm.scope.impl.HibernateOrmScopeSessionContext;
import org.hibernate.search.mapper.orm.scope.impl.TypedSearchScopeImpl;
import org.hibernate.search.mapper.orm.search.loading.EntityLoadingCacheLookupStrategy;
import org.hibernate.search.mapper.orm.session.impl.ConfiguredAutomaticIndexingStrategy;
import org.hibernate.search.mapper.orm.session.impl.HibernateOrmSearchSession;
import org.hibernate.search.mapper.orm.session.impl.HibernateOrmSearchSessionMappingContext;
import org.hibernate.search.mapper.orm.spi.BatchMappingContext;
import org.hibernate.search.mapper.orm.tenancy.spi.TenancyConfiguration;
import org.hibernate.search.mapper.pojo.mapping.spi.AbstractPojoMappingImplementor;
import org.hibernate.search.mapper.pojo.mapping.spi.PojoMappingDelegate;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingDefaultCleanOperation;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexerAgent;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexerAgentCreateContext;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.schema.management.spi.PojoScopeSchemaManager;
import org.hibernate.search.mapper.pojo.scope.spi.PojoScopeDelegate;
import org.hibernate.search.mapper.pojo.work.SearchIndexingPlanFilter;
import org.hibernate.search.mapper.pojo.work.spi.ConfiguredIndexingPlanSynchronizationStrategy;
import org.hibernate.search.mapper.pojo.work.spi.ConfiguredSearchIndexingPlanFilter;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoTypeIndexingPlan;
import org.hibernate.search.util.common.impl.Closer;

@SuppressWarnings("deprecation")
public class HibernateOrmMapping extends AbstractPojoMappingImplementor<HibernateOrmMapping> implements SearchMapping, AutoCloseable, HibernateOrmMappingContext, HibernateOrmListenerContextProvider, BatchMappingContext, HibernateOrmScopeMappingContext, HibernateOrmSearchSessionMappingContext, AutomaticIndexingMappingContext, CoordinationStrategyContext {

    private static final ConfigurationProperty<EntityLoadingCacheLookupStrategy> QUERY_LOADING_CACHE_LOOKUP_STRATEGY = ConfigurationProperty.forKey(HibernateOrmMapperSettings.Radicals.QUERY_LOADING_CACHE_LOOKUP_STRATEGY).as(EntityLoadingCacheLookupStrategy.class, EntityLoadingCacheLookupStrategy::of).withDefault(HibernateOrmMapperSettings.Defaults.QUERY_LOADING_CACHE_LOOKUP_STRATEGY).build();

    private static final ConfigurationProperty<Integer> QUERY_LOADING_FETCH_SIZE = ConfigurationProperty.forKey(HibernateOrmMapperSettings.Radicals.QUERY_LOADING_FETCH_SIZE).asIntegerStrictlyPositive().withDefault(HibernateOrmMapperSettings.Defaults.QUERY_LOADING_FETCH_SIZE).build();

    private static final ConfigurationProperty<SchemaManagementStrategyName> SCHEMA_MANAGEMENT_STRATEGY = ConfigurationProperty.forKey(HibernateOrmMapperSettings.Radicals.SCHEMA_MANAGEMENT_STRATEGY).as(SchemaManagementStrategyName.class, SchemaManagementStrategyName::of).withDefault(HibernateOrmMapperSettings.Defaults.SCHEMA_MANAGEMENT_STRATEGY).build();

    private static final ConfigurationProperty<MassIndexingDefaultCleanOperation> INDEXING_MASS_DEFAULT_CLEAN_OPERATION = ConfigurationProperty.forKey(HibernateOrmMapperSettings.Radicals.INDEXING_MASS_DEFAULT_CLEAN_OPERATION).as(MassIndexingDefaultCleanOperation.class, MassIndexingDefaultCleanOperation::of).withDefault(HibernateOrmMapperSettings.Defaults.INDEXING_MASS_DEFAULT_CLEAN_OPERATION).build();

    public static MappingImplementor<HibernateOrmMapping> create(PojoMappingDelegate mappingDelegate, HibernateOrmTypeContextContainer typeContextContainer, BeanHolder<? extends CoordinationStrategy> coordinationStrategyHolder, ConfiguredAutomaticIndexingStrategy configuredAutomaticIndexingStrategy, SessionFactoryImplementor sessionFactory, ConfigurationPropertySource propertySource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final SessionFactoryImplementor sessionFactory;

    private final HibernateOrmTypeContextContainer typeContextContainer;

    private final BeanHolder<? extends CoordinationStrategy> coordinationStrategyHolder;

    private final ConfiguredAutomaticIndexingStrategy configuredAutomaticIndexingStrategy;

    private final EntityLoadingCacheLookupStrategy cacheLookupStrategy;

    private final int fetchSize;

    private final SchemaManagementListener schemaManagementListener;

    private final MassIndexingDefaultCleanOperation massIndexingDefaultCleanOperation;

    private volatile ConfiguredSearchIndexingPlanFilter applicationIndexingPlanFilter = ConfiguredSearchIndexingPlanFilter.IncludeAll.INSTANCE;

    private TenancyConfiguration tenancyConfiguration;

    private SearchIntegration.Handle integrationHandle;

    private volatile boolean listenerEnabled = true;

    private HibernateOrmMapping(PojoMappingDelegate mappingDelegate, HibernateOrmTypeContextContainer typeContextContainer, SessionFactoryImplementor sessionFactory, BeanHolder<? extends CoordinationStrategy> coordinationStrategyHolder, ConfiguredAutomaticIndexingStrategy configuredAutomaticIndexingStrategy, EntityLoadingCacheLookupStrategy cacheLookupStrategy, int fetchSize, SchemaManagementListener schemaManagementListener, MassIndexingDefaultCleanOperation massIndexingDefaultCleanOperation) {
        super(mappingDelegate, org.hibernate.search.mapper.orm.common.impl.HibernateOrmEntityReference::new);
        this.typeContextContainer = typeContextContainer;
        this.sessionFactory = sessionFactory;
        this.coordinationStrategyHolder = coordinationStrategyHolder;
        this.configuredAutomaticIndexingStrategy = configuredAutomaticIndexingStrategy;
        this.cacheLookupStrategy = cacheLookupStrategy;
        this.fetchSize = fetchSize;
        this.schemaManagementListener = schemaManagementListener;
        this.massIndexingDefaultCleanOperation = massIndexingDefaultCleanOperation;
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
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
    protected void doStop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BackendMappingHints hints() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> TypedSearchScopeImpl<?, T> scope(Class<T> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> TypedSearchScopeImpl<?, T> scope(Class<T> expectedSuperType, String entityName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> TypedSearchScopeImpl<?, T> scope(Collection<? extends Class<? extends T>> classes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> TypedSearchScopeImpl<?, T> scope(Class<T> expectedSuperType, Collection<String> entityNames) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <SR, T> TypedSearchScope<SR, T> typedScope(Class<SR> rootScope, Collection<? extends Class<? extends T>> classes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EntityManagerFactory toEntityManagerFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SessionFactory toOrmSessionFactory() {
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
    public void indexingPlanFilter(SearchIndexingPlanFilter filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ConfiguredSearchIndexingPlanFilter applicationIndexingPlanFilter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConfiguredSearchIndexingPlanFilter configuredSearchIndexingPlanFilter(SearchIndexingPlanFilter filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HibernateOrmMapping toConcreteType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EntityLoadingCacheLookupStrategy cacheLookupStrategy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int fetchSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SessionFactoryImplementor sessionFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TenancyConfiguration tenancyConfiguration() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexingDefaultCleanOperation massIndexingDefaultCleanOperation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HibernateOrmScopeSessionContext sessionContext(EntityManager entityManager) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean listenerEnabled() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // For tests
    public void listenerEnabled(boolean enabled) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // For tests
    public CompletableFuture<?> backgroundIndexingCompletion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoMassIndexerAgent createMassIndexerAgent(PojoMassIndexerAgentCreateContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoIndexingPlan currentIndexingPlanIfExisting(SessionImplementor session) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoTypeIndexingPlan currentIndexingPlanIfTypeIncluded(SharedSessionContractImplementor session, PojoRawTypeIdentifier<?> typeIdentifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AutomaticIndexingQueueEventProcessingPlan createIndexingQueueEventProcessingPlan(Session session) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConfiguredIndexingPlanSynchronizationStrategy currentAutomaticIndexingSynchronizationStrategy(SessionImplementor session) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HibernateOrmTypeContextContainer typeContextProvider() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <SR, T> TypedSearchScopeImpl<SR, T> createScope(Class<SR> rootScope, Collection<? extends Class<? extends T>> classes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <SR, T> TypedSearchScopeImpl<SR, T> createScope(Class<SR> rootScope, Class<T> expectedSuperType, Collection<String> entityNames) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HibernateOrmSearchSession.Builder createSessionBuilder(SharedSessionContractImplementor sessionImplementor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CoordinationStrategy coordinationStrategy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private SearchIntegration searchIntegration() {
        return integrationHandle.getOrFail();
    }

    private Optional<TypedSearchScopeImpl<?, Object>> createAllScope() {
        return delegate().<NonStaticMetamodelScope, EntityReference, SearchIndexedEntity<?>>createPojoAllScope(this, NonStaticMetamodelScope.class, typeContextContainer::indexedForExactType).map(scopeDelegate -> new TypedSearchScopeImpl<>(this, tenancyConfiguration, scopeDelegate));
    }
}
