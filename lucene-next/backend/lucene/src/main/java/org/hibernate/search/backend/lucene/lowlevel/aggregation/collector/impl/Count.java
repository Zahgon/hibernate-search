/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.aggregation.collector.impl;

public class Count implements AggregationFunction<Count> {

    private long count = 0L;

    @Override
    public void apply(long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void merge(AggregationFunction<Count> sibling) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long result() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Count implementation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
