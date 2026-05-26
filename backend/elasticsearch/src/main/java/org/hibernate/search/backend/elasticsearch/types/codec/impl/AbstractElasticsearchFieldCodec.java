/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.codec.impl;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public abstract class AbstractElasticsearchFieldCodec<T> implements ElasticsearchFieldCodec<T> {

    protected final Gson gson;

    public AbstractElasticsearchFieldCodec(Gson gson) {
        this.gson = gson;
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
