/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.aggregation.dsl.impl;

import java.util.function.Function;
import org.hibernate.search.engine.search.aggregation.SearchAggregation;
import org.hibernate.search.engine.search.aggregation.dsl.SumAggregationOptionsStep;
import org.hibernate.search.engine.search.aggregation.dsl.spi.SearchAggregationDslContext;
import org.hibernate.search.engine.search.aggregation.spi.FieldMetricAggregationBuilder;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.PredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;

class SumAggregationOptionsStepImpl<SR, PDF extends TypedSearchPredicateFactory<SR>, F> implements SumAggregationOptionsStep<SR, SumAggregationOptionsStepImpl<SR, PDF, F>, PDF, F> {

    private final FieldMetricAggregationBuilder<F> builder;

    private final SearchAggregationDslContext<SR, ?, ? extends PDF> dslContext;

    SumAggregationOptionsStepImpl(FieldMetricAggregationBuilder<F> builder, SearchAggregationDslContext<SR, ?, ? extends PDF> dslContext) {
        this.builder = builder;
        this.dslContext = dslContext;
    }

    @Override
    public SumAggregationOptionsStepImpl<SR, PDF, F> filter(Function<? super PDF, ? extends PredicateFinalStep> clauseContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SumAggregationOptionsStepImpl<SR, PDF, F> filter(SearchPredicate searchPredicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchAggregation<F> toAggregation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
