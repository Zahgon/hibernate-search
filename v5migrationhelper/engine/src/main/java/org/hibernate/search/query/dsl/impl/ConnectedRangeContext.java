/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.query.dsl.RangeContext;
import org.hibernate.search.query.dsl.RangeMatchingContext;
import org.apache.lucene.search.Query;

/**
 * @author Emmanuel Bernard
 */
class ConnectedRangeContext implements RangeContext {

    private final QueryBuildingContext queryContext;

    private final QueryCustomizer queryCustomizer;

    public ConnectedRangeContext(QueryBuildingContext queryContext) {
        this.queryContext = queryContext;
        this.queryCustomizer = new QueryCustomizer();
    }

    @Override
    public RangeMatchingContext onField(String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RangeContext boostedTo(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RangeContext withConstantScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RangeContext filteredBy(Query filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
