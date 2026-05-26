/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.common.resources.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import org.hibernate.search.engine.environment.thread.spi.ThreadPoolProvider;
import org.hibernate.search.util.common.impl.Closer;

public class EngineThreads {

    private final ThreadPoolProvider threadPoolProvider;

    private ScheduledExecutorService timingExecutor;

    public EngineThreads(ThreadPoolProvider threadPoolProvider) {
        this.threadPoolProvider = threadPoolProvider;
    }

    public void onStop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ScheduledExecutorService getTimingExecutor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
