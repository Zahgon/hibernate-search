/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.impl;

import org.hibernate.search.backend.elasticsearch.client.common.gson.spi.GsonProvider;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequest;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchResponse;
import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import org.hibernate.search.backend.elasticsearch.client.impl.Paths;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.RootTypeMapping;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class PutIndexMappingWork extends AbstractNonBulkableWork<Void> {

    protected PutIndexMappingWork(Builder builder) {
        super(builder);
    }

    @Override
    protected Void generateResult(ElasticsearchWorkExecutionContext context, ElasticsearchResponse response) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder extends AbstractBuilder<Builder> {

        private final URLEncodedString indexName;

        private final JsonObject payload;

        public static Builder create(GsonProvider gsonProvider, URLEncodedString indexName, RootTypeMapping typeMapping) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private Builder(GsonProvider gsonProvider, URLEncodedString indexName, RootTypeMapping typeMapping) {
            super(ElasticsearchRequestSuccessAssessor.DEFAULT_INSTANCE);
            this.indexName = indexName;
            /*
			 * Serializing nulls is really not a good idea here, it triggers NPEs in Elasticsearch
			 * We better not include the null fields.
			 */
            Gson gson = gsonProvider.getGsonNoSerializeNulls();
            this.payload = gson.toJsonTree(typeMapping).getAsJsonObject();
        }

        @Override
        protected ElasticsearchRequest buildRequest() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public PutIndexMappingWork build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
