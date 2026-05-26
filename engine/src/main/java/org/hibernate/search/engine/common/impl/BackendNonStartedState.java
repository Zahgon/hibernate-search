/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.common.impl;

import org.hibernate.search.engine.backend.spi.BackendImplementor;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.impl.ConfigurationPropertySourceExtractor;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.environment.thread.spi.ThreadPoolProvider;
import org.hibernate.search.engine.reporting.spi.ContextualFailureCollector;
import org.hibernate.search.engine.reporting.spi.RootFailureCollector;
import org.hibernate.search.util.common.reporting.EventContext;

class BackendNonStartedState {

    private final EventContext eventContext;

    private final ConfigurationPropertySourceExtractor propertySourceExtractor;

    private final BackendImplementor backend;

    BackendNonStartedState(EventContext eventContext, ConfigurationPropertySourceExtractor propertySourceExtractor, BackendImplementor backend) {
        this.eventContext = eventContext;
        this.propertySourceExtractor = propertySourceExtractor;
        this.backend = backend;
    }

    void closeOnFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    BackendImplementor start(RootFailureCollector rootFailureCollector, BeanResolver beanResolver, ConfigurationPropertySource rootPropertySource, ThreadPoolProvider threadPoolProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
