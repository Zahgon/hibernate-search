/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.model.impl;

import java.util.Collection;
import java.util.Map;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.SyntheticPojoGenericTypeModel;

public interface HibernateOrmTypeModelFactory<T> {

    PojoTypeModel<T> create(HibernateOrmBootstrapIntrospector introspector);

    @SuppressWarnings("unchecked")
    static <T> HibernateOrmTypeModelFactory<T> entityReference(Class<T> javaClass, String entityName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> HibernateOrmTypeModelFactory<T> rawType(Class<T> javaClass) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // This cast is safe if the caller made sure that this name really points to a dynamic-map type
    @SuppressWarnings({ "unchecked", "rawtypes" })
    static HibernateOrmTypeModelFactory<Map> dynamicMap(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> HibernateOrmTypeModelFactory<T[]> array(HibernateOrmTypeModelFactory<T> elementType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <C extends Collection<?>> HibernateOrmTypeModelFactory<C> collection(Class<C> collectionType, HibernateOrmTypeModelFactory<?> elementType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <M extends Map<?, ?>> HibernateOrmTypeModelFactory<M> map(Class<M> mapType, HibernateOrmTypeModelFactory<?> keyType, HibernateOrmTypeModelFactory<?> valueType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
