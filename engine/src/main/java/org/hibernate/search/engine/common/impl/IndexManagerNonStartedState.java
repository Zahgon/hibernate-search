/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.common.impl;

import org.hibernate.search.engine.backend.index.spi.IndexManagerImplementor;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.impl.ConfigurationPropertySourceExtractor;
import org.hibernate.search.engine.common.resources.spi.SavedState;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.reporting.spi.ContextualFailureCollector;
import org.hibernate.search.engine.reporting.spi.RootFailureCollector;
import org.hibernate.search.util.common.reporting.EventContext;

class IndexManagerNonStartedState {

    private final EventContext eventContext;

    private final ConfigurationPropertySourceExtractor propertySourceExtractor;

    private final IndexManagerImplementor indexManager;

    // created on pre-start
    private IndexManagerStartContextImpl startContext;

    private ContextualFailureCollector indexFailureCollector;

    IndexManagerNonStartedState(EventContext eventContext, ConfigurationPropertySourceExtractor propertySourceExtractor, IndexManagerImplementor indexManager) {
        this.eventContext = eventContext;
        this.propertySourceExtractor = propertySourceExtractor;
        this.indexManager = indexManager;
    }

    void closeOnFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void preStart(RootFailureCollector rootFailureCollector, BeanResolver beanResolver, ConfigurationPropertySource rootPropertySource, SavedState savedState) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    IndexManagerImplementor start() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
