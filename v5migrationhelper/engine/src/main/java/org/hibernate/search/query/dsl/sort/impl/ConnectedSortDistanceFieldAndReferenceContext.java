/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.sort.impl;

import org.hibernate.search.query.dsl.impl.QueryBuildingContext;
import org.hibernate.search.query.dsl.sort.SortDistanceFieldAndReferenceContext;
import org.apache.lucene.search.Sort;

/**
 * @author Emmanuel Bernard emmanuel@hibernate.org
 */
public class ConnectedSortDistanceFieldAndReferenceContext extends ConnectedSortAdditionalSortFieldContext implements SortDistanceFieldAndReferenceContext {

    public ConnectedSortDistanceFieldAndReferenceContext(QueryBuildingContext queryContext, SortFieldStates states) {
        super(queryContext, states);
    }

    @Override
    public SortDistanceFieldAndReferenceContext asc() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortDistanceFieldAndReferenceContext desc() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Sort createSort() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
