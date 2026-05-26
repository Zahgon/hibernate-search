/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.aggregation.collector.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.function.Function;
import java.util.function.Supplier;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.JoiningLongMultiValuesSource;
import org.apache.lucene.search.CollectorManager;

public class DoubleAggregationFunctionCollectorManager<AF extends DoubleAggregationFunction<?>> implements CollectorManager<DoubleAggregationFunctionCollector<AF>, Double> {

    private final JoiningLongMultiValuesSource source;

    private final Supplier<DoubleAggregationFunction<AF>> functionSupplier;

    private final Function<Long, Double> longToDouble;

    public DoubleAggregationFunctionCollectorManager(JoiningLongMultiValuesSource source, Supplier<DoubleAggregationFunction<AF>> functionSupplier, Function<Long, Double> longToDouble) {
        this.source = source;
        this.functionSupplier = functionSupplier;
        this.longToDouble = longToDouble;
    }

    @Override
    public DoubleAggregationFunctionCollector<AF> newCollector() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Double reduce(Collection<DoubleAggregationFunctionCollector<AF>> collectors) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
