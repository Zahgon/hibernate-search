/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.impl;

import java.util.Set;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequest;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchResponse;
import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import org.hibernate.search.backend.elasticsearch.client.impl.Paths;
import org.hibernate.search.backend.elasticsearch.logging.impl.QueryLog;
import org.hibernate.search.backend.elasticsearch.work.result.impl.ExplainResult;
import com.google.gson.JsonObject;

public class ExplainWork extends AbstractNonBulkableWork<ExplainResult> {

    private static final ElasticsearchRequestSuccessAssessor SUCCESS_ASSESSOR = ElasticsearchRequestSuccessAssessor.builder().ignoreErrorStatuses(404).build();

    private final URLEncodedString indexName;

    private final URLEncodedString id;

    private ExplainWork(Builder builder) {
        super(builder);
        this.indexName = builder.indexName;
        this.id = builder.id;
    }

    @Override
    protected ExplainResult generateResult(ElasticsearchWorkExecutionContext context, ElasticsearchResponse response) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder extends AbstractBuilder<Builder> {

        private final URLEncodedString indexName;

        private final URLEncodedString id;

        private final JsonObject payload;

        private Set<String> routingKeys;

        public static Builder create(URLEncodedString indexName, URLEncodedString id, JsonObject payload) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private Builder(URLEncodedString indexName, URLEncodedString id, JsonObject payload) {
            super(SUCCESS_ASSESSOR);
            this.indexName = indexName;
            this.id = id;
            this.payload = payload;
        }

        public Builder routingKeys(Set<String> routingKeys) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected ElasticsearchRequest buildRequest() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public ExplainWork build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class ExplainResultImpl implements ExplainResult {

        private final JsonObject jsonObject;

        private ExplainResultImpl(JsonObject jsonObject) {
            super();
            this.jsonObject = jsonObject;
        }

        @Override
        public JsonObject getJsonObject() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
