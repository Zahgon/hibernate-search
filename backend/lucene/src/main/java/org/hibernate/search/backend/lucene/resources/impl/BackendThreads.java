/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.resources.impl;

import org.hibernate.search.backend.lucene.cfg.spi.LuceneBackendSpiSettings;
import org.hibernate.search.backend.lucene.work.spi.LuceneWorkExecutorProvider;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.common.execution.spi.SimpleScheduledExecutor;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.environment.thread.spi.ThreadPoolProvider;
import org.hibernate.search.engine.environment.thread.spi.ThreadProvider;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.impl.Closer;

public class BackendThreads {

    private static final ConfigurationProperty<BeanReference<? extends LuceneWorkExecutorProvider>> BACKEND_WORK_EXECUTOR_PROVIDER = ConfigurationProperty.forKey(LuceneBackendSpiSettings.Radicals.BACKEND_WORK_EXECUTOR_PROVIDER).asBeanReference(LuceneWorkExecutorProvider.class).withDefault(LuceneBackendSpiSettings.Defaults.BACKEND_WORK_EXECUTOR_PROVIDER).build();

    private final String prefix;

    private ThreadPoolProvider threadPoolProvider;

    private SimpleScheduledExecutor writeExecutor;

    public BackendThreads(String prefix) {
        this.prefix = prefix;
    }

    public void onStart(ConfigurationPropertySource propertySource, BeanResolver beanResolver, ThreadPoolProvider threadPoolProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void onStop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ThreadProvider getThreadProvider() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SimpleScheduledExecutor getWriteExecutor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void checkStarted() {
        if (writeExecutor == null) {
            throw new AssertionFailure("Attempt to retrieve the executor or related information before the backend was started.");
        }
    }
}
