/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.common.impl;

import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.common.spi.SearchIntegration;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.environment.thread.spi.ThreadPoolProvider;
import org.hibernate.search.engine.mapper.mapping.spi.MappingStartContext;
import org.hibernate.search.engine.reporting.spi.ContextualFailureCollector;

class MappingStartContextImpl implements MappingStartContext {

    private final ContextualFailureCollector failureCollector;

    private final BeanResolver beanResolver;

    private final ConfigurationPropertySource configurationPropertySource;

    private final ThreadPoolProvider threadPoolProvider;

    private final SearchIntegration.Handle integrationHandle;

    MappingStartContextImpl(ContextualFailureCollector failureCollector, BeanResolver beanResolver, ConfigurationPropertySource configurationPropertySource, ThreadPoolProvider threadPoolProvider, SearchIntegration.Handle integrationHandle) {
        this.failureCollector = failureCollector;
        this.beanResolver = beanResolver;
        this.configurationPropertySource = configurationPropertySource;
        this.threadPoolProvider = threadPoolProvider;
        this.integrationHandle = integrationHandle;
    }

    @Override
    public ContextualFailureCollector failureCollector() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BeanResolver beanResolver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConfigurationPropertySource configurationPropertySource() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ThreadPoolProvider threadPoolProvider() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchIntegration.Handle integrationHandle() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
