/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.dsl.impl;

import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.PropertyMapping;
import org.hibernate.search.backend.elasticsearch.types.dsl.ElasticsearchNativeIndexFieldTypeMappingStep;
import org.hibernate.search.backend.elasticsearch.types.dsl.ElasticsearchNativeIndexFieldTypeOptionsStep;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

class ElasticsearchNativeIndexFieldTypeMappingStepImpl implements ElasticsearchNativeIndexFieldTypeMappingStep {

    private final ElasticsearchIndexFieldTypeBuildContext buildContext;

    ElasticsearchNativeIndexFieldTypeMappingStepImpl(ElasticsearchIndexFieldTypeBuildContext buildContext) {
        this.buildContext = buildContext;
    }

    @Override
    public ElasticsearchNativeIndexFieldTypeOptionsStep<?> mapping(JsonObject jsonObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchNativeIndexFieldTypeOptionsStep<?> mapping(String jsonString) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
