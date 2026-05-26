/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.route;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import org.hibernate.search.util.common.impl.Contracts;

public final class DocumentRoutesDescriptor implements Serializable {

    public static DocumentRoutesDescriptor of(DocumentRouteDescriptor currentRoute) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static DocumentRoutesDescriptor of(DocumentRouteDescriptor currentRoute, Collection<DocumentRouteDescriptor> previousRoutes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A util to convert the legacy representation of a route (a single string) to a {@link DocumentRoutesDescriptor}.
     * <p>
     * It will assume no routes are given if {@code providedRoutingKey} is {@code null},
     * so it's not possible to represent the default route using this util.
     *
     * @param providedRoutingKey The provided routing key, or {@code null}.
     * @return The corresponding routes, or {@code null}.
     */
    public static DocumentRoutesDescriptor fromLegacyRoutingKey(String providedRoutingKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final DocumentRouteDescriptor currentRoute;

    private final Collection<DocumentRouteDescriptor> previousRoutes;

    public DocumentRoutesDescriptor(DocumentRouteDescriptor currentRoute, Collection<DocumentRouteDescriptor> previousRoutes) {
        this.currentRoute = currentRoute;
        Contracts.assertNotNull(previousRoutes, "previousRoutes");
        Contracts.assertNoNullElement(previousRoutes, "previousRoutes");
        this.previousRoutes = previousRoutes;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public DocumentRouteDescriptor currentRoute() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Collection<DocumentRouteDescriptor> previousRoutes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
