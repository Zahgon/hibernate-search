/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.codec.impl;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;

public class ElasticsearchJsonElementFieldCodec implements ElasticsearchFieldCodec<JsonElement> {

    private final Gson gson;

    public ElasticsearchJsonElementFieldCodec(Gson gson) {
        this.gson = gson;
    }

    @Override
    public JsonElement encode(JsonElement value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonElement decode(JsonElement element) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonElement decode(Double value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleWith(ElasticsearchFieldCodec<?> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonElement fromJsonStringToElement(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String fromJsonElementToString(JsonElement value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
