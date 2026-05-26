/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.aggregation.collector.impl;

import java.util.Locale;

public class Min implements AggregationFunction<Min> {

    private Long min;

    @Override
    public void apply(long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void merge(AggregationFunction<Min> sibling) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long result() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Min implementation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
