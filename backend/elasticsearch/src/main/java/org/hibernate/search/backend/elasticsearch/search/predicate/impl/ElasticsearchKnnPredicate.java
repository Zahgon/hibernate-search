/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.predicate.impl;

import java.lang.reflect.Array;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonArrayAccessor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonObjectAccessor;
import org.hibernate.search.backend.elasticsearch.logging.impl.QueryLog;
import org.hibernate.search.backend.elasticsearch.lowlevel.query.impl.Queries;
import org.hibernate.search.backend.elasticsearch.search.common.impl.AbstractElasticsearchCodecAwareSearchQueryElementFactory;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexValueFieldContext;
import org.hibernate.search.backend.elasticsearch.types.codec.impl.ElasticsearchFieldCodec;
import org.hibernate.search.backend.elasticsearch.types.codec.impl.ElasticsearchVectorFieldCodec;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.KnnPredicateBuilder;
import org.hibernate.search.util.common.AssertionFailure;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public abstract class ElasticsearchKnnPredicate extends AbstractElasticsearchSingleFieldPredicate {

    protected final ElasticsearchSearchPredicate filter;

    protected final int k;

    protected final JsonArray vector;

    protected final Float similarity;

    private ElasticsearchKnnPredicate(AbstractKnnBuilder<?> builder) {
        super(builder);
        this.filter = builder.filter;
        this.k = builder.k;
        this.vector = builder.vector;
        this.similarity = builder.similarity;
        builder.filter = null;
        builder.vector = null;
    }

    protected JsonObject prepareFilter(PredicateRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Elasticsearch812Factory<F> extends AbstractElasticsearchCodecAwareSearchQueryElementFactory<KnnPredicateBuilder, F> {

        public Elasticsearch812Factory(ElasticsearchFieldCodec<F> codec) {
            super(codec);
        }

        @Override
        public KnnPredicateBuilder create(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<F> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class OpenSearch2Factory<F> extends AbstractElasticsearchCodecAwareSearchQueryElementFactory<KnnPredicateBuilder, F> {

        public OpenSearch2Factory(ElasticsearchFieldCodec<F> codec) {
            super(codec);
        }

        @Override
        public KnnPredicateBuilder create(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<F> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class OpenSearch214Factory<F> extends AbstractElasticsearchCodecAwareSearchQueryElementFactory<KnnPredicateBuilder, F> {

        public OpenSearch214Factory(ElasticsearchFieldCodec<F> codec) {
            super(codec);
        }

        @Override
        public KnnPredicateBuilder create(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<F> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private abstract static class AbstractKnnBuilder<F> extends AbstractBuilder implements KnnPredicateBuilder {

        private final Class<?> vectorElementsType;

        private final int indexedVectorsDimension;

        protected final ElasticsearchVectorFieldCodec<F> codec;

        private int k;

        private JsonArray vector;

        private ElasticsearchSearchPredicate filter;

        protected Float similarity;

        private AbstractKnnBuilder(ElasticsearchFieldCodec<F> codec, ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<F> field) {
            super(scope, field);
            if (codec instanceof ElasticsearchVectorFieldCodec) {
                this.codec = (ElasticsearchVectorFieldCodec<F>) codec;
                vectorElementsType = this.codec.vectorElementsType();
                indexedVectorsDimension = this.codec.getConfiguredDimensions();
            } else {
                // shouldn't really happen as if someone tries this it should fail on `queryElementFactory` lookup.
                throw new AssertionFailure("Attempting to use a knn predicate on a non-vector field.");
            }
        }

        @Override
        public void k(int k) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void vector(Object vector) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void filter(SearchPredicate filter) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static JsonArray vectorToJsonArray(Object vector, Class<?> vectorElementsType) {
        // we know it is an array since we've checked it when we got the vector
        int length = Array.getLength(vector);
        JsonArray array = new JsonArray(length);
        for (int i = 0; i < length; i++) {
            if (byte.class.equals(vectorElementsType)) {
                array.add(Array.getByte(vector, i));
            } else {
                array.add(Array.getFloat(vector, i));
            }
        }
        return array;
    }

    private static class Elasticsearch812Impl extends ElasticsearchKnnPredicate {

        private static final JsonObjectAccessor KNN_ACCESSOR = JsonAccessor.root().property("knn").asObject();

        private static final JsonAccessor<String> FIELD_ACCESSOR = JsonAccessor.root().property("field").asString();

        private static final JsonArrayAccessor VECTOR_ACCESSOR = JsonAccessor.root().property("query_vector").asArray();

        private static final JsonObjectAccessor FILTER_ACCESSOR = JsonAccessor.root().property("filter").asObject();

        private static final JsonAccessor<Integer> NUM_CANDIDATES_ACCESSOR = JsonAccessor.root().property("num_candidates").asInteger();

        private static final JsonAccessor<Float> SIMILARITY_ACCESSOR = JsonAccessor.root().property("similarity").asFloat();

        private Elasticsearch812Impl(Builder<?> builder) {
            super(builder);
        }

        @Override
        protected JsonObject doToJsonQuery(PredicateRequestContext context, JsonObject outerObject, JsonObject innerObject) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private static class Builder<F> extends AbstractKnnBuilder<F> {

            private Builder(ElasticsearchFieldCodec<F> codec, ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<F> field) {
                super(codec, scope, field);
            }

            @Override
            public void requiredMinimumSimilarity(float similarity) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public void requiredMinimumScore(float score) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public SearchPredicate build() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
    }

    private static class OpenSearch214Impl extends AbstractOpenSearchKnnPredicate {

        private final Float score;

        private OpenSearch214Impl(Builder<?> builder) {
            super(builder);
            this.score = builder.score;
        }

        @Override
        protected void addVersionSpecificFields(JsonObject innerObject) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected static class Builder<F> extends AbstractKnnBuilder<F> {

            protected Float score;

            protected Builder(ElasticsearchFieldCodec<F> codec, ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<F> field) {
                super(codec, scope, field);
            }

            @Override
            public void requiredMinimumSimilarity(float similarity) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public void requiredMinimumScore(float score) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public SearchPredicate build() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
    }

    private static class OpenSearch2Impl extends AbstractOpenSearchKnnPredicate {

        protected OpenSearch2Impl(Builder<?> builder) {
            super(builder);
        }

        @Override
        protected void addVersionSpecificFields(JsonObject innerObject) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected static class Builder<F> extends AbstractKnnBuilder<F> {

            protected Builder(ElasticsearchFieldCodec<F> codec, ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<F> field) {
                super(codec, scope, field);
            }

            @Override
            public void requiredMinimumSimilarity(float similarity) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public void requiredMinimumScore(float score) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public SearchPredicate build() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
    }

    private abstract static class AbstractOpenSearchKnnPredicate extends ElasticsearchKnnPredicate {

        protected static final JsonObjectAccessor KNN_ACCESSOR = JsonAccessor.root().property("knn").asObject();

        protected static final JsonArrayAccessor VECTOR_ACCESSOR = JsonAccessor.root().property("vector").asArray();

        protected static final JsonAccessor<Integer> K_ACCESSOR = JsonAccessor.root().property("k").asInteger();

        protected static final JsonObjectAccessor FILTER_ACCESSOR = JsonAccessor.root().property("filter").asObject();

        protected static final JsonAccessor<Float> MAX_DISTANCE = JsonAccessor.root().property("max_distance").asFloat();

        protected static final JsonAccessor<Float> MIN_SCORE = JsonAccessor.root().property("min_score").asFloat();

        private AbstractOpenSearchKnnPredicate(AbstractKnnBuilder<?> builder) {
            super(builder);
        }

        @Override
        protected final JsonObject doToJsonQuery(PredicateRequestContext context, JsonObject outerObject, JsonObject innerObject) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected abstract void addVersionSpecificFields(JsonObject innerObject);
    }
}
