/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.validation.impl;

import java.util.Objects;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.analysis.impl.AnalyzerDefinition;
import org.hibernate.search.backend.elasticsearch.reporting.impl.ElasticsearchValidationMessages;

class AnalyzerDefinitionValidator extends AnalysisDefinitionValidator<AnalyzerDefinition> {

    AnalyzerDefinitionValidator() {
        super(new AnalysisParameterEquivalenceRegistry.Builder().type("keep_types").param("types").unorderedArray().end().build());
    }

    @Override
    public void validate(ValidationErrorCollector errorCollector, AnalyzerDefinition expectedDefinition, AnalyzerDefinition actualDefinition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected String getDefaultType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
