/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.predicate.impl;

import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.engine.search.predicate.spi.BooleanPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.MatchAllPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.MatchIdPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.MatchNonePredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.QueryStringPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.SearchPredicateBuilderFactory;
import org.hibernate.search.engine.search.predicate.spi.SimpleQueryStringPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.WithParametersPredicateBuilder;
import com.google.gson.JsonObject;

public class ElasticsearchSearchPredicateBuilderFactory implements SearchPredicateBuilderFactory {

    private final ElasticsearchSearchIndexScope<?> scope;

    public ElasticsearchSearchPredicateBuilderFactory(ElasticsearchSearchIndexScope<?> scope) {
        this.scope = scope;
    }

    @Override
    public MatchAllPredicateBuilder matchAll() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MatchNonePredicateBuilder matchNone() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MatchIdPredicateBuilder id() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BooleanPredicateBuilder bool() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SimpleQueryStringPredicateBuilder simpleQueryString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public QueryStringPredicateBuilder queryString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public WithParametersPredicateBuilder withParameters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ElasticsearchSearchPredicate fromJson(JsonObject jsonObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ElasticsearchSearchPredicate fromJson(String jsonString) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
