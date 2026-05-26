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
import org.hibernate.search.backend.lucene.analysis.model.dsl.LuceneAnalyzerOptionalComponentsStep;
import org.hibernate.search.backend.lucene.analysis.model.dsl.LuceneAnalyzerTokenizerStep;
import org.hibernate.search.backend.lucene.logging.impl.AnalysisLog;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharFilterFactory;
import org.apache.lucene.analysis.TokenFilterFactory;
import org.apache.lucene.analysis.TokenizerFactory;

class LuceneAnalyzerComponentsStep implements LuceneAnalyzerTokenizerStep, LuceneAnalyzerOptionalComponentsStep, LuceneAnalyzerBuilder {

    private final String name;

    private final LuceneTokenizerParametersStep tokenizer;

    private final List<LuceneCharFilterParametersStep> charFilters = new ArrayList<>();

    private final List<LuceneTokenFilterParametersStep> tokenFilters = new ArrayList<>();

    LuceneAnalyzerComponentsStep(String name) {
        this.tokenizer = new LuceneTokenizerParametersStep(this);
        this.name = name;
    }

    @Override
    public LuceneAnalyzerOptionalComponentsStep tokenizer(String factoryName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneAnalyzerOptionalComponentsStep tokenizer(Class<? extends TokenizerFactory> factoryType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneAnalyzerOptionalComponentsStep param(String name, String value) {
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

    @Override
    public Analyzer build(LuceneAnalysisComponentFactory factory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
