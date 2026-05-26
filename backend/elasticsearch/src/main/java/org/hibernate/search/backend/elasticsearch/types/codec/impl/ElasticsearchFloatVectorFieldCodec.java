/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.codec.impl;

import org.hibernate.search.engine.backend.types.VectorSimilarity;
import org.hibernate.search.util.common.AssertionFailure;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

public class ElasticsearchFloatVectorFieldCodec extends AbstractElasticsearchVectorFieldCodec<float[]> {

    public ElasticsearchFloatVectorFieldCodec(Gson gson, VectorSimilarity similarity, int dimension, Integer m, Integer efConstruction, float[] indexNullAs) {
        super(gson, similarity, dimension, m, efConstruction, indexNullAs);
    }

    @Override
    protected JsonArray toJsonArray(float[] value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected float[] fromJsonArray(JsonArray jsonElements) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Class<?> vectorElementsType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public float scoreToSimilarity(float score) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
