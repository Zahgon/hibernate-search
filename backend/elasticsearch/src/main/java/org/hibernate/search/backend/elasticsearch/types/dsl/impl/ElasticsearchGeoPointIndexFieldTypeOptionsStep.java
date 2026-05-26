/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.dsl.impl;

import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.DataTypes;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.ElasticsearchExistsPredicate;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ElasticsearchDistanceToFieldProjection;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ElasticsearchFieldProjection;
import org.hibernate.search.backend.elasticsearch.types.codec.impl.ElasticsearchGeoPointFieldCodec;
import org.hibernate.search.backend.elasticsearch.types.predicate.impl.ElasticsearchGeoPointSpatialWithinBoundingBoxPredicate;
import org.hibernate.search.backend.elasticsearch.types.predicate.impl.ElasticsearchGeoPointSpatialWithinCirclePredicate;
import org.hibernate.search.backend.elasticsearch.types.predicate.impl.ElasticsearchGeoPointSpatialWithinPolygonPredicate;
import org.hibernate.search.backend.elasticsearch.types.sort.impl.ElasticsearchDistanceSort;
import org.hibernate.search.engine.backend.types.converter.spi.DefaultStringConverters;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;
import org.hibernate.search.engine.search.projection.spi.ProjectionTypeKeys;
import org.hibernate.search.engine.search.sort.spi.SortTypeKeys;
import org.hibernate.search.engine.spatial.GeoPoint;

class ElasticsearchGeoPointIndexFieldTypeOptionsStep extends AbstractElasticsearchSimpleStandardFieldTypeOptionsStep<ElasticsearchGeoPointIndexFieldTypeOptionsStep, GeoPoint> {

    ElasticsearchGeoPointIndexFieldTypeOptionsStep(ElasticsearchIndexFieldTypeBuildContext buildContext) {
        super(buildContext, GeoPoint.class, DataTypes.GEO_POINT, DefaultStringConverters.GEO_POINT);
    }

    @Override
    protected void complete() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected ElasticsearchGeoPointIndexFieldTypeOptionsStep thisAsS() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
