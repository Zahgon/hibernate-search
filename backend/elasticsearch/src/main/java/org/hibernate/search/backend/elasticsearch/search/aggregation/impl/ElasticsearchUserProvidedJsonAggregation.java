/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.aggregation.impl;

import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.engine.search.aggregation.AggregationKey;
import com.google.gson.JsonObject;

class ElasticsearchUserProvidedJsonAggregation extends AbstractElasticsearchAggregation<JsonObject> {

    private final JsonObject requestJson;

    private ElasticsearchUserProvidedJsonAggregation(Builder builder) {
        super(builder);
        this.requestJson = builder.json;
    }

    @Override
    public Extractor<JsonObject> request(AggregationRequestContext context, AggregationKey<?> key, JsonObject jsonAggregations) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class Builder extends AbstractBuilder<JsonObject> {

        private final JsonObject json;

        Builder(ElasticsearchSearchIndexScope<?> scope, JsonObject json) {
            super(scope);
            this.json = json;
        }

        @Override
        public ElasticsearchSearchAggregation<JsonObject> build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private record PassThroughExtractor(AggregationKey<?> key) implements Extractor<JsonObject> {

        @Override
        public JsonObject extract(JsonObject aggregationResult, AggregationExtractContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
