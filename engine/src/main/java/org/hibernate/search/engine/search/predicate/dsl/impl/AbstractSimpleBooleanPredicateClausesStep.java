/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.predicate.dsl.impl;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.GenericSimpleBooleanPredicateClausesStep;
import org.hibernate.search.engine.search.predicate.dsl.PredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.SimpleBooleanPredicateClausesCollector;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;
import org.hibernate.search.engine.search.predicate.dsl.spi.AbstractPredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.SearchPredicateDslContext;
import org.hibernate.search.engine.search.predicate.spi.BooleanPredicateBuilder;

public abstract class AbstractSimpleBooleanPredicateClausesStep<SR, S extends C, C extends SimpleBooleanPredicateClausesCollector<SR, ?>> extends AbstractPredicateFinalStep implements GenericSimpleBooleanPredicateClausesStep<SR, S, C> {

    public enum SimpleBooleanPredicateOperator implements BiConsumer<BooleanPredicateBuilder, SearchPredicate> {

        AND {

            @Override
            public void accept(BooleanPredicateBuilder builder, SearchPredicate searchPredicate) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
        , OR {

            @Override
            public void accept(BooleanPredicateBuilder builder, SearchPredicate searchPredicate) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }

    }

    private final SimpleBooleanPredicateOperator operator;

    private final BooleanPredicateBuilder builder;

    private final TypedSearchPredicateFactory<SR> factory;

    AbstractSimpleBooleanPredicateClausesStep(SimpleBooleanPredicateOperator operator, SearchPredicateDslContext<?> dslContext, TypedSearchPredicateFactory<SR> factory) {
        super(dslContext);
        this.operator = operator;
        this.builder = dslContext.scope().predicateBuilders().bool();
        this.factory = factory;
    }

    protected abstract S self();

    @Override
    public S add(SearchPredicate searchPredicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S add(Function<? super TypedSearchPredicateFactory<SR>, ? extends PredicateFinalStep> clauseContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public S boost(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public S constantScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S with(Consumer<? super C> contributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean hasClause() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected SearchPredicate build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
