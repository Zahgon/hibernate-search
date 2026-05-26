/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.docvalues.impl;

import java.io.IOException;
import org.apache.lucene.index.SortedDocValues;
import org.apache.lucene.util.BytesRef;

/**
 * Handles a replacement for missing sorted document values.
 * <p>
 * Copied with some changes from
 * {@code org.elasticsearch.index.fielddata.fieldcomparator.BytesRefComparatorSource.ReplaceMissing}
 * of <a href="https://github.com/elastic/elasticsearch">Elasticsearch project</a>.
 */
public class ReplaceMissingSortedDocValues extends SortedDocValues {

    final SortedDocValues originalValues;

    final BytesRef missingValue;

    final int missingValuePosition;

    final boolean missingValueExist;

    boolean hasValue = false;

    public ReplaceMissingSortedDocValues(SortedDocValues originalValues, BytesRef missingValue) throws IOException {
        this.originalValues = originalValues;
        this.missingValue = missingValue;
        int sub = originalValues.lookupTerm(missingValue);
        if (sub < 0) {
            missingValuePosition = -sub - 1;
            missingValueExist = false;
        } else {
            missingValuePosition = sub;
            missingValueExist = true;
        }
    }

    @Override
    public int ordValue() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean advanceExact(int target) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int docID() {
        throw new UnsupportedOperationException("STUB: not implemented");
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
