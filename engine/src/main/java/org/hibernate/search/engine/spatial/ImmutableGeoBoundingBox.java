/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.spatial;

import java.util.Objects;
import org.hibernate.search.util.common.impl.Contracts;

final class ImmutableGeoBoundingBox implements GeoBoundingBox {

    private final GeoPoint topLeft;

    private final GeoPoint bottomRight;

    ImmutableGeoBoundingBox(GeoPoint topLeft, GeoPoint bottomRight) {
        Contracts.assertNotNull(topLeft, "topLeft");
        Contracts.assertNotNull(bottomRight, "bottomRight");
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    @Override
    public GeoPoint topLeft() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public GeoPoint bottomRight() {
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
