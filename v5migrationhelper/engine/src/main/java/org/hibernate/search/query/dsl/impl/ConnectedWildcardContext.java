/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.query.dsl.TermMatchingContext;
import org.hibernate.search.query.dsl.WildcardContext;
import org.apache.lucene.search.Query;

/**
 * @author Emmanuel Bernard
 */
class ConnectedWildcardContext implements WildcardContext {

    private final QueryBuildingContext queryContext;

    private final QueryCustomizer queryCustomizer;

    private final TermQueryContext termContext;

    public ConnectedWildcardContext(QueryCustomizer queryCustomizer, QueryBuildingContext queryContext) {
        this.queryContext = queryContext;
        this.queryCustomizer = queryCustomizer;
        this.termContext = new TermQueryContext(TermQueryContext.Approximation.WILDCARD);
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
    public WildcardContext boostedTo(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public WildcardContext withConstantScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public WildcardContext filteredBy(Query filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
