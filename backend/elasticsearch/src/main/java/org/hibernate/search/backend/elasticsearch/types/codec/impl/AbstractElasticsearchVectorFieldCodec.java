/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.codec.impl;

import java.util.Objects;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonElementTypes;
import org.hibernate.search.engine.backend.types.VectorSimilarity;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;

public abstract class AbstractElasticsearchVectorFieldCodec<F> extends AbstractElasticsearchFieldCodec<F> implements ElasticsearchVectorFieldCodec<F> {

    protected final VectorSimilarity similarity;

    protected final int dimension;

    private final Integer m;

    private final Integer efConstruction;

    private final F indexNullAs;

    protected AbstractElasticsearchVectorFieldCodec(Gson gson, VectorSimilarity similarity, int dimension, Integer m, Integer efConstruction, F indexNullAs) {
        super(gson);
        this.similarity = similarity;
        this.dimension = dimension;
        this.m = m;
        this.efConstruction = efConstruction;
        this.indexNullAs = indexNullAs;
    }

    @Override
    public JsonElement encode(F value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract JsonArray toJsonArray(F value);

    @Override
    public F decode(JsonElement element) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract F fromJsonArray(JsonArray jsonElements);

    @Override
    public int getConfiguredDimensions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleWith(ElasticsearchFieldCodec<?> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean canDecodeArrays() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
