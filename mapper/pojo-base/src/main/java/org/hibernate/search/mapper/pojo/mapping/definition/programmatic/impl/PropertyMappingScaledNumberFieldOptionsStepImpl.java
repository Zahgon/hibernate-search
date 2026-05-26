/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.programmatic.impl;

import org.hibernate.search.mapper.pojo.bridge.binding.spi.FieldModelContributorContext;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingScaledNumberFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;

class PropertyMappingScaledNumberFieldOptionsStepImpl extends AbstractPropertyMappingNonFullTextStandardFieldOptionsStep<PropertyMappingScaledNumberFieldOptionsStep> implements PropertyMappingScaledNumberFieldOptionsStep {

    PropertyMappingScaledNumberFieldOptionsStepImpl(PropertyMappingStep parent, String relativeFieldName) {
        super(parent, relativeFieldName, FieldModelContributorContext::scaledNumberTypeOptionsStep);
    }

    @Override
    PropertyMappingScaledNumberFieldOptionsStep thisAsS() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingScaledNumberFieldOptionsStep decimalScale(int decimalScale) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
