/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.query.dsl.SimpleQueryStringContext;
import org.hibernate.search.query.dsl.SimpleQueryStringMatchingContext;
import org.apache.lucene.search.Query;

/**
 * @author Guillaume Smet
 */
class ConnectedSimpleQueryStringContext implements SimpleQueryStringContext {

    private final QueryBuildingContext queryContext;

    private final QueryCustomizer queryCustomizer;

    public ConnectedSimpleQueryStringContext(QueryBuildingContext queryContext) {
        this.queryContext = queryContext;
        this.queryCustomizer = new QueryCustomizer();
    }

    @Override
    public SimpleQueryStringMatchingContext onField(String field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SimpleQueryStringMatchingContext onFields(String field, String... fields) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConnectedSimpleQueryStringContext boostedTo(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConnectedSimpleQueryStringContext withConstantScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConnectedSimpleQueryStringContext filteredBy(Query filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
