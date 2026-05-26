/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.sort.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.engine.search.sort.SearchSort;
import org.hibernate.search.engine.search.sort.spi.CompositeSortBuilder;

public class ElasticsearchCompositeSort extends AbstractElasticsearchSort {

    private final List<ElasticsearchSearchSort> elements;

    protected ElasticsearchCompositeSort(Builder builder) {
        super(builder);
        elements = builder.elements;
        // Ensure illegal attempts to mutate the sort will fail
        builder.elements = null;
    }

    @Override
    public void toJsonSorts(ElasticsearchSearchSortCollector collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder extends AbstractBuilder implements CompositeSortBuilder {

        private List<ElasticsearchSearchSort> elements = new ArrayList<>();

        protected Builder(ElasticsearchSearchIndexScope<?> scope) {
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
