/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.session.impl;

import static org.hibernate.search.util.common.impl.CollectionHelper.asSetIgnoreNull;
import java.util.Collection;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Synchronization;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.action.spi.AfterTransactionCompletionProcess;
import org.hibernate.action.spi.BeforeTransactionCompletionProcess;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.engine.spi.TransactionCompletionCallbacks;
import org.hibernate.search.engine.backend.common.spi.EntityReferenceFactory;
import org.hibernate.search.engine.search.common.NonStaticMetamodelScope;
import org.hibernate.search.engine.search.query.dsl.SearchQuerySelectStep;
import org.hibernate.search.mapper.orm.automaticindexing.session.impl.DelegatingAutomaticIndexingSynchronizationStrategy;
import org.hibernate.search.mapper.orm.automaticindexing.spi.AutomaticIndexingEventSendingSessionContext;
import org.hibernate.search.mapper.orm.common.EntityReference;
import org.hibernate.search.mapper.orm.loading.impl.HibernateOrmSelectionLoadingContext;
import org.hibernate.search.mapper.orm.logging.impl.ConfigurationLog;
import org.hibernate.search.mapper.orm.logging.impl.OrmMiscLog;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.model.impl.HibernateOrmRuntimeIntrospector;
import org.hibernate.search.mapper.orm.schema.management.SearchSchemaManager;
import org.hibernate.search.mapper.orm.scope.HibernateOrmRootReferenceScope;
import org.hibernate.search.mapper.orm.scope.SearchScope;
import org.hibernate.search.mapper.orm.scope.TypedSearchScope;
import org.hibernate.search.mapper.orm.scope.impl.HibernateOrmScopeSessionContext;
import org.hibernate.search.mapper.orm.scope.impl.TypedSearchScopeImpl;
import org.hibernate.search.mapper.orm.search.loading.dsl.SearchLoadingOptionsStep;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.hibernate.search.mapper.orm.session.context.HibernateOrmSessionContext;
import org.hibernate.search.mapper.orm.work.SearchIndexingPlan;
import org.hibernate.search.mapper.orm.work.SearchWorkspace;
import org.hibernate.search.mapper.orm.work.impl.SearchIndexingPlanImpl;
import org.hibernate.search.mapper.orm.work.impl.SearchIndexingPlanSessionContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoSelectionLoadingContext;
import org.hibernate.search.mapper.pojo.model.spi.PojoRuntimeIntrospector;
import org.hibernate.search.mapper.pojo.session.spi.AbstractPojoSearchSession;
import org.hibernate.search.mapper.pojo.work.IndexingPlanSynchronizationStrategy;
import org.hibernate.search.mapper.pojo.work.SearchIndexingPlanFilter;
import org.hibernate.search.mapper.pojo.work.spi.ConfiguredIndexingPlanSynchronizationStrategy;
import org.hibernate.search.mapper.pojo.work.spi.ConfiguredSearchIndexingPlanFilter;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexer;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingQueueEventProcessingPlan;

/**
 * The actual implementation of {@link SearchSession}.
 */
@SuppressWarnings("deprecation")
public class HibernateOrmSearchSession extends AbstractPojoSearchSession implements SearchSession, HibernateOrmSessionContext, HibernateOrmScopeSessionContext, SearchIndexingPlanSessionContext, AutomaticIndexingEventSendingSessionContext {

