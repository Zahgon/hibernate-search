/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.runtime.impl;

import org.hibernate.search.engine.backend.types.converter.FromDocumentValueConverter;
import org.hibernate.search.engine.backend.types.converter.ToDocumentValueConverter;
import org.hibernate.search.engine.backend.types.converter.runtime.FromDocumentValueConvertContext;
import org.hibernate.search.engine.backend.types.converter.runtime.ToDocumentValueConvertContext;
import org.hibernate.search.mapper.pojo.bridge.IdentifierBridge;

public final class PojoIdentifierBridgeDocumentValueConverter<I> implements ToDocumentValueConverter<I, String>, FromDocumentValueConverter<String, I> {

    private final IdentifierBridge<I> bridge;

    public PojoIdentifierBridgeDocumentValueConverter(IdentifierBridge<I> bridge) {
        this.bridge = bridge;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toDocumentValue(I value, ToDocumentValueConvertContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public I fromDocumentValue(String value, FromDocumentValueConvertContext context) {
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
}
