/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.collector.impl;

import java.util.Set;
import org.hibernate.search.backend.lucene.lowlevel.join.impl.NestedDocsProvider;
import org.hibernate.search.backend.lucene.lowlevel.reader.impl.IndexReaderMetadataResolver;
import org.apache.lucene.search.IndexSearcher;

public class CollectorExecutionContext {

    private final IndexReaderMetadataResolver metadataResolver;

    private final IndexSearcher indexSearcher;

    private final int maxDocs;

    public CollectorExecutionContext(IndexReaderMetadataResolver metadataResolver, IndexSearcher indexSearcher, int maxDocs) {
        this.metadataResolver = metadataResolver;
        this.indexSearcher = indexSearcher;
        this.maxDocs = maxDocs;
    }

    public IndexReaderMetadataResolver getMetadataResolver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IndexSearcher getIndexSearcher() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public NestedDocsProvider createNestedDocsProvider(String parentDocumentPath, String nestedDocumentPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public NestedDocsProvider createNestedDocsProvider(Set<String> nestedDocumentPaths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getMaxDocs() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
