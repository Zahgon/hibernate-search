/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.collector.impl;

import java.io.IOException;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.TextMultiValues;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.TextMultiValuesSource;
import org.hibernate.search.backend.lucene.types.aggregation.impl.LongBucket;
import com.carrotsearch.hppc.LongHashSet;
import com.carrotsearch.hppc.LongObjectHashMap;
import com.carrotsearch.hppc.cursors.LongObjectCursor;
import org.apache.lucene.index.IndexReaderContext;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.index.MultiDocValues;
import org.apache.lucene.index.SortedSetDocValues;
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.CollectorManager;
import org.apache.lucene.search.ScoreMode;
import org.apache.lucene.search.SimpleCollector;

public class TextTermsCollector extends SimpleCollector implements BaseTermsCollector {

    private final LongHashSet uniqueLeafIndicesForDocument = new LongHashSet();

    private final TextMultiValuesSource valuesSource;

    private final LongObjectHashMap<LongBucket> hashValues = new LongObjectHashMap<>();

    private final LongObjectHashMap<TermCollectorSegmentValue> segmentValues = new LongObjectHashMap<>();

    private final String field;

    private SortedSetDocValues sortedSetValues;

    private final CollectorKey<?, ?>[] keys;

    private final CollectorManager<Collector, ?>[] managers;

    private TextMultiValues values;

    private LeafReaderContext leafReaderContext;

    public TextTermsCollector(String field, TextMultiValuesSource valuesSource, CollectorKey<?, ?>[] keys, CollectorManager<Collector, ?>[] managers) {
        this.field = field;
        this.valuesSource = valuesSource;
        this.keys = keys;
        this.managers = managers;
    }

    @Override
    public void collect(int doc) throws IOException {
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

    LongObjectHashMap<LongBucket> segmentValues() {
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

    private void initRootSortedSetDocValues(IndexReaderContext ctx) throws IOException {
        if (sortedSetValues != null || ctx == null) {
            return;
        }
        if (ctx.isTopLevel) {
            this.sortedSetValues = MultiDocValues.getSortedSetValues(ctx.reader(), field);
        }
        initRootSortedSetDocValues(ctx.parent);
    }
}
