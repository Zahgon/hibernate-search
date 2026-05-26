/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.gson.impl;

import java.util.Optional;
import java.util.function.Supplier;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * A {@link JsonAccessor} whose purpose is to check type information
 * on the node being accessed.
 * <p>
 * The node being accessed is provided by the "parent" accessor.
 */
abstract class AbstractTypingJsonAccessor<T> extends AbstractNonRootJsonAccessor<JsonElement, T> {

    public AbstractTypingJsonAccessor(JsonAccessor<JsonElement> parentAccessor) {
        super(parentAccessor);
    }

    @Override
    public Optional<T> get(JsonObject root) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void set(JsonObject root, T newValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T getOrCreate(JsonObject root, Supplier<? extends T> newValueSupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private T fromElement(JsonElement parent) {
        JsonElementType<T> expectedType = getExpectedElementType();
        if (parent == null || parent.isJsonNull()) {
            return null;
        } else if (!expectedType.isInstance(parent)) {
            if (JsonElementTypes.ARRAY.isInstance(parent)) {
                // Unexpected multi-valued item
                JsonArray parentAsArray = JsonElementTypes.ARRAY.fromElement(parent);
                // Let it go if there's zero or one item
                int parentSize = parentAsArray.size();
                if (parentSize == 0) {
                    return null;
                } else if (parentSize == 1) {
                    return fromElement(parentAsArray.get(0));
                }
            }
            throw new UnexpectedJsonElementTypeException(this, expectedType, parent);
        } else {
            return expectedType.fromElement(parent);
        }
    }

    protected JsonElement toElement(T value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract JsonElementType<T> getExpectedElementType();

    @Override
    protected void appendRuntimeRelativePath(StringBuilder path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void appendStaticRelativePath(StringBuilder path, boolean first) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
