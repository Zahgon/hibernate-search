/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.analysis.model.dsl.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.search.backend.elasticsearch.analysis.ElasticsearchAnalysisConfigurationContext;
import org.hibernate.search.backend.elasticsearch.analysis.model.dsl.ElasticsearchAnalysisComponentParametersStep;
import org.hibernate.search.backend.elasticsearch.analysis.model.dsl.ElasticsearchAnalysisComponentTypeStep;
import org.hibernate.search.backend.elasticsearch.analysis.model.dsl.ElasticsearchAnalyzerTokenizerStep;
import org.hibernate.search.backend.elasticsearch.analysis.model.dsl.ElasticsearchAnalyzerTypeStep;
import org.hibernate.search.backend.elasticsearch.analysis.model.dsl.ElasticsearchNormalizerTypeStep;
import org.hibernate.search.backend.elasticsearch.analysis.model.impl.ElasticsearchAnalysisDefinitionCollector;
import org.hibernate.search.backend.elasticsearch.analysis.model.impl.ElasticsearchAnalysisDefinitionContributor;

public class ElasticsearchAnalysisConfigurationContextImpl implements ElasticsearchAnalysisConfigurationContext, ElasticsearchAnalysisDefinitionContributor {

    private final List<ElasticsearchAnalysisDefinitionContributor> children = new ArrayList<>();

    @Override
    public ElasticsearchAnalyzerTypeStep analyzer(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchNormalizerTypeStep normalizer(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchAnalysisComponentTypeStep tokenizer(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchAnalysisComponentTypeStep charFilter(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchAnalysisComponentTypeStep tokenFilter(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void contribute(ElasticsearchAnalysisDefinitionCollector collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
