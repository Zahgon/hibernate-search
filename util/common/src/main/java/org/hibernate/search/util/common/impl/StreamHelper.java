/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.impl;

import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.hibernate.search.util.common.AssertionFailure;

public final class StreamHelper {

    private StreamHelper() {
    }

    @SuppressWarnings("unchecked")
    public static <T, E extends RuntimeException> Collector<T, ?, T> singleElement(Supplier<E> missingValueExceptionSupplier, Supplier<E> multipleValuesExceptionSupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T, K, U, M extends Map<K, U>> Collector<T, ?, M> toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper, Supplier<M> mapSupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T> BinaryOperator<T> throwingMerger() {
        return (u, v) -> {
            throw new AssertionFailure("Unexpected duplicate key: " + u);
        };
    }
}
