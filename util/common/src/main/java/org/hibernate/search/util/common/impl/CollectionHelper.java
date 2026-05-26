/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Provides some methods for simplified collection instantiation.
 *
 * @author Gunnar Morling
 * @author Hardy Ferentschik
 */
public final class CollectionHelper {

    private CollectionHelper() {
    }

    public static <K, V> HashMap<K, V> newHashMap(int size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(int size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> HashSet<T> newHashSet(int size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> LinkedHashSet<T> newLinkedHashSet(int size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SafeVarargs
    public static <T> Set<T> asSet(T... ts) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SafeVarargs
    public static <T> Set<T> asSetIgnoreNull(T... ts) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SafeVarargs
    public static <T> Set<T> asLinkedHashSet(T... ts) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SafeVarargs
    public static <T> Set<T> asTreeSet(T... ts) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SafeVarargs
    public static <T> Set<T> asImmutableSet(T... items) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SafeVarargs
    public static <T> List<T> asList(T firstItem, T... otherItems) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SafeVarargs
    public static <T> List<T> asImmutableList(T... items) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> List<T> toImmutableList(List<? extends T> list) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Set<T> toImmutableSet(Set<? extends T> set) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <K, V> Map<K, V> toImmutableMap(Map<K, V> map) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Set<? extends T> flattenAsSet(Collection<? extends Collection<? extends T>> input) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * As the default loadFactor is of 0.75, we need to calculate the initial capacity from the expected size to avoid
     * resizing the collection when we populate the collection with all the initial elements. We use a calculation
     * similar to what is done in {@link HashMap#putAll(Map)}.
     *
     * @param expectedSize the expected size of the collection
     * @return the initial capacity of the collection
     */
    private static int getInitialCapacityFromExpectedSize(int expectedSize) {
        if (expectedSize < 3) {
            return expectedSize + 1;
        }
        return (int) (expectedSize / 0.75f + 1.0f);
    }

    /**
     * @return Whether all elements that are present in the first set are available in the second one.
     */
    public static <T> boolean isSubset(Set<T> subset, Set<T> superset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Set<T> notInTheOtherSet(Set<T> subset, Set<T> superset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
