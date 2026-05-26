/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.codec.impl;

import org.hibernate.search.backend.elasticsearch.gson.impl.JsonElementTypes;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;

public final class ElasticsearchDoubleFieldCodec extends AbstractElasticsearchFieldCodec<Double> {

    public ElasticsearchDoubleFieldCodec(Gson gson) {
        super(gson);
    }

    @Override
    public JsonElement encode(Double value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Double decode(JsonElement element) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Double decode(Double value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleWith(ElasticsearchFieldCodec<?> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
