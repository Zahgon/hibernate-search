/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.projection.dsl.impl;

import java.util.function.BiFunction;
import org.hibernate.search.engine.search.projection.SearchProjection;
import org.hibernate.search.engine.search.projection.dsl.CompositeProjectionFrom2AsStep;
import org.hibernate.search.engine.search.projection.dsl.CompositeProjectionValueStep;
import org.hibernate.search.engine.search.projection.spi.CompositeProjectionBuilder;
import org.hibernate.search.engine.search.spi.ResultsCompositor;

class CompositeProjectionFrom2AsStepImpl<V1, V2> extends AbstractCompositeProjectionFromAsStep implements CompositeProjectionFrom2AsStep<V1, V2> {

    final SearchProjection<V1> inner1;

    final SearchProjection<V2> inner2;

    public CompositeProjectionFrom2AsStepImpl(CompositeProjectionBuilder builder, SearchProjection<V1> inner1, SearchProjection<V2> inner2) {
        super(builder);
        this.inner1 = inner1;
        this.inner2 = inner2;
    }

    @Override
    public <V> CompositeProjectionValueStep<?, V> as(BiFunction<V1, V2, V> transformer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    SearchProjection<?>[] toProjectionArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
