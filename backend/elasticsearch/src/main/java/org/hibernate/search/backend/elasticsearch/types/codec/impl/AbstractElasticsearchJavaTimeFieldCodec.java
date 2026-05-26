/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.codec.impl;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonElementTypes;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;

public abstract class AbstractElasticsearchJavaTimeFieldCodec<T extends TemporalAccessor> extends AbstractElasticsearchFieldCodec<T> {

    protected final DateTimeFormatter formatter;

    public AbstractElasticsearchJavaTimeFieldCodec(Gson gson, DateTimeFormatter delegate) {
        super(gson);
        this.formatter = delegate;
    }

    @Override
    public JsonElement encode(T value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A different encoding is required for provided missing Java time values. See HSEARCH-3255.
     *
     * @param value to encode
     * @return a {@link JsonElement} containing the long scalar value, if {@code value} is not null.
     */
    @Override
    public JsonElement encodeForMissing(T value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T decode(JsonElement element) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T decodeAggregationKey(JsonElement key, JsonElement keyAsString) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleWith(ElasticsearchFieldCodec<?> obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected String nullUnsafeFormat(T value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract T nullUnsafeParse(String stringValue);

    protected abstract Long nullUnsafeScalar(T value);
}
