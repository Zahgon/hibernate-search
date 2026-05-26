/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.validation.impl;

import org.hibernate.search.backend.elasticsearch.lowlevel.index.analysis.impl.CharFilterDefinition;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.analysis.impl.TokenFilterDefinition;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.analysis.impl.TokenizerDefinition;

class AnalysisComponentDefinitionValidators {

    private AnalysisComponentDefinitionValidators() {
    }

    static Validator<CharFilterDefinition> charFilterDefinitionValidator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static Validator<TokenizerDefinition> tokenizerDefinitionValidator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static Validator<TokenFilterDefinition> tokenFilterDefinitionValidator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
