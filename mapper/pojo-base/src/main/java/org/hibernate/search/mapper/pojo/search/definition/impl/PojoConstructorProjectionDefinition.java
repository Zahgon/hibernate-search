/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.search.definition.impl;

import java.util.List;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.definition.ProjectionDefinition;
import org.hibernate.search.engine.search.projection.definition.ProjectionDefinitionContext;
import org.hibernate.search.engine.search.projection.definition.spi.CompositeProjectionDefinition;
import org.hibernate.search.engine.search.projection.dsl.CompositeProjectionInnerStep;
import org.hibernate.search.engine.search.projection.dsl.CompositeProjectionValueStep;
import org.hibernate.search.mapper.pojo.logging.impl.ProjectionLog;
import org.hibernate.search.mapper.pojo.model.path.spi.ProjectionConstructorPath;
import org.hibernate.search.mapper.pojo.model.spi.PojoConstructorIdentifier;
import org.hibernate.search.util.common.SearchException;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.reflect.spi.ValueCreateHandle;
import org.hibernate.search.util.common.spi.ToStringTreeAppendable;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

public final class PojoConstructorProjectionDefinition<T> implements CompositeProjectionDefinition<T>, ToStringTreeAppendable {

    private final PojoConstructorIdentifier constructor;

    private final ValueCreateHandle<? extends T> handle;

    private final List<BeanHolder<? extends ProjectionDefinition<?>>> parameters;

    public PojoConstructorProjectionDefinition(PojoConstructorIdentifier constructor, ValueCreateHandle<? extends T> valueCreateHandle, List<BeanHolder<? extends ProjectionDefinition<?>>> parameters) {
        this.constructor = constructor;
        this.handle = valueCreateHandle;
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void appendTo(ToStringTreeAppender appender) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompositeProjectionValueStep<?, T> apply(CompositeProjectionInnerStep initialStep, ProjectionDefinitionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
