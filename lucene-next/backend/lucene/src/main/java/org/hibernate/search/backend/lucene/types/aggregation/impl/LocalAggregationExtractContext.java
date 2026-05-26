/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.aggregation.impl;

import java.util.Map;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorKey;
import org.hibernate.search.backend.lucene.lowlevel.join.impl.NestedDocsProvider;
import org.hibernate.search.backend.lucene.search.aggregation.impl.AggregationExtractContext;
import org.hibernate.search.backend.lucene.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.engine.backend.types.converter.runtime.FromDocumentValueConvertContext;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.Query;

class LocalAggregationExtractContext implements AggregationExtractContext {

    private final AggregationExtractContext delegate;

    private Map<CollectorKey<?, ?>, Object> results;

    LocalAggregationExtractContext(AggregationExtractContext delegate) {
        this.delegate = delegate;
    }

    @Override
    public PredicateRequestContext toPredicateRequestContext(String absolutePath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexReader getIndexReader() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FromDocumentValueConvertContext fromDocumentValueConvertContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @Override
    public <C extends Collector, T> T getCollectorResults(CollectorKey<C, T> key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public NestedDocsProvider createNestedDocsProvider(String nestedDocumentPath, Query nestedFilter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setResults(Map<CollectorKey<?, ?>, Object> results) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
