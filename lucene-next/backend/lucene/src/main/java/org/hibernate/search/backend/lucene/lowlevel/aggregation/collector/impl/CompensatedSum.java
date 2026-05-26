/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.aggregation.collector.impl;

import java.util.Locale;

/**
 * <p>
 * The algorithm is inspired by {@code org.opensearch.search.aggregations.metrics.SumAggregator}
 * of <a href="https://opensearch.org/">OpenSearch</a>.
 */
public class CompensatedSum implements DoubleAggregationFunction<CompensatedSum> {

    private final KahanSummation kahanSummation = new KahanSummation(0, 0);

    @Override
    public void apply(double value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void merge(DoubleAggregationFunction<CompensatedSum> sibling) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Double result() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompensatedSum implementation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
