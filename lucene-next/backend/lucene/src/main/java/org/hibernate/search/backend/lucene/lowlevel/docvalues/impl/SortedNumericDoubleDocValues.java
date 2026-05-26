/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.docvalues.impl;

import java.io.IOException;
import java.util.function.LongToDoubleFunction;
import org.apache.lucene.index.DocValues;
import org.apache.lucene.index.NumericDocValues;
import org.apache.lucene.index.SortedNumericDocValues;
import org.apache.lucene.search.DocIdSetIterator;
import org.apache.lucene.util.NumericUtils;

/**
 * Clone of {@link SortedNumericDocValues} for double values.
 * <p>
 * Copied and adapted from {@code org.elasticsearch.index.fielddata.SortedNumericDoubleValues} class
 * of <a href="https://github.com/elastic/elasticsearch">Elasticsearch project</a>.
 */
public abstract class SortedNumericDoubleDocValues extends DocIdSetIterator {

    /**
     * Sole constructor. (For invocation by subclass
     * constructors, typically implicit.)
     */
    protected SortedNumericDoubleDocValues() {
    }

    /**
     * Advance the iterator to exactly {@code target} and return whether
     * {@code target} has a value.
     * {@code target} must be greater than or equal to the current
     * doc ID and must be a valid doc ID, ie. &ge; 0 and
     * &lt; {@code maxDoc}.
     *
     * @param target the target
     * @return the next value
     * @throws IOException
     */
    public abstract boolean advanceExact(int target) throws IOException;

    /**
     * Iterates to the next value in the current document. Do not call this more than
     * {@link #docValueCount} times for the document.
     *
     * @return next value
     * @throws IOException
     */
    public abstract double nextValue() throws IOException;

    /**
     * Retrieves the number of values for the current document. This must always
     * be greater than zero.
     * It is illegal to call this method after {@link #advanceExact(int)}
     * returned {@code false}.
     *
     * @return value count
     */
    public abstract int docValueCount();

    public static SortedNumericDoubleDocValues fromDoubleField(SortedNumericDocValues values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static SortedNumericDoubleDocValues fromFloatField(SortedNumericDocValues values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static NumericDoubleValues unwrapSingleton(SortedNumericDoubleDocValues values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static SortedNumericDoubleDocValues create(SortedNumericDocValues values, LongToDoubleFunction decoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class SingleValuedFieldNumericDoubleDocValues extends SingletonNumericDoubleDocValues {

        private final LongToDoubleFunction decoder;

        SingleValuedFieldNumericDoubleDocValues(NumericDocValues values, LongToDoubleFunction decoder) {
            super(values);
            this.decoder = decoder;
        }

        @Override
        public NumericDoubleValues toNumericDoubleValues() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public double nextValue() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class MultiValuedFieldNumericDoubleDocValues extends SortedNumericDoubleDocValues {

        private final SortedNumericDocValues values;

        private final LongToDoubleFunction decoder;

        MultiValuedFieldNumericDoubleDocValues(SortedNumericDocValues values, LongToDoubleFunction decoder) {
            this.values = values;
            this.decoder = decoder;
        }

        @Override
        public double nextValue() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean advanceExact(int doc) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int advance(int target) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int nextDoc() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int docID() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int docValueCount() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public long cost() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
