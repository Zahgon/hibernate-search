/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.aggregation.collector.impl;

import java.util.BitSet;
import java.util.Locale;
import com.carrotsearch.hppc.LongHashSet;

/**
 * <p>
 * The algorithm to collect distinct elements is inspired by {@code org.apache.lucene.facet.LongValueFacetCounts}
 * of <a href="https://lucene.apache.org/">Apache Lucene project</a>.
 */
public class CountDistinctValues implements AggregationFunction<CountDistinctValues> {

    private final BitSet counts = new BitSet(1024);

    private final LongHashSet hashCounts = new LongHashSet();

    @Override
    public void apply(long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void merge(AggregationFunction<CountDistinctValues> sibling) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long result() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CountDistinctValues implementation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
