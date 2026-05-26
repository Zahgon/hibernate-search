/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.common.timing.spi;

import java.time.Duration;
import org.hibernate.search.engine.common.timing.Deadline;
import org.hibernate.search.engine.logging.impl.QueryLog;
import org.hibernate.search.util.common.SearchTimeoutException;

public final class StaticDeadline implements Deadline {

    /**
     * @param milliseconds The number of milliseconds until the deadline.
     * @return An immutable {@link Deadline} which does not track the passing time.
     * {@link #checkRemainingTimeMillis()} will always return the same value
     * and will never throw an exception.
     */
    public static Deadline ofMilliseconds(long milliseconds) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final long remainingTimeMillis;

    private StaticDeadline(long remainingTimeMillis) {
        this.remainingTimeMillis = remainingTimeMillis;
    }

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
