/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.gson.impl;

import org.hibernate.search.util.common.AssertionFailure;
import com.google.gson.JsonElement;

public abstract class JsonElementType<T> {

    JsonElementType() {
        // Not allowed
    }

    public final T fromElement(JsonElement element) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract T nullUnsafeFromElement(JsonElement element);

    public final JsonElement toElement(T value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract JsonElement nullUnsafeToElement(T element);

    public final boolean isInstance(JsonElement element) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract boolean nullUnsafeIsInstance(JsonElement element);
}
