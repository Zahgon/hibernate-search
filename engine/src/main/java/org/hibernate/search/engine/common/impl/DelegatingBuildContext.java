/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.common.impl;

import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.common.resources.impl.EngineThreads;
import org.hibernate.search.engine.common.timing.spi.TimingSource;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.environment.classpath.spi.ClassResolver;
import org.hibernate.search.engine.environment.classpath.spi.ResourceResolver;
import org.hibernate.search.engine.environment.thread.spi.ThreadPoolProvider;
import org.hibernate.search.engine.reporting.FailureHandler;

class DelegatingBuildContext {

    private final RootBuildContext delegate;

    DelegatingBuildContext(RootBuildContext delegate) {
        this.delegate = delegate;
    }

    public ClassResolver classResolver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ResourceResolver resourceResolver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BeanResolver beanResolver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ConfigurationPropertySource configurationPropertySource() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ThreadPoolProvider threadPoolProvider() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public FailureHandler failureHandler() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public EngineThreads engineThreads() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public TimingSource timingSource() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
