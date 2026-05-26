/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.projection.dsl.impl;

import java.util.List;
import java.util.function.Function;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.dsl.CompositeProjectionFromAsStep;
import org.hibernate.search.engine.search.projection.dsl.CompositeProjectionValueStep;
import org.hibernate.search.engine.search.projection.spi.CompositeProjectionBuilder;
import org.hibernate.search.engine.search.spi.ResultsCompositor;

abstract class AbstractCompositeProjectionFromAsStep implements CompositeProjectionFromAsStep {

    final CompositeProjectionBuilder builder;

    public AbstractCompositeProjectionFromAsStep(CompositeProjectionBuilder builder) {
        this.builder = builder;
    }

    @Override
    public final CompositeProjectionValueStep<?, List<?>> asList() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final <V> CompositeProjectionValueStep<?, V> asList(Function<? super List<?>, ? extends V> transformer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompositeProjectionValueStep<?, Object[]> asArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <V> CompositeProjectionValueStep<?, V> asArray(Function<? super Object[], ? extends V> transformer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract SearchProjection<?>[] toProjectionArray();
}
