/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.common.timing.impl;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.hibernate.search.engine.common.resources.impl.EngineThreads;
import org.hibernate.search.engine.common.timing.spi.TimingSource;

/**
 * Default implementation for a {@link TimingSource}
 *
 * @author Sanne Grinovero (C) 2012 Red Hat Inc.
 * @since 4.1
 */
public final class DefaultTimingSource implements TimingSource {

    private static final long INVALID_TIME = -1;

    private final EngineThreads threads;

    //lazily initialize it, so we don't start a thread for those who don't use timeouts
    //guarded by synchronization on this
    private ScheduledFuture<?> future;

    private volatile long currentTimeApproximation = INVALID_TIME;

    public DefaultTimingSource(EngineThreads threads) {
        this.threads = threads;
    }

    @Override
    public long monotonicTimeEstimate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void ensureTimeEstimateIsInitialized() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long nanoTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public synchronized void stop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class TriggerTask implements Runnable {

        @Override
        public void run() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static long currentTime() {
        return TimeUnit.MILLISECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }
}
