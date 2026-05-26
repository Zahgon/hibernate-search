/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.validation.impl;

import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.AbstractTypeMapping;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.DynamicType;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.PropertyMapping;
import org.hibernate.search.backend.elasticsearch.reporting.impl.ElasticsearchValidationMessages;
import com.google.gson.JsonElement;

abstract class AbstractTypeMappingValidator<T extends AbstractTypeMapping> implements Validator<T> {

    protected abstract Validator<PropertyMapping> getPropertyMappingValidator();

    private final Validator<JsonElement> extraAttributeValidator = new JsonElementValidator(new JsonElementEquivalence());

    @Override
    public void validate(ValidationErrorCollector errorCollector, T expectedMapping, T actualMapping) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
