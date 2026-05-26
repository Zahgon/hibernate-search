/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.identity.impl;

import java.util.function.Supplier;
import org.hibernate.search.mapper.pojo.bridge.runtime.spi.BridgeMappingContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.spi.BridgeSessionContext;
import org.hibernate.search.mapper.pojo.logging.impl.IndexingLog;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.model.spi.PojoCaster;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.util.common.reflect.spi.ValueReadHandle;

public final class UnmappedPropertyIdentifierMapping<I, E> implements IdentifierMappingImplementor<I, E> {

    private final PojoCaster<? super I> caster;

    private final ValueReadHandle<I> property;

    private final PojoRawTypeIdentifier<E> typeIdentifier;

    public UnmappedPropertyIdentifierMapping(PojoRawTypeIdentifier<E> typeIdentifier, PojoCaster<? super I> caster, ValueReadHandle<I> property) {
        this.caster = caster;
        this.property = property;
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
    // We can only cast to the raw type, if I is generic we need an unchecked cast
    @SuppressWarnings("unchecked")
    public I getIdentifier(Object providedId, Supplier<? extends E> entitySupplierOrNull) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public I getIdentifierOrNull(E entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toDocumentIdentifier(Object identifier, BridgeMappingContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public I fromDocumentIdentifier(String documentId, BridgeSessionContext sessionContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
