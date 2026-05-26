/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.spatial;

import java.util.Objects;

final class ImmutableGeoPoint implements GeoPoint {

    private final double latitude;

    private final double longitude;

    ImmutableGeoPoint(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double latitude() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double longitude() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
