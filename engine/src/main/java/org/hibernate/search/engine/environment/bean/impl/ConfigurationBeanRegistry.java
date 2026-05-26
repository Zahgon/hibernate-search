/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.environment.bean.impl;

import java.util.Map;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.logging.impl.EngineMiscLog;

final class ConfigurationBeanRegistry {

    private final Map<Class<?>, BeanReferenceRegistryForType<?>> explicitlyConfiguredBeans;

    ConfigurationBeanRegistry(Map<Class<?>, BeanReferenceRegistryForType<?>> explicitlyConfiguredBeans) {
        this.explicitlyConfiguredBeans = explicitlyConfiguredBeans;
    }

    public <T> BeanHolder<T> resolve(Class<T> typeReference, BeanResolver beanResolver) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <T> BeanHolder<T> resolve(Class<T> typeReference, String nameReference, BeanResolver beanResolver) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // We know the registry has the correct type, see BeanConfigurationContextImpl
    @SuppressWarnings("unchecked")
    public <T> BeanReferenceRegistryForType<T> explicitlyConfiguredBeans(Class<T> exposedType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
