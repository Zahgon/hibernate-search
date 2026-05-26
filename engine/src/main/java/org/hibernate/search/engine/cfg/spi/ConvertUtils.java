/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.cfg.spi;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.logging.impl.FormattingLog;
import org.hibernate.search.util.common.SearchException;

public final class ConvertUtils {

    private ConvertUtils() {
        // Private constructor, do not use
    }

    /**
     * Convert a property value to a given class, either by casting it if possible
     * or by treating it as a string to be parsed.
     *
     * @param expectedType the expected type
     * @param parser a parser from String to the expected type
     * @param value the value to convert (a String)
     * @param <T> The type of the returned value.
     * @return the converted value
     * @throws SearchException for invalid values.
     */
    public static <T> T convert(Class<T> expectedType, Function<String, T> parser, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert a property value from String to boolean if necessary, allowing only either "true" or "false".
     *
     * @param value the value to convert (a Boolean, or a String to be parsed)
     * @return true if value is "true", false if value is "false"
     * @throws SearchException for invalid format or values.
     */
    public static Boolean convertBoolean(Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert a property value from String to int if necessary.
     *
     * @param value the value to convert (a Number, or a String to be parsed)
     * @return the converted integer
     * @throws SearchException for invalid format or values.
     */
    public static Integer convertInteger(Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert a property value from String to long if necessary.
     *
     * @param value the value to convert (a Number, or a String to be parsed)
     * @return the converted long
     * @throws SearchException for invalid format or values.
     */
    public static Long convertLong(Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert a property value from String to byte if necessary.
     *
     * @param value the value to convert (a Number, or a String to be parsed)
     * @return the converted byte
     * @throws SearchException for invalid format or values.
     */
    public static Byte convertByte(Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert a property value from String to short if necessary.
     *
     * @param value the value to convert (a Number, or a String to be parsed)
     * @return the converted short
     * @throws SearchException for invalid format or values.
     */
    public static Short convertShort(Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert a property value from String to float if necessary.
     *
     * @param value the value to convert (a Number, or a String to be parsed)
     * @return the converted float
     * @throws SearchException for invalid format or values.
     */
    public static Float convertFloat(Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert a property value from String to double if necessary.
     *
     * @param value the value to convert (a Number, or a String to be parsed)
     * @return the converted double
     * @throws SearchException for invalid format or values.
     */
    public static Double convertDouble(Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert a property value from String to BigDecimal if necessary.
     *
     * @param value the value to convert (a BigDecimal, a Number, or a String to be parsed)
     * @return the converted BigDecimal
     * @throws SearchException for invalid format or values.
     */
    public static BigDecimal convertBigDecimal(Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert a property value from String to BigInteger if necessary.
     *
     * @param value the value to convert (a BigInteger, a Number, or a String to be parsed)
     * @return the converted BigInteger
     * @throws SearchException for invalid format or values.
     */
    public static BigInteger convertBigInteger(Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> BeanReference<? extends T> convertBeanReference(Class<T> expectedType, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> List<T> convertMultiValue(Pattern separatorPattern, Function<Object, T> elementConverter, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Object trimIfString(Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
