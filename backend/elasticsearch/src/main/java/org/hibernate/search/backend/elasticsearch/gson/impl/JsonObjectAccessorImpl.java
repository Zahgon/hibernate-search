/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.gson.impl;

import org.hibernate.search.util.common.impl.Contracts;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * A {@link JsonAccessor} that ensures the accessed object is a {@link JsonObject}.
 */
public class JsonObjectAccessorImpl extends AbstractTypingJsonAccessor<JsonObject> implements JsonObjectAccessor, JsonCompositeAccessor<JsonObject> {

    public JsonObjectAccessorImpl(JsonAccessor<JsonElement> parent) {
        super(parent);
    }

    @Override
    protected JsonElementType<JsonObject> getExpectedElementType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonObject getOrCreate(JsonObject root) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public UnknownTypeJsonAccessor property(String propertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
