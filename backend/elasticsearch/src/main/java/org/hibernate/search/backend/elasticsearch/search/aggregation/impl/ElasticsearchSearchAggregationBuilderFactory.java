/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.aggregation.impl;

import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.engine.search.aggregation.spi.CompositeAggregationBuilder;
import org.hibernate.search.engine.search.aggregation.spi.SearchAggregationBuilder;
import org.hibernate.search.engine.search.aggregation.spi.SearchAggregationBuilderFactory;
import org.hibernate.search.engine.search.aggregation.spi.WithParametersAggregationBuilder;
import com.google.gson.JsonObject;

public class ElasticsearchSearchAggregationBuilderFactory implements SearchAggregationBuilderFactory {

    private final ElasticsearchSearchIndexScope<?> scope;

    public ElasticsearchSearchAggregationBuilderFactory(ElasticsearchSearchIndexScope<?> scope) {
        this.scope = scope;
    }

    public SearchAggregationBuilder<JsonObject> fromJson(JsonObject jsonObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchAggregationBuilder<JsonObject> fromJson(String jsonString) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> WithParametersAggregationBuilder<T> withParameters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> CompositeAggregationBuilder<T> compositeAggregation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
