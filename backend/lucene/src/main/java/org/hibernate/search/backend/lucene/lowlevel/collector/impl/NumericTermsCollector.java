/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.collector.impl;

import java.io.IOException;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.LongMultiValues;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.LongMultiValuesSource;
import com.carrotsearch.hppc.LongHashSet;
import com.carrotsearch.hppc.LongObjectHashMap;
import com.carrotsearch.hppc.cursors.LongObjectCursor;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.CollectorManager;
import org.apache.lucene.search.ScoreMode;
import org.apache.lucene.search.SimpleCollector;

public class NumericTermsCollector extends SimpleCollector implements BaseTermsCollector {

    private final LongHashSet uniqueLeafIndicesForDocument = new LongHashSet();

    private final LongMultiValuesSource valuesSource;

    private final LongObjectHashMap<TermCollectorSegmentValue> segmentValues = new LongObjectHashMap<>();

    private final CollectorKey<?, ?>[] keys;

    private final CollectorManager<Collector, ?>[] managers;

    private LongMultiValues values;

    private LeafReaderContext leafReaderContext;

    public NumericTermsCollector(LongMultiValuesSource valuesSource, CollectorKey<?, ?>[] keys, CollectorManager<Collector, ?>[] managers) {
        this.valuesSource = valuesSource;
        this.keys = keys;
        this.managers = managers;
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
    public void finish() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CollectorKey<?, ?>[] keys() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CollectorManager<Collector, ?>[] managers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    LongObjectHashMap<TermCollectorSegmentValue> segmentValues() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
