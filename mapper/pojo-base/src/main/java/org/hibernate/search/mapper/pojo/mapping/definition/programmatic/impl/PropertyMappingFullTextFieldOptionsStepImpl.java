/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.programmatic.impl;

import java.util.Collection;
import org.hibernate.search.engine.backend.analysis.AnalyzerNames;
import org.hibernate.search.engine.backend.types.Highlightable;
import org.hibernate.search.engine.backend.types.Norms;
import org.hibernate.search.engine.backend.types.TermVector;
import org.hibernate.search.mapper.pojo.bridge.binding.spi.FieldModelContributorContext;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoIndexMappingCollectorPropertyNode;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingFullTextFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;

class PropertyMappingFullTextFieldOptionsStepImpl extends AbstractPropertyMappingStandardFieldOptionsStep<PropertyMappingFullTextFieldOptionsStep> implements PropertyMappingFullTextFieldOptionsStep {

    PropertyMappingFullTextFieldOptionsStepImpl(PropertyMappingStep parent, String relativeFieldName) {
        super(parent, relativeFieldName, FieldModelContributorContext::stringTypeOptionsStep);
    }

    private boolean contributeDefaultAnalyzer = true;

    @Override
    PropertyMappingFullTextFieldOptionsStep thisAsS() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingFullTextFieldOptionsStep analyzer(String analyzerName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingFullTextFieldOptionsStep searchAnalyzer(String searchAnalyzerName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingFullTextFieldOptionsStep norms(Norms norms) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingFullTextFieldOptionsStep termVector(TermVector termVector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PropertyMappingFullTextFieldOptionsStep highlightable(Collection<Highlightable> highlightable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void contributeIndexMapping(PojoIndexMappingCollectorPropertyNode collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
