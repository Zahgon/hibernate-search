/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.gson.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public final class JsonElementTypes {

    private JsonElementTypes() {
        // Private constructor, do not use.
    }

    public static final JsonElementType<JsonObject> OBJECT = new JsonElementType<JsonObject>() {

        @Override
        protected JsonObject nullUnsafeFromElement(JsonElement element) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected JsonElement nullUnsafeToElement(JsonObject value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected boolean nullUnsafeIsInstance(JsonElement element) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    public static final JsonElementType<JsonArray> ARRAY = new JsonElementType<JsonArray>() {

        @Override
        protected JsonArray nullUnsafeFromElement(JsonElement element) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected JsonElement nullUnsafeToElement(JsonArray value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected boolean nullUnsafeIsInstance(JsonElement element) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    public static final JsonElementType<String> STRING = new JsonElementType<String>() {

        @Override
        protected String nullUnsafeFromElement(JsonElement element) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected JsonElement nullUnsafeToElement(String value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected boolean nullUnsafeIsInstance(JsonElement element) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    public static final JsonElementType<Boolean> BOOLEAN = new JsonElementType<Boolean>() {

        @Override
        protected Boolean nullUnsafeFromElement(JsonElement element) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected JsonElement nullUnsafeToElement(Boolean value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected boolean nullUnsafeIsInstance(JsonElement element) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    private abstract static class JsonNumberType<T extends Number> extends JsonElementType<T> {

        @Override
        protected T nullUnsafeFromElement(JsonElement element) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected abstract T nullUnsafeFromNumber(JsonPrimitive primitive);

        @Override
        protected JsonElement nullUnsafeToElement(T value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected boolean nullUnsafeIsInstance(JsonElement element) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static final JsonElementType<Integer> INTEGER = new JsonNumberType<Integer>() {

        @Override
        protected Integer nullUnsafeFromNumber(JsonPrimitive primitive) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    public static final JsonElementType<Long> LONG = new JsonNumberType<Long>() {

        @Override
        protected Long nullUnsafeFromNumber(JsonPrimitive primitive) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    public static final JsonElementType<Float> FLOAT = new JsonNumberType<Float>() {

        @Override
        protected Float nullUnsafeFromNumber(JsonPrimitive primitive) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    public static final JsonElementType<Double> DOUBLE = new JsonNumberType<Double>() {

        @Override
        protected Double nullUnsafeFromNumber(JsonPrimitive primitive) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    public static final JsonElementType<Byte> BYTE = new JsonNumberType<Byte>() {

        @Override
        protected Byte nullUnsafeFromNumber(JsonPrimitive primitive) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    public static final JsonElementType<Short> SHORT = new JsonNumberType<Short>() {

        @Override
        protected Short nullUnsafeFromNumber(JsonPrimitive primitive) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    public static final JsonElementType<BigDecimal> BIG_DECIMAL = new JsonNumberType<BigDecimal>() {

        @Override
        protected BigDecimal nullUnsafeFromNumber(JsonPrimitive primitive) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    public static final JsonElementType<BigInteger> BIG_INTEGER = new JsonNumberType<BigInteger>() {

        @Override
        protected BigInteger nullUnsafeFromNumber(JsonPrimitive primitive) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected boolean nullUnsafeIsInstance(JsonElement element) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };
}
