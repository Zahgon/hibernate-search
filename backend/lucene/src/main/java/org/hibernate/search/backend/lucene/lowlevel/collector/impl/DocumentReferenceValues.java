/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.collector.impl;

import java.io.IOException;
import org.hibernate.search.backend.lucene.lowlevel.common.impl.MetadataFields;
import org.hibernate.search.backend.lucene.lowlevel.reader.impl.IndexReaderMetadataResolver;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneDocumentReference;
import org.hibernate.search.engine.backend.common.DocumentReference;
import org.apache.lucene.index.BinaryDocValues;
import org.apache.lucene.index.DocValues;
import org.apache.lucene.index.LeafReaderContext;

public abstract class DocumentReferenceValues<R> implements Values<R> {

    public static DocumentReferenceValues<DocumentReference> simple(CollectorExecutionContext executionContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final IndexReaderMetadataResolver metadataResolver;

    private String currentLeafMappedTypeName;

    private BinaryDocValues currentLeafIdDocValues;

    protected DocumentReferenceValues(CollectorExecutionContext executionContext) {
        this.metadataResolver = executionContext.getMetadataResolver();
    }

    @Override
    public final void context(LeafReaderContext context) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final R get(int doc) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract R toReference(String typeName, String identifier);
}
