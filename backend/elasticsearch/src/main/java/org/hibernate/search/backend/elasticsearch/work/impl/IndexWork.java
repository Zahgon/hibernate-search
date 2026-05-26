/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.impl;

import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import com.google.gson.JsonObject;

public class IndexWork extends AbstractSingleDocumentIndexingWork implements SingleDocumentIndexingWork {

    private IndexWork(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractSingleDocumentIndexingWork.AbstractBuilder<Builder> {

        private final URLEncodedString indexName;

        private final String routingKey;

        private final JsonObject document;

        public static Builder create(String entityTypeName, Object entityIdentifier, URLEncodedString elasticsearchIndexName, String documentIdentifier, String routingKey, JsonObject document) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private Builder(String entityTypeName, Object entityIdentifier, URLEncodedString elasticsearchIndexName, String documentIdentifier, String routingKey, JsonObject document) {
            super(ElasticsearchRequestSuccessAssessor.DEFAULT_INSTANCE, entityTypeName, entityIdentifier, documentIdentifier);
            this.indexName = elasticsearchIndexName;
            this.routingKey = routingKey;
            this.document = document;
        }

        @Override
        protected JsonObject buildBulkableActionMetadata() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected JsonObject buildBulkableActionBody() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public IndexWork build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
