/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.spatial.impl;

import org.hibernate.search.spatial.Coordinates;

/**
 * Normalized latitude,longitude holder (in [-90;90],[-180,180]) with distance and destination computations methods
 *
 * @author Nicolas Helleringer
 * @author Mathieu Perez
 */
public final class Point implements Coordinates {

    private final double latitude;

    private final double longitude;

    /**
     * @param latitude in degrees
     * @param longitude in degrees
     * @return a point with coordinates given in degrees
     */
    public static Point fromDegrees(double latitude, double longitude) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param center the coordinates for the Point to be created
     * @return a Point from given Coordinates. Same instance when given a Point.
     */
    public static Point fromCoordinates(Coordinates center) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param latitude in degrees
     * @param longitude in degrees
     * @return a point with coordinates given in degrees
     */
    public static Point fromDegreesInclusive(double latitude, double longitude) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param longitude in degrees
     * @return longitude normalized in ]-180;+180]
     */
    public static double normalizeLongitude(double longitude) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param longitude in degrees
     * @return longitude normalized in [-180;+180]
     */
    public static double normalizeLongitudeInclusive(double longitude) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param latitude in degrees
     * @return latitude normalized in [-90;+90]
     */
    public static double normalizeLatitude(double latitude) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param latitude in radians
     * @param longitude in radians
     * @return a point with coordinates given in radians
     */
    public static Point fromRadians(double latitude, double longitude) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param latitude in degrees
     * @param longitude in degrees
     */
    private Point(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Calculate end of travel point
     *
     * @param distance to travel
     * @param heading of travel in decimal degree
     * @return arrival point
     * @see <a href="http://www.movable-type.co.uk/scripts/latlong.html">Compute destination</a>
     */
    public Point computeDestination(double distance, double heading) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Compute distance between two points
     *
     * @param other a {@link Point} object.
     * @return the distance between points
     * @see <a href="http://www.movable-type.co.uk/scripts/latlong.html">Distance haversine formula</a>
     */
    public double getDistanceTo(Point other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Compute distance point and other location given by its latitude and longitude in decimal degrees
     *
     * @param latitude in decimal degrees
     * @param longitude in decimal degrees
     * @return the distance between the points
     * @see <a href="http://www.movable-type.co.uk/scripts/latlong.html">Distance haversine formula</a>
     */
    public double getDistanceTo(final double latitude, final double longitude) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Double getLatitude() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Double getLongitude() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getLatitudeRad() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getLongitudeRad() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
