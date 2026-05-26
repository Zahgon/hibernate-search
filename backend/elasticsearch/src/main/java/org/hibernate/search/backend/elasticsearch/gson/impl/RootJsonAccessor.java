/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.gson.impl;

import java.util.Optional;
import java.util.function.Supplier;
import org.hibernate.search.util.common.AssertionFailure;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

class RootJsonAccessor implements JsonCompositeAccessor<JsonElement> {

    // Wrap the instance in a JsonObjectAccessor, because we know the root is an object
    static final JsonObjectAccessor INSTANCE = new JsonObjectAccessorImpl(new RootJsonAccessor());

    private RootJsonAccessor() {
        // Private, use INSTANCE instead.
    }

    @Override
    public Optional<JsonElement> get(JsonObject root) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private JsonObject requireRoot(JsonObject root) {
        if (root == null) {
            throw new AssertionFailure("A null root was encountered");
        } else {
            return root;
        }
    }

    @Override
    public void set(JsonObject root, JsonElement value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonObject getOrCreate(JsonObject root, Supplier<? extends JsonElement> newValueSupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonObject getOrCreate(JsonObject root) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
