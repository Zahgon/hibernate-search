/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.aggregation.impl;

import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.logging.impl.QueryLog;
import org.hibernate.search.backend.elasticsearch.logging.spi.ElasticsearchClientLog;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexNodeContext;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.backend.elasticsearch.search.query.impl.ElasticsearchSearchQueryExtractContext;
import org.hibernate.search.engine.search.aggregation.AggregationKey;
import org.hibernate.search.engine.search.aggregation.spi.CountDocumentAggregationBuilder;
import org.hibernate.search.engine.search.common.spi.SearchQueryElementFactory;
import com.google.gson.JsonObject;

public class ElasticsearchCountDocumentAggregation extends AbstractElasticsearchAggregation<Long> {

    private static final JsonAccessor<Long> TOTAL_HITS_VALUE_PROPERTY_ACCESSOR = JsonAccessor.root().property("hits").property("total").property("value").asLong();

    private static final JsonAccessor<Long> RESPONSE_DOC_COUNT_ACCESSOR = JsonAccessor.root().property("doc_count").asLong();

    private static final JsonAccessor<Long> RESPONSE_ROOT_DOC_COUNT_ACCESSOR = JsonAccessor.root().property("root_doc_count").property("doc_count").asLong();

    private final boolean isNested;

    private ElasticsearchCountDocumentAggregation(Builder builder) {
        super(builder);
        this.isNested = builder.isNested;
    }

    public static SearchQueryElementFactory<CountDocumentAggregationBuilder.TypeSelector, ElasticsearchSearchIndexScope<?>, ElasticsearchSearchIndexNodeContext> factory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class Factory implements SearchQueryElementFactory<CountDocumentAggregationBuilder.TypeSelector, ElasticsearchSearchIndexScope<?>, ElasticsearchSearchIndexNodeContext> {

        @Override
        public CountDocumentAggregationBuilder.TypeSelector create(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexNodeContext node) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void checkCompatibleWith(SearchQueryElementFactory<?, ?, ?> other) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class TypeSelector implements CountDocumentAggregationBuilder.TypeSelector {

        private final ElasticsearchSearchIndexScope<?> scope;

        private final ElasticsearchSearchIndexNodeContext node;

        private TypeSelector(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexNodeContext node) {
            this.scope = scope;
            // doesn't matter in this case
            this.node = node;
        }

        @Override
        public CountDocumentAggregationBuilder builder() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @Override
    public Extractor<Long> request(AggregationRequestContext context, AggregationKey<?> key, JsonObject jsonAggregations) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private record CountDocumentsExtractor(AggregationKey<?> key, boolean isNested, boolean rootContext) implements Extractor<Long> {

        @Override
        public Long extract(JsonObject aggregationResult, AggregationExtractContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Builder extends AbstractBuilder<Long> implements CountDocumentAggregationBuilder {

        private final boolean isNested;

        private Builder(ElasticsearchSearchIndexScope<?> scope, boolean isNested) {
            super(scope);
            this.isNested = isNested;
        }

        @Override
        public ElasticsearchCountDocumentAggregation build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
