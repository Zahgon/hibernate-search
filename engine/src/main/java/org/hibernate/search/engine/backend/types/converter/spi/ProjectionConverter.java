/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.backend.types.converter.spi;

import org.hibernate.search.engine.backend.types.converter.FromDocumentValueConverter;
import org.hibernate.search.engine.backend.types.converter.runtime.FromDocumentValueConvertContext;
import org.hibernate.search.engine.backend.types.converter.runtime.FromDocumentValueConvertContextExtension;
import org.hibernate.search.engine.logging.impl.QueryLog;
import org.hibernate.search.util.common.impl.Contracts;
import org.hibernate.search.util.common.reporting.spi.EventContextProvider;

/**
 * A converter from a value obtained from the backend to a projected value.
 *
 * @param <F> The type of source values obtained from the backend.
 * @param <V> The type of projected values.
 */
public final class ProjectionConverter<F, V> {

    public static <F> ProjectionConverter<F, F> passThrough(Class<F> fieldAndValueType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final Class<V> valueType;

    private final FromDocumentValueConverter<? super F, V> delegate;

    public ProjectionConverter(Class<V> valueType, FromDocumentValueConverter<? super F, V> delegate) {
        Contracts.assertNotNull(valueType, "valueType");
        Contracts.assertNotNull(delegate, "delegate");
        this.valueType = valueType;
        this.delegate = delegate;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Class<V> valueType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param value The index field value to convert.
     * @param context A context that can be
     * {@link FromDocumentValueConvertContext#extension(FromDocumentValueConvertContextExtension) extended}
     * to a more useful type, giving access to such things as a Hibernate ORM Session (if using the Hibernate ORM mapper).
     * @return The converted value.
     */
    public V fromDocumentValue(F value, FromDocumentValueConvertContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Check whether projected values can be assigned to the given type,
     * and returns the projection converter with an appropriate type.
     *
     * @param expectedType A candidate type for assignment of converted values.
     * @param eventContextProvider A provider for the event context to pass to produced exceptions.
     * @return The projection converter, guaranteed to convert values to the given type.
     * @throws org.hibernate.search.util.common.SearchException If the projection converter cannot convert values to the given type.
     * @param <T> A candidate type for assignment of converted values.
     */
    // We check the cast is legal through reflection
    @SuppressWarnings("unchecked")
    public <T> ProjectionConverter<F, ? extends T> withConvertedType(Class<T> expectedType, EventContextProvider eventContextProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param other Another {@link DslConverter}, never {@code null}.
     * @return {@code true} if the given object behaves exactly the same as this object,
     * i.e. its {@link #withConvertedType(Class, EventContextProvider)} and {@link #fromDocumentValue(Object, FromDocumentValueConvertContext)}
     * methods are guaranteed to always return the same value as this object's
     * when given the same input. {@code false} otherwise, or when in doubt.
     */
    public boolean isCompatibleWith(ProjectionConverter<?, ?> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The document value converter that is backing up this converter.
     */
    public FromDocumentValueConverter<? super F, V> delegate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
