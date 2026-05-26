/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.validation.impl;

import org.hibernate.search.backend.elasticsearch.reporting.impl.ElasticsearchValidationMessages;
import com.google.gson.JsonElement;

class JsonElementValidator implements Validator<JsonElement> {

    private final JsonElementEquivalenceProvider equivalenceProvider;

    JsonElementValidator(JsonElementEquivalence equivalence) {
        this(ignored -> equivalence);
    }

    JsonElementValidator(JsonElementEquivalenceProvider equivalenceProvider) {
        this.equivalenceProvider = equivalenceProvider;
    }

    @Override
    public void validate(ValidationErrorCollector theErrorCollector, JsonElement expected, JsonElement actual) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public interface JsonElementEquivalenceProvider {

        JsonElementEquivalence get(String elementName);
    }
}
