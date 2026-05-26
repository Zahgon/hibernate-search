/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.aggregation.dsl.impl;

import org.hibernate.search.engine.search.aggregation.dsl.AvgAggregationFieldStep;
import org.hibernate.search.engine.search.aggregation.dsl.AvgAggregationOptionsStep;
import org.hibernate.search.engine.search.aggregation.dsl.spi.SearchAggregationDslContext;
import org.hibernate.search.engine.search.aggregation.spi.AggregationTypeKeys;
import org.hibernate.search.engine.search.aggregation.spi.FieldMetricAggregationBuilder;
import org.hibernate.search.engine.search.common.ValueModel;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;
import org.hibernate.search.util.common.impl.Contracts;

public class AvgAggregationFieldStepImpl<SR, PDF extends TypedSearchPredicateFactory<SR>> implements AvgAggregationFieldStep<SR, PDF> {

    private final SearchAggregationDslContext<SR, ?, ? extends PDF> dslContext;

    public AvgAggregationFieldStepImpl(SearchAggregationDslContext<SR, ?, ? extends PDF> dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public <F> AvgAggregationOptionsStep<SR, ?, PDF, F> field(String fieldPath, Class<F> type, ValueModel valueModel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
