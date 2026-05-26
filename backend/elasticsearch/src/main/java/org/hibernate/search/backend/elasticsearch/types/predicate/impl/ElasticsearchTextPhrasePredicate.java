/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.predicate.impl;

import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonObjectAccessor;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.analysis.impl.AnalyzerConstants;
import org.hibernate.search.backend.elasticsearch.search.common.impl.AbstractElasticsearchValueFieldSearchQueryElementFactory;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexValueFieldContext;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.AbstractElasticsearchSingleFieldPredicate;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.PhrasePredicateBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class ElasticsearchTextPhrasePredicate extends AbstractElasticsearchSingleFieldPredicate {

    private static final JsonObjectAccessor MATCH_PHRASE_ACCESSOR = JsonAccessor.root().property("match_phrase").asObject();

    private static final JsonAccessor<Integer> SLOP_ACCESSOR = JsonAccessor.root().property("slop").asInteger();

    private static final JsonAccessor<JsonElement> QUERY_ACCESSOR = JsonAccessor.root().property("query");

    private static final JsonAccessor<String> ANALYZER_ACCESSOR = JsonAccessor.root().property("analyzer").asString();

    private final Integer slop;

    private final JsonElement phrase;

    private final String analyzer;

    private ElasticsearchTextPhrasePredicate(Builder builder) {
        super(builder);
        slop = builder.slop;
        phrase = builder.phrase;
        analyzer = builder.analyzer;
    }

    @Override
    protected JsonObject doToJsonQuery(PredicateRequestContext context, JsonObject outerObject, JsonObject innerObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Factory extends AbstractElasticsearchValueFieldSearchQueryElementFactory<PhrasePredicateBuilder, String> {

        @Override
        public PhrasePredicateBuilder create(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<String> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Builder extends AbstractBuilder implements PhrasePredicateBuilder {

        private final ElasticsearchSearchIndexValueFieldContext<String> field;

        private Integer slop;

        private JsonElement phrase;

        private String analyzer;

        private Builder(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<String> field) {
            super(scope, field);
            this.field = field;
        }

        @Override
        public void slop(int slop) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void phrase(String phrase) {
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
        public SearchPredicate build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
