/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.impl;

import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequest;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchResponse;
import org.hibernate.search.backend.elasticsearch.client.impl.Paths;
import com.google.gson.JsonObject;

public class ClearScrollWork extends AbstractNonBulkableWork<Void> {

    protected ClearScrollWork(Builder builder) {
        super(builder);
    }

    @Override
    protected Void generateResult(ElasticsearchWorkExecutionContext context, ElasticsearchResponse response) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder extends AbstractBuilder<Builder> {

        private final String scrollId;

        public Builder(String scrollId) {
            super(ElasticsearchRequestSuccessAssessor.DEFAULT_INSTANCE);
            this.scrollId = scrollId;
        }

        @Override
        protected ElasticsearchRequest buildRequest() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public ClearScrollWork build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
