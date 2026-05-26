/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.projection.dsl.spi;

import java.util.List;
import java.util.function.Function;
import org.hibernate.search.engine.common.dsl.spi.DslExtensionState;
import org.hibernate.search.engine.search.common.NamedValues;
import org.hibernate.search.engine.search.common.ValueModel;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.dsl.CompositeProjectionInnerStep;
import org.hibernate.search.engine.search.projection.dsl.CompositeProjectionValueStep;
import org.hibernate.search.engine.search.projection.dsl.DistanceToFieldProjectionValueStep;
import org.hibernate.search.engine.search.projection.dsl.DocumentReferenceProjectionOptionsStep;
import org.hibernate.search.engine.search.projection.dsl.EntityProjectionOptionsStep;
import org.hibernate.search.engine.search.projection.dsl.EntityReferenceProjectionOptionsStep;
import org.hibernate.search.engine.search.projection.dsl.ExtendedSearchProjectionFactory;
import org.hibernate.search.engine.search.projection.dsl.FieldProjectionValueStep;
import org.hibernate.search.engine.search.projection.dsl.HighlightProjectionOptionsStep;
import org.hibernate.search.engine.search.projection.dsl.IdProjectionOptionsStep;
import org.hibernate.search.engine.search.projection.dsl.ProjectionFinalStep;
import org.hibernate.search.engine.search.projection.dsl.ScoreProjectionOptionsStep;
import org.hibernate.search.engine.search.projection.dsl.SearchProjectionFactoryExtension;
import org.hibernate.search.engine.search.projection.dsl.SearchProjectionFactoryExtensionIfSupportedStep;
import org.hibernate.search.engine.search.projection.dsl.impl.CompositeProjectionInnerStepImpl;
import org.hibernate.search.engine.search.projection.dsl.impl.CompositeProjectionValueStepImpl;
import org.hibernate.search.engine.search.projection.dsl.impl.DistanceToFieldProjectionValueStepImpl;
import org.hibernate.search.engine.search.projection.dsl.impl.DocumentReferenceProjectionOptionsStepImpl;
import org.hibernate.search.engine.search.projection.dsl.impl.EntityProjectionOptionsStepImpl;
import org.hibernate.search.engine.search.projection.dsl.impl.EntityReferenceProjectionOptionsStepImpl;
import org.hibernate.search.engine.search.projection.dsl.impl.FieldProjectionValueStepImpl;
import org.hibernate.search.engine.search.projection.dsl.impl.HighlightProjectionOptionsStepImpl;
import org.hibernate.search.engine.search.projection.dsl.impl.IdProjectionOptionsStepImpl;
import org.hibernate.search.engine.search.projection.dsl.impl.ScoreProjectionOptionsStepImpl;
import org.hibernate.search.engine.search.projection.dsl.impl.SearchProjectionFactoryExtensionStep;
import org.hibernate.search.engine.search.projection.spi.SearchProjectionIndexScope;
import org.hibernate.search.engine.search.spi.ResultsCompositor;
import org.hibernate.search.engine.spatial.GeoPoint;
import org.hibernate.search.util.common.impl.Contracts;

public abstract class AbstractSearchProjectionFactory<SR, S extends ExtendedSearchProjectionFactory<SR, S, R, E>, SC extends SearchProjectionIndexScope<?>, R, E> implements ExtendedSearchProjectionFactory<SR, S, R, E> {

    protected final SearchProjectionDslContext<SC> dslContext;

    public AbstractSearchProjectionFactory(SearchProjectionDslContext<SC> dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public DocumentReferenceProjectionOptionsStep<?> documentReference() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> FieldProjectionValueStep<?, T> field(String fieldPath, Class<T> clazz, ValueModel valueModel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FieldProjectionValueStep<?, Object> field(String fieldPath, ValueModel valueModel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EntityReferenceProjectionOptionsStep<?, R> entityReference() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <I> IdProjectionOptionsStep<?, I> id(Class<I> requestedIdentifierType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EntityProjectionOptionsStep<?, E> entity() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> EntityProjectionOptionsStep<?, T> entity(Class<T> requestedEntityType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ScoreProjectionOptionsStep<?> score() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DistanceToFieldProjectionValueStep<?, Double> distance(String fieldPath, GeoPoint center) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompositeProjectionInnerStep object(String objectFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompositeProjectionInnerStep composite() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompositeProjectionValueStep<?, List<?>> composite(SearchProjection<?>... projections) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> ProjectionFinalStep<T> constant(T value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> ProjectionFinalStep<T> withParameters(Function<? super NamedValues, ? extends ProjectionFinalStep<T>> projectionCreator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> T extension(SearchProjectionFactoryExtension<T, R, E> extension) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> SearchProjectionFactoryExtensionIfSupportedStep<SR, T, R, E> extension() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String toAbsolutePath(String relativeFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HighlightProjectionOptionsStep highlight(String fieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
