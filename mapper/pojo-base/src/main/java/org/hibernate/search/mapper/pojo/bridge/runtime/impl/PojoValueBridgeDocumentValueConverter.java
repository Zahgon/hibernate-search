/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.runtime.impl;

import java.util.Optional;
import org.hibernate.search.engine.backend.mapping.spi.BackendMappingContext;
import org.hibernate.search.engine.backend.session.spi.BackendSessionContext;
import org.hibernate.search.engine.backend.types.converter.FromDocumentValueConverter;
import org.hibernate.search.engine.backend.types.converter.ToDocumentValueConverter;
import org.hibernate.search.engine.backend.types.converter.runtime.FromDocumentValueConvertContext;
import org.hibernate.search.engine.backend.types.converter.runtime.FromDocumentValueConvertContextExtension;
import org.hibernate.search.engine.backend.types.converter.runtime.ToDocumentValueConvertContext;
import org.hibernate.search.engine.backend.types.converter.runtime.ToDocumentValueConvertContextExtension;
import org.hibernate.search.mapper.pojo.bridge.ValueBridge;
import org.hibernate.search.mapper.pojo.bridge.runtime.ValueBridgeFromIndexedValueContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.ValueBridgeToIndexedValueContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.spi.BridgeMappingContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.spi.BridgeSessionContext;

public final class PojoValueBridgeDocumentValueConverter<V, F> implements ToDocumentValueConverter<V, F>, FromDocumentValueConverter<F, V> {

    private final ValueBridge<V, F> bridge;

    public PojoValueBridgeDocumentValueConverter(ValueBridge<V, F> bridge) {
        this.bridge = bridge;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public F toDocumentValue(V value, ToDocumentValueConvertContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public V fromDocumentValue(F value, FromDocumentValueConvertContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleWith(ToDocumentValueConverter<?, ?> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleWith(FromDocumentValueConverter<?, ?> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ValueBridge<V, F> bridge() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final class ContextExtension implements ToDocumentValueConvertContextExtension<ValueBridgeToIndexedValueContext>, FromDocumentValueConvertContextExtension<ValueBridgeFromIndexedValueContext> {

        private static final ContextExtension INSTANCE = new ContextExtension();

        @Override
        public Optional<ValueBridgeToIndexedValueContext> extendOptional(ToDocumentValueConvertContext original, BackendMappingContext mappingContext) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Optional<ValueBridgeFromIndexedValueContext> extendOptional(FromDocumentValueConvertContext original, BackendSessionContext sessionContext) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
