/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.route.impl;

import java.util.Objects;
import org.hibernate.search.mapper.pojo.route.DocumentRoute;
import org.hibernate.search.mapper.pojo.route.DocumentRouteDescriptor;

public class DocumentRouteImpl implements DocumentRoute {

    private String routingKey;

    @Override
    public void routingKey(String routingKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String routingKey() {
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

    public DocumentRouteDescriptor toDescriptor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
