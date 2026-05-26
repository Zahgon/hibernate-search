/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.mapper.scope.impl;

import org.hibernate.search.engine.backend.scope.IndexScopeExtension;
import org.hibernate.search.engine.backend.scope.spi.IndexScope;
import org.hibernate.search.engine.backend.session.spi.BackendSessionContext;
import org.hibernate.search.engine.mapper.scope.spi.MappedIndexScope;
import org.hibernate.search.engine.search.aggregation.dsl.TypedSearchAggregationFactory;
import org.hibernate.search.engine.search.highlighter.dsl.SearchHighlighterFactory;
import org.hibernate.search.engine.search.loading.spi.SearchLoadingContextBuilder;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;
import org.hibernate.search.engine.search.projection.dsl.TypedSearchProjectionFactory;
import org.hibernate.search.engine.search.query.dsl.SearchQuerySelectStep;
import org.hibernate.search.engine.search.query.dsl.impl.DefaultSearchQuerySelectStep;
import org.hibernate.search.engine.search.sort.dsl.TypedSearchSortFactory;

class MappedIndexScopeImpl<SR, R, E> implements MappedIndexScope<SR, R, E> {

    private final IndexScope<SR> delegate;

    MappedIndexScopeImpl(IndexScope<SR> delegate) {
        this.delegate = delegate;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <LOS> SearchQuerySelectStep<SR, ?, R, E, LOS, TypedSearchProjectionFactory<SR, R, E>, ?> search(BackendSessionContext sessionContext, SearchLoadingContextBuilder<E, LOS> loadingContextBuilder) {
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
    public TypedSearchProjectionFactory<SR, R, E> projection() {
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
    public <T> T extension(IndexScopeExtension<T> extension) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
