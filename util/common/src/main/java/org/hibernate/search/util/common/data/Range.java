/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.data;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import org.hibernate.search.util.common.impl.Contracts;

/**
 * A representation of a range that can be used with any type.
 * <p>
 * Because there are no restrictions on type of values that can be used with this {@link Range} class,
 * it is not able to "understand" values that are passed to its various factory methods.
 * As a result, only minimal consistency checks are performed: null-checks, mostly.
 * In particular, <strong>this class does not check that the lower bound is actually lower than the upper bound</strong>,
 * because it has no idea what ordering to use.
 * Checking the relative order of bounds is the responsibility of callers of the {@link #lowerBoundValue()}
 * and {@link #upperBoundValue()} methods.
 *
 * @param <T> The type of values in this range.
 */
public final class Range<T> {

    /**
     * Create a canonical range, i.e. a range in the form
     * {@code [lowerBoundValue, upperBoundValue)} (lower bound included, upper bound excluded),
     * or {@code [lowerBoundValue, +Infinity]} (both bounds included) if the upper bound is {@code +Infinity}.
     * <p>
     * This is mostly useful when creating multiple, contiguous ranges,
     * like for example in range aggregations.
     *
     * @param lowerBoundValue The lower bound of the range.
     * May be {@code null} to represent {@code -Infinity} (no lower bound),
     * @param upperBoundValue The upper bound of the range.
     * May be {@code null} to represent {@code +Infinity} (no upper bound).
     * @param <T> The type of range bounds.
     * @return The range {@code [lowerBoundValue, upperBoundValue)} (lower bound included, upper bound excluded),
     * or {@code [lowerBoundValue, +Infinity]} (both bounds included) if the upper bound is {@code +Infinity}.
     */
    public static <T> Range<T> canonical(T lowerBoundValue, T upperBoundValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param <T> The type of range bounds.
     * @return The range {@code [-Infinity, +Infinity]} (both bounds included).
     */
    public static <T> Range<T> all() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param lowerBoundValue The lower bound of the range.
     * May be {@code null} to represent {@code -Infinity} (no lower bound),
     * @param upperBoundValue The upper bound of the range.
     * May be {@code null} to represent {@code +Infinity} (no upper bound).
     * @param <T> The type of range bounds.
     * @return The range {@code [lowerBoundValue, upperBoundValue]} (both bounds included).
     */
    public static <T> Range<T> between(T lowerBoundValue, T upperBoundValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param lowerBoundValue The value of the lower bound of the range.
     * May be {@code null} to represent {@code -Infinity} (no lower bound).
     * @param lowerBoundInclusion Whether the lower bound is included in the range or excluded.
     * @param upperBoundValue The value of the upper bound of the range.
     * May be {@code null} to represent {@code +Infinity} (no upper bound).
     * @param upperBoundInclusion Whether the upper bound is included in the range or excluded.
     * @param <T> The type of range bounds.
     * @return A {@link Range}.
     */
    public static <T> Range<T> between(T lowerBoundValue, RangeBoundInclusion lowerBoundInclusion, T upperBoundValue, RangeBoundInclusion upperBoundInclusion) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param lowerBoundValue The value of the lower bound of the range. Must not be {@code null}.
     * @param <T> The type of range bounds.
     * @return The range {@code [lowerBoundValue, +Infinity]} (both bounds included).
     */
    public static <T> Range<T> atLeast(T lowerBoundValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param lowerBoundValue The value of the lower bound of the range. Must not be {@code null}.
     * @param <T> The type of range bounds.
     * @return The range {@code (lowerBoundValue, +Infinity]} (lower bound excluded, upper bound included).
     */
    public static <T> Range<T> greaterThan(T lowerBoundValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param upperBoundValue The value of the upper bound of the range. Must not be {@code null}.
     * @param <T> The type of range bounds.
     * @return The range {@code [-Infinity, upperBoundValue]} (both bounds included).
     */
    public static <T> Range<T> atMost(T upperBoundValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param upperBoundValue The value of the upper bound of the range. Must not be {@code null}.
     * @param <T> The type of range bounds.
     * @return The range {@code [-Infinity, upperBoundValue)} (lower bound included, upper bound excluded).
     */
    public static <T> Range<T> lessThan(T upperBoundValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final Optional<T> lowerBoundValue;

    private final RangeBoundInclusion lowerBoundInclusion;

    private final Optional<T> upperBoundValue;

    private final RangeBoundInclusion upperBoundInclusion;

    private Range(T lowerBoundValue, RangeBoundInclusion lowerBoundInclusion, T upperBoundValue, RangeBoundInclusion upperBoundInclusion) {
        Contracts.assertNotNull(lowerBoundInclusion, "lowerBoundInclusion");
        Contracts.assertNotNull(upperBoundInclusion, "upperBoundInclusion");
        this.lowerBoundValue = Optional.ofNullable(lowerBoundValue);
        this.lowerBoundInclusion = lowerBoundInclusion;
        this.upperBoundValue = Optional.ofNullable(upperBoundValue);
        this.upperBoundInclusion = upperBoundInclusion;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The value of the lower bound, or an empty optional to represent {-Infinity} (no lower bound).
     */
    public Optional<T> lowerBoundValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return Whether the lower bound is included in the range or excluded.
     * Always {@link RangeBoundInclusion#EXCLUDED} if there is no lower bound.
     */
    public RangeBoundInclusion lowerBoundInclusion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The value of the lower bound, or an empty optional to represent {+Infinity} (no upper bound).
     */
    public Optional<T> upperBoundValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return Whether the upper bound is included in the range or excluded.
     * Always {@link RangeBoundInclusion#EXCLUDED} if there is no upper bound.
     */
    public RangeBoundInclusion upperBoundInclusion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <R> Range<R> map(Function<? super T, ? extends R> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
