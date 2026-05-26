/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.aggregation.impl;

import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.logging.spi.ElasticsearchClientLog;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.engine.search.aggregation.AggregationKey;
import org.hibernate.search.engine.search.aggregation.SearchAggregation;
import org.hibernate.search.engine.search.aggregation.spi.CompositeAggregationBuilder;
import org.hibernate.search.engine.search.spi.ResultsCompositor;
import com.google.gson.JsonObject;

public class ElasticsearchCompositeAggregation<A> extends AbstractElasticsearchAggregation<A> {

    private static final String REVERSE_NESTED_WRAPPER_NAME = "reverse_nested_wrapper";

    private static final JsonAccessor<JsonObject> REQUEST_REVERSE_NESTED_WRAPPER_ACCESSOR = JsonAccessor.root().property(REVERSE_NESTED_WRAPPER_NAME).asObject();

    private static final AggregationKey<?> REVERSE_NESTED_WRAPPER_KEY = AggregationKey.of(REVERSE_NESTED_WRAPPER_NAME);

    private static final AggregationKey<?> REGULAR_KEY = AggregationKey.of("regular_aggregation");

    private final ElasticsearchSearchAggregation<?>[] aggregations;

    private final ResultsCompositor<?, A> compositor;

    private ElasticsearchCompositeAggregation(Builder<A> builder) {
        super(builder);
        aggregations = builder.inners;
        compositor = builder.compositor;
    }

    public Extractor<A> request(AggregationRequestContext context, AggregationKey<?> key, JsonObject jsonAggregations) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder<T> extends AbstractBuilder<T> implements CompositeAggregationBuilder<T> {

        private ElasticsearchSearchAggregation<?>[] inners;

        private ResultsCompositor<?, T> compositor;

        public Builder(ElasticsearchSearchIndexScope<?> scope) {
            super(scope);
        }

        private Builder(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchAggregation<?>[] inners, ResultsCompositor<?, T> compositor) {
            super(scope);
            this.inners = inners;
            this.compositor = compositor;
        }

        @Override
        public ElasticsearchCompositeAggregation<T> build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public CompositeAggregationBuilder<T> innerAggregations(SearchAggregation<?>[] inners) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public <V> CompositeAggregationBuilder<V> compositor(ResultsCompositor<?, V> compositor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private record CompositeExtractor<E, A>(AggregationKey<?> key, ResultsCompositor<E, A> compositor, Extractor<?>[] extractors, AggregationKey<?>[] keys) implements Extractor<A> {

        @Override
        public A extract(JsonObject aggregationResult, AggregationExtractContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static AggregationKey<?> compositeKeyFor(boolean isNested) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
