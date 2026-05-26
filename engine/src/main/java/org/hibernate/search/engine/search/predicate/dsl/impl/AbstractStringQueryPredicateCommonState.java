/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.predicate.dsl.impl;

import java.util.function.Consumer;
import org.hibernate.search.engine.search.common.BooleanOperator;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.CommonQueryStringPredicateOptionsStep;
import org.hibernate.search.engine.search.predicate.dsl.MinimumShouldMatchConditionStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.AbstractPredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.SearchPredicateDslContext;
import org.hibernate.search.engine.search.predicate.spi.CommonQueryStringPredicateBuilder;
import org.hibernate.search.util.common.impl.Contracts;

abstract class AbstractStringQueryPredicateCommonState<T extends AbstractStringQueryPredicateCommonState<?, ?, ?>, S extends CommonQueryStringPredicateOptionsStep<T>, B extends CommonQueryStringPredicateBuilder> extends AbstractPredicateFinalStep implements CommonQueryStringPredicateOptionsStep<T> {

    protected final B builder;

    private final MinimumShouldMatchConditionStepImpl<T> minimumShouldMatchStep;

    AbstractStringQueryPredicateCommonState(SearchPredicateDslContext<?> dslContext) {
        super(dslContext);
        this.builder = createBuilder(dslContext);
        this.minimumShouldMatchStep = new MinimumShouldMatchConditionStepImpl<>(builder, thisAsT());
    }

    protected abstract B createBuilder(SearchPredicateDslContext<?> dslContext);

    @Override
    protected SearchPredicate build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    CommonQueryStringPredicateBuilder.FieldState field(String fieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected T matching(String queryString) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T constantScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T boost(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T defaultOperator(BooleanOperator operator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T analyzer(String analyzerName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T skipAnalysis() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MinimumShouldMatchConditionStep<? extends T> minimumShouldMatch() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T minimumShouldMatch(Consumer<? super MinimumShouldMatchConditionStep<?>> constraintContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract T thisAsT();
}
