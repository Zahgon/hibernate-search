/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.predicate.impl;

import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.engine.search.predicate.spi.BooleanPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.MatchAllPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.MatchIdPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.MatchNonePredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.QueryStringPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.SearchPredicateBuilderFactory;
import org.hibernate.search.engine.search.predicate.spi.SimpleQueryStringPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.WithParametersPredicateBuilder;
import org.apache.lucene.search.Query;

public class LuceneSearchPredicateBuilderFactory implements SearchPredicateBuilderFactory {

    private final LuceneSearchIndexScope<?> scope;

    public LuceneSearchPredicateBuilderFactory(LuceneSearchIndexScope<?> scope) {
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

    public LuceneSearchPredicate fromLuceneQuery(Query query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
