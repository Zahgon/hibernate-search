/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.concurrent.TimeUnit;

/**
 * Helpers for classes in java.time.*
 */
public final class TimeHelper {

    private static final int NANOS_PER_MILLI = 1_000_000;

    private TimeHelper() {
        // not allowed
    }

    /**
     * Workaround for https://bugs.openjdk.java.net/browse/JDK-8066982,
     * which at the moment has only been solved for JDK9.
     *
     * <p>Tested against TCKDTFParsedInstant in
     * http://hg.openjdk.java.net/jdk9/dev/jdk/rev/f371bdfb7875
     * with both JDK8b101 and JDK9 (early access - build 137).
     *
     * @param value The value to be parsed
     * @param formatter The formatter to use when parsing
     * @return The parsed {@link ZonedDateTime}
     */
    public static ZonedDateTime parseZoneDateTime(String value, DateTimeFormatter formatter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts in milliseconds a time duration expressed with {@code time} and {@code timeUnit}.
     * The result value is rounded up.
     * If either of the parameters is null, it will return null.
     *
     * @param time a time duration
     * @param timeUnit the time unit used to express the duration
     * @return rounded up duration in milliseconds
     */
    public static Long toMillisecondsRoundedUp(Long time, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
