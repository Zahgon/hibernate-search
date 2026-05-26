/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.dsl.impl;

import org.hibernate.search.backend.elasticsearch.types.codec.impl.AbstractElasticsearchVectorFieldCodec;
import org.hibernate.search.backend.elasticsearch.types.codec.impl.ElasticsearchByteVectorFieldCodec;
import org.hibernate.search.backend.elasticsearch.types.mapping.impl.ElasticsearchVectorFieldTypeMappingContributor;
import org.hibernate.search.engine.backend.types.VectorSimilarity;

class ElasticsearchByteVectorFieldTypeOptionsStep extends AbstractElasticsearchVectorFieldTypeOptionsStep<ElasticsearchByteVectorFieldTypeOptionsStep, byte[]> {

    ElasticsearchByteVectorFieldTypeOptionsStep(ElasticsearchIndexFieldTypeBuildContext buildContext, ElasticsearchVectorFieldTypeMappingContributor mappingContributor) {
        super(buildContext, byte[].class, mappingContributor);
    }

    @Override
    protected AbstractElasticsearchVectorFieldCodec<byte[]> createCodec(VectorSimilarity vectorSimilarity, int dimension, Integer m, Integer efConstruction, byte[] indexNullAs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String type() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected ElasticsearchByteVectorFieldTypeOptionsStep thisAsS() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
