/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.environment.bean;

import org.hibernate.search.util.common.impl.Contracts;

final class InstanceBeanReference<T> implements BeanReference<T> {

    private final T instance;

    InstanceBeanReference(T instance) {
        Contracts.assertNotNull(instance, "instance");
        this.instance = instance;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BeanHolder<T> resolve(BeanResolver beanResolver) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    // Checked using reflection
    @SuppressWarnings("unchecked")
    public <U> BeanReference<? extends U> asSubTypeOf(Class<U> expectedType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
