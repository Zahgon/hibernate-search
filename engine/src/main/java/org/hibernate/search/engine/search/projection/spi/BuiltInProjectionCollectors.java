/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.projection.spi;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.Function;
import org.hibernate.search.engine.search.projection.ProjectionCollector;

/**
 * Provides access to built-in projection collectors.
 */
public interface BuiltInProjectionCollectors {

    // PROVIDER works for any V.
    @SuppressWarnings("unchecked")
    static <V> ProjectionCollector.Provider<V, V> nullable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // PROVIDER works for any V.
    @SuppressWarnings("unchecked")
    static <V> ProjectionCollector.Provider<V, List<V>> list() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <V, C> ProjectionCollector.Provider<V, C> simple(Function<List<V>, C> converter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <V> ProjectionCollector.Provider<V, V[]> array(Class<? super V> componentType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // PROVIDER works for any V.
    @SuppressWarnings("unchecked")
    static <V> ProjectionCollector.Provider<V, Set<V>> set() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // PROVIDER works for any V.
    @SuppressWarnings("unchecked")
    static <V> ProjectionCollector.Provider<V, SortedSet<V>> sortedSet() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <V> ProjectionCollector.Provider<V, SortedSet<V>> sortedSet(Comparator<? super V> comparator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // PROVIDER works for any V.
    @SuppressWarnings("unchecked")
    static <V> ProjectionCollector.Provider<V, Optional<V>> optional() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
