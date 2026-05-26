/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.session.spi;

import org.hibernate.search.mapper.pojo.bridge.runtime.IdentifierBridgeFromDocumentIdentifierContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.PropertyBridgeWriteContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.RoutingBridgeRouteContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.TypeBridgeWriteContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.ValueBridgeFromIndexedValueContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.impl.SessionBasedBridgeOperationContext;
import org.hibernate.search.mapper.pojo.scope.spi.PojoScopeSessionContext;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexer;
import org.hibernate.search.mapper.pojo.work.spi.PojoWorkSessionContext;

public abstract class AbstractPojoSearchSession implements PojoWorkSessionContext, PojoScopeSessionContext {

    private final PojoSearchSessionMappingContext mappingContext;

    private final SessionBasedBridgeOperationContext sessionBasedBridgeOperationContext;

    protected AbstractPojoSearchSession(PojoSearchSessionMappingContext mappingContext) {
        this.mappingContext = mappingContext;
        this.sessionBasedBridgeOperationContext = new SessionBasedBridgeOperationContext(this);
    }

    @Override
    public PojoSearchSessionMappingContext mappingContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final IdentifierBridgeFromDocumentIdentifierContext identifierBridgeFromDocumentIdentifierContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RoutingBridgeRouteContext routingBridgeRouteContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final TypeBridgeWriteContext typeBridgeWriteContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final PropertyBridgeWriteContext propertyBridgeWriteContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final ValueBridgeFromIndexedValueContext valueBridgeFromIndexedValueContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected PojoIndexer createIndexer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
