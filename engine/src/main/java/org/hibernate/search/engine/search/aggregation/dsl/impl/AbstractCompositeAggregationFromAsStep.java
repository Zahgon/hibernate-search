/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.aggregation.dsl.impl;

import java.util.List;
import java.util.function.Function;
import org.hibernate.search.engine.search.aggregation.SearchAggregation;
import org.hibernate.search.engine.search.aggregation.dsl.AggregationFinalStep;
import org.hibernate.search.engine.search.aggregation.dsl.CompositeAggregationFromAsStep;
import org.hibernate.search.engine.search.aggregation.spi.CompositeAggregationBuilder;
import org.hibernate.search.engine.search.spi.ResultsCompositor;

abstract class AbstractCompositeAggregationFromAsStep implements CompositeAggregationFromAsStep {

    final CompositeAggregationBuilder<?> builder;

    public AbstractCompositeAggregationFromAsStep(CompositeAggregationBuilder<?> builder) {
        this.builder = builder;
    }

    @Override
    public final AggregationFinalStep<List<?>> asList() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final <V> AggregationFinalStep<V> asList(Function<? super List<?>, ? extends V> transformer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AggregationFinalStep<Object[]> asArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <V> AggregationFinalStep<V> asArray(Function<? super Object[], ? extends V> transformer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract SearchAggregation<?>[] toAggregationArray();

    protected final class CompositeAggregationFinalStep<V> implements AggregationFinalStep<V> {

        private final SearchAggregation<V> aggregation;

        protected CompositeAggregationFinalStep(ResultsCompositor<?, V> compositor) {
            aggregation = builder.innerAggregations(toAggregationArray()).compositor(compositor).build();
        }

        @Override
        public SearchAggregation<V> toAggregation() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
