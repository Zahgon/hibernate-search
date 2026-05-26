/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequest;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchResponse;
import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import org.hibernate.search.backend.elasticsearch.client.impl.Paths;
import org.hibernate.search.backend.elasticsearch.work.factory.impl.ElasticsearchWorkFactory;
import com.google.gson.JsonObject;

public class DeleteByQueryWork extends AbstractNonBulkableWork<Void> {

    private final NonBulkableWork<?> refreshWork;

    protected DeleteByQueryWork(Builder builder) {
        super(builder);
        this.refreshWork = builder.buildRefreshWork();
    }

    @Override
    protected CompletableFuture<?> beforeExecute(ElasticsearchWorkExecutionContext executionContext, ElasticsearchRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Void generateResult(ElasticsearchWorkExecutionContext context, ElasticsearchResponse response) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder extends AbstractBuilder<Builder> {

        private final URLEncodedString indexName;

        private final JsonObject payload;

        private final Set<URLEncodedString> typeNames = new HashSet<>();

        private Collection<String> routingKeys;

        private final RefreshWork.Builder refreshWorkBuilder;

        public Builder(URLEncodedString indexName, JsonObject payload, ElasticsearchWorkFactory workFactory) {
            super(ElasticsearchRequestSuccessAssessor.DEFAULT_INSTANCE);
            this.indexName = indexName;
            this.payload = payload;
            this.refreshWorkBuilder = workFactory.isRefreshSupported() ? workFactory.refresh().index(indexName) : null;
        }

        public Builder routingKeys(Collection<String> routingKeys) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected ElasticsearchRequest buildRequest() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected NonBulkableWork<?> buildRefreshWork() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public DeleteByQueryWork build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
