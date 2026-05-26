/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.index.layout.impl;

import org.hibernate.search.backend.elasticsearch.index.layout.IndexLayoutStrategy;

/**
 * A no-alias layout strategy for indexes:
 * <ul>
 *     <li>The Elasticsearch index name is identical to the Hibernate Search index names.
 *     <li>There is no write alias.
 *     <li>There is no read alias.
 * </ul>
 */
public final class NoAliasIndexLayoutStrategy implements IndexLayoutStrategy {

    public static final String NAME = "no-alias";

    @Override
    public String createInitialElasticsearchIndexName(String hibernateSearchIndexName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String createWriteAlias(String hibernateSearchIndexName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String createReadAlias(String hibernateSearchIndexName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String extractUniqueKeyFromHibernateSearchIndexName(String hibernateSearchIndexName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String extractUniqueKeyFromElasticsearchIndexName(String elasticsearchIndexName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
