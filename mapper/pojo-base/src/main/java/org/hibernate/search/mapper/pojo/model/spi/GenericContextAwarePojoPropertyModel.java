/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.spi;

import java.lang.annotation.Annotation;
import java.util.stream.Stream;
import org.hibernate.search.util.common.reflect.spi.ValueReadHandle;

final class GenericContextAwarePojoPropertyModel<T> implements PojoPropertyModel<T> {

    private final PojoPropertyModel<? super T> rawPropertyModel;

    private final GenericContextAwarePojoGenericTypeModel<T> genericPropertyTypeModel;

    GenericContextAwarePojoPropertyModel(PojoPropertyModel<? super T> rawPropertyModel, GenericContextAwarePojoGenericTypeModel<T> genericPropertyTypeModel) {
        this.rawPropertyModel = rawPropertyModel;
        this.genericPropertyTypeModel = genericPropertyTypeModel;
    }

    @Override
    public String name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Stream<Annotation> annotations() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoTypeModel<T> typeModel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    // We know that, in the current generic context, this cast is legal
    @SuppressWarnings("unchecked")
    public ValueReadHandle<T> handle() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
