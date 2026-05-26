/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.analysis.model.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.hibernate.search.backend.elasticsearch.analysis.impl.ElasticsearchAnalysisDescriptor;
import org.hibernate.search.backend.elasticsearch.logging.impl.AnalysisLog;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.analysis.impl.AnalyzerDefinition;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.analysis.impl.CharFilterDefinition;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.analysis.impl.NormalizerDefinition;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.analysis.impl.TokenFilterDefinition;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.analysis.impl.TokenizerDefinition;
import org.hibernate.search.engine.backend.analysis.AnalyzerDescriptor;
import org.hibernate.search.engine.backend.analysis.NormalizerDescriptor;
import org.hibernate.search.engine.backend.analysis.spi.AnalysisDescriptorRegistry;

/**
 * A registry of analysis-related definitions for Elasticsearch.
 * <p>
 * This class provides access to the full mapping from names to definitions
 * (see {@link #getAnalyzerDefinitions} for instance).
 */
public final class ElasticsearchAnalysisDefinitionRegistry implements AnalysisDescriptorRegistry {

    private final Map<String, AnalyzerDefinition> analyzerDefinitions;

    private final Map<String, NormalizerDefinition> normalizerDefinitions;

    private final Map<String, TokenizerDefinition> tokenizerDefinitions;

    private final Map<String, TokenFilterDefinition> tokenFilterDefinitions;

    private final Map<String, CharFilterDefinition> charFilterDefinitions;

    public ElasticsearchAnalysisDefinitionRegistry() {
        // Nothing to do: we're creating an empty registry
        analyzerDefinitions = Collections.emptyMap();
        normalizerDefinitions = Collections.emptyMap();
        tokenizerDefinitions = Collections.emptyMap();
        tokenFilterDefinitions = Collections.emptyMap();
        charFilterDefinitions = Collections.emptyMap();
    }

    public ElasticsearchAnalysisDefinitionRegistry(ElasticsearchAnalysisDefinitionContributor contributor) {
        analyzerDefinitions = new TreeMap<>();
        normalizerDefinitions = new TreeMap<>();
        tokenizerDefinitions = new TreeMap<>();
        tokenFilterDefinitions = new TreeMap<>();
        charFilterDefinitions = new TreeMap<>();
        contributor.contribute(new ElasticsearchAnalysisDefinitionCollector() {

            @Override
            public void collect(String name, AnalyzerDefinition definition) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public void collect(String name, NormalizerDefinition definition) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public void collect(String name, TokenizerDefinition definition) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public void collect(String name, TokenFilterDefinition definition) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public void collect(String name, CharFilterDefinition definition) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        });
    }

    public Map<String, AnalyzerDefinition> getAnalyzerDefinitions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, NormalizerDefinition> getNormalizerDefinitions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, TokenizerDefinition> getTokenizerDefinitions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, TokenFilterDefinition> getTokenFilterDefinitions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, CharFilterDefinition> getCharFilterDefinitions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<? extends AnalyzerDescriptor> analyzerDescriptor(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
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
