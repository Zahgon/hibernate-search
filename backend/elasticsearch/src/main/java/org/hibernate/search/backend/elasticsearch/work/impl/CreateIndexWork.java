/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.impl;

import java.util.Map;
import org.hibernate.search.backend.elasticsearch.client.common.gson.spi.GsonProvider;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequest;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchResponse;
import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import org.hibernate.search.backend.elasticsearch.client.impl.ElasticsearchClientUtils;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.aliases.impl.IndexAliasDefinition;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.RootTypeMapping;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.settings.impl.IndexSettings;
import org.hibernate.search.backend.elasticsearch.work.result.impl.CreateIndexResult;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CreateIndexWork extends AbstractNonBulkableWork<CreateIndexResult> {

    private static final String MAPPINGS_PROPERTY = "mappings";

    protected CreateIndexWork(Builder builder) {
        super(builder);
    }

    @Override
    protected CreateIndexResult generateResult(ElasticsearchWorkExecutionContext context, ElasticsearchResponse response) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder extends AbstractBuilder<Builder> {

        private final GsonProvider gsonProvider;

        private final URLEncodedString indexName;

        private final JsonObject payload = new JsonObject();

        public static Builder create(GsonProvider gsonProvider, URLEncodedString indexName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private Builder(GsonProvider gsonProvider, URLEncodedString indexName) {
            super(ElasticsearchRequestSuccessAssessor.DEFAULT_INSTANCE);
            this.gsonProvider = gsonProvider;
            this.indexName = indexName;
        }

        public Builder aliases(Map<String, IndexAliasDefinition> aliases) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder settings(IndexSettings settings) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder mapping(RootTypeMapping mapping) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder ignoreExisting() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected ElasticsearchRequest buildRequest() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public CreateIndexWork build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
