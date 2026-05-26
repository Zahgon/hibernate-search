/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.model.impl;

import java.util.Map;
import java.util.Objects;
import org.hibernate.search.util.common.reflect.spi.ValueReadHandle;

final class HibernateOrmDynamicMapValueReadHandle<T> implements ValueReadHandle<T> {

    private final String name;

    private final Class<T> type;

    HibernateOrmDynamicMapValueReadHandle(String name, Class<T> type) {
        this.name = name;
        this.type = type;
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

    @Override
    public T get(Object thiz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
