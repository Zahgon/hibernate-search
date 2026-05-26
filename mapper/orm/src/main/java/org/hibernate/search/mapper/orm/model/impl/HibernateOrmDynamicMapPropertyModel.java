/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.model.impl;

import java.lang.annotation.Annotation;
import java.util.stream.Stream;
import org.hibernate.search.mapper.orm.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.model.spi.PojoPropertyModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;
import org.hibernate.search.util.common.reflect.spi.ValueReadHandle;

class HibernateOrmDynamicMapPropertyModel<T> implements PojoPropertyModel<T> {

    private final HibernateOrmBootstrapIntrospector introspector;

    private final HibernateOrmDynamicMapRawTypeModel holderTypeModel;

    private final String name;

    private final HibernateOrmBasicDynamicMapPropertyMetadata ormPropertyMetadata;

    private ValueReadHandle<T> handle;

    private PojoTypeModel<T> typeModel;

    HibernateOrmDynamicMapPropertyModel(HibernateOrmBootstrapIntrospector introspector, HibernateOrmDynamicMapRawTypeModel holderTypeModel, String name, HibernateOrmBasicDynamicMapPropertyMetadata ormPropertyMetadata) {
        this.introspector = introspector;
        this.holderTypeModel = holderTypeModel;
        this.name = name;
        this.ormPropertyMetadata = ormPropertyMetadata;
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
    // We will just trust ORM metadata on this one.
    @SuppressWarnings("unchecked")
    public PojoTypeModel<T> typeModel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    // We will just trust ORM metadata on this one.
    @SuppressWarnings("unchecked")
    public ValueReadHandle<T> handle() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
