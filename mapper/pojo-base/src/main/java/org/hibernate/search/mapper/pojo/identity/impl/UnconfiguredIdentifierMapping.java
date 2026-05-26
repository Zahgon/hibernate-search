/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.identity.impl;

import java.util.function.Supplier;
import org.hibernate.search.mapper.pojo.bridge.runtime.spi.BridgeMappingContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.spi.BridgeSessionContext;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;

public final class UnconfiguredIdentifierMapping<E> implements IdentifierMappingImplementor<Object, E> {

    private final PojoRawTypeIdentifier<E> typeIdentifier;

    public UnconfiguredIdentifierMapping(PojoRawTypeIdentifier<E> typeIdentifier) {
        this.typeIdentifier = typeIdentifier;
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
    public Object getIdentifier(Object providedId, Supplier<? extends E> entitySupplierOrNull) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object getIdentifierOrNull(E entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toDocumentIdentifier(Object identifier, BridgeMappingContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object fromDocumentIdentifier(String documentId, BridgeSessionContext sessionContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
