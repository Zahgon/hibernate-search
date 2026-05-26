/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.projection.spi;

import org.hibernate.search.engine.backend.types.converter.FromDocumentValueConverter;
import org.hibernate.search.engine.backend.types.converter.runtime.FromDocumentValueConvertContext;
import org.hibernate.search.engine.logging.impl.QueryLog;
import org.hibernate.search.engine.search.projection.ProjectionCollector;

/**
 * A {@link ProjectionCollector} that can accumulate up to one value, and will throw an exception beyond that.
 *
 * @param <E> The type of extracted values to accumulate before being transformed.
 * @param <V> The type of values to accumulate obtained by transforming extracted values ({@code E}).
 */
abstract class BaseSingleValuedProjectionCollector<E, V, R> implements ProjectionCollector<E, V, Object, R> {

    protected BaseSingleValuedProjectionCollector() {
    }

    @Override
    public final String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final E createInitial() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final E accumulate(Object accumulated, E value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final int size(Object accumulated) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("unchecked")
    public final E get(Object accumulated, int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Object transform(Object accumulated, int index, V transformed) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("unchecked")
    public final Object transformAll(Object accumulated, FromDocumentValueConverter<? super E, ? extends V> converter, FromDocumentValueConvertContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
