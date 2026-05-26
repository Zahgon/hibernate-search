/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.validation.impl;

import java.util.Objects;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.analysis.impl.AnalysisDefinition;
import org.hibernate.search.backend.elasticsearch.reporting.impl.ElasticsearchValidationMessages;
import com.google.gson.JsonElement;

class AnalysisDefinitionValidator<T extends AnalysisDefinition> implements Validator<T> {

    private final AnalysisParameterEquivalenceRegistry equivalences;

    AnalysisDefinitionValidator(AnalysisParameterEquivalenceRegistry equivalences) {
        this.equivalences = equivalences;
    }

    @Override
    public void validate(ValidationErrorCollector errorCollector, T expectedDefinition, T actualDefinition) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected String getDefaultType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
