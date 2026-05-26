/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.query.impl;

import java.util.Set;
import org.hibernate.search.engine.backend.session.spi.BackendSessionContext;
import org.hibernate.search.engine.search.loading.spi.SearchLoadingContext;
import org.hibernate.search.engine.search.query.spi.QueryParameters;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;

/**
 * The context holding all the useful information pertaining to the Lucene search query,
 * to be used when extracting data from the response.
 */
class LuceneSearchQueryRequestContext {

    private final LuceneSearchQueryIndexScope<?, ?> queryIndexScope;

    private final BackendSessionContext sessionContext;

    private final SearchLoadingContext<?> loadingContext;

    private final Query luceneQuery;

    private final Sort luceneSort;

    private final Set<String> routingKeys;

    private final QueryParameters parameters;

    LuceneSearchQueryRequestContext(LuceneSearchQueryIndexScope<?, ?> queryIndexScope, BackendSessionContext sessionContext, SearchLoadingContext<?> loadingContext, Query luceneQuery, Sort luceneSort, Set<String> routingKeys, QueryParameters parameters) {
        this.queryIndexScope = queryIndexScope;
        this.sessionContext = sessionContext;
        this.loadingContext = loadingContext;
        this.luceneQuery = luceneQuery;
        this.luceneSort = luceneSort;
        this.routingKeys = routingKeys;
        this.parameters = parameters;
    }

    public LuceneSearchQueryIndexScope<?, ?> getQueryIndexScope() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    BackendSessionContext getSessionContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    SearchLoadingContext<?> getLoadingContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    Query getLuceneQuery() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    Sort getLuceneSort() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Set<String> getRoutingKeys() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public QueryParameters getQueryParameters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
