/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.dsl.impl;

import org.hibernate.search.backend.elasticsearch.types.codec.impl.AbstractElasticsearchVectorFieldCodec;
import org.hibernate.search.backend.elasticsearch.types.codec.impl.ElasticsearchFloatVectorFieldCodec;
import org.hibernate.search.backend.elasticsearch.types.mapping.impl.ElasticsearchVectorFieldTypeMappingContributor;
import org.hibernate.search.engine.backend.types.VectorSimilarity;

class ElasticsearchFloatVectorFieldTypeOptionsStep extends AbstractElasticsearchVectorFieldTypeOptionsStep<ElasticsearchFloatVectorFieldTypeOptionsStep, float[]> {

    ElasticsearchFloatVectorFieldTypeOptionsStep(ElasticsearchIndexFieldTypeBuildContext buildContext, ElasticsearchVectorFieldTypeMappingContributor mappingContributor) {
        super(buildContext, float[].class, mappingContributor);
    }

    @Override
    public String type() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected AbstractElasticsearchVectorFieldCodec<float[]> createCodec(VectorSimilarity similarity, int dimension, Integer m, Integer efConstruction, float[] indexNullAs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected ElasticsearchFloatVectorFieldTypeOptionsStep thisAsS() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
