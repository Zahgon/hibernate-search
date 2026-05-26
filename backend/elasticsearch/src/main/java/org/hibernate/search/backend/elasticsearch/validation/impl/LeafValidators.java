/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.validation.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.DataTypes;
import org.hibernate.search.backend.elasticsearch.reporting.impl.ElasticsearchValidationMessages;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public final class LeafValidators {

    private LeafValidators() {
    }

    private static final double DEFAULT_DOUBLE_DELTA = 0.001;

    private static final float DEFAULT_FLOAT_DELTA = 0.001f;

    public static final LeafValidator<Object> EQUAL = new LeafValidator<Object>() {

        @Override
        protected void doValidate(ValidationErrorCollector errorCollector, Object defaultedExpected, Object defaultedActual, Object actual) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    public static final LeafValidator<Double> EQUAL_DOUBLE = new LeafValidator<Double>() {

        @Override
        protected void doValidate(ValidationErrorCollector errorCollector, Double defaultedExpected, Double defaultedActual, Object actual) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    public static final LeafValidator<Float> EQUAL_FLOAT = new LeafValidator<Float>() {

        @Override
        protected void doValidate(ValidationErrorCollector errorCollector, Float defaultedExpected, Float defaultedActual, Object actual) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    /*
	 * Special validation for an Elasticsearch format:
	 * - Checks that the first element (the format used for output format in ES) is equal
	 * - Checks all expected formats are present in the actual value
	 */
    public static final LeafValidator<List<String>> FORMAT = new LeafValidator<List<String>>() {

        @Override
        protected void doValidate(ValidationErrorCollector errorCollector, List<String> defaultedExpected, List<String> defaultedActual, Object actual) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    public static LeafValidator<? super JsonElement> jsonElement(String type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final LeafValidator<JsonElement> JSON_ELEMENT_AS_DOUBLE_LEAF_VALIDATOR = new LeafValidator<JsonElement>() {

        @Override
        protected void doValidate(ValidationErrorCollector errorCollector, JsonElement defaultedExpected, JsonElement defaultedActual, Object actual) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    private static final LeafValidator<JsonElement> JSON_ELEMENT_AS_FLOAT_LEAF_VALIDATOR = new LeafValidator<JsonElement>() {

        @Override
        protected void doValidate(ValidationErrorCollector errorCollector, JsonElement defaultedExpected, JsonElement defaultedActual, Object actual) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    private static boolean areNumbers(JsonElement expectedValue, JsonElement actualValue) {
        if (!(expectedValue instanceof JsonPrimitive && actualValue instanceof JsonPrimitive)) {
            return false;
        }
        return ((JsonPrimitive) expectedValue).isNumber() && ((JsonPrimitive) actualValue).isNumber();
    }
}
