/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.bootstrap.impl;

import org.hibernate.resource.beans.container.spi.ContainedBean;
import org.hibernate.resource.beans.container.spi.ContainedBeanImplementor;
import org.hibernate.search.engine.environment.bean.BeanHolder;

final class HibernateOrmContainedBeanBeanHolderAdapter<T> implements BeanHolder<T> {

    private final ContainedBean<T> containedBean;

    HibernateOrmContainedBeanBeanHolderAdapter(ContainedBean<T> containedBean) {
        this.containedBean = containedBean;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
