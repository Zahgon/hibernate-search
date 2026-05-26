/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.validation.impl;

import java.util.List;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.NamedDynamicTemplate;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.PropertyMapping;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.RootTypeMapping;
import org.hibernate.search.backend.elasticsearch.reporting.impl.ElasticsearchValidationMessages;

public class RootTypeMappingValidator extends AbstractTypeMappingValidator<RootTypeMapping> {

    private final Validator<List<NamedDynamicTemplate>> dynamicTemplatesValidator;

    private final Validator<PropertyMapping> propertyMappingValidator;

    public RootTypeMappingValidator(ElasticsearchPropertyMappingValidatorProvider propertyMappingValidatorProvider) {
        this.propertyMappingValidator = propertyMappingValidatorProvider.create();
        this.dynamicTemplatesValidator = new NamedDynamicTemplateListValidator(this.propertyMappingValidator);
    }

    @Override
    public void validate(ValidationErrorCollector errorCollector, RootTypeMapping expectedMapping, RootTypeMapping actualMapping) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Validator<PropertyMapping> getPropertyMappingValidator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
