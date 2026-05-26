/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.query.impl;

import org.apache.lucene.search.DocIdSetIterator;

public final class ExplicitDocIdSetIterator extends DocIdSetIterator {

    public static DocIdSetIterator of(int[] sortedTopLevelDocIds, int leafDocBase, int leafMaxLeafId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static int findFirstGreaterThanOrEqualTo(int[] values, int min) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] >= min) {
                return i;
            }
        }
        return -1;
    }

    private final int[] sortedTopLevelDocIds;

    private final int leafDocBase;

    private final int firstIndex;

    private final int leafMaxDocId;

    private int index;

    private int leafDocId = -1;

    ExplicitDocIdSetIterator(int[] sortedTopLevelDocIds, int leafDocBase, int firstIndex, int leafMaxDocId) {
        this.sortedTopLevelDocIds = sortedTopLevelDocIds;
        this.leafDocBase = leafDocBase;
        this.firstIndex = firstIndex;
        this.leafMaxDocId = leafMaxDocId;
        this.index = firstIndex;
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
