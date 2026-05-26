/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.timeout.spi;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.hibernate.search.engine.common.timing.Deadline;
import org.hibernate.search.engine.common.timing.spi.TimingSource;
import org.hibernate.search.engine.logging.impl.QueryLog;
import org.hibernate.search.util.common.SearchTimeoutException;
import org.hibernate.search.util.common.impl.TimeHelper;

/**
 * @author Emmanuel Bernard
 */
public class TimeoutManager {

    public static TimeoutManager of(TimingSource timingSource, Long timeout, TimeUnit timeUnit, boolean exceptionOnTimeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static TimeoutManager noTimeout(TimingSource timingSource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static TimeoutManager softTimeout(TimingSource timingSource, long timeout, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static TimeoutManager hardTimeout(TimingSource timingSource, long timeout, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public enum Type {

        NONE, EXCEPTION, LIMIT
    }

    protected final TimingSource timingSource;

    protected final Long timeoutValue;

    protected final TimeUnit timeoutUnit;

    protected final Long timeoutMs;

    protected final Type type;

    private final DynamicDeadline deadline;

    private Long monotonicTimeEstimateStart;

    private Long nanoTimeStart;

    public TimeoutManager(TimingSource timingSource, Long timeoutValue, TimeUnit timeoutUnit, Type type) {
        this.timingSource = timingSource;
        this.timeoutValue = timeoutValue;
        this.timeoutUnit = timeoutUnit;
        this.timeoutMs = TimeHelper.toMillisecondsRoundedUp(timeoutValue, timeoutUnit);
        this.type = type;
        this.deadline = timeoutMs == null ? null : new DynamicDeadline();
        if (requireMonotonicTimeEstimate()) {
            timingSource.ensureTimeEstimateIsInitialized();
        }
    }

    /**
     * we start counting from this method call (if needed)
     */
    public void start() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void stop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public TimingSource timingSource() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The deadline for the timeout defined by this timeout manager,
     * {@code null} if no timeout is set.
     */
    public Deadline deadlineOrNull() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The hard deadline defined by this timeout manager,
     * i.e. the deadline beyond which an exception should be thrown.
     * {@code null} if no hard timeout is set.
     */
    public Deadline hardDeadlineOrNull() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long timeoutBaseline() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return {@code true} if the timeout was reached in a previous call to {@link #checkTimedOut()},
     * {@code false} otherwise.
     */
    public boolean isTimedOut() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return {@code true} if the timeout was reached, {@code false} otherwise.
     * @throws org.hibernate.search.util.common.SearchTimeoutException If the timeout was reached and
     * a hard timeout was requested.
     */
    public boolean checkTimedOut() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean hasHardTimeout() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the time passed from the start with high precision.
     * This method may be performance expensive.
     *
     * @return high precision duration of took time.
     */
    public Duration tookTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected long elapsedTimeEstimateMillis() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean requireMonotonicTimeEstimate() {
        return !Type.NONE.equals(type);
    }

    final class DynamicDeadline implements Deadline {

        boolean timedOut = false;

        @Override
        public long checkRemainingTimeMillis() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void forceTimeout(Exception cause) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchTimeoutException forceTimeoutAndCreateException(Exception cause) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
