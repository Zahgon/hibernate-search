/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.environment.bean.impl;

import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.spi.BeanProvider;
import org.hibernate.search.engine.logging.impl.EngineMiscLog;

public final class NoConfiguredBeanManagerBeanProvider implements BeanProvider {

    NoConfiguredBeanManagerBeanProvider() {
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
    public <T> BeanHolder<T> forTypeAndName(Class<T> typeReference, String implementationFullyQualifiedClassName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
