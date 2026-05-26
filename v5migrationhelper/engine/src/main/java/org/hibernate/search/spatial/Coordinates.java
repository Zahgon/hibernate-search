/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.spatial;

import org.hibernate.search.annotations.Latitude;
import org.hibernate.search.annotations.Longitude;
import org.hibernate.search.engine.spatial.GeoPoint;

/**
 * Minimum interface for a field/method to be spatial hash indexable
 *
 * @author Nicolas Helleringer
 * @deprecated Use {@link GeoPoint} instead.
 * Refer to the <a href="https://hibernate.org/search/documentation/migrate/6.0/">migration guide</a> for more information.
 */
@Deprecated
public interface Coordinates {

    /**
     * @return the latitude in degrees
     */
    @Latitude
    Double getLatitude();

    /**
     * @return the longitude in degrees
     */
    @Longitude
    Double getLongitude();

    static GeoPoint toGeoPoint(Coordinates coordinates) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
