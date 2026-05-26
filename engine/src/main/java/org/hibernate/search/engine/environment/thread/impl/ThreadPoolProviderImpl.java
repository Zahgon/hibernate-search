/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.environment.thread.impl;

import static org.hibernate.search.engine.logging.impl.EngineMiscLog.INSTANCE;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.thread.spi.ThreadPoolProvider;
import org.hibernate.search.engine.environment.thread.spi.ThreadProvider;
import org.hibernate.search.util.common.impl.Closer;

/**
 * Helper to create threads and executors.
 *
 * @author Sanne Grinovero
 */
public class ThreadPoolProviderImpl implements ThreadPoolProvider {

    private static final int QUEUE_MAX_LENGTH = 1000;

    private final BeanHolder<? extends ThreadProvider> threadProviderHolder;

    public ThreadPoolProviderImpl(BeanHolder<? extends ThreadProvider> threadProviderHolder) {
        this.threadProviderHolder = threadProviderHolder;
    }

    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ThreadProvider threadProvider() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ThreadPoolExecutor newFixedThreadPool(int threads, String threadNamePrefix) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ThreadPoolExecutor newFixedThreadPool(int threads, String threadNamePrefix, int queueSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ScheduledExecutorService newScheduledExecutor(int threads, String threadNamePrefix) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isScheduledExecutorBlocking() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A handler for rejected tasks that will have the caller block until space is available.
     */
    public static class BlockPolicy implements RejectedExecutionHandler {

        /**
         * Puts the Runnable to the blocking queue, effectively blocking the delegating thread until space is available.
         *
         * @param r the runnable task requested to be executed
         * @param e the executor attempting to execute this task
         */
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
