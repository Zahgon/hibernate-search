/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.query.spi;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import org.hibernate.search.engine.logging.impl.QueryLog;
import org.hibernate.search.engine.search.aggregation.AggregationKey;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.engine.search.query.SearchResultTotal;

public class SimpleSearchResult<H> implements SearchResult<H> {

    private final SearchResultTotal resultTotal;

    private final List<H> hits;

    private final Map<AggregationKey<?>, ?> aggregationResults;

    private final Duration took;

    private final boolean timedOut;

    public SimpleSearchResult(SearchResultTotal resultTotal, List<H> hits, Map<AggregationKey<?>, ?> aggregationResults, Duration took, Boolean timedOut) {
        this.resultTotal = resultTotal;
        this.hits = hits;
        this.aggregationResults = aggregationResults;
        this.took = took;
        this.timedOut = (timedOut != null) && timedOut;
    }

    @Override
    public SearchResultTotal total() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<H> hits() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    // The type of aggregation results must be consistent with the type of keys, by contract
    @SuppressWarnings("unchecked")
    public <T> T aggregation(AggregationKey<T> key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Duration took() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean timedOut() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
