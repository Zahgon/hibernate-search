/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.predicate.dsl.impl;

import java.util.function.Consumer;
import java.util.function.Function;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.BooleanPredicateOptionsCollector;
import org.hibernate.search.engine.search.predicate.dsl.GenericBooleanPredicateClausesStep;
import org.hibernate.search.engine.search.predicate.dsl.MinimumShouldMatchConditionStep;
import org.hibernate.search.engine.search.predicate.dsl.PredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;
import org.hibernate.search.engine.search.predicate.dsl.spi.AbstractPredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.SearchPredicateDslContext;
import org.hibernate.search.engine.search.predicate.spi.BooleanPredicateBuilder;

abstract class AbstractBooleanPredicateClausesStep<SR, S extends C, C extends BooleanPredicateOptionsCollector<SR, ?>> extends AbstractPredicateFinalStep implements GenericBooleanPredicateClausesStep<SR, S, C> {

    private final TypedSearchPredicateFactory<SR> factory;

    private final BooleanPredicateBuilder builder;

    private final MinimumShouldMatchConditionStepImpl<S> minimumShouldMatchStep;

    public AbstractBooleanPredicateClausesStep(SearchPredicateDslContext<?> dslContext, TypedSearchPredicateFactory<SR> factory) {
        super(dslContext);
        this.factory = factory;
        this.builder = dslContext.scope().predicateBuilders().bool();
        this.minimumShouldMatchStep = new MinimumShouldMatchConditionStepImpl<>(builder, self());
    }

    protected abstract S self();

    @Override
    public S boost(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S constantScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S with(Consumer<? super C> contributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S must(SearchPredicate searchPredicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S mustNot(SearchPredicate searchPredicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S should(SearchPredicate searchPredicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S filter(SearchPredicate searchPredicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S must(Function<? super TypedSearchPredicateFactory<SR>, ? extends PredicateFinalStep> clauseContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S mustNot(Function<? super TypedSearchPredicateFactory<SR>, ? extends PredicateFinalStep> clauseContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S should(Function<? super TypedSearchPredicateFactory<SR>, ? extends PredicateFinalStep> clauseContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S filter(Function<? super TypedSearchPredicateFactory<SR>, ? extends PredicateFinalStep> clauseContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MinimumShouldMatchConditionStep<S> minimumShouldMatch() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S minimumShouldMatch(Consumer<? super MinimumShouldMatchConditionStep<?>> constraintContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected SearchPredicate build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean hasClause() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
