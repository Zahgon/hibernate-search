/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.aggregation.dsl.impl;

import org.hibernate.search.engine.search.aggregation.dsl.MinAggregationFieldStep;
import org.hibernate.search.engine.search.aggregation.dsl.MinAggregationOptionsStep;
import org.hibernate.search.engine.search.aggregation.dsl.spi.SearchAggregationDslContext;
import org.hibernate.search.engine.search.aggregation.spi.AggregationTypeKeys;
import org.hibernate.search.engine.search.aggregation.spi.FieldMetricAggregationBuilder;
import org.hibernate.search.engine.search.common.ValueModel;
import org.hibernate.search.engine.search.predicate.dsl.TypedSearchPredicateFactory;
import org.hibernate.search.util.common.impl.Contracts;

public class MinAggregationFieldStepImpl<SR, PDF extends TypedSearchPredicateFactory<SR>> implements MinAggregationFieldStep<SR, PDF> {

    private final SearchAggregationDslContext<SR, ?, ? extends PDF> dslContext;

    public MinAggregationFieldStepImpl(SearchAggregationDslContext<SR, ?, ? extends PDF> dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public <F> MinAggregationOptionsStep<SR, ?, PDF, F> field(String fieldPath, Class<F> type, ValueModel valueModel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
