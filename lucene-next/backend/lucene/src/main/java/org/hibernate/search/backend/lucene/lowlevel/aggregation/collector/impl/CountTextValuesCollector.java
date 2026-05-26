/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.aggregation.collector.impl;

import java.io.IOException;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.TextMultiValues;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.TextMultiValuesSource;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.ScoreMode;
import org.apache.lucene.search.SimpleCollector;

public class CountTextValuesCollector extends SimpleCollector {

    private final TextMultiValuesSource source;

    private TextMultiValues values;

    private long count;

    LeafReaderContext context;

    public CountTextValuesCollector(TextMultiValuesSource source) {
        this.source = source;
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

    public long count() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
