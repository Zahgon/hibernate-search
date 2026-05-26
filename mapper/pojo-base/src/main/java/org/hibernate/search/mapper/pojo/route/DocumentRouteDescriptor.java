/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.route;

import java.io.Serializable;
import java.util.Objects;

public final class DocumentRouteDescriptor implements Serializable {

    public static DocumentRouteDescriptor of(String routingKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final String routingKey;

    private DocumentRouteDescriptor(String routingKey) {
        this.routingKey = routingKey;
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
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String routingKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
