/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.runtime.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;
import org.hibernate.search.mapper.pojo.bridge.runtime.spi.BridgeSessionContext;
import org.hibernate.search.mapper.pojo.route.DocumentRouteDescriptor;
import org.hibernate.search.mapper.pojo.route.DocumentRoutesDescriptor;

public final class NoOpDocumentRouter implements DocumentRouter<Object> {

    public static final NoOpDocumentRouter INSTANCE = new NoOpDocumentRouter();

    private static final DocumentRouteDescriptor DEFAULT_ROUTE = DocumentRouteDescriptor.of(null);

    private static final DocumentRoutesDescriptor DEFAULT_ROUTES = DocumentRoutesDescriptor.of(DEFAULT_ROUTE);

    private NoOpDocumentRouter() {
    }

    @Override
    public DocumentRouteDescriptor currentRoute(Object entityIdentifier, Supplier<?> entitySupplier, DocumentRoutesDescriptor providedRoutes, BridgeSessionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DocumentRoutesDescriptor routes(Object entityIdentifier, Supplier<?> entitySupplier, DocumentRoutesDescriptor providedRoutes, BridgeSessionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
