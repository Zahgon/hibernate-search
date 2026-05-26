/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.projection.impl;

import org.hibernate.search.backend.lucene.lowlevel.collector.impl.DocumentReferenceValues;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.Values;
import org.hibernate.search.backend.lucene.reporting.impl.LuceneSearchHints;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.engine.backend.common.DocumentReference;
import org.hibernate.search.engine.search.loading.spi.LoadingResult;
import org.hibernate.search.engine.search.projection.spi.ProjectionTypeKeys;

class LuceneDocumentReferenceProjection extends AbstractLuceneProjection<DocumentReference> implements LuceneSearchProjection.Extractor<DocumentReference, DocumentReference> {

    LuceneDocumentReferenceProjection(LuceneSearchIndexScope<?> scope) {
        super(scope);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Extractor<?, DocumentReference> request(ProjectionRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Values<DocumentReference> values(ProjectionExtractContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DocumentReference transform(LoadingResult<?> loadingResult, DocumentReference extractedData, ProjectionTransformContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
