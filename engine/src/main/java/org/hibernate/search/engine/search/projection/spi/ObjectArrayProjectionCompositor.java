/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.projection.spi;

@SuppressWarnings({ "deprecation", "removal" })
@Deprecated(since = "8.1", forRemoval = true)
abstract class ObjectArrayProjectionCompositor<V> implements ProjectionCompositor<Object[], V> {

    private final int size;

    ObjectArrayProjectionCompositor(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract Object transformer();

    @Override
    public Object[] createInitial() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object[] set(Object[] components, int index, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object get(Object[] components, int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public abstract V finish(Object[] components);
}
