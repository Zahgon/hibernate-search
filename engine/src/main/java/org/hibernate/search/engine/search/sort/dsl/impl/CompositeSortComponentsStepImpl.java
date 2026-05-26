/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.sort.dsl.impl;

import org.hibernate.search.engine.search.sort.SearchSort;
import org.hibernate.search.engine.search.sort.dsl.CompositeSortComponentsStep;
import org.hibernate.search.engine.search.sort.dsl.TypedSearchSortFactory;
import org.hibernate.search.engine.search.sort.dsl.spi.SearchSortDslContext;

public final class CompositeSortComponentsStepImpl<SR> implements CompositeSortComponentsStep<SR, CompositeSortComponentsStepImpl<SR>> {

    private SearchSortDslContext<SR, ?, ?> dslContext;

    public CompositeSortComponentsStepImpl(SearchSortDslContext<SR, ?, ?> dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public CompositeSortComponentsStepImpl<SR> add(SearchSort searchSort) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TypedSearchSortFactory<SR> then() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchSort toSort() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
