/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.predicate.dsl.impl;

import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.NotPredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.PredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.AbstractPredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.SearchPredicateDslContext;
import org.hibernate.search.engine.search.predicate.spi.BooleanPredicateBuilder;

public final class NotPredicateFinalStepImpl extends AbstractPredicateFinalStep implements NotPredicateFinalStep {

    private final BooleanPredicateBuilder builder;

    public NotPredicateFinalStepImpl(SearchPredicateDslContext<?> dslContext, SearchPredicate searchPredicate) {
        super(dslContext);
        this.builder = dslContext.scope().predicateBuilders().bool();
        this.builder.mustNot(searchPredicate);
    }

    public NotPredicateFinalStepImpl(SearchPredicateDslContext<?> dslContext, PredicateFinalStep searchPredicate) {
        this(dslContext, searchPredicate.toPredicate());
    }

    @Override
    protected SearchPredicate build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public NotPredicateFinalStep boost(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public NotPredicateFinalStep constantScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
