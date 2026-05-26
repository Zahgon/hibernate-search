/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.predicate.dsl.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.hibernate.search.engine.search.common.spi.SearchIndexScope;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.SpatialWithinPredicateFieldMoreStep;
import org.hibernate.search.engine.search.predicate.dsl.SpatialWithinPredicateOptionsStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.SearchPredicateDslContext;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;
import org.hibernate.search.engine.search.predicate.spi.SearchPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.SpatialWithinBoundingBoxPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.SpatialWithinCirclePredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.SpatialWithinPolygonPredicateBuilder;
import org.hibernate.search.engine.search.reference.predicate.SpatialPredicateFieldReference;
import org.hibernate.search.engine.spatial.DistanceUnit;
import org.hibernate.search.engine.spatial.GeoBoundingBox;
import org.hibernate.search.engine.spatial.GeoPoint;
import org.hibernate.search.engine.spatial.GeoPolygon;
import org.hibernate.search.util.common.impl.CollectionHelper;
import org.hibernate.search.util.common.impl.Contracts;

class SpatialWithinPredicateFieldMoreStepImpl<SR> implements SpatialWithinPredicateFieldMoreStep<SR, SpatialWithinPredicateFieldMoreStepImpl<SR>, SpatialWithinPredicateOptionsStep<?>>, AbstractBooleanMultiFieldPredicateCommonState.FieldSetState {

    private final CommonState<SR> commonState;

    private final List<String> fieldPaths;

    private final List<SearchPredicateBuilder> predicateBuilders;

    private Float fieldSetBoost;

    SpatialWithinPredicateFieldMoreStepImpl(CommonState<SR> commonState, List<String> fieldPaths) {
        this.commonState = commonState;
        this.commonState.add(this);
        this.fieldPaths = CollectionHelper.toImmutableList(fieldPaths);
        this.predicateBuilders = new ArrayList<>(fieldPaths.size());
    }

    @Override
    public SpatialWithinPredicateFieldMoreStepImpl<SR> fields(String... fieldPaths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @Override
    public SpatialWithinPredicateFieldMoreStepImpl<SR> fields(SpatialPredicateFieldReference<? super SR>... fieldReferences) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SpatialWithinPredicateFieldMoreStepImpl<SR> boost(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SpatialWithinPredicateOptionsStep<?> circle(GeoPoint center, double radius, DistanceUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SpatialWithinPredicateOptionsStep<?> polygon(GeoPolygon polygon) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SpatialWithinPredicateOptionsStep<?> boundingBox(GeoBoundingBox boundingBox) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void contributePredicates(Consumer<SearchPredicate> collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void generateWithinCircleQueryBuilders(GeoPoint center, double radius, DistanceUnit unit) {
        SearchIndexScope<?> scope = commonState.scope();
        for (String fieldPath : fieldPaths) {
            SpatialWithinCirclePredicateBuilder predicateBuilder = scope.fieldQueryElement(fieldPath, PredicateTypeKeys.SPATIAL_WITHIN_CIRCLE);
            predicateBuilder.circle(center, radius, unit);
            predicateBuilders.add(predicateBuilder);
        }
    }

    private void generateWithinPolygonQueryBuilders(GeoPolygon polygon) {
        SearchIndexScope<?> scope = commonState.scope();
        for (String fieldPath : fieldPaths) {
            SpatialWithinPolygonPredicateBuilder predicateBuilder = scope.fieldQueryElement(fieldPath, PredicateTypeKeys.SPATIAL_WITHIN_POLYGON);
            predicateBuilder.polygon(polygon);
            predicateBuilders.add(predicateBuilder);
        }
    }

    private void generateWithinBoundingBoxQueryBuilders(GeoBoundingBox boundingBox) {
        SearchIndexScope<?> scope = commonState.scope();
        for (String fieldPath : fieldPaths) {
            SpatialWithinBoundingBoxPredicateBuilder predicateBuilder = scope.fieldQueryElement(fieldPath, PredicateTypeKeys.SPATIAL_WITHIN_BOUNDING_BOX);
            predicateBuilder.boundingBox(boundingBox);
            predicateBuilders.add(predicateBuilder);
        }
    }

    static class CommonState<SR> extends AbstractBooleanMultiFieldPredicateCommonState<CommonState<SR>, SpatialWithinPredicateFieldMoreStepImpl<SR>> implements SpatialWithinPredicateOptionsStep<CommonState<SR>> {

        CommonState(SearchPredicateDslContext<?> dslContext) {
            super(dslContext);
        }

        SpatialWithinPredicateOptionsStep<?> circle(GeoPoint center, double radius, DistanceUnit unit) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        SpatialWithinPredicateOptionsStep<?> polygon(GeoPolygon polygon) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        SpatialWithinPredicateOptionsStep<?> boundingBox(GeoBoundingBox boundingBox) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected CommonState<SR> thisAsS() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
