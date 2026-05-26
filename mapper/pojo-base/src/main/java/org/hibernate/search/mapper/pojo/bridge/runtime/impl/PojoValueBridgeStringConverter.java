/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.runtime.impl;

import org.hibernate.search.engine.backend.types.converter.FromDocumentValueConverter;
import org.hibernate.search.engine.backend.types.converter.ToDocumentValueConverter;
import org.hibernate.search.engine.backend.types.converter.runtime.FromDocumentValueConvertContext;
import org.hibernate.search.engine.backend.types.converter.runtime.ToDocumentValueConvertContext;
import org.hibernate.search.mapper.pojo.bridge.ValueBridge;

public final class PojoValueBridgeStringConverter<F> implements ToDocumentValueConverter<String, F>, FromDocumentValueConverter<F, String> {

    private final ValueBridge<?, F> bridge;

    public PojoValueBridgeStringConverter(ValueBridge<?, F> bridge) {
        this.bridge = bridge;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public F toDocumentValue(String value, ToDocumentValueConvertContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String fromDocumentValue(F value, FromDocumentValueConvertContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleWith(ToDocumentValueConverter<?, ?> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
