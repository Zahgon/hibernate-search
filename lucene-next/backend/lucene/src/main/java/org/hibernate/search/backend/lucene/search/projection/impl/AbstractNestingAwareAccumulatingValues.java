/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.projection.impl;

import java.io.IOException;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.TopDocsDataCollectorExecutionContext;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.Values;
import org.hibernate.search.backend.lucene.lowlevel.join.impl.ChildDocIds;
import org.hibernate.search.backend.lucene.lowlevel.join.impl.NestedDocsProvider;
import org.hibernate.search.engine.search.projection.ProjectionCollector;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.DocIdSetIterator;

abstract class AbstractNestingAwareAccumulatingValues<E, A> implements Values<A> {

    private final NestedDocsProvider nestedDocsProvider;

    protected final ProjectionCollector<E, ?, A, ?> collector;

    protected ChildDocIds currentLeafChildDocIds;

    AbstractNestingAwareAccumulatingValues(String parentDocumentPath, String nestedDocumentPath, ProjectionCollector<E, ?, A, ?> collector, TopDocsDataCollectorExecutionContext context) {
        this.nestedDocsProvider = nestedDocumentPath == null || nestedDocumentPath.equals(parentDocumentPath) ? null : context.createNestedDocsProvider(parentDocumentPath, nestedDocumentPath);
        this.collector = collector;
    }

    @Override
    public void context(LeafReaderContext context) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected DocIdSetIterator doContext(LeafReaderContext context) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final A get(int parentDocId) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract A accumulate(A accumulated, int docId) throws IOException;
}
