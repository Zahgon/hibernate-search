/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.sort.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.engine.search.sort.SearchSort;
import org.hibernate.search.engine.search.sort.spi.CompositeSortBuilder;

class LuceneCompositeSort extends AbstractLuceneSort {

    private final List<LuceneSearchSort> elements;

    LuceneCompositeSort(Builder builder) {
        super(builder);
        elements = builder.elements;
        // Ensure illegal attempts to mutate the sort will fail
        builder.elements = null;
    }

    @Override
    public void toSortFields(LuceneSearchSortCollector collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class Builder extends AbstractBuilder implements CompositeSortBuilder {

        private List<LuceneSearchSort> elements = new ArrayList<>();

        Builder(LuceneSearchIndexScope<?> scope) {
            super(scope);
        }

        @Override
        public void add(SearchSort sort) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchSort build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
