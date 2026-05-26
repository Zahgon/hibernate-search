/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.validation.impl;

/**
 * A component used by {@link Validator} implementations
 * to validate leaf values: attributes of a property mapping, parameters of an analyzer definition, ...
 *
 * @param <T> The type of values to validate.
 */
abstract class LeafValidator<T> {

    public final void validate(ValidationErrorCollector errorCollector, ValidationContextType type, String name, T expected, T actual) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /*
	 * Validate that two values are equal, using a given default value when null is encountered on either value.
	 * Useful to take into account the fact that Elasticsearch has default values for attributes.
	 */
    public final void validateWithDefault(ValidationErrorCollector errorCollector, ValidationContextType type, String name, T expected, T actual, T defaultValueForNulls) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /*
	 * Validate that two values are equal, using a given default value when null is encountered on either value.
	 * Useful to take into account the fact that Elasticsearch has default values for attributes.
	 */
    public final void validateWithDefault(ValidationErrorCollector errorCollector, ValidationContextType type, String name, T expected, T actual, T defaultValueForExpectedNull, T defaultValueForActualNull) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract void doValidate(ValidationErrorCollector errorCollector, T defaultedExpected, T defaultedActual, Object actual);
}
