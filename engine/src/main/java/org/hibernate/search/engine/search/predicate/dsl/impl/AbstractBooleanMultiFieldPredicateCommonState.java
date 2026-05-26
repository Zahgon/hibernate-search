/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.predicate.dsl.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.hibernate.search.engine.logging.impl.QueryLog;
import org.hibernate.search.engine.search.common.spi.SearchIndexScope;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.spi.AbstractPredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.SearchPredicateDslContext;
import org.hibernate.search.engine.search.predicate.spi.BooleanPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.SearchPredicateBuilder;

/**
 * A common state for a multi-field predicate DSL
 * that will simply create one predicate per field and a boolean query to join the predicates.
 * <p>
 * This abstract class is appropriate if the predicate supports targeting multiple fields at the DSL level,
 * but not at the backend SPI level (like for range predicates, for example).
 * Some predicate support targeting multiple fields at the backend SPI level,
 * like the simple query string predicate.
 *
 * @param <S> The "self" type returned by DSL methods.
 * @param <F> The type of field set states.
 */
abstract class AbstractBooleanMultiFieldPredicateCommonState<S extends AbstractBooleanMultiFieldPredicateCommonState<?, ?>, F extends AbstractBooleanMultiFieldPredicateCommonState.FieldSetState> extends AbstractPredicateFinalStep {

    private final List<F> fieldSetStates = new ArrayList<>();

    private Float predicateLevelBoost;

    private boolean withConstantScore = false;

    AbstractBooleanMultiFieldPredicateCommonState(SearchPredicateDslContext<?> dslContext) {
        super(dslContext);
    }

    public SearchIndexScope<?> scope() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void add(F fieldSetState) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    List<F> getFieldSetStates() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public S boost(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public S constantScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected SearchPredicate build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract S thisAsS();

    final void applyBoostAndConstantScore(Float fieldSetBoost, SearchPredicateBuilder predicateBuilder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public interface FieldSetState {

        void contributePredicates(Consumer<SearchPredicate> collector);
    }
}
