/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.spi;

import java.util.Objects;
import org.hibernate.search.util.common.impl.Contracts;

/**
 * An identifier for POJO types.
 * <p>
 * On contrary to type models, type identifiers can be manipulated at runtime (after bootstrap),
 * but they do not provide any reflection capabilities.
 *
 * @see PojoRawTypeModel
 */
public final class PojoRawTypeIdentifier<T> {

    public static <T> PojoRawTypeIdentifier<T> of(Class<T> javaClass) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> PojoRawTypeIdentifier<T> of(Class<T> javaClass, String label) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final Class<T> javaClass;

    private final String name;

    private PojoRawTypeIdentifier(Class<T> javaClass, String name) {
        Contracts.assertNotNull(javaClass, "javaClass");
        this.javaClass = javaClass;
        this.name = name;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The exact Java {@link Class} for this type.
     */
    public Class<T> javaClass() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isNamed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
