/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.query.spi;

import java.util.List;
import java.util.Optional;
import org.hibernate.search.engine.logging.impl.QueryLog;
import org.hibernate.search.engine.search.query.SearchQuery;
import org.hibernate.search.engine.search.query.SearchResult;

/**
 * An abstract base for implementations of {@link SearchQuery}.
 *
 * @param <H> The type of query hits.
 * @param <R> The result type (extending {@link SearchResult}).
 */
public abstract class AbstractSearchQuery<H, R extends SearchResult<H>> implements SearchQueryImplementor<H> {

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public R fetchAll() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public R fetch(Integer limit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public abstract R fetch(Integer offset, Integer limit);

    @Override
    public List<H> fetchAllHits() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<H> fetchHits(Integer limit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<H> fetchSingleHit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
