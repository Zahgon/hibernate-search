/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.docvalues.impl;

import java.io.IOException;
import java.util.Objects;
import org.hibernate.search.backend.lucene.lowlevel.join.impl.NestedDocsProvider;
import org.hibernate.search.engine.spatial.GeoPoint;
import org.apache.lucene.index.DocValues;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.DoubleValues;
import org.apache.lucene.search.DoubleValuesSource;
import org.apache.lucene.search.Explanation;
import org.apache.lucene.search.IndexSearcher;

/**
 * A {@link DoubleMultiValuesToSingleValuesSource} that wraps the distance between a GeoPoint field
 * and a given center.
 */
public class GeoPointDistanceMultiValuesToSingleValuesSource extends DoubleMultiValuesToSingleValuesSource {

    private final String field;

    private final GeoPoint center;

    public GeoPointDistanceMultiValuesToSingleValuesSource(String field, MultiValueMode mode, NestedDocsProvider nestedDocsProvider, GeoPoint center) {
        super(mode, nestedDocsProvider);
        this.field = field;
        this.center = center;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean needsScores() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCacheable(LeafReaderContext ctx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Explanation explain(LeafReaderContext ctx, int docId, Explanation scoreExplanation) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DoubleValuesSource rewrite(IndexSearcher searcher) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected GeoPointDistanceDocValues getSortedNumericDoubleDocValues(LeafReaderContext ctx) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
