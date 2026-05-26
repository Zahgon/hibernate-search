/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.impl;

import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import com.google.gson.JsonObject;

public class DeleteWork extends AbstractSingleDocumentIndexingWork {

    private static final ElasticsearchRequestSuccessAssessor SUCCESS_ASSESSOR = ElasticsearchRequestSuccessAssessor.builder().ignoreErrorStatuses(404).build();

    private DeleteWork(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractSingleDocumentIndexingWork.AbstractBuilder<Builder> {

        private final URLEncodedString indexName;

        private final String routingKey;

        public static Builder create(String entityTypeName, Object entityIdentifier, URLEncodedString elasticsearchIndexName, String documentIdentifier, String routingKey) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private Builder(String entityTypeName, Object entityIdentifier, URLEncodedString elasticsearchIndexName, String documentIdentifier, String routingKey) {
            super(SUCCESS_ASSESSOR, entityTypeName, entityIdentifier, documentIdentifier);
            this.indexName = elasticsearchIndexName;
            this.routingKey = routingKey;
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
        public DeleteWork build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
