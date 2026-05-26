/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.impl;

import org.hibernate.search.mapper.pojo.model.PojoModelValue;
import org.hibernate.search.mapper.pojo.model.spi.PojoBootstrapIntrospector;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;

/**
 * @param <T> The type used as a root element.
 */
public class PojoModelValueElement<T> implements PojoModelValue<T> {

    private final PojoBootstrapIntrospector introspector;

    private final PojoTypeModel<? extends T> typeModel;

    public PojoModelValueElement(PojoBootstrapIntrospector introspector, PojoTypeModel<? extends T> typeModel) {
        this.introspector = introspector;
        this.typeModel = typeModel;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isAssignableTo(Class<?> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Class<?> rawType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PojoTypeModel<? extends T> typeModel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
