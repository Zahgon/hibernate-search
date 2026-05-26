/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.query.dsl.FuzzyContext;
import org.hibernate.search.query.dsl.TermMatchingContext;
import org.apache.lucene.search.Query;

/**
 * @author Emmanuel Bernard
 */
class ConnectedFuzzyContext implements FuzzyContext {

    private final QueryBuildingContext queryContext;

    private final QueryCustomizer queryCustomizer;

    private final TermQueryContext termContext;

    public ConnectedFuzzyContext(QueryCustomizer queryCustomizer, QueryBuildingContext queryContext) {
        this.queryCustomizer = queryCustomizer;
        this.termContext = new TermQueryContext(TermQueryContext.Approximation.FUZZY);
        this.queryContext = queryContext;
    }

    @Override
    public TermMatchingContext onField(String field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TermMatchingContext onFields(String... fields) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FuzzyContext withEditDistanceUpTo(int maxEditDistance) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConnectedFuzzyContext withPrefixLength(int prefixLength) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FuzzyContext boostedTo(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FuzzyContext withConstantScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FuzzyContext filteredBy(Query filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
