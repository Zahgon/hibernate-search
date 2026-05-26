/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.collector.impl;

import java.io.IOException;
import com.carrotsearch.hppc.IntObjectHashMap;
import com.carrotsearch.hppc.IntObjectMap;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.CollectorManager;
import org.apache.lucene.search.ScoreMode;
import org.apache.lucene.search.SimpleCollector;

/**
 * The collector used when collecting data related to top docs.
 *
 * @param <T> The type of value collected for each top doc.
 */
public class TopDocsDataCollector<T> extends SimpleCollector {

    public interface Factory<T> extends CollectorKey<TopDocsDataCollector<T>, IntObjectMap<T>> {

        CollectorManager<TopDocsDataCollector<T>, IntObjectMap<T>> create(TopDocsDataCollectorExecutionContext context) throws IOException;
    }

    private final Values<? extends T> values;

    private final StoredFieldsValuesDelegate storedFieldsValuesDelegate;

    private final IntObjectMap<T> collected = new IntObjectHashMap<>();

    private int currentLeafDocBase;

    public TopDocsDataCollector(TopDocsDataCollectorExecutionContext context, Values<? extends T> values) {
        this.values = values;
        this.storedFieldsValuesDelegate = context.storedFieldsValuesDelegate();
    }

    @Override
    protected void doSetNextReader(LeafReaderContext context) throws IOException {
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

    public IntObjectMap<T> collected() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
