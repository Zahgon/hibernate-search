/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.impl;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequest;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchResponse;
import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import org.hibernate.search.backend.elasticsearch.client.impl.Paths;

/**
 * A flush work for ES5, using the Flush API then the Refresh API.
 * <p>
 * This is necessary because the "refresh" parameter in the Flush API has been removed
 * in ES5 (elasticsearch/elasticsearch:7cc48c8e8723d3b31fbcb371070bc2a8d87b1f7e).
 */
public class FlushWork extends AbstractNonBulkableWork<Void> {

    protected FlushWork(Builder builder) {
        super(builder);
    }

    @Override
    protected Void generateResult(ElasticsearchWorkExecutionContext context, ElasticsearchResponse response) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder extends AbstractBuilder<Builder> {

        private final Set<URLEncodedString> indexNames = new HashSet<>();

        public Builder() {
            super(ElasticsearchRequestSuccessAssessor.DEFAULT_INSTANCE);
        }

        public Builder index(URLEncodedString indexName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected ElasticsearchRequest buildRequest() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public FlushWork build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
