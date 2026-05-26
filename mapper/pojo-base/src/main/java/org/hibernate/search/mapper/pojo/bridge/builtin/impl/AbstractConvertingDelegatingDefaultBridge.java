/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.impl;

import org.hibernate.search.mapper.pojo.bridge.IdentifierBridge;
import org.hibernate.search.mapper.pojo.bridge.ValueBridge;
import org.hibernate.search.mapper.pojo.bridge.runtime.IdentifierBridgeToDocumentIdentifierContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.ValueBridgeFromIndexedValueContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.ValueBridgeToIndexedValueContext;

/**
 * An abstract base for default bridges that convert the property value to an equivalent value in another type,
 * which is supported directly by the backend,
 * and rely on a delegate bridge to implement string-related operations
 * ({@link IdentifierBridge#toDocumentIdentifier(Object, IdentifierBridgeToDocumentIdentifierContext)},
 * {@link ValueBridge#parse(String)}, ...).
 *
 * @param <V> The type of values on the POJO side of the bridge.
 * @param <F> The type of converted values, which is the type of raw index field values, on the index side of the bridge.
 */
abstract class AbstractConvertingDelegatingDefaultBridge<V, F> extends AbstractSimpleDefaultBridge<V, F> {

    private final AbstractPassThroughDefaultBridge<F> delegate;

    protected AbstractConvertingDelegatingDefaultBridge(AbstractPassThroughDefaultBridge<F> delegate) {
        this.delegate = delegate;
    }

    @Override
    public final F toIndexedValue(V value, ValueBridgeToIndexedValueContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final V fromIndexedValue(F value, ValueBridgeFromIndexedValueContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final F parse(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected final String toString(V value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected final V fromString(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract F toConvertedValue(V value);

    protected abstract V fromConvertedValue(F value);
}
