/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.projection.dsl.impl;

import java.util.function.Function;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.dsl.CompositeProjectionFrom1AsStep;
import org.hibernate.search.engine.search.projection.dsl.CompositeProjectionValueStep;
import org.hibernate.search.engine.search.projection.spi.CompositeProjectionBuilder;
import org.hibernate.search.engine.search.spi.ResultsCompositor;

class CompositeProjectionFrom1AsStepImpl<V1> extends AbstractCompositeProjectionFromAsStep implements CompositeProjectionFrom1AsStep<V1> {

    final SearchProjection<V1> inner1;

    public CompositeProjectionFrom1AsStepImpl(CompositeProjectionBuilder builder, SearchProjection<V1> inner1) {
        super(builder);
        this.inner1 = inner1;
    }

    @Override
    public <V> CompositeProjectionValueStep<?, V> as(Function<V1, V> transformer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    SearchProjection<?>[] toProjectionArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
