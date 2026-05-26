/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.validation.impl;

import java.util.Objects;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.analysis.impl.NormalizerDefinition;
import org.hibernate.search.backend.elasticsearch.reporting.impl.ElasticsearchValidationMessages;

class NormalizerDefinitionValidator extends AnalysisDefinitionValidator<NormalizerDefinition> {

    NormalizerDefinitionValidator() {
        super(new AnalysisParameterEquivalenceRegistry.Builder().build());
    }

    @Override
    public void validate(ValidationErrorCollector errorCollector, NormalizerDefinition expectedDefinition, NormalizerDefinition actualDefinition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected String getDefaultType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
