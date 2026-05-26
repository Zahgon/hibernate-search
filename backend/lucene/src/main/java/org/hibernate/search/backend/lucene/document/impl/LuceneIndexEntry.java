/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.document.impl;

import java.util.Iterator;
import java.util.List;
import org.apache.lucene.document.Document;

public class LuceneIndexEntry implements Iterable<Document> {

    private final String indexName;

    private final String id;

    private final List<Document> documents;

    LuceneIndexEntry(String indexName, String id, List<Document> documents) {
        this.indexName = indexName;
        this.id = id;
        this.documents = documents;
    }

    @Override
    public Iterator<Document> iterator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
