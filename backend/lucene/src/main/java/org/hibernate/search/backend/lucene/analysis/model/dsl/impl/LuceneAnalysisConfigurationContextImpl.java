/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.analysis.model.dsl.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurationContext;
import org.hibernate.search.backend.lucene.analysis.impl.LuceneAnalysisComponentFactory;
import org.hibernate.search.backend.lucene.analysis.model.dsl.LuceneAnalyzerTokenizerStep;
import org.hibernate.search.backend.lucene.analysis.model.dsl.LuceneAnalyzerTypeStep;
import org.hibernate.search.backend.lucene.analysis.model.dsl.LuceneNormalizerOptionalComponentsStep;
import org.hibernate.search.backend.lucene.analysis.model.dsl.LuceneNormalizerTypeStep;
import org.hibernate.search.backend.lucene.analysis.model.impl.LuceneAnalysisDefinitionCollector;
import org.hibernate.search.backend.lucene.analysis.model.impl.LuceneAnalysisDefinitionContributor;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharFilterFactory;
import org.apache.lucene.analysis.TokenFilterFactory;
import org.apache.lucene.analysis.TokenizerFactory;
import org.apache.lucene.search.similarities.Similarity;

public class LuceneAnalysisConfigurationContextImpl implements LuceneAnalysisConfigurationContext, LuceneAnalysisDefinitionContributor {

    private final LuceneAnalysisComponentFactory factory;

    private Similarity similarity;

    private final Map<String, LuceneAnalyzerBuilder> analyzers = new LinkedHashMap<>();

    private final Map<String, LuceneAnalyzerBuilder> normalizers = new LinkedHashMap<>();

    public LuceneAnalysisConfigurationContextImpl(LuceneAnalysisComponentFactory factory) {
        this.factory = factory;
    }

    @Override
    public LuceneAnalyzerTypeStep analyzer(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneNormalizerTypeStep normalizer(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void similarity(Similarity similarity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<String> availableTokenizers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<String> availableCharFilters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<String> availableTokenFilters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void contribute(LuceneAnalysisDefinitionCollector collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<Similarity> getSimilarity() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void addAnalyzer(String name, LuceneAnalyzerBuilder definition) {
        // Override if existing
        analyzers.put(name, definition);
    }

    private void addNormalizer(String name, LuceneAnalyzerBuilder definition) {
        // Override if existing
        normalizers.putIfAbsent(name, definition);
    }
}
