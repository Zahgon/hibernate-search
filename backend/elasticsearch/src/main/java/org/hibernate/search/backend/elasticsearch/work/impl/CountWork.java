/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequest;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchResponse;
import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import org.hibernate.search.backend.elasticsearch.client.impl.Paths;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.engine.common.timing.Deadline;
import com.google.gson.JsonObject;

public class CountWork extends AbstractNonBulkableWork<Long> {

    private static final JsonAccessor<Long> COUNT_ACCESSOR = JsonAccessor.root().property("count").asLong();

    protected CountWork(Builder builder) {
        super(builder);
    }

    @Override
    protected Long generateResult(ElasticsearchWorkExecutionContext context, ElasticsearchResponse response) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder extends AbstractBuilder<Builder> {

        private final List<URLEncodedString> indexNames = new ArrayList<>();

        private JsonObject query;

        private Set<String> routingKeys;

        private Deadline deadline;

        public Builder() {
            super(ElasticsearchRequestSuccessAssessor.DEFAULT_INSTANCE);
        }

        public Builder index(URLEncodedString indexName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder query(JsonObject query) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder routingKeys(Set<String> routingKeys) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder deadline(Deadline deadline) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected ElasticsearchRequest buildRequest() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public CountWork build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
