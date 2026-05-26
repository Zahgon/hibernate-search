/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.sort.dsl.impl;

import org.hibernate.search.backend.lucene.search.predicate.dsl.LuceneSearchPredicateFactory;
import org.hibernate.search.backend.lucene.search.sort.dsl.LuceneSearchSortFactory;
import org.hibernate.search.backend.lucene.search.sort.impl.LuceneSearchSortIndexScope;
import org.hibernate.search.engine.search.sort.dsl.SortThenStep;
import org.hibernate.search.engine.search.sort.dsl.spi.AbstractSearchSortFactory;
import org.hibernate.search.engine.search.sort.dsl.spi.SearchSortDslContext;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;

public class LuceneSearchSortFactoryImpl<SR> extends AbstractSearchSortFactory<SR, LuceneSearchSortFactory<SR>, LuceneSearchSortIndexScope<?>, LuceneSearchPredicateFactory<SR>> implements LuceneSearchSortFactory<SR> {

    public LuceneSearchSortFactoryImpl(SearchSortDslContext<SR, LuceneSearchSortIndexScope<?>, LuceneSearchPredicateFactory<SR>> dslContext) {
        super(dslContext);
    }

    @Override
    public LuceneSearchSortFactory<SR> withRoot(String objectFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortThenStep<SR> fromLuceneSortField(SortField luceneSortField) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortThenStep<SR> fromLuceneSort(Sort luceneSort) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
