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
import org.apache.lucene.index.SortedSetDocValues;
import org.apache.lucene.search.DocIdSetIterator;

/**
 * A source of {@link TextMultiValues} that automatically fetches values from nested documents if necessary.
 */
public abstract class JoiningTextMultiValuesSource extends TextMultiValuesSource {

    /**
     * Creates a {@link JoiningTextMultiValuesSource} that wraps a text-valued field
     *
     * @param field the field
     * @param nested the nested provider
     * @return A {@link JoiningTextMultiValuesSource}
     */
    public static JoiningTextMultiValuesSource fromField(String field, NestedDocsProvider nested) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final NestedDocsProvider nestedDocsProvider;

    protected JoiningTextMultiValuesSource(NestedDocsProvider nestedDocsProvider) {
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
    public TextMultiValues getValues(LeafReaderContext ctx) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract SortedSetDocValues getSortedSetDocValues(LeafReaderContext ctx) throws IOException;

    protected TextMultiValues select(SortedSetDocValues values, ChildDocIds childDocsWithValues) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class FieldTextMultiValuesSource extends JoiningTextMultiValuesSource {

        private final String field;

        public FieldTextMultiValuesSource(String field, NestedDocsProvider nestedDocsProvider) {
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
        protected SortedSetDocValues getSortedSetDocValues(LeafReaderContext ctx) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
