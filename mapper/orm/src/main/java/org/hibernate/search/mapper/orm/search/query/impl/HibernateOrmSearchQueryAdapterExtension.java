/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.search.query.impl;

import java.util.Optional;
import org.hibernate.search.engine.search.loading.spi.SearchLoadingContext;
import org.hibernate.search.engine.search.query.SearchQuery;
import org.hibernate.search.engine.search.query.SearchQueryExtension;
import org.hibernate.search.engine.search.query.spi.SearchQueryImplementor;
import org.hibernate.search.mapper.orm.loading.impl.HibernateOrmSelectionLoadingContext;

@SuppressWarnings("removal")
@Deprecated(since = "8.1", forRemoval = true)
final class HibernateOrmSearchQueryAdapterExtension<H> implements SearchQueryExtension<HibernateOrmSearchQueryAdapter<H>, H> {

    private static final HibernateOrmSearchQueryAdapterExtension<Object> INSTANCE = new HibernateOrmSearchQueryAdapterExtension<>();

    // The instance works for any H
    @SuppressWarnings("unchecked")
    static <H> HibernateOrmSearchQueryAdapterExtension<H> get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<HibernateOrmSearchQueryAdapter<H>> extendOptional(SearchQuery<H> original, SearchLoadingContext<?> loadingContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
