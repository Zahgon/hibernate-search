/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.query.dsl.SpatialContext;
import org.hibernate.search.query.dsl.SpatialMatchingContext;
import org.hibernate.search.query.dsl.Unit;
import org.hibernate.search.query.dsl.WithinContext;
import org.apache.lucene.search.Query;

/**
 * @author Emmanuel Bernard
 */
public class ConnectedSpatialContext implements SpatialContext {

    private final QueryBuildingContext queryContext;

    private final QueryCustomizer queryCustomizer;

    private final SpatialQueryContext spatialContext;

    public ConnectedSpatialContext(QueryBuildingContext context) {
        this.queryContext = context;
        this.queryCustomizer = new QueryCustomizer();
        //today we only do constant score for spatial queries
        queryCustomizer.withConstantScore();
        spatialContext = new SpatialQueryContext();
    }

    @Override
    public SpatialMatchingContext onField(String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SpatialContext boostedTo(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SpatialContext withConstantScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SpatialContext filteredBy(Query filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public WithinContext within(double distance, Unit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    QueryBuildingContext getQueryContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    QueryCustomizer getQueryCustomizer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    SpatialQueryContext getSpatialContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
