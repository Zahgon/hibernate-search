/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.reflect.impl;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Optional;
import org.hibernate.search.util.common.AssertionFailure;

public final class ReflectionUtils {

    private ReflectionUtils() {
    }

    public static Class<?> getRawType(Type type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Optional<Type> getArrayElementType(Type type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static Class<?> getArrayClass(Class<?> rawElementType) {
        // This is ugly, but apparently the only way to get an array type from an element type
        return Array.newInstance(rawElementType, 0).getClass();
    }
}
