/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.projection.spi;

import java.util.function.Function;

@SuppressWarnings({ "deprecation", "removal" })
@Deprecated(since = "8.1", forRemoval = true)
final class SingleValuedProjectionCompositor<P1, V> implements ProjectionCompositor<Object, V> {

    private final Function<P1, V> transformer;

    SingleValuedProjectionCompositor(Function<P1, V> transformer) {
        this.transformer = transformer;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public P1 createInitial() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object set(Object components, int index, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object get(Object components, int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @Override
    public V finish(Object components) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
