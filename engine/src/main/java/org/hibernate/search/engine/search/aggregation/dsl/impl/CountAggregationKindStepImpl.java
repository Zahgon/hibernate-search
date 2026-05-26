/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.aggregation.dsl.impl;

import org.hibernate.search.engine.search.aggregation.dsl.CountAggregationKindStep;
import org.hibernate.search.engine.search.aggregation.dsl.CountDocumentsAggregationFinalStep;
import org.hibernate.search.engine.search.aggregation.dsl.CountValuesAggregationOptionsStep;
import org.hibernate.search.engine.search.aggregation.dsl.spi.SearchAggregationDslContext;
import org.hibernate.search.engine.search.aggregation.spi.AggregationTypeKeys;
import org.hibernate.search.engine.search.aggregation.spi.CountValuesAggregationBuilder;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;

public class CountAggregationKindStepImpl<SR, PDF extends TypedSearchPredicateFactory<SR>> implements CountAggregationKindStep<SR, PDF> {

    private final SearchAggregationDslContext<SR, ?, ? extends PDF> dslContext;

    public CountAggregationKindStepImpl(SearchAggregationDslContext<SR, ?, ? extends PDF> dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public CountDocumentsAggregationFinalStep documents() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CountValuesAggregationOptionsStep<SR, ?, PDF> field(String fieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
