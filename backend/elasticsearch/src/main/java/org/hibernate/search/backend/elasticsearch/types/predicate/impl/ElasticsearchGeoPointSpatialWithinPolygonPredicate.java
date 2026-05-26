/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.predicate.impl;

import java.util.List;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonObjectAccessor;
import org.hibernate.search.backend.elasticsearch.search.common.impl.AbstractElasticsearchValueFieldSearchQueryElementFactory;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexValueFieldContext;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.AbstractElasticsearchSingleFieldPredicate;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.SpatialWithinPolygonPredicateBuilder;
import org.hibernate.search.engine.spatial.GeoPoint;
import org.hibernate.search.engine.spatial.GeoPolygon;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ElasticsearchGeoPointSpatialWithinPolygonPredicate extends AbstractElasticsearchSingleFieldPredicate {

    private static final JsonObjectAccessor GEO_SHAPE_ACCESSOR = JsonAccessor.root().property("geo_shape").asObject();

    private static final JsonAccessor<Boolean> IGNORE_UNMAPPED_ACCESSOR = JsonAccessor.root().property("ignore_unmapped").asBoolean();

    private static final String COORDINATES_PROPERTY_NAME = "coordinates";

    private static final String TYPE_PROPERTY_NAME = "type";

    private static final String TYPE_PROPERTY_VALUE = "Polygon";

    private static final String SHAPE_PROPERTY_NAME = "shape";

    private final double[] coordinates;

    private ElasticsearchGeoPointSpatialWithinPolygonPredicate(Builder builder) {
        super(builder);
        coordinates = builder.coordinates;
    }

    @Override
    protected JsonObject doToJsonQuery(PredicateRequestContext context, JsonObject outerObject, JsonObject innerObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Factory extends AbstractElasticsearchValueFieldSearchQueryElementFactory<SpatialWithinPolygonPredicateBuilder, GeoPoint> {

        @Override
        public Builder create(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<GeoPoint> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Builder extends AbstractBuilder implements SpatialWithinPolygonPredicateBuilder {

        private double[] coordinates;

        private Builder(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<GeoPoint> field) {
            super(scope, field);
        }

        @Override
        public void polygon(GeoPolygon polygon) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchPredicate build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
