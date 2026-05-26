/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.spatial.impl;

import org.hibernate.search.spatial.Coordinates;

/**
 * Bounding box for search area on Earth
 *
 * @author Nicolas Helleringer
 * @author Mathieu Perez
 */
public final class Rectangle {

    private final Point lowerLeft;

    private final Point upperRight;

    public Rectangle(Point lowerLeft, Point upperRight) {
        this.lowerLeft = lowerLeft;
        this.upperRight = upperRight;
    }

    /**
     * Compute appropriate bounding box on Earth with pole and prime meridian crossing checks
     *
     * @param centerCoordinates of the search area
     * @param radius of the search area
     * @return a bounding box for the area
     * @see <a href="http://janmatuschek.de/LatitudeLongitudeBoundingCoordinates">Bouding box on Earth calculation</a>
     */
    public static Rectangle fromBoundingCircle(Coordinates centerCoordinates, double radius) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Point getLowerLeft() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Point getUpperRight() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
