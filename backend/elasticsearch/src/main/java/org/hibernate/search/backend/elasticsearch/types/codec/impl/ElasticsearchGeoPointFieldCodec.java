/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.codec.impl;

import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonElementTypes;
import org.hibernate.search.backend.elasticsearch.logging.spi.ElasticsearchClientLog;
import org.hibernate.search.engine.spatial.GeoPoint;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

public final class ElasticsearchGeoPointFieldCodec extends AbstractElasticsearchFieldCodec<GeoPoint> {

    private static final JsonAccessor<Double> LATITUDE_ACCESSOR = JsonAccessor.root().property("lat").asDouble();

    private static final JsonAccessor<Double> LONGITUDE_ACCESSOR = JsonAccessor.root().property("lon").asDouble();

    public ElasticsearchGeoPointFieldCodec(Gson gson) {
        super(gson);
    }

    @Override
    public JsonElement encode(GeoPoint value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public GeoPoint decode(JsonElement element) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleWith(ElasticsearchFieldCodec<?> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
