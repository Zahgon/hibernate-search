/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.cfg.spi;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static java.time.temporal.ChronoField.YEAR;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.SignStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.hibernate.search.engine.logging.impl.FormattingLog;
import org.hibernate.search.engine.spatial.GeoPoint;
import org.hibernate.search.util.common.SearchException;
import org.hibernate.search.util.common.impl.TimeHelper;

public final class ParseUtils {

    // The DateTimeFormatter class does not expose a public constant for the ISO format, so we need to do it ourselves.
    public static final DateTimeFormatter ISO_YEAR = new DateTimeFormatterBuilder().// Accept "-1" instead of requiring -0001
    parseLenient().appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD).toFormatter(Locale.ROOT);

    // The DateTimeFormatter class does not expose a public constant for the ISO format, so we need to do it ourselves.
    public static final DateTimeFormatter ISO_YEAR_MONTH = new DateTimeFormatterBuilder().appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD).appendLiteral('-').appendValue(MONTH_OF_YEAR, 2).toFormatter(Locale.ROOT);

    // The DateTimeFormatter class does not expose a public constant for the ISO format, so we need to do it ourselves.
    public static final DateTimeFormatter ISO_MONTH_DAY = new DateTimeFormatterBuilder().appendLiteral("--").appendValue(MONTH_OF_YEAR, 2).appendLiteral('-').appendValue(DAY_OF_MONTH, 2).toFormatter(Locale.ROOT);

    private static final String GEO_POINT_SEPARATOR = ",\\s*";

    private ParseUtils() {
        // Private constructor, do not use
    }

    public static String parseString(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static char parseCharacter(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Boolean parseBoolean(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Integer parseInteger(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Long parseLong(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Byte parseByte(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Short parseShort(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Float parseFloat(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Double parseDouble(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static BigDecimal parseBigDecimal(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static BigInteger parseBigInteger(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Instant parseInstant(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static LocalDate parseLocalDate(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static LocalDateTime parseLocalDateTime(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static LocalTime parseLocalTime(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static OffsetDateTime parseOffsetDateTime(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static OffsetTime parseOffsetTime(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static ZonedDateTime parseZonedDateTime(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Year parseYear(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static YearMonth parseYearMonth(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static MonthDay parseMonthDay(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static ZoneId parseZoneId(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static ZoneOffset parseZoneOffset(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Period parsePeriod(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Duration parseDuration(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static UUID parseUUID(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <E extends Enum<E>> E parseEnum(Class<E> enumType, String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static GeoPoint parseGeoPoint(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> T parseDiscreteValues(T[] allowedValues, Function<T, String> stringRepresentationFunction, BiFunction<String, List<String>, RuntimeException> invalidValueFunction, String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static byte[] parseBytePrimitiveArray(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static float[] parseFloatPrimitiveArray(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static String[] arrayValues(String value) {
        if (value.startsWith("[") && value.endsWith("]")) {
            value = value.substring(1, value.length() - 1).trim();
        }
        return value.split("[,;\\s]+");
    }
}
