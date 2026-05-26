/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.projection.definition.spi;

import java.util.List;
import org.hibernate.search.engine.search.projection.ProjectionCollector;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.definition.ProjectionDefinitionContext;
import org.hibernate.search.util.common.annotation.Incubating;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

@Incubating
public abstract class ObjectProjectionDefinition<P, T> extends AbstractProjectionDefinition<P> implements AutoCloseable {

    protected final String fieldPath;

    protected final CompositeProjectionDefinition<T> delegate;

    private ObjectProjectionDefinition(String fieldPath, CompositeProjectionDefinition<T> delegate) {
        this.fieldPath = fieldPath;
        this.delegate = delegate;
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

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Deprecated(since = "8.0")
    @Incubating
    public static final class SingleValued<T> extends ObjectProjectionDefinition<T, T> {

        public SingleValued(String fieldPath, CompositeProjectionDefinition<T> delegate) {
            super(fieldPath, delegate);
        }

        @Override
        protected boolean multi() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchProjection<T> create(ProjectionDefinitionContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @Deprecated(since = "8.0")
    @Incubating
    public static final class MultiValued<T> extends ObjectProjectionDefinition<List<T>, T> {

        public MultiValued(String fieldPath, CompositeProjectionDefinition<T> delegate) {
            super(fieldPath, delegate);
        }

        @Override
        protected boolean multi() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchProjection<List<T>> create(ProjectionDefinitionContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @Incubating
    public static final class WrappedValued<C, T> extends ObjectProjectionDefinition<C, T> {

        private final ProjectionCollector.Provider<T, C> collector;

        public WrappedValued(String fieldPath, CompositeProjectionDefinition<T> delegate, ProjectionCollector.Provider<T, C> collector) {
            super(fieldPath, delegate);
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
