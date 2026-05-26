/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.projection.impl;

import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonArrayAccessor;
import org.hibernate.search.backend.elasticsearch.reporting.impl.ElasticsearchSearchHints;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.engine.search.loading.spi.LoadingResult;
import org.hibernate.search.engine.search.loading.spi.ProjectionHitMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

class ElasticsearchSourceProjection extends AbstractElasticsearchProjection<JsonObject> implements ElasticsearchSearchProjection.Extractor<JsonObject, JsonObject> {

    private static final JsonArrayAccessor REQUEST_SOURCE_ACCESSOR = JsonAccessor.root().property("_source").asArray();

    private static final JsonPrimitive WILDCARD_ALL = new JsonPrimitive("*");

    ElasticsearchSourceProjection(ElasticsearchSearchIndexScope<?> scope) {
        super(scope);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Extractor<?, JsonObject> request(JsonObject requestBody, ProjectionRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonObject extract(ProjectionHitMapper<?> projectionHitMapper, JsonObject hit, JsonObject source, ProjectionExtractContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonObject transform(LoadingResult<?> loadingResult, JsonObject extractedData, ProjectionTransformContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
