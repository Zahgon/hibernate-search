/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.projection.spi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.search.engine.search.projection.ProjectionCollector;

/**
 * A {@link ProjectionCollector} that can accumulate any number of values into a {@link List},
 * and transforms that list into an arbitrary container on {@link #finish(List)}.
 *
 * @param <E> The type of extracted values to accumulate before being transformed.
 * @param <V> The type of values to accumulate obtained by transforming extracted values ({@code E}).
 * @param <R> The type of the final result containing values of type {@code V}.
 */
abstract class ListBasedProjectionCollector<E, V, R> implements ProjectionCollector<E, V, List<Object>, R> {

    ListBasedProjectionCollector() {
    }

    @Override
    public final String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final List<Object> createInitial() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final List<Object> accumulate(List<Object> accumulated, E value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final List<Object> accumulateAll(List<Object> accumulated, Collection<E> values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final int size(List<Object> accumulated) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("unchecked")
    public final E get(List<Object> accumulated, int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final List<Object> transform(List<Object> accumulated, int index, V transformed) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public final R finish(List<Object> accumulated) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract R doFinish(List<V> accumulated);
}
