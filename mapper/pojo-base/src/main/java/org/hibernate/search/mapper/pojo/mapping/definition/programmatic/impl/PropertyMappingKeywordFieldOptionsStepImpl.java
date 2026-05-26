/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.programmatic.impl;

import org.hibernate.search.engine.backend.types.Norms;
import org.hibernate.search.mapper.pojo.bridge.binding.spi.FieldModelContributorContext;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingKeywordFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;

class PropertyMappingKeywordFieldOptionsStepImpl extends AbstractPropertyMappingNonFullTextStandardFieldOptionsStep<PropertyMappingKeywordFieldOptionsStep> implements PropertyMappingKeywordFieldOptionsStep {

    PropertyMappingKeywordFieldOptionsStepImpl(PropertyMappingStep parent, String relativeFieldName) {
        super(parent, relativeFieldName, FieldModelContributorContext::stringTypeOptionsStep);
    }

    @Override
    PropertyMappingKeywordFieldOptionsStep thisAsS() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingKeywordFieldOptionsStep normalizer(String normalizerName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingKeywordFieldOptionsStep norms(Norms norms) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
