/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.gson.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonArrayAccessorImpl extends AbstractTypingJsonAccessor<JsonArray> implements JsonArrayAccessor, JsonCompositeAccessor<JsonArray> {

    public JsonArrayAccessorImpl(JsonAccessor<JsonElement> parentAccessor) {
        super(parentAccessor);
    }

    @Override
    protected JsonElementType<JsonArray> getExpectedElementType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonArray getOrCreate(JsonObject root) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public UnknownTypeJsonAccessor element(int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addElementIfAbsent(JsonObject root, JsonElement newValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
