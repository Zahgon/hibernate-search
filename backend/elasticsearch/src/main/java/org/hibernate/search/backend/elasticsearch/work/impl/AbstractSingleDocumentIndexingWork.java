/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.impl;

import org.hibernate.search.backend.elasticsearch.logging.spi.ElasticsearchClientLog;
import org.hibernate.search.engine.backend.work.execution.DocumentRefreshStrategy;
import com.google.gson.JsonObject;

public abstract class AbstractSingleDocumentIndexingWork implements BulkableWork<Void>, SingleDocumentIndexingWork {

    private final JsonObject bulkableActionMetadata;

    private final JsonObject bulkableActionBody;

    protected final ElasticsearchRequestSuccessAssessor resultAssessor;

    private final String entityTypeName;

    private final Object entityIdentifier;

    private final String documentIdentifier;

    private final DocumentRefreshStrategy refreshStrategy;

    protected AbstractSingleDocumentIndexingWork(AbstractBuilder<?> builder) {
        this.bulkableActionMetadata = builder.buildBulkableActionMetadata();
        this.bulkableActionBody = builder.buildBulkableActionBody();
        this.resultAssessor = builder.resultAssessor;
        this.entityTypeName = builder.entityTypeName;
        this.entityIdentifier = builder.entityIdentifier;
        this.documentIdentifier = builder.documentIdentifier;
        this.refreshStrategy = builder.refreshStrategy;
    }

    @Override
    public String getQueuingKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getEntityTypeName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object getEntityIdentifier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DocumentRefreshStrategy getRefreshStrategy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonObject getBulkableActionMetadata() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonObject getBulkableActionBody() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Void handleBulkResult(ElasticsearchWorkExecutionContext context, JsonObject bulkResponseItem) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract static class AbstractBuilder<B> {

        private final ElasticsearchRequestSuccessAssessor resultAssessor;

        private final String entityTypeName;

        private final Object entityIdentifier;

        protected final String documentIdentifier;

        private DocumentRefreshStrategy refreshStrategy = DocumentRefreshStrategy.NONE;

        public AbstractBuilder(ElasticsearchRequestSuccessAssessor resultAssessor, String entityTypeName, Object entityIdentifier, String documentIdentifier) {
            this.resultAssessor = resultAssessor;
            this.entityTypeName = entityTypeName;
            this.entityIdentifier = entityIdentifier;
            this.documentIdentifier = documentIdentifier;
        }

        @SuppressWarnings("unchecked")
        public B refresh(DocumentRefreshStrategy refreshStrategy) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected abstract JsonObject buildBulkableActionMetadata();

        protected abstract JsonObject buildBulkableActionBody();

        public abstract AbstractSingleDocumentIndexingWork build();
    }
}
