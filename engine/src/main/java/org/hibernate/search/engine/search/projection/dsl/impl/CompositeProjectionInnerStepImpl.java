/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.projection.dsl.impl;

import org.hibernate.search.engine.search.common.NonStaticMetamodelScope;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.definition.impl.DefaultProjectionDefinitionContext;
import org.hibernate.search.engine.search.projection.dsl.CompositeProjectionFrom1AsStep;
import org.hibernate.search.engine.search.projection.dsl.CompositeProjectionFrom2AsStep;
import org.hibernate.search.engine.search.projection.dsl.CompositeProjectionFrom3AsStep;
import org.hibernate.search.engine.search.projection.dsl.CompositeProjectionFromAsStep;
import org.hibernate.search.engine.search.projection.dsl.CompositeProjectionInnerStep;
import org.hibernate.search.engine.search.projection.dsl.CompositeProjectionValueStep;
import org.hibernate.search.engine.search.projection.dsl.ExtendedSearchProjectionFactory;
import org.hibernate.search.engine.search.projection.dsl.ProjectionFinalStep;
import org.hibernate.search.engine.search.projection.dsl.spi.SearchProjectionDslContext;
import org.hibernate.search.engine.search.projection.spi.CompositeProjectionBuilder;
import org.hibernate.search.engine.search.projection.spi.ProjectionTypeKeys;
import org.hibernate.search.util.common.impl.Contracts;

public class CompositeProjectionInnerStepImpl<SR> implements CompositeProjectionInnerStep {

    private final SearchProjectionDslContext<?> dslContext;

    private final ExtendedSearchProjectionFactory<SR, ?, ?, ?> projectionFactory;

    private final CompositeProjectionBuilder builder;

    private final String objectFieldPath;

    public CompositeProjectionInnerStepImpl(SearchProjectionDslContext<?> dslContext, ExtendedSearchProjectionFactory<SR, ?, ?, ?> projectionFactory) {
        this.dslContext = dslContext;
        this.projectionFactory = projectionFactory;
        this.builder = dslContext.scope().projectionBuilders().composite();
        this.objectFieldPath = null;
    }

    public CompositeProjectionInnerStepImpl(SearchProjectionDslContext<?> dslContext, ExtendedSearchProjectionFactory<SR, ?, ?, ?> projectionFactory, String objectFieldPath) {
        this.dslContext = dslContext;
        this.projectionFactory = projectionFactory;
        this.builder = dslContext.scope().fieldQueryElement(objectFieldPath, ProjectionTypeKeys.OBJECT);
        this.objectFieldPath = objectFieldPath;
    }

    @Override
    public <V> CompositeProjectionValueStep<?, V> as(Class<V> objectClass) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <V1> CompositeProjectionFrom1AsStep<V1> from(SearchProjection<V1> projection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <V1, V2> CompositeProjectionFrom2AsStep<V1, V2> from(SearchProjection<V1> projection1, SearchProjection<V2> projection2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <V1, V2, V3> CompositeProjectionFrom3AsStep<V1, V2, V3> from(SearchProjection<V1> projection1, SearchProjection<V2> projection2, SearchProjection<V3> projection3) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompositeProjectionFromAsStep from(SearchProjection<?>... projections) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final CompositeProjectionFromAsStep from(ProjectionFinalStep<?>... dslFinalSteps) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
