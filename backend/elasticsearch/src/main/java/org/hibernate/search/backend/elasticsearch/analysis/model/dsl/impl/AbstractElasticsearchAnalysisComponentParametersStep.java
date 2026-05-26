/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.analysis.model.dsl.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import org.hibernate.search.backend.elasticsearch.analysis.model.dsl.ElasticsearchAnalysisComponentParametersStep;
import org.hibernate.search.backend.elasticsearch.analysis.model.dsl.ElasticsearchAnalysisComponentTypeStep;
import org.hibernate.search.backend.elasticsearch.analysis.model.impl.ElasticsearchAnalysisDefinitionContributor;
import org.hibernate.search.backend.elasticsearch.logging.impl.AnalysisLog;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.analysis.impl.AnalysisDefinition;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

abstract class AbstractElasticsearchAnalysisComponentParametersStep<D extends AnalysisDefinition> implements ElasticsearchAnalysisComponentParametersStep, ElasticsearchAnalysisComponentTypeStep, ElasticsearchAnalysisDefinitionContributor {

    protected final String name;

    protected final D definition;

    AbstractElasticsearchAnalysisComponentParametersStep(String name, D definition) {
        this.name = name;
        this.definition = definition;
    }

    @Override
    public ElasticsearchAnalysisComponentParametersStep type(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private ElasticsearchAnalysisComponentParametersStep param(String name, JsonElement value) {
        Map<String, JsonElement> parameters = definition.getParameters();
        if (parameters == null) {
            parameters = new LinkedHashMap<>();
            definition.setParameters(parameters);
        }
        JsonElement previous = parameters.putIfAbsent(name, value);
        if (previous != null) {
            throw AnalysisLog.INSTANCE.analysisComponentParameterConflict(name, previous, value);
        }
        return this;
    }

    @Override
    public ElasticsearchAnalysisComponentParametersStep param(String name, String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchAnalysisComponentParametersStep param(String name, String... values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchAnalysisComponentParametersStep param(String name, boolean value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchAnalysisComponentParametersStep param(String name, boolean... values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchAnalysisComponentParametersStep param(String name, Number value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchAnalysisComponentParametersStep param(String name, Number... values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
