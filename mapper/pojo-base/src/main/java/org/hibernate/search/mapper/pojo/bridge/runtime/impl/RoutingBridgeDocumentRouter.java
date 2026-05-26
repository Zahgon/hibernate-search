/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.runtime.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.Supplier;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.mapper.pojo.bridge.RoutingBridge;
import org.hibernate.search.mapper.pojo.bridge.runtime.spi.BridgeSessionContext;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.route.DocumentRoute;
import org.hibernate.search.mapper.pojo.route.DocumentRouteDescriptor;
import org.hibernate.search.mapper.pojo.route.DocumentRoutes;
import org.hibernate.search.mapper.pojo.route.DocumentRoutesDescriptor;
import org.hibernate.search.mapper.pojo.route.impl.DocumentRouteImpl;
import org.hibernate.search.util.common.impl.Closer;

public final class RoutingBridgeDocumentRouter<E> implements DocumentRouter<E> {

    private final BeanHolder<? extends RoutingBridge<? super E>> routingBridgeHolder;

    public RoutingBridgeDocumentRouter(BeanHolder<? extends RoutingBridge<? super E>> routingBridgeHolder) {
        this.routingBridgeHolder = routingBridgeHolder;
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DocumentRouteDescriptor currentRoute(Object entityIdentifier, Supplier<? extends E> entitySupplier, DocumentRoutesDescriptor providedRoutes, BridgeSessionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DocumentRoutesDescriptor routes(Object entityIdentifier, Supplier<? extends E> entitySupplier, DocumentRoutesDescriptor providedRoutes, BridgeSessionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final class CurrentDocumentRoutes implements DocumentRoutes {

        private DocumentRouteImpl currentRoute = null;

        private boolean skip = false;

        @Override
        // For the eclipse-compiler: complains on bridge not bing closed
        @SuppressWarnings("resource")
        public DocumentRoute addRoute() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void notIndexed() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        // For the eclipse-compiler: complains on bridge not bing closed
        @SuppressWarnings("resource")
        DocumentRouteDescriptor currentRoute(Object entityIdentifier, E entity, BridgeSessionContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private final class PreviousDocumentRoutes implements DocumentRoutes {

        private List<DocumentRouteImpl> previousRoutes = null;

        private boolean skip = false;

        @Override
        public DocumentRoute addRoute() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void notIndexed() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        // For the eclipse-compiler: complains on bridge not bing closed
        @SuppressWarnings("resource")
        Collection<DocumentRouteDescriptor> previousDifferentRoutes(DocumentRouteDescriptor currentRoute, Object entityIdentifier, E entity, DocumentRoutesDescriptor providedRoutes, BridgeSessionContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
