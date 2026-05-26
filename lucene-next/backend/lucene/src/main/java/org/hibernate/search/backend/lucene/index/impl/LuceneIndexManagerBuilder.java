/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.index.impl;

import org.hibernate.search.backend.lucene.document.impl.LuceneIndexEntryFactory;
import org.hibernate.search.backend.lucene.document.model.dsl.impl.LuceneIndexRootBuilder;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexModel;
import org.hibernate.search.engine.backend.document.model.dsl.spi.IndexRootBuilder;
import org.hibernate.search.engine.backend.index.spi.IndexManagerBuilder;
import org.hibernate.search.util.common.impl.SuppressingCloser;

public class LuceneIndexManagerBuilder implements IndexManagerBuilder {

    private final IndexManagerBackendContext backendContext;

    private final String indexName;

    private final LuceneIndexRootBuilder schemaRootNodeBuilder;

    public LuceneIndexManagerBuilder(IndexManagerBackendContext backendContext, String indexName, LuceneIndexRootBuilder schemaRootNodeBuilder) {
        this.backendContext = backendContext;
        this.indexName = indexName;
        this.schemaRootNodeBuilder = schemaRootNodeBuilder;
    }

    @Override
    public void closeOnFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexRootBuilder schemaRootNodeBuilder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneIndexManagerImpl build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
