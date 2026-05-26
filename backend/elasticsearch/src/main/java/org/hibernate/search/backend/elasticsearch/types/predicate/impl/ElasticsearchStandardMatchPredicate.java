/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.predicate.impl;

import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonObjectAccessor;
import org.hibernate.search.backend.elasticsearch.logging.impl.QueryLog;
import org.hibernate.search.backend.elasticsearch.search.common.impl.AbstractElasticsearchCodecAwareSearchQueryElementFactory;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexValueFieldContext;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.AbstractElasticsearchSingleFieldPredicate;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.backend.elasticsearch.types.codec.impl.ElasticsearchFieldCodec;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.engine.search.common.ValueModel;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.MatchPredicateBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ElasticsearchStandardMatchPredicate extends AbstractElasticsearchSingleFieldPredicate {

    private static final JsonAccessor<JsonElement> QUERY_ACCESSOR = JsonAccessor.root().property("query");

    private static final JsonObjectAccessor MATCH_ACCESSOR = JsonAccessor.root().property("match").asObject();

    private final JsonElement value;

    ElasticsearchStandardMatchPredicate(Builder<?> builder) {
        super(builder);
        value = builder.value;
    }

    @Override
    protected JsonObject doToJsonQuery(PredicateRequestContext context, JsonObject outerObject, JsonObject innerObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Factory<F> extends AbstractElasticsearchCodecAwareSearchQueryElementFactory<MatchPredicateBuilder, F> {

        public Factory(ElasticsearchFieldCodec<F> codec) {
            super(codec);
        }

        @Override
        public MatchPredicateBuilder create(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<F> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static class Builder<F> extends AbstractBuilder implements MatchPredicateBuilder {

        protected final ElasticsearchSearchIndexValueFieldContext<F> field;

        private final ElasticsearchFieldCodec<F> codec;

        private JsonElement value;

        Builder(ElasticsearchFieldCodec<F> codec, ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<F> field) {
            super(scope, field);
            this.field = field;
            this.codec = codec;
        }

        @Override
        public void fuzzy(int maxEditDistance, int exactPrefixLength) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void analyzer(String analyzerName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void skipAnalysis() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void value(Object value, ValueModel valueModel) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void minimumShouldMatchNumber(int ignoreConstraintCeiling, int matchingClausesNumber) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void minimumShouldMatchPercent(int ignoreConstraintCeiling, int matchingClausesPercent) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchPredicate build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
