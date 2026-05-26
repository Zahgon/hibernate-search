/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.common.spi;

import java.util.Objects;
import org.hibernate.search.engine.common.EntityReference;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;

/**
 * A simple, default implementation for {@link EntityReference} for POJO-based mappers.
 * <p>
 * Should be used instead of custom implementations, whose support is going to be removed in the future.
 */
public final class PojoEntityReference implements EntityReference {

    public static EntityReference withDefaultName(Class<?> javaClass, Object id) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EntityReference withName(Class<?> javaClass, String entityName, Object id) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final PojoRawTypeIdentifier<?> typeIdentifier;

    private final String name;

    private final Object id;

    public PojoEntityReference(PojoRawTypeIdentifier<?> typeIdentifier, String name, Object id) {
        this.typeIdentifier = typeIdentifier;
        this.name = name;
        this.id = id;
    }

    @Override
    public Class<?> type() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object id() {
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

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
