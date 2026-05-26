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
import org.hibernate.search.engine.search.predicate.spi.SpatialWithinCirclePredicateBuilder;
import org.hibernate.search.engine.spatial.DistanceUnit;
import org.hibernate.search.engine.spatial.GeoPoint;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ElasticsearchGeoPointSpatialWithinCirclePredicate extends AbstractElasticsearchSingleFieldPredicate {

    private static final JsonObjectAccessor GEO_DISTANCE_ACCESSOR = JsonAccessor.root().property("geo_distance").asObject();

    private static final JsonAccessor<Double> DISTANCE_ACCESSOR = JsonAccessor.root().property("distance").asDouble();

    private static final JsonAccessor<Boolean> IGNORE_UNMAPPED_ACCESSOR = JsonAccessor.root().property("ignore_unmapped").asBoolean();

    private final double distanceInMeters;

    private final JsonElement center;

    private ElasticsearchGeoPointSpatialWithinCirclePredicate(Builder builder) {
        super(builder);
        distanceInMeters = builder.distanceInMeters;
        center = builder.center;
    }

    @Override
    protected JsonObject doToJsonQuery(PredicateRequestContext context, JsonObject outerObject, JsonObject innerObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Factory extends AbstractElasticsearchCodecAwareSearchQueryElementFactory<SpatialWithinCirclePredicateBuilder, GeoPoint> {

        public Factory(ElasticsearchFieldCodec<GeoPoint> codec) {
            super(codec);
        }

        @Override
        public Builder create(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<GeoPoint> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Builder extends AbstractBuilder implements SpatialWithinCirclePredicateBuilder {

        private final ElasticsearchFieldCodec<GeoPoint> codec;

        private double distanceInMeters;

        private JsonElement center;

        private Builder(ElasticsearchFieldCodec<GeoPoint> codec, ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<GeoPoint> field) {
            super(scope, field);
            this.codec = codec;
        }

        @Override
        public void circle(GeoPoint center, double radius, DistanceUnit unit) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchPredicate build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
