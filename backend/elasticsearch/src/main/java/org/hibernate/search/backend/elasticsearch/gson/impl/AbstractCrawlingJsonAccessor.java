/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.gson.impl;

import java.util.Optional;
import java.util.function.Supplier;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * A {@link JsonAccessor} whose purpose is to get access to a new node
 * in the data structure (object property, array element, ...).
 */
abstract class AbstractCrawlingJsonAccessor<P extends JsonElement> extends AbstractNonRootJsonAccessor<P, JsonElement> implements UnknownTypeJsonAccessor {

    public AbstractCrawlingJsonAccessor(JsonCompositeAccessor<P> parentAccessor) {
        super(parentAccessor);
    }

    @Override
    protected JsonCompositeAccessor<P> getParentAccessor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<JsonElement> get(JsonObject root) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract JsonElement doGet(P parent);

    @Override
    public void set(JsonObject root, JsonElement newValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract void doSet(P parent, JsonElement newValue);

    @Override
    public JsonElement getOrCreate(JsonObject root, Supplier<? extends JsonElement> newValueSupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonObjectAccessor asObject() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonArrayAccessor asArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonAccessor<String> asString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonAccessor<Boolean> asBoolean() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonAccessor<Integer> asInteger() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonAccessor<Long> asLong() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonAccessor<Float> asFloat() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonAccessor<Double> asDouble() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public UnknownTypeJsonAccessor element(int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public UnknownTypeJsonAccessor property(String propertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
