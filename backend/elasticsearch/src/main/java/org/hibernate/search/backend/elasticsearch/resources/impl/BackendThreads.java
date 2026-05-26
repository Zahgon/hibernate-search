/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.resources.impl;

import org.hibernate.search.backend.elasticsearch.cfg.spi.ElasticsearchBackendSpiSettings;
import org.hibernate.search.backend.elasticsearch.work.spi.ElasticsearchWorkExecutorProvider;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.common.execution.spi.SimpleScheduledExecutor;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.environment.thread.spi.ThreadPoolProvider;
import org.hibernate.search.engine.environment.thread.spi.ThreadProvider;
import org.hibernate.search.util.common.AssertionFailure;

public class BackendThreads {

    private static final ConfigurationProperty<BeanReference<? extends ElasticsearchWorkExecutorProvider>> BACKEND_WORK_EXECUTOR_PROVIDER = ConfigurationProperty.forKey(ElasticsearchBackendSpiSettings.Radicals.BACKEND_WORK_EXECUTOR_PROVIDER).asBeanReference(ElasticsearchWorkExecutorProvider.class).withDefault(ElasticsearchBackendSpiSettings.Defaults.BACKEND_WORK_EXECUTOR_PROVIDER).build();

    private final String prefix;

    private ThreadPoolProvider threadPoolProvider;

    private SimpleScheduledExecutor workExecutor;

    public BackendThreads(String prefix) {
        this.prefix = prefix;
    }

    public void onStart(ConfigurationPropertySource propertySource, BeanResolver beanResolver, ThreadPoolProvider threadPoolProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void onStop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getPrefix() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ThreadProvider getThreadProvider() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SimpleScheduledExecutor getWorkExecutor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void checkStarted() {
        if (workExecutor == null) {
            throw new AssertionFailure("Attempt to retrieve the executor or related information before the backend was started.");
        }
    }
}
