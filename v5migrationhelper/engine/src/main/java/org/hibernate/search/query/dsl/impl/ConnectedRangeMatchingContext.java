/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.query.dsl.RangeMatchingContext;
import org.hibernate.search.query.dsl.RangeTerminationExcludable;

/**
 * @author Emmanuel Bernard
 */
public class ConnectedRangeMatchingContext implements RangeMatchingContext {

    private final QueryBuildingContext queryContext;

    private final QueryCustomizer queryCustomizer;

    private final RangeQueryContext rangeContext;

    private final FieldsContext fieldsContext;

    public ConnectedRangeMatchingContext(String fieldName, QueryCustomizer queryCustomizer, QueryBuildingContext queryContext) {
        this.queryContext = queryContext;
        this.queryCustomizer = queryCustomizer;
        this.rangeContext = new RangeQueryContext();
        this.fieldsContext = new FieldsContext(new String[] { fieldName }, queryContext);
    }

    @Override
    public RangeMatchingContext andField(String field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> FromRangeContext<T> from(T from) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class ConnectedFromRangeContext<T> implements FromRangeContext<T> {

        private final ConnectedRangeMatchingContext mother;

        ConnectedFromRangeContext(ConnectedRangeMatchingContext mother) {
            this.mother = mother;
        }

        @Override
        public RangeTerminationExcludable to(T to) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public FromRangeContext<T> excludeLimit() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @Override
    public RangeTerminationExcludable below(Object below) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RangeTerminationExcludable above(Object above) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RangeMatchingContext boostedTo(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RangeMatchingContext ignoreAnalyzer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RangeMatchingContext ignoreFieldBridge() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
