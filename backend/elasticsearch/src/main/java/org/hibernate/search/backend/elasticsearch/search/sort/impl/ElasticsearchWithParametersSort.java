/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.sort.impl;

import java.util.function.Function;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.engine.search.common.NamedValues;
import org.hibernate.search.engine.search.sort.SearchSort;
import org.hibernate.search.engine.search.sort.dsl.SortFinalStep;
import org.hibernate.search.engine.search.sort.spi.WithParametersSortBuilder;

class ElasticsearchWithParametersSort extends AbstractElasticsearchSort {

    private final ElasticsearchSearchIndexScope<?> scope;

    private final Function<? super NamedValues, ? extends SortFinalStep> sortCreator;

    ElasticsearchWithParametersSort(Builder builder) {
        super(builder);
        scope = builder.scope;
        sortCreator = builder.sortCreator;
    }

    @Override
    public void toJsonSorts(ElasticsearchSearchSortCollector collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class Builder extends AbstractBuilder implements WithParametersSortBuilder {

        private Function<? super NamedValues, ? extends SortFinalStep> sortCreator;

        Builder(ElasticsearchSearchIndexScope<?> scope) {
            super(scope);
        }

        @Override
        public void creator(Function<? super NamedValues, ? extends SortFinalStep> sortCreator) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchSort build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
