/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.annotations.Spatial;
import org.hibernate.search.query.dsl.Unit;
import org.hibernate.search.spatial.Coordinates;

/**
 * @author Emmanuel Bernard
 */
public class SpatialQueryContext {

    private String coordinatesField;

    private double radiusDistance;

    private Unit distanceUnit;

    private Coordinates coordinates;

    public String getCoordinatesField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCoordinatesField(String coordinatesField) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getRadiusDistance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Unit getDistanceUnit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Coordinates getCoordinates() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCoordinates(Coordinates coordinates) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRadius(double distance, Unit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
