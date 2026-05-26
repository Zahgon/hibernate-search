/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.bootstrap.impl;

import org.hibernate.resource.beans.container.spi.BeanContainer;
import org.hibernate.resource.beans.container.spi.ContainedBean;
import org.hibernate.resource.beans.spi.BeanInstanceProducer;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.spi.BeanProvider;
import org.hibernate.search.mapper.orm.logging.impl.ConfigurationLog;
import org.hibernate.search.util.common.impl.Contracts;
import org.hibernate.search.util.common.impl.SuppressingCloser;

/**
 * A {@link BeanProvider} relying on a Hibernate ORM {@link BeanContainer} to resolve beans.
 */
final class HibernateOrmBeanContainerBeanProvider implements BeanProvider {

    private static final BeanContainer.LifecycleOptions LIFECYCLE_OPTIONS = new BeanContainer.LifecycleOptions() {

        @Override
        public boolean canUseCachedReferences() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean useJpaCompliantCreation() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    private final BeanContainer beanContainer;

    private final BeanInstanceProducer fallbackInstanceProducer;

    HibernateOrmBeanContainerBeanProvider(BeanContainer beanContainer) {
        Contracts.assertNotNull(beanContainer, "beanContainer");
        this.beanContainer = beanContainer;
        this.fallbackInstanceProducer = new BeanInstanceProducer() {

            @Override
            public <B> B produceBeanInstance(Class<B> aClass) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public <B> B produceBeanInstance(String s, Class<B> aClass) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        };
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> BeanHolder<T> forType(Class<T> typeReference) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> BeanHolder<T> forTypeAndName(Class<T> typeReference, String nameReference) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
