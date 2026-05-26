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
import org.apache.lucene.index.SortedNumericDocValues;
import org.apache.lucene.search.DocIdSetIterator;

/**
 * A source of {@link LongMultiValues} that automatically fetches values from nested documents if necessary.
 */
public abstract class JoiningLongMultiValuesSource extends LongMultiValuesSource {

    /**
     * Creates a {@link JoiningLongMultiValuesSource} that wraps a Long-valued field
     *
     * @param field the field
     * @param nested the nested provider
     * @return A {@link JoiningLongMultiValuesSource}
     */
    public static JoiningLongMultiValuesSource fromLongField(String field, NestedDocsProvider nested) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a {@link JoiningLongMultiValuesSource} that wraps an Integer-valued field
     *
     * @param field the field
     * @param nested the nested provider
     * @return A {@link JoiningLongMultiValuesSource}
     */
    public static JoiningLongMultiValuesSource fromIntField(String field, NestedDocsProvider nested) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static JoiningLongMultiValuesSource fromField(String field, NestedDocsProvider nested) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final NestedDocsProvider nestedDocsProvider;

    public JoiningLongMultiValuesSource(NestedDocsProvider nestedDocsProvider) {
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
    public LongMultiValues getValues(LeafReaderContext ctx) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract SortedNumericDocValues getSortedNumericDocValues(LeafReaderContext ctx) throws IOException;

    protected LongMultiValues select(SortedNumericDocValues values, ChildDocIds childDocsWithValues) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class FieldLongMultiValuesSource extends JoiningLongMultiValuesSource {

        private final String field;

        public FieldLongMultiValuesSource(String field, NestedDocsProvider nestedDocsProvider) {
            super(nestedDocsProvider);
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
        protected SortedNumericDocValues getSortedNumericDocValues(LeafReaderContext ctx) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
