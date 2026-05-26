/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.sort.impl;

import org.hibernate.search.backend.lucene.logging.impl.QueryLog;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.MultiValueMode;
import org.hibernate.search.backend.lucene.search.common.impl.AbstractLuceneValueFieldSearchQueryElementFactory;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexValueFieldContext;
import org.hibernate.search.backend.lucene.types.sort.comparatorsource.impl.LuceneFieldComparatorSource;
import org.hibernate.search.backend.lucene.types.sort.comparatorsource.impl.LuceneGeoPointDistanceComparatorSource;
import org.hibernate.search.engine.search.common.SortMode;
import org.hibernate.search.engine.search.sort.SearchSort;
import org.hibernate.search.engine.search.sort.dsl.SortOrder;
import org.hibernate.search.engine.search.sort.spi.DistanceSortBuilder;
import org.hibernate.search.engine.spatial.GeoPoint;
import org.hibernate.search.util.common.AssertionFailure;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.SloppyMath;

public class LuceneGeoPointDistanceSort extends AbstractLuceneDocumentValueSort {

    private final double effectiveMissingValue;

    private final GeoPoint center;

    private LuceneGeoPointDistanceSort(Builder builder) {
        super(builder);
        effectiveMissingValue = builder.getEffectiveMissingValue();
        center = builder.center;
    }

    @Override
    protected LuceneFieldComparatorSource doCreateFieldComparatorSource(String nestedDocumentPath, MultiValueMode multiValueMode, Query nestedFilter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Factory extends AbstractLuceneValueFieldSearchQueryElementFactory<DistanceSortBuilder, GeoPoint> {

        @Override
        public DistanceSortBuilder create(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<GeoPoint> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Builder extends AbstractBuilder implements DistanceSortBuilder {

        private GeoPoint center;

        private Object missingValue;

        private Builder(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<GeoPoint> field) {
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

        private double getEffectiveMissingValue() {
            if (missingValue == null) {
                // missing value implicit distance (same as ES):
                return Double.POSITIVE_INFINITY;
            }
            if (missingValue == SortMissingValue.MISSING_FIRST) {
                return (order == SortOrder.DESC) ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
            }
            if (missingValue == SortMissingValue.MISSING_LAST) {
                return (order == SortOrder.DESC) ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
            }
            if (missingValue == SortMissingValue.MISSING_LOWEST) {
                return Double.NEGATIVE_INFINITY;
            }
            if (missingValue == SortMissingValue.MISSING_HIGHEST) {
                return Double.POSITIVE_INFINITY;
            }
            if (missingValue instanceof GeoPoint) {
                GeoPoint geoPointMissingValue = (GeoPoint) missingValue;
                return SloppyMath.haversinMeters(geoPointMissingValue.latitude(), geoPointMissingValue.longitude(), center.latitude(), center.longitude());
            }
            throw new AssertionFailure("Unexpected missing value: " + missingValue);
        }
    }
}
