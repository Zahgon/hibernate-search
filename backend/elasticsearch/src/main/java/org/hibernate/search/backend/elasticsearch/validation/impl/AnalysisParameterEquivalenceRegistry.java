/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.validation.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores the knowledge of how to compare values for a given parameter
 * for a given analysis type (analyzer type, char filter type, etc.).
 */
class AnalysisParameterEquivalenceRegistry {

    private static final JsonElementEquivalence DEFAULT_ELEMENT_EQUIVALENCE = new JsonElementEquivalence();

    // Nested arrays are not considered unordered.
    private static final JsonElementEquivalence UNORDERED_ARRAY_EQUIVALENCE = new JsonElementUnorderedArrayEquivalence(DEFAULT_ELEMENT_EQUIVALENCE);

    private final Map<String, Map<String, JsonElementEquivalence>> equivalences;

    private AnalysisParameterEquivalenceRegistry(Map<String, Map<String, JsonElementEquivalence>> equivalences) {
        super();
        this.equivalences = equivalences;
    }

    public JsonElementEquivalence get(String type, String parameter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder {

        private final Map<String, Map<String, JsonElementEquivalence>> equivalences = new HashMap<>();

        public TypeBuilder type(String name) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public AnalysisParameterEquivalenceRegistry build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class TypeBuilder {

        private final Builder parent;

        private final Map<String, JsonElementEquivalence> equivalences;

        private TypeBuilder(Builder parent, Map<String, JsonElementEquivalence> equivalences) {
            super();
            this.parent = parent;
            this.equivalences = equivalences;
        }

        public ParameterBuilder param(String name) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void add(String parameterName, JsonElementEquivalence equivalence) {
            equivalences.put(parameterName, equivalence);
        }

        public Builder end() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class ParameterBuilder {

        private final TypeBuilder parent;

        private final String parameterName;

        private ParameterBuilder(TypeBuilder parent, String parameterName) {
            super();
            this.parent = parent;
            this.parameterName = parameterName;
        }

        public TypeBuilder unorderedArray() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
