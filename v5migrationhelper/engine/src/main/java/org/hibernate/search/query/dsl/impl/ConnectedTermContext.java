/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.query.dsl.FuzzyContext;
import org.hibernate.search.query.dsl.TermContext;
import org.hibernate.search.query.dsl.TermMatchingContext;
import org.hibernate.search.query.dsl.WildcardContext;
import org.apache.lucene.search.Query;

/**
 * @author Emmanuel Bernard
 */
class ConnectedTermContext implements TermContext {

    private final QueryBuildingContext queryContext;

    private final QueryCustomizer queryCustomizer;

    private final TermQueryContext termContext;

    public ConnectedTermContext(QueryBuildingContext queryContext) {
        this.queryContext = queryContext;
        this.queryCustomizer = new QueryCustomizer();
        this.termContext = new TermQueryContext(TermQueryContext.Approximation.EXACT);
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
    public FuzzyContext fuzzy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public WildcardContext wildcard() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConnectedTermContext boostedTo(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConnectedTermContext withConstantScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConnectedTermContext filteredBy(Query filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
