/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.sort.impl;

import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.engine.search.sort.SearchSort;
import org.hibernate.search.engine.search.sort.spi.CompositeSortBuilder;
import org.hibernate.search.engine.search.sort.spi.ScoreSortBuilder;
import org.hibernate.search.engine.search.sort.spi.SearchSortBuilderFactory;
import org.hibernate.search.engine.search.sort.spi.WithParametersSortBuilder;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;

public class LuceneSearchSortBuilderFactory implements SearchSortBuilderFactory {

    private final LuceneSearchIndexScope<?> scope;

    public LuceneSearchSortBuilderFactory(LuceneSearchIndexScope<?> scope) {
        this.scope = scope;
    }

    @Override
    public ScoreSortBuilder score() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchSort indexOrder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompositeSortBuilder composite() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public WithParametersSortBuilder withParameters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public LuceneSearchSort fromLuceneSortField(SortField luceneSortField) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public LuceneSearchSort fromLuceneSort(Sort luceneSort) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
