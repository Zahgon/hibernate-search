/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.dsl.impl;

import org.hibernate.search.backend.lucene.search.projection.impl.LuceneDistanceToFieldProjection;
import org.hibernate.search.backend.lucene.search.projection.impl.LuceneFieldProjection;
import org.hibernate.search.backend.lucene.types.codec.impl.DocValues;
import org.hibernate.search.backend.lucene.types.codec.impl.Indexing;
import org.hibernate.search.backend.lucene.types.codec.impl.LuceneGeoPointFieldCodec;
import org.hibernate.search.backend.lucene.types.codec.impl.Storage;
import org.hibernate.search.backend.lucene.types.impl.LuceneIndexValueFieldType;
import org.hibernate.search.backend.lucene.types.predicate.impl.LuceneExistsPredicate;
import org.hibernate.search.backend.lucene.types.predicate.impl.LuceneGeoPointSpatialWithinBoundingBoxPredicate;
import org.hibernate.search.backend.lucene.types.predicate.impl.LuceneGeoPointSpatialWithinCirclePredicate;
import org.hibernate.search.backend.lucene.types.predicate.impl.LuceneGeoPointSpatialWithinPolygonPredicate;
import org.hibernate.search.backend.lucene.types.sort.impl.LuceneGeoPointDistanceSort;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.engine.backend.types.converter.spi.DefaultStringConverters;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;
import org.hibernate.search.engine.search.projection.spi.ProjectionTypeKeys;
import org.hibernate.search.engine.search.sort.spi.SortTypeKeys;
import org.hibernate.search.engine.spatial.GeoPoint;

class LuceneGeoPointIndexFieldTypeOptionsStep extends AbstractLuceneStandardIndexFieldTypeOptionsStep<LuceneGeoPointIndexFieldTypeOptionsStep, GeoPoint> {

    private Sortable sortable = Sortable.DEFAULT;

    LuceneGeoPointIndexFieldTypeOptionsStep(LuceneIndexFieldTypeBuildContext buildContext) {
        super(buildContext, GeoPoint.class, DefaultStringConverters.GEO_POINT);
    }

    @Override
    public LuceneGeoPointIndexFieldTypeOptionsStep sortable(Sortable sortable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneIndexValueFieldType<GeoPoint> toIndexFieldType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected LuceneGeoPointIndexFieldTypeOptionsStep thisAsS() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
