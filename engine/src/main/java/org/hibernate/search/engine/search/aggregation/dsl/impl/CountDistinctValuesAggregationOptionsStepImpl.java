/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.aggregation.dsl.impl;

import java.util.function.Function;
import org.hibernate.search.engine.search.aggregation.SearchAggregation;
import org.hibernate.search.engine.search.aggregation.dsl.CountDistinctValuesAggregationOptionsStep;
import org.hibernate.search.engine.search.aggregation.dsl.spi.SearchAggregationDslContext;
import org.hibernate.search.engine.search.aggregation.spi.SearchFilterableAggregationBuilder;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.PredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;

@Deprecated(since = "8.1", forRemoval = true)
class CountDistinctValuesAggregationOptionsStepImpl<SR, PDF extends TypedSearchPredicateFactory<SR>> implements CountDistinctValuesAggregationOptionsStep<SR, CountDistinctValuesAggregationOptionsStepImpl<SR, PDF>, PDF> {

    private final SearchFilterableAggregationBuilder<Long> builder;

    private final SearchAggregationDslContext<SR, ?, ? extends PDF> dslContext;

    CountDistinctValuesAggregationOptionsStepImpl(SearchFilterableAggregationBuilder<Long> builder, SearchAggregationDslContext<SR, ?, ? extends PDF> dslContext) {
        this.builder = builder;
        this.dslContext = dslContext;
    }

    @Override
    public CountDistinctValuesAggregationOptionsStepImpl<SR, PDF> filter(Function<? super PDF, ? extends PredicateFinalStep> clauseContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CountDistinctValuesAggregationOptionsStepImpl<SR, PDF> filter(SearchPredicate searchPredicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchAggregation<Long> toAggregation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
