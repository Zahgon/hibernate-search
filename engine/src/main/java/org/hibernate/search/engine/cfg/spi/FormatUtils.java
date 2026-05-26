/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.cfg.spi;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.hibernate.search.engine.spatial.GeoPoint;
import org.hibernate.search.util.common.annotation.Incubating;

@Incubating
public final class FormatUtils {

    private FormatUtils() {
    }

    public static String format(BigDecimal value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String format(BigInteger value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String format(Boolean value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String format(Byte value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String format(Double value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String format(Float value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String format(GeoPoint value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String format(Instant value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String format(Integer value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String format(LocalDate value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String format(LocalDateTime value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String format(LocalTime value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String format(Long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String format(MonthDay value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String format(OffsetDateTime value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String format(OffsetTime value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String format(Short value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String format(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String format(Year value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String format(YearMonth value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String format(ZonedDateTime value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
