/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.collector.impl;

import java.io.IOException;
import java.util.Set;
import org.hibernate.search.backend.lucene.lowlevel.join.impl.ChildDocIds;
import org.hibernate.search.backend.lucene.lowlevel.join.impl.NestedDocsProvider;
import org.hibernate.search.backend.lucene.search.extraction.impl.ReusableDocumentStoredFieldVisitor;
import org.hibernate.search.util.common.AssertionFailure;
import com.carrotsearch.hppc.IntObjectHashMap;
import com.carrotsearch.hppc.IntObjectMap;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.LeafReader;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.DocIdSetIterator;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Weight;

/**
 * Collects values from stored fields, for use in {@link Values} implementations.
 * <p>
 * <strong>WARNING:</strong> this relies on reader.document() to load the value of stored field
 * for <strong>each single matching document</strong>,
 * Use with care.
 */
public class StoredFieldsValuesDelegate {

    public static class Factory {

        private final ReusableDocumentStoredFieldVisitor storedFieldVisitor;

        private final Set<String> requiredNestedDocumentPathsForStoredFields;

        public Factory(ReusableDocumentStoredFieldVisitor storedFieldVisitor, Set<String> requiredNestedDocumentPathsForStoredFields) {
            this.storedFieldVisitor = storedFieldVisitor;
            this.requiredNestedDocumentPathsForStoredFields = requiredNestedDocumentPathsForStoredFields;
        }

        public StoredFieldsValuesDelegate create(CollectorExecutionContext context) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private final NestedDocsProvider nestedDocsProvider;

    private final Weight childrenWeight;

    private final ReusableDocumentStoredFieldVisitor storedFieldVisitor;

    private ChildDocIds currentLeafChildDocs;

    private LeafReader currentLeafReader;

    private int currentRootDoc;

    private Document currentRootDocValue;

    private final IntObjectMap<Document> currentChildDocValues;

    public StoredFieldsValuesDelegate(NestedDocsProvider nestedDocsProvider, ReusableDocumentStoredFieldVisitor storedFieldVisitor, IndexSearcher indexSearcher) throws IOException {
        this.childrenWeight = nestedDocsProvider == null ? null : nestedDocsProvider.childDocsWeight(indexSearcher);
        this.nestedDocsProvider = nestedDocsProvider;
        this.storedFieldVisitor = storedFieldVisitor;
        this.currentChildDocValues = nestedDocsProvider == null ? null : new IntObjectHashMap<>();
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void context(LeafReaderContext context) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void collect(int parentDoc) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Document get(int docId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
