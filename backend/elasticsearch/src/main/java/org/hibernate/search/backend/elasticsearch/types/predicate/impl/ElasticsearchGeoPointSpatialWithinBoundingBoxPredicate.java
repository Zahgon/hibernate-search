/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.predicate.impl;

import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonObjectAccessor;
import org.hibernate.search.backend.elasticsearch.search.common.impl.AbstractElasticsearchCodecAwareSearchQueryElementFactory;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexValueFieldContext;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.AbstractElasticsearchSingleFieldPredicate;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.backend.elasticsearch.types.codec.impl.ElasticsearchFieldCodec;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.SpatialWithinBoundingBoxPredicateBuilder;
import org.hibernate.search.engine.spatial.GeoBoundingBox;
import org.hibernate.search.engine.spatial.GeoPoint;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ElasticsearchGeoPointSpatialWithinBoundingBoxPredicate extends AbstractElasticsearchSingleFieldPredicate {

    private static final JsonObjectAccessor GEO_BOUNDING_BOX_ACCESSOR = JsonAccessor.root().property("geo_bounding_box").asObject();

    private static final JsonAccessor<Boolean> IGNORE_UNMAPPED_ACCESSOR = JsonAccessor.root().property("ignore_unmapped").asBoolean();

    private static final String TOP_LEFT_PROPERTY_NAME = "top_left";

    private static final String BOTTOM_RIGHT_PROPERTY_NAME = "bottom_right";

    private final JsonElement topLeft;

    private final JsonElement bottomRight;

    private ElasticsearchGeoPointSpatialWithinBoundingBoxPredicate(Builder builder) {
        super(builder);
        topLeft = builder.topLeft;
        bottomRight = builder.bottomRight;
    }

    @Override
    protected JsonObject doToJsonQuery(PredicateRequestContext context, JsonObject outerObject, JsonObject innerObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Factory extends AbstractElasticsearchCodecAwareSearchQueryElementFactory<SpatialWithinBoundingBoxPredicateBuilder, GeoPoint> {

        public Factory(ElasticsearchFieldCodec<GeoPoint> codec) {
            super(codec);
        }

        @Override
        public Builder create(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<GeoPoint> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Builder extends AbstractBuilder implements SpatialWithinBoundingBoxPredicateBuilder {

        private final ElasticsearchFieldCodec<GeoPoint> codec;

        private JsonElement topLeft;

        private JsonElement bottomRight;

        private Builder(ElasticsearchFieldCodec<GeoPoint> codec, ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<GeoPoint> field) {
            super(scope, field);
            this.codec = codec;
        }

        @Override
        public void boundingBox(GeoBoundingBox boundingBox) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchPredicate build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
