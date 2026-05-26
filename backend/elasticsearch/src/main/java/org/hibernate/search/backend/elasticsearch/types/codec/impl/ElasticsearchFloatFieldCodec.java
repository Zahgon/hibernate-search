/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.codec.impl;

import org.hibernate.search.backend.elasticsearch.gson.impl.JsonElementTypes;
import org.hibernate.search.engine.cfg.spi.NumberUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;

public final class ElasticsearchFloatFieldCodec extends AbstractElasticsearchFieldCodec<Float> {

    public ElasticsearchFloatFieldCodec(Gson gson) {
        super(gson);
    }

    @Override
    public JsonElement encode(Float value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Float decode(JsonElement element) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Float decode(Double value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleWith(ElasticsearchFieldCodec<?> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
