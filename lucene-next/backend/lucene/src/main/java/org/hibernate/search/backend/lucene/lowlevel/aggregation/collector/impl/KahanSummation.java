/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.aggregation.collector.impl;

import java.util.Locale;

/**
 * <p>
 * Copied with some changes from {@code org.opensearch.search.aggregations.metrics.CompensatedSum}
 * of <a href="https://opensearch.org/">OpenSearch</a>.
 */
public class KahanSummation {

    private static final double NO_CORRECTION = 0.0;

    private double value;

    private double delta;

    private boolean initialized;

    /**
     * Used to calculate sums using the Kahan summation algorithm.
     *
     * @param value the sum
     * @param delta correction term
     */
    public KahanSummation(double value, double delta) {
        this.value = value;
        this.delta = delta;
    }

    /**
     * The value of the sum.
     */
    public double value() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The correction term.
     */
    public double delta() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether anything was actually added to this sum or is the result is supposed to be `null`.
     */
    public boolean initialized() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Increments the Kahan sum by adding a value without a correction term.
     */
    public KahanSummation add(double value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Resets the internal state to use the new value and compensation delta
     */
    public void reset(double value, double delta) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Increments the Kahan sum by adding two sums, and updating the correction term for reducing numeric errors.
     */
    public KahanSummation add(double value, double delta) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
