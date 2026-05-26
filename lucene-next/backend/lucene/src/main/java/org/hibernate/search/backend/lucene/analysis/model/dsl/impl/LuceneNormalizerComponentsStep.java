/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.analysis.model.dsl.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.search.backend.lucene.analysis.impl.LuceneAnalysisComponentFactory;
import org.hibernate.search.backend.lucene.analysis.model.dsl.LuceneAnalysisComponentParametersStep;
import org.hibernate.search.backend.lucene.analysis.model.dsl.LuceneNormalizerOptionalComponentsStep;
import org.hibernate.search.backend.lucene.logging.impl.AnalysisLog;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharFilterFactory;
import org.apache.lucene.analysis.TokenFilterFactory;

class LuceneNormalizerComponentsStep implements LuceneNormalizerOptionalComponentsStep, LuceneAnalyzerBuilder {

    private final String name;

    private final List<LuceneCharFilterParametersStep> charFilters = new ArrayList<>();

    private final List<LuceneTokenFilterParametersStep> tokenFilters = new ArrayList<>();

    LuceneNormalizerComponentsStep(String name) {
        this.name = name;
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

    @Override
    public Analyzer build(LuceneAnalysisComponentFactory factory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
