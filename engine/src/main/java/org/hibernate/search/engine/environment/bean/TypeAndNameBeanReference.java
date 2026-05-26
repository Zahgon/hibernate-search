/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.environment.bean;

import org.hibernate.search.util.common.impl.Contracts;

final class TypeAndNameBeanReference<T> extends TypeBeanReference<T> {

    private final String name;

    TypeAndNameBeanReference(Class<T> type, String name, BeanRetrieval retrieval) {
        super(type, retrieval);
        Contracts.assertNotNullNorEmpty(name, "name");
        this.name = name;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BeanHolder<T> resolve(BeanResolver beanResolver) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
