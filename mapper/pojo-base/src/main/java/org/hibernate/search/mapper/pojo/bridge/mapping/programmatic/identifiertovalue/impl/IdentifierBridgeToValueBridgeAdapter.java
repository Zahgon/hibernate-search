/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.identifiertovalue.impl;

import org.hibernate.search.mapper.pojo.bridge.IdentifierBridge;
import org.hibernate.search.mapper.pojo.bridge.ValueBridge;
import org.hibernate.search.mapper.pojo.bridge.runtime.ValueBridgeFromIndexedValueContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.ValueBridgeToIndexedValueContext;

final class IdentifierBridgeToValueBridgeAdapter<I> implements ValueBridge<I, String> {

    private final IdentifierBridge<I> delegate;

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IdentifierBridgeToValueBridgeAdapter(IdentifierBridge<I> delegate) {
        this.delegate = delegate;
    }

    @Override
    public String toIndexedValue(I value, ValueBridgeToIndexedValueContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public I fromIndexedValue(String value, ValueBridgeFromIndexedValueContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleWith(ValueBridge<?, ?> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
