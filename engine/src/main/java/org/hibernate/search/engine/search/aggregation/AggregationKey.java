/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.aggregation;

import java.util.Objects;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.util.common.impl.Contracts;

/**
 * A key allowing to retrieve an aggregation from the search result.
 *
 * @param <A> The type of result for this aggregation.
 *
 * @see SearchResult#aggregation(AggregationKey)
 */
public final class AggregationKey<A> {

    /**
     * @param name The name of the aggregation. All root aggregation names must be unique within a single query.
     * @param <A> The type of result for this aggregation.
     * @return A new aggregation key.
     */
    public static <A> AggregationKey<A> of(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final String name;

    private AggregationKey(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The name passed to {@link #of(String)}.
     */
    public String name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
