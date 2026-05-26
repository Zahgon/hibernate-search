/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.spatial;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.search.engine.logging.impl.FormattingLog;
import org.hibernate.search.util.common.impl.CollectionHelper;
import org.hibernate.search.util.common.impl.Contracts;

final class ImmutableGeoPolygon implements GeoPolygon {

    private List<GeoPoint> points;

    ImmutableGeoPolygon(List<GeoPoint> points) {
        Contracts.assertNotNull(points, "points");
        GeoPoint firstPoint = points.get(0);
        GeoPoint lastPoint = points.get(points.size() - 1);
        if (!firstPoint.equals(lastPoint)) {
            throw FormattingLog.INSTANCE.invalidGeoPolygonFirstPointNotIdenticalToLastPoint(firstPoint, lastPoint);
        }
        this.points = CollectionHelper.toImmutableList(new ArrayList<>(points));
    }

    @Override
    public List<GeoPoint> points() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
