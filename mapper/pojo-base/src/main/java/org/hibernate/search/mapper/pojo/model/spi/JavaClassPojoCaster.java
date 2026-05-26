/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.spi;

public final class JavaClassPojoCaster<T> implements PojoCaster<T> {

    private final Class<T> clazz;

    public JavaClassPojoCaster(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T cast(Object object) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T castOrNull(Object object) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
