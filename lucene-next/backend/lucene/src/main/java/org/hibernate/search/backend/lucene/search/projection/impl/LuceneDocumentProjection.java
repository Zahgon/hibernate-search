/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.projection.impl;

import org.hibernate.search.backend.lucene.lowlevel.collector.impl.StoredFieldsValuesDelegate;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.Values;
import org.hibernate.search.backend.lucene.reporting.impl.LuceneSearchHints;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.engine.search.loading.spi.LoadingResult;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.LeafReaderContext;

class LuceneDocumentProjection extends AbstractLuceneProjection<Document> implements LuceneSearchProjection.Extractor<Document, Document> {

    LuceneDocumentProjection(LuceneSearchIndexScope<?> scope) {
        super(scope);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Extractor<?, Document> request(ProjectionRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Values<Document> values(ProjectionExtractContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Document transform(LoadingResult<?> loadingResult, Document extractedData, ProjectionTransformContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
