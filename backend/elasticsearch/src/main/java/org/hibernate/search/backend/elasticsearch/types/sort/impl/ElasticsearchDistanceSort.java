/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.sort.impl;

import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonObjectAccessor;
import org.hibernate.search.backend.elasticsearch.logging.impl.QueryLog;
import org.hibernate.search.backend.elasticsearch.search.common.impl.AbstractElasticsearchValueFieldSearchQueryElementFactory;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexValueFieldContext;
import org.hibernate.search.backend.elasticsearch.search.sort.impl.ElasticsearchSearchSortCollector;
import org.hibernate.search.backend.elasticsearch.types.codec.impl.ElasticsearchFieldCodec;
import org.hibernate.search.engine.search.common.SortMode;
import org.hibernate.search.engine.search.sort.SearchSort;
import org.hibernate.search.engine.search.sort.dsl.SortOrder;
import org.hibernate.search.engine.search.sort.spi.DistanceSortBuilder;
import org.hibernate.search.engine.spatial.GeoPoint;
import com.google.gson.JsonObject;

public class ElasticsearchDistanceSort extends AbstractElasticsearchDocumentValueSort {

    private static final JsonObjectAccessor GEO_DISTANCE_ACCESSOR = JsonAccessor.root().property("_geo_distance").asObject();

    private final GeoPoint center;

    private final ElasticsearchFieldCodec<GeoPoint> codec;

    private ElasticsearchDistanceSort(Builder builder) {
        super(builder);
        center = builder.center;
        codec = builder.field.type().codec();
    }

    @Override
    protected void doToJsonSorts(ElasticsearchSearchSortCollector collector, JsonObject innerObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Factory extends AbstractElasticsearchValueFieldSearchQueryElementFactory<DistanceSortBuilder, GeoPoint> {

        @Override
        public DistanceSortBuilder create(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<GeoPoint> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Builder extends AbstractBuilder<GeoPoint> implements DistanceSortBuilder {

        private GeoPoint center;

        private boolean missingFirst = false;

        private boolean missingLast = false;

        private Builder(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<GeoPoint> field) {
            super(scope, field);
        }

        @Override
        public void center(GeoPoint center) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void missingFirst() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void missingLast() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void missingHighest() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void missingLowest() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void missingAs(GeoPoint value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void mode(SortMode mode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchSort build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
