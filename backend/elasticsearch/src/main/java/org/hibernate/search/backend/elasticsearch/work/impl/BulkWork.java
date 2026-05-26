/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.impl;

import java.util.List;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequest;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchResponse;
import org.hibernate.search.backend.elasticsearch.client.impl.Paths;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.work.result.impl.BulkResult;
import org.hibernate.search.engine.backend.work.execution.DocumentRefreshStrategy;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class BulkWork extends AbstractNonBulkableWork<BulkResult> {

    private static final JsonAccessor<JsonArray> BULK_ITEMS = JsonAccessor.root().property("items").asArray();

    protected BulkWork(Builder builder) {
        super(builder);
    }

    @Override
    protected BulkResult generateResult(ElasticsearchWorkExecutionContext context, ElasticsearchResponse response) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder extends AbstractNonBulkableWork.AbstractBuilder<Builder> {

        private final List<? extends BulkableWork<?>> bulkableWorks;

        private DocumentRefreshStrategy refreshStrategy = DocumentRefreshStrategy.NONE;

        public Builder(List<? extends BulkableWork<?>> bulkableWorks) {
            super(ElasticsearchRequestSuccessAssessor.DEFAULT_INSTANCE);
            this.bulkableWorks = bulkableWorks;
        }

        public Builder refresh(DocumentRefreshStrategy refreshStrategy) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected ElasticsearchRequest buildRequest() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public BulkWork build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class BulkResultImpl implements BulkResult {

        private final JsonArray results;

        public BulkResultImpl(JsonArray results) {
            super();
            this.results = results;
        }

        @Override
        public <T> T extract(ElasticsearchWorkExecutionContext context, BulkableWork<T> work, int index) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
