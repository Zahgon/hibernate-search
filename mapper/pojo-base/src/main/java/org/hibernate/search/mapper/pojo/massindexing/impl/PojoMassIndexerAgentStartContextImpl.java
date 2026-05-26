/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.massindexing.impl;

import java.util.concurrent.ScheduledExecutorService;
import org.hibernate.search.engine.environment.thread.spi.ThreadPoolProvider;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexerAgentStartContext;

class PojoMassIndexerAgentStartContextImpl implements PojoMassIndexerAgentStartContext {

    private final ThreadPoolProvider threadPoolProvider;

    private final FailureHandler failureHandler;

    private ScheduledExecutorService scheduledExecutorService;

    PojoMassIndexerAgentStartContextImpl(ThreadPoolProvider threadPoolProvider, FailureHandler failureHandler) {
        this.threadPoolProvider = threadPoolProvider;
        this.failureHandler = failureHandler;
    }

    @Override
    public ScheduledExecutorService scheduledExecutor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FailureHandler failureHandler() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void clear() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
