/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.identity.impl;

import java.util.function.Supplier;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.mapper.pojo.bridge.IdentifierBridge;
import org.hibernate.search.mapper.pojo.bridge.runtime.spi.BridgeMappingContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.spi.BridgeSessionContext;
import org.hibernate.search.mapper.pojo.logging.impl.IndexingLog;
import org.hibernate.search.util.common.impl.Closer;

public final class ProvidedIdentifierMapping implements IdentifierMappingImplementor<Object, Object> {

    private final BeanHolder<? extends IdentifierBridge<Object>> bridgeHolder;

    // This class is bivariant in E
    @SuppressWarnings("unchecked")
    public static <E> IdentifierMappingImplementor<Object, E> get(BeanHolder<? extends IdentifierBridge<Object>> bridgeHolder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private ProvidedIdentifierMapping(BeanHolder<? extends IdentifierBridge<Object>> bridgeHolder) {
        this.bridgeHolder = bridgeHolder;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object getIdentifier(Object providedId, Supplier<?> entityProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object getIdentifierOrNull(Object entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toDocumentIdentifier(Object identifier, BridgeMappingContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object fromDocumentIdentifier(String documentId, BridgeSessionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
