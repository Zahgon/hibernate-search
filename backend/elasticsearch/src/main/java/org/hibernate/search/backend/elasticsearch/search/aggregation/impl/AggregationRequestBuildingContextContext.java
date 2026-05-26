/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.aggregation.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.util.common.annotation.Incubating;

/**
 * Sometimes we need to pass something we created while building up the json in one of the "doRequest" methods
 * in the aggregation build up to the "later" steps e.g. to when we create the extractor.
 */
@Incubating
public final class AggregationRequestBuildingContextContext implements AggregationRequestContext {

    private final AggregationRequestContext aggregationRequestContext;

    private final Map<Key<?>, Object> buildingContext = new HashMap<>();

    public AggregationRequestBuildingContextContext(AggregationRequestContext aggregationRequestContext) {
        this.aggregationRequestContext = aggregationRequestContext;
    }

    public <T> T get(Key<T> key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void add(Key<?> key, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PredicateRequestContext getRootPredicateContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isRootContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <V> Key<V> buildingContextKey(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Key<V> {

        private final String name;

        private Key(String name) {
            this.name = name;
        }

        @SuppressWarnings("unchecked")
        private V cast(Object value) {
            return (V) value;
        }

        @Override
        public boolean equals(Object o) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
