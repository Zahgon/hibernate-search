/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.projection.impl;

import java.util.Objects;
import org.hibernate.search.engine.spatial.GeoPoint;

public class DistanceSortKey {

    private final String absoluteFieldPath;

    private final GeoPoint location;

    public DistanceSortKey(String absoluteFieldPath, GeoPoint location) {
        this.absoluteFieldPath = absoluteFieldPath;
        this.location = location;
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
