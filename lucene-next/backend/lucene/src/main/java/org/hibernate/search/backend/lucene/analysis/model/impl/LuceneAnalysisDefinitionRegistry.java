/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.analysis.model.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import org.hibernate.search.backend.lucene.analysis.impl.LuceneAnalysisDescriptor;
import org.hibernate.search.engine.backend.analysis.AnalyzerDescriptor;
import org.hibernate.search.engine.backend.analysis.NormalizerDescriptor;
import org.hibernate.search.engine.backend.analysis.spi.AnalysisDescriptorRegistry;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.search.similarities.BM25Similarity;
import org.apache.lucene.search.similarities.Similarity;

/**
 * A registry of analysis-related definitions for Lucene.
 */
public final class LuceneAnalysisDefinitionRegistry implements AnalysisDescriptorRegistry {

    private final Similarity similarity;

    private final Map<String, LuceneAnalysisDescriptor> analyzerDescriptors;

    private final Map<String, LuceneAnalysisDescriptor> normalizerDefinitions;

    public LuceneAnalysisDefinitionRegistry(LuceneAnalysisDefinitionContributor contributor) {
        similarity = contributor.getSimilarity().orElseGet(LuceneAnalysisDefinitionRegistry::createDefaultSimilarity);
        analyzerDescriptors = new TreeMap<>();
        normalizerDefinitions = new TreeMap<>();
        contributor.contribute(new LuceneAnalysisDefinitionCollector() {

            @Override
            public void collectAnalyzer(String name, Analyzer analyzer) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public void collectNormalizer(String name, Analyzer normalizer) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        });
    }

    public Similarity getSimilarity() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param name An analyzer name
     * @return The analyzer definition associated with the given name,
     * or {@code null} if there isn't any.
     */
    public Analyzer getAnalyzerDefinition(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<? extends AnalyzerDescriptor> analyzerDescriptor(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param name A normalizer name
     * @return The normalizer definition associated with the given name,
     * or {@code null} if there isn't any.
     */
    public Analyzer getNormalizerDefinition(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static Similarity createDefaultSimilarity() {
        return new BM25Similarity();
    }

    @Override
    public Collection<? extends AnalyzerDescriptor> analyzerDescriptors() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<? extends NormalizerDescriptor> normalizerDescriptor(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Collection<? extends NormalizerDescriptor> normalizerDescriptors() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
