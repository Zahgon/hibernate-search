/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequest;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchResponse;
import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import org.hibernate.search.backend.elasticsearch.client.impl.Paths;

/**
 * A force-merge work for ES5+.
 * <p>
 * The ForceMerge API replaced the removed Optimize API in ES5.
 */
public class ForceMergeWork extends AbstractNonBulkableWork<Void> {

    protected ForceMergeWork(Builder builder) {
        super(builder);
    }

    @Override
    protected Void generateResult(ElasticsearchWorkExecutionContext context, ElasticsearchResponse response) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder extends AbstractBuilder<Builder> {

        private final List<URLEncodedString> indexNames = new ArrayList<>();

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
        public ForceMergeWork build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
