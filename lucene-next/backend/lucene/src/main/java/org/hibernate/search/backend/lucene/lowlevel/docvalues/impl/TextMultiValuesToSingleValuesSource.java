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
import org.apache.lucene.index.SortedDocValues;
import org.apache.lucene.index.SortedSetDocValues;
import org.apache.lucene.util.BytesRef;

/**
 * A source of {@link SortedDocValues} (text doc values) with multiple values per document,
 * where multiple values are "aggregated" into a single value
 * according to a given {@link MultiValueMode}.
 * <p>
 * Some of this code was copied and adapted from
 * {@code org.elasticsearch.search.MultiValueMode}
 * from the <a href="https://github.com/elastic/elasticsearch">Elasticsearch project</a>.
 */
public abstract class TextMultiValuesToSingleValuesSource {

    /**
     * Creates a {@link TextMultiValuesToSingleValuesSource} that wraps a text field
     *
     * @param field the field
     * @param mode the mode
     * @param nested the nested provider
     * @return DoubleMultiValuesSource
     */
    public static TextMultiValuesToSingleValuesSource fromField(String field, MultiValueMode mode, NestedDocsProvider nested) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final MultiValueMode mode;

    protected final NestedDocsProvider nestedDocsProvider;

    public TextMultiValuesToSingleValuesSource(MultiValueMode mode, NestedDocsProvider nestedDocsProvider) {
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

    public SortedDocValues getValues(LeafReaderContext ctx) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract SortedSetDocValues getSortedSetDocValues(LeafReaderContext ctx) throws IOException;

    protected SortedDocValues select(SortedSetDocValues values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected SortedDocValues select(SortedSetDocValues values, ChildDocIds childDocsWithValues) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class FieldMultiValuesToSingleValuesSource extends TextMultiValuesToSingleValuesSource {

        private final String field;

        public FieldMultiValuesToSingleValuesSource(String field, MultiValueMode mode, NestedDocsProvider nestedDocsProvider) {
            super(mode, nestedDocsProvider);
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
        protected SortedSetDocValues getSortedSetDocValues(LeafReaderContext ctx) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private abstract static class SortedSetDocValuesToSortedDocValuesWrapper extends SortedDocValues {

        private final SortedSetDocValues delegate;

        SortedSetDocValuesToSortedDocValuesWrapper(SortedSetDocValues delegate) {
            this.delegate = delegate;
            if (delegate.getValueCount() > Integer.MAX_VALUE) {
                // We may want to remove this limitation?
                // It would require defining our own FieldComparator mimicking TermOrdValComparator, which is pretty complex...
                // Note that single-valued text docvalues are limited to that many different terms anyway,
                // so this is no worse than the "legacy" sorts on single-valued text fields.
                throw new IllegalStateException("Cannot sort when more than " + Integer.MAX_VALUE + " terms are indexed");
            }
        }

        @Override
        public int getValueCount() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public BytesRef lookupOrd(int ord) throws IOException {
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
