/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.impl;

import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequest;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchResponse;
import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import org.hibernate.search.backend.elasticsearch.client.impl.Paths;
import org.hibernate.search.backend.elasticsearch.index.IndexStatus;
import org.hibernate.search.engine.common.timing.spi.StaticDeadline;

public class WaitForIndexStatusWork extends AbstractNonBulkableWork<Void> {

    protected WaitForIndexStatusWork(Builder builder) {
        super(builder);
    }

    @Override
    protected Void generateResult(ElasticsearchWorkExecutionContext context, ElasticsearchResponse response) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder extends AbstractBuilder<Builder> {

        private final URLEncodedString indexName;

        private final IndexStatus requiredStatus;

        private final int requiredStatusTimeoutInMs;

        public Builder(URLEncodedString indexName, IndexStatus requiredStatus, int requiredStatusTimeoutInMs) {
            super(ElasticsearchRequestSuccessAssessor.DEFAULT_INSTANCE);
            this.indexName = indexName;
            this.requiredStatus = requiredStatus;
            this.requiredStatusTimeoutInMs = requiredStatusTimeoutInMs;
        }

        @Override
        protected ElasticsearchRequest buildRequest() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public WaitForIndexStatusWork build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
