/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.sort.impl;

import org.hibernate.search.query.dsl.impl.QueryBuildingContext;
import org.hibernate.search.query.dsl.sort.SortContext;
import org.hibernate.search.query.dsl.sort.SortDistanceNoFieldContext;
import org.hibernate.search.query.dsl.sort.SortFieldContext;
import org.hibernate.search.query.dsl.sort.SortNativeContext;
import org.hibernate.search.query.dsl.sort.SortOrderTermination;
import org.hibernate.search.query.dsl.sort.SortScoreContext;
import org.apache.lucene.search.SortField;

/**
 * @author Emmanuel Bernard emmanuel@hibernate.org
 */
public class ConnectedSortContext extends AbstractConnectedSortContext implements SortContext {

    public ConnectedSortContext(QueryBuildingContext queryContext) {
        super(queryContext, new SortFieldStates(queryContext));
    }

    @Override
    public SortScoreContext byScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortOrderTermination byIndexOrder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortFieldContext byField(String field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortDistanceNoFieldContext byDistance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortNativeContext byNative(SortField sortField) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
