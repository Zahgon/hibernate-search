/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.jakarta.batch.core.massindexing.util.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;
import java.util.Locale;
import java.util.Map;
import org.hibernate.CacheMode;
import org.hibernate.search.jakarta.batch.core.logging.impl.JakartaBatchLog;
import org.hibernate.search.mapper.orm.loading.spi.ConditionalExpression;
import org.hibernate.search.util.common.SearchException;
import org.hibernate.search.util.common.impl.StringHelper;

/**
 * @author Mincong Huang
 */
public final class SerializationUtil {

    private SerializationUtil() {
        // Private constructor, do not use it.
    }

    public static String serialize(Object object) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Object deserialize(String serialized) throws IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Given a parameter key-value pair, parses the value into boolean.
     * <p>
     * Only string literals "true" and "false" are allowed, where case is
     * ignored. Parsing any other value, such as {@code null}, "", "t", "f",
     * "0", "1", will lead to a parsing failure.
     *
     * @throws SearchException if the parsing fails.
     */
    public static boolean parseBooleanParameterOptional(String key, String value, boolean defaultValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static int parseIntegerParameter(String key, String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Integer parseIntegerParameterOptional(String key, String value, Integer defaultValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static CacheMode parseCacheModeParameter(String key, String value, CacheMode defaultValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T extends Enum<T>> T parseEnumParameter(Class<T> clazz, String key, String value, T defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        try {
            return Enum.valueOf(clazz, value);
        } catch (IllegalArgumentException e) {
            throw JakartaBatchLog.INSTANCE.unableToParseJobParameter(key, value, e.getMessage(), e);
        }
    }

    public static ConditionalExpression parseReindexOnlyParameters(String reindexOnlyHql, String serializedReindexOnlyParameters) throws IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
