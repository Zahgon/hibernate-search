/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.analysis.model.dsl.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import org.hibernate.search.backend.lucene.analysis.model.dsl.LuceneAnalysisComponentParametersStep;
import org.hibernate.search.backend.lucene.analysis.model.dsl.LuceneAnalysisOptionalComponentsStep;
import org.hibernate.search.backend.lucene.logging.impl.AnalysisLog;
import org.apache.lucene.analysis.CharFilterFactory;
import org.apache.lucene.analysis.TokenFilterFactory;

abstract class AbstractLuceneAnalysisComponentParametersStep<T> implements LuceneAnalysisComponentParametersStep, LuceneAnalysisComponentBuilder<T> {

    private final LuceneAnalysisOptionalComponentsStep parentStep;

    final Map<String, String> params = new LinkedHashMap<>();

    AbstractLuceneAnalysisComponentParametersStep(LuceneAnalysisOptionalComponentsStep parentStep) {
        this.parentStep = parentStep;
    }

    @Override
    public LuceneAnalysisComponentParametersStep param(String name, String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneAnalysisComponentParametersStep charFilter(String factoryName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneAnalysisComponentParametersStep charFilter(Class<? extends CharFilterFactory> factoryType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneAnalysisComponentParametersStep tokenFilter(String factoryName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneAnalysisComponentParametersStep tokenFilter(Class<? extends TokenFilterFactory> factoryType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
