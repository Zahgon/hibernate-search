/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.sort.impl;

import org.hibernate.search.query.dsl.impl.QueryBuildingContext;
import org.hibernate.search.query.dsl.sort.SortDistanceFieldAndReferenceContext;
import org.hibernate.search.query.dsl.sort.SortDistanceFieldContext;
import org.hibernate.search.query.dsl.sort.SortLatLongContext;
import org.hibernate.search.spatial.Coordinates;

/**
 * @author Emmanuel Bernard emmanuel@hibernate.org
 * @author Yoann Rodiere
 */
public class ConnectedSortDistanceFieldContext extends AbstractConnectedSortContext implements SortDistanceFieldContext, SortLatLongContext {

    public ConnectedSortDistanceFieldContext(QueryBuildingContext queryContext, SortFieldStates states) {
        super(queryContext, states);
    }

    @Override
    public SortDistanceFieldAndReferenceContext fromCoordinates(Coordinates coordinates) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortLatLongContext fromLatitude(double latitude) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortDistanceFieldAndReferenceContext andLongitude(double longitude) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
