/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.docvalues.impl;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Function;
import org.hibernate.search.backend.lucene.lowlevel.join.impl.ChildDocIds;
import org.hibernate.search.backend.lucene.lowlevel.join.impl.NestedDocsProvider;
import org.apache.lucene.index.DocValues;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.index.SortedNumericDocValues;
import org.apache.lucene.search.DoubleValues;
import org.apache.lucene.search.DoubleValuesSource;
import org.apache.lucene.search.Explanation;
import org.apache.lucene.search.IndexSearcher;

/**
 * An implementation of {@link DoubleValuesSource} for docvalues with multiple values per document,
 * where multiple values are "aggregated" into a single value
 * according to a given {@link MultiValueMode}.
 * <p>
 * Some of this code was copied and adapted from
 * {@code org.elasticsearch.search.MultiValueMode}
 * from the <a href="https://github.com/elastic/elasticsearch">Elasticsearch project</a>.
 */
public abstract class DoubleMultiValuesToSingleValuesSource extends DoubleValuesSource {

    /**
     * Creates a {@link DoubleMultiValuesToSingleValuesSource} that wraps a double-valued field
     *
     * @param field the field
     * @param mode the mode
     * @param nested the nested provider
     * @return A {@link DoubleMultiValuesToSingleValuesSource}
     */
    public static DoubleMultiValuesToSingleValuesSource fromDoubleField(String field, MultiValueMode mode, NestedDocsProvider nested) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a {@link DoubleMultiValuesToSingleValuesSource} that wraps a float-valued field
     *
     * @param field the field
     * @param mode the mode
     * @param nested the nested provider
     * @return A {@link DoubleMultiValuesToSingleValuesSource}
     */
    public static DoubleMultiValuesToSingleValuesSource fromFloatField(String field, MultiValueMode mode, NestedDocsProvider nested) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static DoubleMultiValuesToSingleValuesSource fromField(String field, MultiValueMode mode, NestedDocsProvider nested, Function<SortedNumericDocValues, SortedNumericDoubleDocValues> decoder) {
        return new FieldMultiValuesToSingleValuesSource(field, mode, nested, decoder);
    }

    protected final MultiValueMode mode;

    protected final NestedDocsProvider nestedDocsProvider;

    public DoubleMultiValuesToSingleValuesSource(MultiValueMode mode, NestedDocsProvider nestedDocsProvider) {
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
    public NumericDoubleValues getValues(LeafReaderContext ctx, DoubleValues scores) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract SortedNumericDoubleDocValues getSortedNumericDoubleDocValues(LeafReaderContext ctx) throws IOException;

    protected NumericDoubleValues select(SortedNumericDoubleDocValues values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected NumericDoubleValues select(SortedNumericDoubleDocValues values, ChildDocIds childDocsWithValues) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class FieldMultiValuesToSingleValuesSource extends DoubleMultiValuesToSingleValuesSource {

        private final String field;

        private final Function<SortedNumericDocValues, SortedNumericDoubleDocValues> decoder;

        public FieldMultiValuesToSingleValuesSource(String field, MultiValueMode mode, NestedDocsProvider nestedDocsProvider, Function<SortedNumericDocValues, SortedNumericDoubleDocValues> decoder) {
            super(mode, nestedDocsProvider);
            this.field = field;
            this.decoder = decoder;
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
        public DoubleValuesSource rewrite(IndexSearcher searcher) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected SortedNumericDoubleDocValues getSortedNumericDoubleDocValues(LeafReaderContext ctx) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
