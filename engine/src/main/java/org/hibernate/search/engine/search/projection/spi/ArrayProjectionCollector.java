/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.projection.spi;

import java.lang.reflect.Array;
import java.util.List;
import org.hibernate.search.engine.search.projection.ProjectionCollector;

/**
 * A {@link ProjectionCollector} that can accumulate any number of values into a {@code V[]}.
 *
 * @param <E> The type of extracted values to accumulate before being transformed.
 * @param <V> The type of values to accumulate obtained by transforming extracted values ({@code E}).
 */
final class ArrayProjectionCollector<E, V> extends ListBasedProjectionCollector<E, V, V[]> {

    static <U, R> Provider<U, R> provider(Class<? super U> elementType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private ArrayProjectionCollector(Class<? super V> elementType) {
        this.elementType = elementType;
    }

    private final Class<? super V> elementType;

    @SuppressWarnings("unchecked")
    @Override
    public V[] doFinish(List<V> accumulated) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    private static class ArrayProvider<U, R> implements Provider<U, R> {

        private final ArrayProjectionCollector<?, U> instance;

        private ArrayProvider(Class<? super U> elementType) {
            instance = new ArrayProjectionCollector<>(elementType);
        }

        @Override
        public <T> ProjectionCollector<T, U, ?, R> get() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean isSingleValued() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
