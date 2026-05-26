/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.cache.impl;

import java.util.Optional;
import org.hibernate.search.backend.lucene.cache.QueryCachingConfigurationContext;
import org.apache.lucene.search.QueryCache;
import org.apache.lucene.search.QueryCachingPolicy;
import org.apache.lucene.util.Version;

public class LuceneQueryCachingContext implements QueryCachingConfigurationContext {

    private final Version luceneVersion;

    private QueryCache cache;

    private QueryCachingPolicy policy;

    public LuceneQueryCachingContext(Version luceneVersion) {
        this.luceneVersion = luceneVersion;
    }

    @Override
    public Version luceneVersion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryCache(QueryCache cache) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<QueryCache> queryCache() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void queryCachingPolicy(QueryCachingPolicy policy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<QueryCachingPolicy> queryCachingPolicy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
