/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.impl;

import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.SearchException;

/**
 * Throwable-related utils.
 */
public final class Throwables {

    private Throwables() {
    }

    public static RuntimeException toRuntimeException(Throwable throwable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Exception expectException(Throwable throwable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T extends Throwable> T combine(T throwable, T otherThrowable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String getFirstNonNullMessage(Throwable t) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String safeToString(Throwable throwableBeingHandled, Object object) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static String safeArrayToString(Throwable throwableBeingHandled, Object[] array) {
        if (array == null) {
            return "null";
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                b.append(", ");
            }
            b.append(safeToString(throwableBeingHandled, array[i]));
        }
        b.append(']');
        return b.toString();
    }
}
