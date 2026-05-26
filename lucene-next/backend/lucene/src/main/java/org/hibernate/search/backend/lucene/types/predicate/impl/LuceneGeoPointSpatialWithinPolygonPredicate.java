/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.predicate.impl;

import java.util.List;
import org.hibernate.search.backend.lucene.search.common.impl.AbstractLuceneValueFieldSearchQueryElementFactory;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexValueFieldContext;
import org.hibernate.search.backend.lucene.search.predicate.impl.AbstractLuceneLeafSingleFieldPredicate;
import org.hibernate.search.backend.lucene.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.SpatialWithinPolygonPredicateBuilder;
import org.hibernate.search.engine.spatial.GeoPoint;
import org.hibernate.search.engine.spatial.GeoPolygon;
import org.apache.lucene.document.LatLonPoint;
import org.apache.lucene.geo.Polygon;
import org.apache.lucene.search.Query;

public class LuceneGeoPointSpatialWithinPolygonPredicate extends AbstractLuceneLeafSingleFieldPredicate {

    private LuceneGeoPointSpatialWithinPolygonPredicate(Builder builder) {
        super(builder);
    }

    public static class Factory extends AbstractLuceneValueFieldSearchQueryElementFactory<SpatialWithinPolygonPredicateBuilder, GeoPoint> {

        @Override
        public Builder create(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<GeoPoint> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static class Builder extends AbstractBuilder<GeoPoint> implements SpatialWithinPolygonPredicateBuilder {

        protected GeoPolygon polygon;

        Builder(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<GeoPoint> field) {
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

        @Override
        protected Query buildQuery(PredicateRequestContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
