/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.validation.impl;

import java.util.Map;
import java.util.Objects;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * Determines whether two {@link JsonElement}s should be considered equivalent.
 */
class JsonElementEquivalence {

    private final JsonElementEquivalence nestedEquivalence;

    JsonElementEquivalence() {
        // Use the same equivalence for array items and object properties
        this.nestedEquivalence = this;
    }

    JsonElementEquivalence(JsonElementEquivalence itemEquivalence) {
        // Use the given equivalence for array items and object properties
        this.nestedEquivalence = itemEquivalence;
    }

    /**
     * Determines whether two {@link JsonElement}s should be considered equivalent.
     * @param left An element whose equivalence to {@code right} will be tested.
     * @param right An element whose equivalence to {@code left} will be tested.
     * @return {@code true} if {@code left} and {@code right} are equivalent, {@code false} otherwise.
     */
    public boolean isEquivalent(JsonElement left, JsonElement right) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /*
	 * Compares the string representation of primitives.
	 *
	 * This is necessary when validating analysis settings because,
	 * when we retrieve settings from Elasticsearch,
	 * it only returns strings.
	 * The reason is probably that the values are stored as strings.
	 * Thus we must also handle the case where we initially set an integer value but Elasticsearch
	 * shows it as a string.
	 */
    protected boolean isPrimitiveEquivalent(JsonPrimitive left, JsonPrimitive right) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean isArrayEquivalent(JsonArray left, JsonArray right) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean isObjectEquivalent(JsonObject left, JsonObject right) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean isNestedEquivalent(JsonElement left, JsonElement right) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /*
	 * Compare two elements that either aren't of the same type or are both JsonNull.
	 */
    protected boolean isElementEquivalent(JsonElement left, JsonElement right) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
