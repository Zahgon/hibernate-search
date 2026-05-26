/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.aggregation.collector.impl;

import java.util.Locale;

public class CountValues implements AggregationFunction<CountValues> {

    private long count = 0L;

    @Override
    public void apply(long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void merge(AggregationFunction<CountValues> sibling) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long result() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CountValues implementation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
