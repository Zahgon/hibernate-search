/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.validation.impl;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.DynamicTemplate;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.NamedDynamicTemplate;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.PropertyMapping;
import org.hibernate.search.backend.elasticsearch.reporting.impl.ElasticsearchValidationMessages;

public class NamedDynamicTemplateListValidator implements Validator<List<NamedDynamicTemplate>> {

    private final DynamicTemplateValidator dynamicTemplateValidator;

    public NamedDynamicTemplateListValidator(Validator<PropertyMapping> propertyMappingValidator) {
        this.dynamicTemplateValidator = new DynamicTemplateValidator(propertyMappingValidator);
    }

    @Override
    public void validate(ValidationErrorCollector errorCollector, List<NamedDynamicTemplate> expected, List<NamedDynamicTemplate> actual) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Map<String, DynamicTemplate> toMapReportingDuplicates(ValidationErrorCollector errorCollector, List<NamedDynamicTemplate> list) {
        Map<String, DynamicTemplate> result = new LinkedHashMap<>();
        for (NamedDynamicTemplate template : list) {
            DynamicTemplate previous = result.putIfAbsent(template.getName(), template.getTemplate());
            if (previous != null) {
                errorCollector.push(ValidationContextType.DYNAMIC_TEMPLATE, template.getName());
                try {
                    errorCollector.addError(ElasticsearchValidationMessages.INSTANCE.dynamicTemplateDuplicate());
                } finally {
                    errorCollector.pop();
                }
            }
        }
        return result;
    }
}
