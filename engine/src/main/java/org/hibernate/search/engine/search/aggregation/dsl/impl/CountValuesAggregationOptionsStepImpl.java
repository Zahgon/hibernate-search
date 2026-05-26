/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.aggregation.dsl.impl;

import java.util.function.Function;
import org.hibernate.search.engine.search.aggregation.SearchAggregation;
import org.hibernate.search.engine.search.aggregation.dsl.CountValuesAggregationOptionsStep;
import org.hibernate.search.engine.search.aggregation.dsl.spi.SearchAggregationDslContext;
import org.hibernate.search.engine.search.aggregation.spi.CountValuesAggregationBuilder;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.PredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;

class CountValuesAggregationOptionsStepImpl<SR, PDF extends TypedSearchPredicateFactory<SR>> implements CountValuesAggregationOptionsStep<SR, CountValuesAggregationOptionsStepImpl<SR, PDF>, PDF> {

    private final CountValuesAggregationBuilder builder;

    private final SearchAggregationDslContext<SR, ?, ? extends PDF> dslContext;

    CountValuesAggregationOptionsStepImpl(CountValuesAggregationBuilder builder, SearchAggregationDslContext<SR, ?, ? extends PDF> dslContext) {
        this.builder = builder;
        this.dslContext = dslContext;
    }

    @Override
    public CountValuesAggregationOptionsStepImpl<SR, PDF> filter(Function<? super PDF, ? extends PredicateFinalStep> clauseContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CountValuesAggregationOptionsStepImpl<SR, PDF> filter(SearchPredicate searchPredicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchAggregation<Long> toAggregation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CountValuesAggregationOptionsStepImpl<SR, PDF> distinct(boolean distinct) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
