/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.impl;

import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequest;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchResponse;
import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import org.hibernate.search.backend.elasticsearch.client.impl.Paths;

public class OpenIndexWork extends AbstractNonBulkableWork<Void> {

    protected OpenIndexWork(Builder builder) {
        super(builder);
    }

    @Override
    protected Void generateResult(ElasticsearchWorkExecutionContext context, ElasticsearchResponse response) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder extends AbstractBuilder<Builder> {

        private final URLEncodedString indexName;

        public Builder(URLEncodedString indexName) {
            super(ElasticsearchRequestSuccessAssessor.DEFAULT_INSTANCE);
            this.indexName = indexName;
        }

        @Override
        protected ElasticsearchRequest buildRequest() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public OpenIndexWork build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
