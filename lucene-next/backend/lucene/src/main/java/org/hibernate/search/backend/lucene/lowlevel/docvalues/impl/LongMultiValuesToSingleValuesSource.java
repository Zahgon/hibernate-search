/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.docvalues.impl;

import java.io.IOException;
import java.util.Objects;
import org.hibernate.search.backend.lucene.lowlevel.join.impl.ChildDocIds;
import org.hibernate.search.backend.lucene.lowlevel.join.impl.NestedDocsProvider;
import org.apache.lucene.index.DocValues;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.index.NumericDocValues;
import org.apache.lucene.index.SortedNumericDocValues;
import org.apache.lucene.search.DoubleValues;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.LongValues;
import org.apache.lucene.search.LongValuesSource;

/**
 * An implementation of {@link LongValuesSource} for docvalues with multiple values per document,
 * where multiple values are "aggregated" into a single value
 * according to a given {@link MultiValueMode}.
 * <p>
 * Some of this code was copied and adapted from
 * {@code org.elasticsearch.search.MultiValueMode}
 * from the <a href="https://github.com/elastic/elasticsearch">Elasticsearch project</a>.
 */
public abstract class LongMultiValuesToSingleValuesSource extends LongValuesSource {

    /**
     * Creates a {@link LongMultiValuesToSingleValuesSource} that wraps a long-valued field
     *
     * @param field the field
     * @param mode the mode
     * @param nested the nested provider
     * @return A {@link LongMultiValuesToSingleValuesSource}
     */
    public static LongMultiValuesToSingleValuesSource fromLongField(String field, MultiValueMode mode, NestedDocsProvider nested) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a {@link LongMultiValuesToSingleValuesSource} that wraps an int-valued field
     *
     * @param field the field
     * @param mode the mode
     * @param nested the nested provider
     * @return A {@link LongMultiValuesToSingleValuesSource}
     */
    public static LongMultiValuesToSingleValuesSource fromIntField(String field, MultiValueMode mode, NestedDocsProvider nested) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static LongMultiValuesToSingleValuesSource fromField(String field, MultiValueMode mode, NestedDocsProvider nested) {
        return new MultiFieldValuesToSingleValuesSource(field, mode, nested);
    }

    protected final MultiValueMode mode;

    protected final NestedDocsProvider nestedDocsProvider;

    public LongMultiValuesToSingleValuesSource(MultiValueMode mode, NestedDocsProvider nestedDocsProvider) {
        this.mode = mode;
        this.nestedDocsProvider = nestedDocsProvider;
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
    public LongValues getValues(LeafReaderContext ctx, DoubleValues scores) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a {@link NumericDocValues} instance for the passed-in LeafReaderContext and scores
     *
     * If scores are not needed to calculate the values (ie {@link #needsScores() returns false}, callers
     * may safely pass {@code null} for the {@code scores} parameter.
     *
     * @param ctx the ctx
     * @param scores the scores
     * @return NumericDocValues
     * @throws IOException
     */
    public NumericDocValues getRawNumericDocValues(LeafReaderContext ctx, DoubleValues scores) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract SortedNumericDocValues getSortedNumericDocValues(LeafReaderContext ctx) throws IOException;

    protected LongValues select(final SortedNumericDocValues values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected LongValues select(SortedNumericDocValues values, ChildDocIds childDocsWithValues) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class MultiFieldValuesToSingleValuesSource extends LongMultiValuesToSingleValuesSource {

        private final String field;

        private MultiFieldValuesToSingleValuesSource(String field, MultiValueMode mode, NestedDocsProvider nested) {
            super(mode, nested);
            this.field = field;
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
        public LongValuesSource rewrite(IndexSearcher searcher) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected SortedNumericDocValues getSortedNumericDocValues(LeafReaderContext ctx) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class RawNumericDocValues extends NumericDocValues {

        private int docID = -1;

        private final LongValues values;

        public RawNumericDocValues(LongValues values) {
            this.values = values;
        }

        @Override
        public boolean advanceExact(int target) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public long longValue() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int docID() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int nextDoc() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int advance(int target) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public long cost() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
