/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.common.impl;

import java.util.Objects;
import org.hibernate.search.mapper.pojo.common.spi.PojoEntityReference;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;

/**
 * The (legacy) EntityReference implementation specific to the Hibernate ORM mapper.
 *
 * @deprecated Wherever possible, use {@link PojoEntityReference} instead.
 * This may not be possible everywhere due to backwards compatibility constraints.
 */
@Deprecated(since = "6.2")
public final class HibernateOrmEntityReference implements org.hibernate.search.mapper.orm.common.EntityReference {

    public static org.hibernate.search.mapper.orm.common.EntityReference withDefaultName(Class<?> type, Object id) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static org.hibernate.search.mapper.orm.common.EntityReference withName(Class<?> type, String name, Object id) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final PojoRawTypeIdentifier<?> typeIdentifier;

    private final String name;

    private final Object id;

    public HibernateOrmEntityReference(PojoRawTypeIdentifier<?> typeIdentifier, String name, Object id) {
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
