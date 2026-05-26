/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.query.dsl.spi;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.PredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.SimpleBooleanPredicateClausesCollector;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.dsl.ProjectionFinalStep;
import org.hibernate.search.engine.search.projection.dsl.TypedSearchProjectionFactory;
import org.hibernate.search.engine.search.query.dsl.SearchQueryDslExtension;
import org.hibernate.search.engine.search.query.dsl.SearchQueryOptionsStep;
import org.hibernate.search.engine.search.query.dsl.SearchQuerySelectStep;
import org.hibernate.search.engine.search.query.dsl.SearchQueryWhereStep;

public abstract class AbstractDelegatingSearchQuerySelectStep<SR, R, E, LOS> implements SearchQuerySelectStep<SR, SearchQueryOptionsStep<SR, ?, E, LOS, ?, ?>, R, E, LOS, TypedSearchProjectionFactory<SR, R, E>, TypedSearchPredicateFactory<SR>> {

    private final SearchQuerySelectStep<SR, ?, R, E, LOS, ?, ?> delegate;

    public AbstractDelegatingSearchQuerySelectStep(SearchQuerySelectStep<SR, ?, R, E, LOS, ?, ?> delegate) {
        this.delegate = delegate;
    }

    @Override
    public SearchQueryWhereStep<SR, ?, E, LOS, ?> selectEntity() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchQueryWhereStep<SR, ?, R, LOS, ?> selectEntityReference() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <P> SearchQueryWhereStep<SR, ?, P, LOS, ?> select(Class<P> objectClass) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <P> SearchQueryWhereStep<SR, ?, P, LOS, ?> select(Function<? super TypedSearchProjectionFactory<SR, R, E>, ? extends ProjectionFinalStep<P>> projectionContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <P> SearchQueryWhereStep<SR, ?, P, LOS, ?> select(SearchProjection<P> projection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchQueryWhereStep<SR, ?, List<?>, LOS, ?> select(SearchProjection<?>... projections) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchQueryOptionsStep<SR, ?, E, LOS, ?, ?> where(Function<? super TypedSearchPredicateFactory<SR>, ? extends PredicateFinalStep> predicateContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchQueryOptionsStep<SR, ?, E, LOS, ?, ?> where(BiConsumer<? super TypedSearchPredicateFactory<SR>, ? super SimpleBooleanPredicateClausesCollector<SR, ?>> predicateContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchQueryOptionsStep<SR, ?, E, LOS, ?, ?> where(SearchPredicate predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> T extension(SearchQueryDslExtension<SR, T, R, E, LOS> extension) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
