/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.docvalues.impl;

import java.io.IOException;
import java.util.function.DoubleToLongFunction;
import java.util.function.LongToDoubleFunction;
import org.apache.lucene.index.NumericDocValues;
import org.apache.lucene.search.DoubleValues;

/**
 * A per-document numeric value.
 * <p>
 * Copied and adapted from {@code org.elasticsearch.index.fielddata.NumericDoubleValues} class
 * of <a href="https://github.com/elastic/elasticsearch">Elasticsearch project</a>.
 */
public abstract class NumericDoubleValues extends DoubleValues {

    /**
     * Sole constructor. (For invocation by subclass
     * constructors, typically implicit.)
     */
    protected NumericDoubleValues() {
    }

    /**
     * Returns numeric docvalues view of raw double bits
     * @return numeric
     */
    public NumericDocValues getRawDoubleValues() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns numeric docvalues view of raw float bits
     * @return numeric
     */
    public NumericDocValues getRawFloatValues() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static NumericDoubleValues fromField(NumericDocValues values, LongToDoubleFunction decoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * An empty NumericDoubleValues instance that always returns {@code false} from {@link #advanceExact(int)}
     */
    public static final NumericDoubleValues EMPTY = new NumericDoubleValues() {

        @Override
        public double doubleValue() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean advanceExact(int doc) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    private static class FieldNumericDoubleValues extends NumericDoubleValues {

        private final NumericDocValues values;

        private final LongToDoubleFunction decoder;

        FieldNumericDoubleValues(NumericDocValues values, LongToDoubleFunction decoder) {
            this.values = values;
            this.decoder = decoder;
        }

        @Override
        public double doubleValue() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean advanceExact(int doc) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private class RawNumericDocValues extends NumericDocValues {

        private int docID = -1;

        private final DoubleToLongFunction decorator;

        public RawNumericDocValues(DoubleToLongFunction decorator) {
            this.decorator = decorator;
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
