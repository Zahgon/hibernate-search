/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.impl;

import org.hibernate.search.mapper.pojo.bridge.runtime.ValueBridgeFromIndexedValueContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.ValueBridgeToIndexedValueContext;

/**
 * An abstract base for default bridges that format the property value to a string.
 *
 * @param <V> The type of values on the POJO side of the bridge.
 */
abstract class AbstractStringBasedDefaultBridge<V> extends AbstractSimpleDefaultBridge<V, String> {

    @Override
    public final String toIndexedValue(V value, ValueBridgeToIndexedValueContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final V fromIndexedValue(String value, ValueBridgeFromIndexedValueContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String parse(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
