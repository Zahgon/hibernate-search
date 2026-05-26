/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.aggregation.collector.impl;

import java.io.IOException;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.LongMultiValues;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.LongMultiValuesSource;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.ScoreMode;
import org.apache.lucene.search.SimpleCollector;

public class AggregationFunctionCollector<R extends AggregationFunction<?>> extends SimpleCollector {

    private final LongMultiValuesSource valueSource;

    private final AggregationFunction<R> aggregationFunction;

    private LongMultiValues values;

    public AggregationFunctionCollector(LongMultiValuesSource valueSource, AggregationFunction<R> aggregationFunction) {
        this.valueSource = valueSource;
        this.aggregationFunction = aggregationFunction;
    }

    public void merge(AggregationFunctionCollector<R> sibling) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Long result() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void collect(int doc) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ScoreMode scoreMode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void doSetNextReader(LeafReaderContext context) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void finish() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
