/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.validation.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A component responsible for checking that an expected and actual value are identical.
 *
 * @param <T> The type of values to validate.
 */
public interface Validator<T> {

    void validate(ValidationErrorCollector errorCollector, T expected, T actual);

    /*
	 * Validate all elements in a map, ignoring unexpected elements.
	 */
    default void validateAllIgnoreUnexpected(ValidationErrorCollector errorCollector, ValidationContextType type, String messageIfMissing, Map<String, ? extends T> expectedMap, Map<String, ? extends T> actualMap) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /*
	 * Validate all elements in a map, including unexpected elements.
	 */
    default void validateAllIncludingUnexpected(ValidationErrorCollector errorCollector, ValidationContextType type, Map<String, ? extends T> expectedMap, Map<String, ? extends T> actualMap) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
