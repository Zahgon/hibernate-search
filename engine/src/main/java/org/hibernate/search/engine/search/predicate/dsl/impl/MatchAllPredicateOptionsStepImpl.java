/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.predicate.dsl.impl;

import java.util.function.Function;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.MatchAllPredicateOptionsStep;
import org.hibernate.search.engine.search.predicate.dsl.PredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;
import org.hibernate.search.engine.search.predicate.dsl.spi.AbstractPredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.SearchPredicateDslContext;
import org.hibernate.search.engine.search.predicate.spi.BooleanPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.MatchAllPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.SearchPredicateBuilder;

public final class MatchAllPredicateOptionsStepImpl<SR> extends AbstractPredicateFinalStep implements MatchAllPredicateOptionsStep<SR, MatchAllPredicateOptionsStep<SR, ?>> {

    private final TypedSearchPredicateFactory<SR> factory;

    private final MatchAllPredicateBuilder matchAllBuilder;

    private MatchAllExceptState exceptState;

    private Float boost;

    private boolean constantScore = false;

    public MatchAllPredicateOptionsStepImpl(SearchPredicateDslContext<?> dslContext, TypedSearchPredicateFactory<SR> factory) {
        super(dslContext);
        this.factory = factory;
        this.matchAllBuilder = dslContext.scope().predicateBuilders().matchAll();
    }

    @Override
    public MatchAllPredicateOptionsStep<SR, ?> boost(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MatchAllPredicateOptionsStep<SR, ?> constantScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MatchAllPredicateOptionsStep<SR, ?> except(SearchPredicate searchPredicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MatchAllPredicateOptionsStep<SR, ?> except(Function<? super TypedSearchPredicateFactory<SR>, ? extends PredicateFinalStep> clauseContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected SearchPredicate build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private MatchAllExceptState getExceptState() {
        if (exceptState == null) {
            exceptState = new MatchAllExceptState();
        }
        return exceptState;
    }

    private class MatchAllExceptState {

        private final BooleanPredicateBuilder booleanBuilder;

        MatchAllExceptState() {
            this.booleanBuilder = dslContext.scope().predicateBuilders().bool();
        }

        void addClause(Function<? super TypedSearchPredicateFactory<SR>, ? extends PredicateFinalStep> clauseContributor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void addClause(SearchPredicate predicate) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        SearchPredicateBuilder builder(SearchPredicate matchAll) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
