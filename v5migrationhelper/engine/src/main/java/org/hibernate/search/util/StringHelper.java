/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Inspired from {@code org.hibernate.util.StringHelper}, but removing
 * most methods as they are not needed for Hibernate Search.
 *
 * @author Emmanuel Bernard
 * @author Sanne Grinovero
 * @deprecated Will be removed without replacement.
 */
@Deprecated
public final class StringHelper {

    private StringHelper() {
        /* static methods only - hide constructor */
    }

    public static boolean isNotEmpty(final String string) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static boolean isEmpty(final String string) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String qualify(final String prefix, final String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Joins the elements of the given array to a string, separated by the given separator string.
     *
     * @param array the array to join
     * @param separator the separator string
     *
     * @return a string made up of the string representations of the given array's members, separated by the given separator
     *         string
     */
    public static String join(Object[] array, String separator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Joins the elements of the given iterable to a string, separated by the given separator string.
     *
     * @param iterable the iterable to join
     * @param separator the separator string
     *
     * @return a string made up of the string representations of the given iterable members, separated by the given separator
     *         string
     */
    public static String join(Iterable<?> iterable, String separator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Joins the elements of the given iterator to a string, separated by the given separator string.
     *
     * @param iterator the iterator to join
     * @param separator the separator string
     *
     * @return a string made up of the string representations of the given iterator members, separated by the given separator
     *         string
     */
    public static String join(Iterator<?> iterator, String separator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
