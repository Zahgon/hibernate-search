/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.projection.impl;

import org.hibernate.search.backend.elasticsearch.reporting.impl.ElasticsearchSearchHints;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.engine.backend.common.DocumentReference;
import org.hibernate.search.engine.search.loading.spi.LoadingResult;
import org.hibernate.search.engine.search.loading.spi.ProjectionHitMapper;
import org.hibernate.search.engine.search.projection.spi.ProjectionTypeKeys;
import com.google.gson.JsonObject;

public class ElasticsearchEntityReferenceProjection<R> extends AbstractElasticsearchProjection<R> implements ElasticsearchSearchProjection.Extractor<DocumentReference, R> {

    private final DocumentReferenceExtractionHelper helper;

    ElasticsearchEntityReferenceProjection(ElasticsearchSearchIndexScope<?> scope, DocumentReferenceExtractionHelper helper) {
        super(scope);
        this.helper = helper;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Extractor<?, R> request(JsonObject requestBody, ProjectionRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DocumentReference extract(ProjectionHitMapper<?> projectionHitMapper, JsonObject hit, JsonObject source, ProjectionExtractContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("unchecked")
    public R transform(LoadingResult<?> loadingResult, DocumentReference extractedData, ProjectionTransformContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
