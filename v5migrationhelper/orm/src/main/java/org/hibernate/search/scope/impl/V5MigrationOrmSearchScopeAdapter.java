/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.scope.impl;

import java.util.Set;
import java.util.stream.Collectors;
import org.hibernate.search.engine.backend.index.IndexManager;
import org.hibernate.search.engine.common.EntityReference;
import org.hibernate.search.engine.search.aggregation.dsl.SearchAggregationFactory;
import org.hibernate.search.engine.search.predicate.dsl.SearchPredicateFactory;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.dsl.SearchProjectionFactory;
import org.hibernate.search.engine.search.sort.dsl.SearchSortFactory;
import org.hibernate.search.mapper.orm.entity.SearchIndexedEntity;
import org.hibernate.search.mapper.orm.scope.SearchScope;
import org.hibernate.search.scope.spi.V5MigrationSearchScope;

public class V5MigrationOrmSearchScopeAdapter implements V5MigrationSearchScope {

    private final SearchScope<?> delegate;

    public V5MigrationOrmSearchScopeAdapter(SearchScope<?> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Set<Class<?>> targetTypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<IndexManager> indexManagers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchPredicateFactory predicate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchSortFactory sort() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchProjectionFactory<?, ?> projection() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchProjection<Object> idProjection() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchProjection<? extends Class<?>> objectClassProjection() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchAggregationFactory aggregation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchScope<?> toSearchScope() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