    /**
     * @param sessionImplementor A Hibernate session
     * @return The {@link HibernateOrmSearchSession} to use within the context of the given session.
     */
    public static HibernateOrmSearchSession get(HibernateOrmSearchSessionMappingContext context, SharedSessionContractImplementor sessionImplementor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param sessionImplementor A Hibernate session
     * @return The {@link HibernateOrmSearchSession} to use within the context of the given session.
     */
    public static HibernateOrmSearchSession get(HibernateOrmSearchSessionMappingContext context, SharedSessionContractImplementor sessionImplementor, boolean createIfDoesNotExist) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final HibernateOrmSearchSessionMappingContext mappingContext;

    private final HibernateOrmSessionTypeContextProvider typeContextProvider;

    private final SharedSessionContractImplementor sessionImplementor;

    private final HibernateOrmRuntimeIntrospector runtimeIntrospector;

    private final ConfiguredAutomaticIndexingStrategy automaticIndexingStrategy;

    private ConfiguredSearchIndexingPlanFilter configuredIndexingPlanFilter;

    private ConfiguredIndexingPlanSynchronizationStrategy indexingPlanSynchronizationStrategy;

    private SearchIndexingPlanImpl indexingPlan;

    private HibernateOrmSearchSession(Builder builder) {
        super(builder.mappingContext);
        this.mappingContext = builder.mappingContext;
        this.typeContextProvider = builder.typeContextProvider;
        this.automaticIndexingStrategy = builder.automaticIndexingStrategy;
        this.sessionImplementor = builder.sessionImplementor;
        this.runtimeIntrospector = builder.buildRuntimeIntrospector();
        // make sure that even if a session filter is not configured we will fall back to an application one if needed.
        this.configuredIndexingPlanFilter = mappingContext.applicationIndexingPlanFilter();
        this.indexingPlanSynchronizationStrategy = automaticIndexingStrategy.defaultIndexingPlanSynchronizationStrategy();
    }

    @Override
    public HibernateOrmSearchSessionMappingContext mappingContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String tenantIdentifier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object tenantIdentifierValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoIndexer createIndexer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> SearchQuerySelectStep<NonStaticMetamodelScope, ?, EntityReference, T, SearchLoadingOptionsStep, ?, ?> search(Collection<? extends Class<? extends T>> classes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <SR, T> SearchQuerySelectStep<SR, ?, EntityReference, T, SearchLoadingOptionsStep, ?, ?> search(TypedSearchScope<SR, T> scope) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> SearchQuerySelectStep<?, ?, EntityReference, T, SearchLoadingOptionsStep, ?, ?> search(SearchScope<T> scope) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <SR, T> SearchQuerySelectStep<SR, ?, EntityReference, T, SearchLoadingOptionsStep, ?, ?> search(HibernateOrmRootReferenceScope<SR, T> scope) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private <SR, T> SearchQuerySelectStep<SR, ?, EntityReference, T, SearchLoadingOptionsStep, ?, ?> search(TypedSearchScopeImpl<SR, T> scope) {
        return scope.search(this, loadingContextBuilder());
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
    public MassIndexer massIndexer(Collection<? extends Class<?>> classes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> TypedSearchScopeImpl<NonStaticMetamodelScope, T> scope(Collection<? extends Class<? extends T>> classes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> TypedSearchScope<NonStaticMetamodelScope, T> scope(Class<T> expectedSuperType, Collection<String> entityNames) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <SR, T> TypedSearchScope<SR, T> typedScope(Class<SR> rootScope, Collection<? extends Class<? extends T>> classes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EntityManager toEntityManager() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Session toOrmSession() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SessionImplementor session() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchIndexingPlan indexingPlan() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    // need to keep OLD API still implemented
    @SuppressWarnings("deprecation")
    public void automaticIndexingSynchronizationStrategy(org.hibernate.search.mapper.orm.automaticindexing.session.AutomaticIndexingSynchronizationStrategy synchronizationStrategy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void indexingPlanSynchronizationStrategy(IndexingPlanSynchronizationStrategy synchronizationStrategy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void indexingPlanFilter(SearchIndexingPlanFilter filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConfiguredSearchIndexingPlanFilter configuredIndexingPlanFilter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EntityReferenceFactory entityReferenceFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoSelectionLoadingContext defaultLoadingContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoRuntimeIntrospector runtimeIntrospector() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoIndexingPlan currentIndexingPlan(boolean createIfDoesNotExist) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PojoIndexingQueueEventProcessingPlan createIndexingQueueEventProcessingPlan() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void checkOpen() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConfiguredIndexingPlanSynchronizationStrategy configuredAutomaticIndexingSynchronizationStrategy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private HibernateOrmSelectionLoadingContext.Builder loadingContextBuilder() {
        return new HibernateOrmSelectionLoadingContext.Builder(mappingContext, this);
    }

    private void registerSynchronization(SharedSessionContractImplementor sessionImplementor, Synchronization synchronization) {
        //use {Before|After}TransactionCompletionProcess instead of registerSynchronization because it does not
        //swallow transactions.
        /*
		 * HSEARCH-540: the pre process must be both a BeforeTransactionCompletionProcess and a TX Synchronization.
		 *
		 * In a resource-local tx env, the beforeCommit phase is called after the flush, and prepares work queue.
		 * Also, any exceptions that occur during that are propagated (if a Synchronization was used, the exceptions
		 * would be eaten).
		 *
		 * In a JTA env, the before transaction completion is called before the flush, so not all changes are yet
		 * written. However, Synchronization-s do propagate exceptions, so they can be safely used.
		 */
        final TransactionCompletionCallbacks completionCallbacks = sessionImplementor.getTransactionCompletionCallbacks();
        SynchronizationAdapter adapter = new SynchronizationAdapter(synchronization);
        boolean isLocal = isLocalTransaction(sessionImplementor);
        if (isLocal) {
            //if local tx never use Synchronization
            completionCallbacks.registerCallback((BeforeTransactionCompletionProcess) adapter);
        } else {
            //TODO could we remove the action queue registration in this case?
            completionCallbacks.registerCallback((BeforeTransactionCompletionProcess) adapter);
            sessionImplementor.accessTransaction().registerSynchronization(adapter);
        }
        //executed in all environments
        completionCallbacks.registerCallback((AfterTransactionCompletionProcess) adapter);
    }

    private boolean isLocalTransaction(SharedSessionContractImplementor sessionImplementor) {
        return !sessionImplementor.getTransactionCoordinator().getTransactionCoordinatorBuilder().isJta();
    }

    private static void checkOpen(SharedSessionContractImplementor session) {
        try {
            session.checkOpen();
        } catch (IllegalStateException e) {
            throw OrmMiscLog.INSTANCE.hibernateSessionIsClosed(e);
        }
    }

    public static class Builder {

        private final HibernateOrmSearchSessionMappingContext mappingContext;

        private final HibernateOrmSessionTypeContextProvider typeContextProvider;

        private final ConfiguredAutomaticIndexingStrategy automaticIndexingStrategy;

        private final SharedSessionContractImplementor sessionImplementor;

        public Builder(HibernateOrmSearchSessionMappingContext mappingContext, HibernateOrmSessionTypeContextProvider typeContextProvider, ConfiguredAutomaticIndexingStrategy automaticIndexingStrategy, SharedSessionContractImplementor sessionImplementor) {
            this.mappingContext = mappingContext;
            this.typeContextProvider = typeContextProvider;
            this.automaticIndexingStrategy = automaticIndexingStrategy;
            this.sessionImplementor = sessionImplementor;
        }

        private HibernateOrmRuntimeIntrospector buildRuntimeIntrospector() {
            return new HibernateOrmRuntimeIntrospector(mappingContext.typeIdentifierResolver(), sessionImplementor);
        }

        public HibernateOrmSearchSession build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
