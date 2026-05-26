/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.join.impl;

import java.io.IOException;
import org.hibernate.search.util.common.AssertionFailure;
import org.apache.lucene.search.DocIdSetIterator;
import org.apache.lucene.util.BitSet;

/**
 * A provider of children docIds for a given parent docId.
 */
public class ChildDocIds {

    private final BitSet parentDocs;

    private final DocIdSetIterator childDocs;

    private int currentParentDocId = -1;

    private int lastReturnedChildDocId = -1;

    public ChildDocIds(BitSet parentDocs, DocIdSetIterator childDocs) {
        this.parentDocs = parentDocs;
        this.childDocs = childDocs;
    }

    /**
     * @param parentDocId The docID of a parent document. Must be strictly greater than
     * the docId passed to this method the last time it was invoked.
     * @return {@code true} if there is at least one child for the given parent.
     * @throws IOException If advancing underlying iterators throws an exception.
     */
    public boolean advanceExactParent(int parentDocId) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The docId of the next child of the parent doc set by the last call to {@link #advanceExactParent(int)},
     * or {@link DocIdSetIterator#NO_MORE_DOCS} if there isn't any more child for this parent doc.
     * @throws IOException If advancing underlying iterators throws an exception.
     */
    public int nextChild() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param target The docID of a document. Must be greater than or equal to the docId of the last retrieved child.
     * @return The docId of the next child of the parent doc set by the last call to {@link #advanceExactParent(int)},
     * beyond {@code previousIdExcluded},
     * or {@link DocIdSetIterator#NO_MORE_DOCS} if there isn't any more child for this parent doc
     * beyond {@code previousIdExcluded}.
     * @throws IOException If advancing underlying iterators throws an exception.
     */
    public int nextChild(int target) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
