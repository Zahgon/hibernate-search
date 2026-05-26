/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.validation.impl;

import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.DynamicTemplate;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.PropertyMapping;
import org.hibernate.search.backend.elasticsearch.reporting.impl.ElasticsearchValidationMessages;
import com.google.gson.JsonElement;

class DynamicTemplateValidator implements Validator<DynamicTemplate> {

    private final Validator<JsonElement> extraAttributeValidator = new JsonElementValidator(new JsonElementEquivalence());

    private final Validator<PropertyMapping> propertyMappingValidator;

    public DynamicTemplateValidator(Validator<PropertyMapping> propertyMappingValidator) {
        this.propertyMappingValidator = propertyMappingValidator;
    }

    @Override
    public void validate(ValidationErrorCollector errorCollector, DynamicTemplate expected, DynamicTemplate actual) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
