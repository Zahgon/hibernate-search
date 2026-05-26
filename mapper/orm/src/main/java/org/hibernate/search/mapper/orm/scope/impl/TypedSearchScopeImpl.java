/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.scope.impl;

import static org.hibernate.search.util.common.impl.CollectionHelper.asSetIgnoreNull;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import org.hibernate.search.engine.backend.scope.IndexScopeExtension;
import org.hibernate.search.engine.search.aggregation.dsl.TypedSearchAggregationFactory;
import org.hibernate.search.engine.search.highlighter.dsl.SearchHighlighterFactory;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;
import org.hibernate.search.engine.search.projection.dsl.TypedSearchProjectionFactory;
import org.hibernate.search.engine.search.query.dsl.SearchQuerySelectStep;
import org.hibernate.search.engine.search.sort.dsl.TypedSearchSortFactory;
import org.hibernate.search.mapper.orm.common.EntityReference;
import org.hibernate.search.mapper.orm.entity.SearchIndexedEntity;
import org.hibernate.search.mapper.orm.loading.impl.HibernateOrmSelectionLoadingContext;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.massindexing.impl.HibernateOrmMassIndexer;
import org.hibernate.search.mapper.orm.massindexing.impl.HibernateOrmMassIndexingContext;
import org.hibernate.search.mapper.orm.schema.management.SearchSchemaManager;
import org.hibernate.search.mapper.orm.schema.management.impl.SearchSchemaManagerImpl;
import org.hibernate.search.mapper.orm.scope.TypedSearchScope;
import org.hibernate.search.mapper.orm.search.loading.dsl.SearchLoadingOptionsStep;
import org.hibernate.search.mapper.orm.spi.BatchScopeContext;
import org.hibernate.search.mapper.orm.tenancy.spi.TenancyConfiguration;
import org.hibernate.search.mapper.orm.work.SearchWorkspace;
import org.hibernate.search.mapper.orm.work.impl.SearchWorkspaceImpl;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexer;
import org.hibernate.search.mapper.pojo.schema.management.spi.PojoScopeSchemaManager;
import org.hibernate.search.mapper.pojo.scope.spi.PojoScopeDelegate;
import org.hibernate.search.mapper.pojo.work.spi.PojoScopeWorkspace;

@SuppressWarnings("deprecation")
public class TypedSearchScopeImpl<SR, E> implements TypedSearchScope<SR, E>, BatchScopeContext<E> {

    private final HibernateOrmScopeMappingContext mappingContext;

    private final TenancyConfiguration tenancyConfiguration;

    private final PojoScopeDelegate<SR, EntityReference, E, SearchIndexedEntity<? extends E>> delegate;

    public TypedSearchScopeImpl(HibernateOrmScopeMappingContext mappingContext, TenancyConfiguration tenancyConfiguration, PojoScopeDelegate<SR, EntityReference, E, SearchIndexedEntity<? extends E>> delegate) {
        this.mappingContext = mappingContext;
        this.tenancyConfiguration = tenancyConfiguration;
        this.delegate = delegate;
    }

    public SearchQuerySelectStep<SR, ?, EntityReference, E, SearchLoadingOptionsStep, ?, ?> search(HibernateOrmScopeSessionContext sessionContext, HibernateOrmSelectionLoadingContext.Builder loadingContextBuilder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TypedSearchPredicateFactory<SR> predicate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TypedSearchSortFactory<SR> sort() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TypedSearchProjectionFactory<SR, EntityReference, E> projection() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TypedSearchAggregationFactory<SR> aggregation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchHighlighterFactory highlighter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchSchemaManager schemaManager() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchWorkspace workspace() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("removal")
    public SearchWorkspace workspace(String tenantId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchWorkspace workspace(Object tenantId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoScopeWorkspace pojoWorkspace(String tenantId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer massIndexer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("removal")
    public MassIndexer massIndexer(String tenantId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer massIndexer(Object tenantId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer massIndexer(Set<?> tenantIds) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<? extends SearchIndexedEntity<? extends E>> includedTypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> T extension(IndexScopeExtension<T> extension) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PojoScopeSchemaManager schemaManagerDelegate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
