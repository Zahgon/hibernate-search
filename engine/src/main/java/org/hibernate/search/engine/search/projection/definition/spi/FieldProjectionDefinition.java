/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.projection.definition.spi;

import java.util.List;
import org.hibernate.search.engine.search.common.ValueModel;
import org.hibernate.search.engine.search.projection.ProjectionCollector;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.definition.ProjectionDefinitionContext;
import org.hibernate.search.util.common.annotation.Incubating;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

@Incubating
public abstract class FieldProjectionDefinition<P, F> extends AbstractProjectionDefinition<P> {

    protected final String fieldPath;

    protected final Class<F> fieldType;

    protected final ValueModel valueModel;

    private FieldProjectionDefinition(String fieldPath, Class<F> fieldType, ValueModel valueModel) {
        this.fieldPath = fieldPath;
        this.fieldType = fieldType;
        this.valueModel = valueModel;
    }

    @Override
    protected String type() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void appendTo(ToStringTreeAppender appender) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract boolean multi();

    @Deprecated(since = "8.0")
    @Incubating
    public static final class SingleValued<F> extends FieldProjectionDefinition<F, F> {

        public SingleValued(String fieldPath, Class<F> fieldType, ValueModel valueModel) {
            super(fieldPath, fieldType, valueModel);
        }

        @Override
        protected boolean multi() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchProjection<F> create(ProjectionDefinitionContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @Deprecated(since = "8.0")
    @Incubating
    public static final class MultiValued<F> extends FieldProjectionDefinition<List<F>, F> {

        public MultiValued(String fieldPath, Class<F> fieldType, ValueModel valueModel) {
            super(fieldPath, fieldType, valueModel);
        }

        @Override
        protected boolean multi() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchProjection<List<F>> create(ProjectionDefinitionContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @Incubating
    public static final class AccumulatedValued<C, F> extends FieldProjectionDefinition<C, F> {

        private final ProjectionCollector.Provider<F, C> collector;

        public AccumulatedValued(String fieldPath, Class<F> fieldType, ProjectionCollector.Provider<F, C> collector, ValueModel valueModel) {
            super(fieldPath, fieldType, valueModel);
            this.collector = collector;
        }

        @Override
        protected boolean multi() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchProjection<C> create(ProjectionDefinitionContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
