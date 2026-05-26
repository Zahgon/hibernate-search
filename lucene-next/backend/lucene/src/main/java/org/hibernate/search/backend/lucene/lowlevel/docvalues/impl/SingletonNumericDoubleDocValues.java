/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.docvalues.impl;

import java.io.IOException;
import org.apache.lucene.index.NumericDocValues;

abstract class SingletonNumericDoubleDocValues extends SortedNumericDoubleDocValues {

    protected final NumericDocValues values;

    SingletonNumericDoubleDocValues(NumericDocValues values) {
        this.values = values;
    }

    public abstract NumericDoubleValues toNumericDoubleValues();

    @Override
    public final boolean advanceExact(int doc) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final int advance(int target) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final int nextDoc() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final int docID() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final int docValueCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final long cost() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
