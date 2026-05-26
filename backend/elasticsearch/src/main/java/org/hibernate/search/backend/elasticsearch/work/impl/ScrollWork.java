/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.impl;

import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequest;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchResponse;
import org.hibernate.search.backend.elasticsearch.client.impl.Paths;
import org.hibernate.search.engine.common.timing.Deadline;
import com.google.gson.JsonObject;

public class ScrollWork<R> extends AbstractNonBulkableWork<R> {

    private final ElasticsearchSearchResultExtractor<R> resultExtractor;

    private final Deadline deadline;

    private final boolean failOnDeadline;

    protected ScrollWork(Builder<R> builder) {
        super(builder);
        this.resultExtractor = builder.resultExtractor;
        this.deadline = builder.deadline;
        this.failOnDeadline = builder.failOnDeadline;
    }

    @Override
    protected R generateResult(ElasticsearchWorkExecutionContext context, ElasticsearchResponse response) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder<R> extends AbstractBuilder<Builder<R>> {

        private final String scrollId;

        private final String scrollTimeout;

        private final ElasticsearchSearchResultExtractor<R> resultExtractor;

        private Deadline deadline;

        private boolean failOnDeadline;

        public Builder(String scrollId, String scrollTimeout, ElasticsearchSearchResultExtractor<R> resultExtractor) {
            super(ElasticsearchRequestSuccessAssessor.DEFAULT_INSTANCE);
            this.scrollId = scrollId;
            this.scrollTimeout = scrollTimeout;
            this.resultExtractor = resultExtractor;
        }

        public Builder<R> deadline(Deadline deadline, boolean failOnDeadline) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected ElasticsearchRequest buildRequest() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public ScrollWork<R> build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
