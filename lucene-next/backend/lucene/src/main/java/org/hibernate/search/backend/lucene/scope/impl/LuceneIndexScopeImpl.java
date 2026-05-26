/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.scope.impl;

import java.util.Collection;
import java.util.Set;
import org.hibernate.search.backend.lucene.lowlevel.reader.impl.HibernateSearchMultiReader;
import org.hibernate.search.backend.lucene.scope.LuceneIndexScope;
import org.hibernate.search.backend.lucene.scope.model.impl.LuceneScopeIndexManagerContext;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexContext;
import org.hibernate.search.backend.lucene.search.query.impl.LuceneSearchQueryIndexScope;
import org.hibernate.search.backend.lucene.search.query.impl.SearchBackendContext;
import org.hibernate.search.engine.backend.mapping.spi.BackendMappingContext;
import org.hibernate.search.engine.backend.scope.spi.IndexScope;
import org.apache.lucene.index.IndexReader;

public class LuceneIndexScopeImpl<SR> implements IndexScope<SR>, LuceneIndexScope {

    private final LuceneSearchQueryIndexScope<SR, ?> searchScope;

    public LuceneIndexScopeImpl(SearchBackendContext backendContext, BackendMappingContext mappingContext, Class<SR> rootScopeType, Set<? extends LuceneScopeIndexManagerContext> indexManagerContexts) {
        this.searchScope = backendContext.createSearchContext(mappingContext, rootScopeType, indexManagerContexts);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneSearchQueryIndexScope<SR, ?> searchScope() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexReader openIndexReader(Set<String> routingKeys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
