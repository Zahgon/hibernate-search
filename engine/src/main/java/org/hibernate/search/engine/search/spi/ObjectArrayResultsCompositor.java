/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.spi;

import org.hibernate.search.util.common.annotation.Incubating;

@Incubating
abstract class ObjectArrayResultsCompositor<V> implements ResultsCompositor<Object[], V> {

    private final int size;

    ObjectArrayResultsCompositor(int size) {
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
