/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.sort.impl;

import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.engine.search.sort.SearchSort;
import org.hibernate.search.engine.search.sort.spi.CompositeSortBuilder;
import org.hibernate.search.engine.search.sort.spi.ScoreSortBuilder;
import org.hibernate.search.engine.search.sort.spi.SearchSortBuilderFactory;
import org.hibernate.search.engine.search.sort.spi.WithParametersSortBuilder;
import com.google.gson.JsonObject;

public class ElasticsearchSearchSortBuilderFactory implements SearchSortBuilderFactory {

    private final ElasticsearchSearchIndexScope<?> scope;

    public ElasticsearchSearchSortBuilderFactory(ElasticsearchSearchIndexScope<?> scope) {
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

    public ElasticsearchSearchSort fromJson(JsonObject jsonObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ElasticsearchSearchSort fromJson(String jsonString) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
