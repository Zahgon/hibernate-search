/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.spi;

import java.util.function.Function;
import org.hibernate.search.util.common.annotation.Incubating;

@Incubating
final class SingleValuedResultsCompositor<P1, V> implements ResultsCompositor<Object, V> {

    private final Function<P1, V> transformer;

    SingleValuedResultsCompositor(Function<P1, V> transformer) {
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
