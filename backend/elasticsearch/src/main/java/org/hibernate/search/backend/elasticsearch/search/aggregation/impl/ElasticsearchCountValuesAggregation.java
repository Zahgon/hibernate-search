/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.aggregation.impl;

import java.util.List;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonElementTypes;
import org.hibernate.search.backend.elasticsearch.logging.impl.QueryLog;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexNodeContext;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexValueFieldContext;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.ElasticsearchSearchPredicate;
import org.hibernate.search.engine.search.aggregation.AggregationKey;
import org.hibernate.search.engine.search.aggregation.spi.CountValuesAggregationBuilder;
import org.hibernate.search.engine.search.common.spi.SearchQueryElementFactory;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ElasticsearchCountValuesAggregation extends AbstractElasticsearchNestableAggregation<Long> {

    private static final JsonAccessor<JsonObject> COUNT_PROPERTY_ACCESSOR = JsonAccessor.root().property("value_count").asObject();

    private static final JsonAccessor<JsonObject> COUNT_DISTINCT_PROPERTY_ACCESSOR = JsonAccessor.root().property("cardinality").asObject();

    private static final JsonAccessor<String> FIELD_PROPERTY_ACCESSOR = JsonAccessor.root().property("field").asString();

    private final String absoluteFieldPath;

    private final JsonAccessor<JsonObject> operation;

    private ElasticsearchCountValuesAggregation(Builder builder) {
        super(builder);
        this.absoluteFieldPath = builder.field.absolutePath();
        this.operation = builder.operation;
    }

    public static SearchQueryElementFactory<CountValuesAggregationBuilder.TypeSelector, ElasticsearchSearchIndexScope<?>, ElasticsearchSearchIndexNodeContext> factory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class Factory implements SearchQueryElementFactory<CountValuesAggregationBuilder.TypeSelector, ElasticsearchSearchIndexScope<?>, ElasticsearchSearchIndexNodeContext> {

        @Override
        public CountValuesAggregationBuilder.TypeSelector create(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexNodeContext node) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void checkCompatibleWith(SearchQueryElementFactory<?, ?, ?> other) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class TypeSelector implements CountValuesAggregationBuilder.TypeSelector {

        private final ElasticsearchSearchIndexScope<?> scope;

        private final ElasticsearchSearchIndexNodeContext node;

        private TypeSelector(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexNodeContext node) {
            this.scope = scope;
            // doesn't matter in this case
            this.node = node;
        }

        @Override
        public CountValuesAggregationBuilder builder() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @Override
    protected final JsonObject doRequest(AggregationRequestBuildingContextContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Extractor<Long> extractor(AggregationKey<?> key, AggregationRequestBuildingContextContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class MetricLongExtractor extends AbstractExtractor<Long> {

        protected MetricLongExtractor(AggregationKey<?> key, List<String> nestedPathHierarchy, ElasticsearchSearchPredicate filter) {
            super(key, nestedPathHierarchy, filter);
        }

        @Override
        protected Long doExtract(JsonObject aggregationResult, AggregationExtractContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Builder extends AbstractBuilder<Long> implements CountValuesAggregationBuilder {

        private JsonAccessor<JsonObject> operation;

        private Builder(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<?> field) {
            super(scope, field);
            this.operation = COUNT_PROPERTY_ACCESSOR;
        }

        @Override
        public ElasticsearchCountValuesAggregation build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void distinct(boolean distinct) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
