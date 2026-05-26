/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.sort.impl;

import org.hibernate.search.query.dsl.impl.QueryBuildingContext;
import org.hibernate.search.query.dsl.sort.SortAdditionalSortFieldContext;
import org.hibernate.search.query.dsl.sort.SortDistanceNoFieldContext;
import org.hibernate.search.query.dsl.sort.SortFieldContext;
import org.hibernate.search.query.dsl.sort.SortNativeContext;
import org.hibernate.search.query.dsl.sort.SortOrderTermination;
import org.hibernate.search.query.dsl.sort.SortScoreContext;
import org.apache.lucene.search.SortField;

/**
 * @author Emmanuel Bernard emmanuel@hibernate.org
 */
public abstract class ConnectedSortAdditionalSortFieldContext extends AbstractConnectedSortContext implements SortAdditionalSortFieldContext {

    public ConnectedSortAdditionalSortFieldContext(QueryBuildingContext queryContext, SortFieldStates states) {
        super(queryContext, states);
    }

    @Override
    public SortFieldContext andByField(String field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortScoreContext andByScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortOrderTermination andByIndexOrder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortDistanceNoFieldContext andByDistance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortNativeContext andByNative(SortField sortField) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
