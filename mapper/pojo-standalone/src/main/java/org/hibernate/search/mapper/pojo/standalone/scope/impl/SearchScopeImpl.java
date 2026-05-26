/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.standalone.scope.impl;

import static org.hibernate.search.util.common.impl.CollectionHelper.asSetIgnoreNull;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import org.hibernate.search.engine.backend.scope.IndexScopeExtension;
import org.hibernate.search.engine.common.EntityReference;
import org.hibernate.search.engine.search.aggregation.dsl.TypedSearchAggregationFactory;
import org.hibernate.search.engine.search.highlighter.dsl.SearchHighlighterFactory;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;
import org.hibernate.search.engine.search.projection.dsl.TypedSearchProjectionFactory;
import org.hibernate.search.engine.search.query.dsl.SearchQuerySelectStep;
import org.hibernate.search.engine.search.sort.dsl.TypedSearchSortFactory;
import org.hibernate.search.mapper.pojo.loading.spi.PojoSelectionLoadingContextBuilder;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexer;
import org.hibernate.search.mapper.pojo.schema.management.spi.PojoScopeSchemaManager;
import org.hibernate.search.mapper.pojo.scope.spi.PojoScopeDelegate;
import org.hibernate.search.mapper.pojo.scope.spi.PojoScopeSessionContext;
import org.hibernate.search.mapper.pojo.standalone.entity.SearchIndexedEntity;
import org.hibernate.search.mapper.pojo.standalone.loading.impl.StandalonePojoLoadingContext;
import org.hibernate.search.mapper.pojo.standalone.massindexing.MassIndexer;
import org.hibernate.search.mapper.pojo.standalone.massindexing.impl.StandalonePojoMassIndexer;
import org.hibernate.search.mapper.pojo.standalone.schema.management.SearchSchemaManager;
import org.hibernate.search.mapper.pojo.standalone.schema.management.impl.SearchSchemaManagerImpl;
import org.hibernate.search.mapper.pojo.standalone.scope.TypedSearchScope;
import org.hibernate.search.mapper.pojo.standalone.tenancy.impl.TenancyConfiguration;
import org.hibernate.search.mapper.pojo.standalone.work.SearchWorkspace;
import org.hibernate.search.mapper.pojo.standalone.work.impl.SearchWorkspaceImpl;

public class SearchScopeImpl<SR, E> implements TypedSearchScope<SR, E> {

    private final StandalonePojoScopeMappingContext mappingContext;

    private final PojoScopeDelegate<SR, EntityReference, E, SearchIndexedEntity<? extends E>> delegate;

    private final TenancyConfiguration tenancyConfiguration;

    public SearchScopeImpl(StandalonePojoScopeMappingContext mappingContext, TenancyConfiguration tenancyConfiguration, PojoScopeDelegate<SR, EntityReference, E, SearchIndexedEntity<? extends E>> delegate) {
        this.mappingContext = mappingContext;
        this.tenancyConfiguration = tenancyConfiguration;
        this.delegate = delegate;
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
    public Set<? extends SearchIndexedEntity<? extends E>> includedTypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> T extension(IndexScopeExtension<T> extension) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchQuerySelectStep<SR, ?, EntityReference, E, ?, ?, ?> search(PojoScopeSessionContext sessionContext, PojoSelectionLoadingContextBuilder<?> loadingContextBuilder) {
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

    public PojoScopeSchemaManager schemaManagerDelegate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
