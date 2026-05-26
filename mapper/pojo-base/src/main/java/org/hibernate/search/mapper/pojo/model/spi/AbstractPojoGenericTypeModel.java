/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.spi;

/**
 * An abstract base for implementations of a {@link PojoTypeModel}
 * representing a type with generic type parameters.
 */
public abstract class AbstractPojoGenericTypeModel<T> implements PojoTypeModel<T> {

    private final PojoRawTypeModel<? super T> rawTypeModel;

    protected AbstractPojoGenericTypeModel(PojoRawTypeModel<? super T> rawTypeModel) {
        this.rawTypeModel = rawTypeModel;
    }

    @Override
    public final String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final PojoRawTypeModel<? super T> rawType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoPropertyModel<?> property(String propertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
