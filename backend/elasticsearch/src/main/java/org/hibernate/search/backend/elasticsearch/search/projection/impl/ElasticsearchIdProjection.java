/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.projection.impl;

import org.hibernate.search.backend.elasticsearch.reporting.impl.ElasticsearchSearchHints;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.engine.backend.types.converter.spi.ProjectionConverter;
import org.hibernate.search.engine.search.loading.spi.LoadingResult;
import org.hibernate.search.engine.search.loading.spi.ProjectionHitMapper;
import org.hibernate.search.engine.search.projection.spi.ProjectionTypeKeys;
import com.google.gson.JsonObject;

public class ElasticsearchIdProjection<I> extends AbstractElasticsearchProjection<I> implements ElasticsearchSearchProjection.Extractor<String, I> {

    private final ProjectionExtractionHelper<String> extractionHelper;

    private final ProjectionConverter<String, ? extends I> converter;

    ElasticsearchIdProjection(ElasticsearchSearchIndexScope<?> scope, ProjectionExtractionHelper<String> extractionHelper, ProjectionConverter<String, ? extends I> converter) {
        super(scope);
        this.extractionHelper = extractionHelper;
        this.converter = converter;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Extractor<?, I> request(JsonObject requestBody, ProjectionRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String extract(ProjectionHitMapper<?> projectionHitMapper, JsonObject hit, JsonObject source, ProjectionExtractContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public I transform(LoadingResult<?> loadingResult, String extractedData, ProjectionTransformContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
