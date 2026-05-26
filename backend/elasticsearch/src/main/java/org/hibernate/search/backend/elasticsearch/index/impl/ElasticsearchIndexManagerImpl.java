/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.index.impl;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import org.hibernate.search.backend.elasticsearch.ElasticsearchBackend;
import org.hibernate.search.backend.elasticsearch.analysis.impl.ElasticsearchAnalysisPerformer;
import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import org.hibernate.search.backend.elasticsearch.document.impl.DocumentMetadataContributor;
import org.hibernate.search.backend.elasticsearch.document.impl.ElasticsearchDocumentObjectBuilder;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexModel;
import org.hibernate.search.backend.elasticsearch.index.ElasticsearchIndexManager;
import org.hibernate.search.backend.elasticsearch.logging.impl.DeprecationLog;
import org.hibernate.search.backend.elasticsearch.logging.impl.ElasticsearchMiscLog;
import org.hibernate.search.backend.elasticsearch.logging.impl.QueryLog;
import org.hibernate.search.backend.elasticsearch.metamodel.ElasticsearchIndexDescriptor;
import org.hibernate.search.backend.elasticsearch.orchestration.impl.ElasticsearchBatchingWorkOrchestrator;
import org.hibernate.search.backend.elasticsearch.schema.management.impl.ElasticsearchIndexSchemaManager;
import org.hibernate.search.backend.elasticsearch.work.execution.impl.WorkExecutionIndexManagerContext;
import org.hibernate.search.engine.backend.analysis.AnalysisToken;
import org.hibernate.search.engine.backend.index.IndexManager;
import org.hibernate.search.engine.backend.index.spi.IndexManagerImplementor;
import org.hibernate.search.engine.backend.index.spi.IndexManagerStartContext;
import org.hibernate.search.engine.backend.mapping.spi.BackendMappingContext;
import org.hibernate.search.engine.backend.schema.management.spi.IndexSchemaManager;
import org.hibernate.search.engine.backend.scope.spi.IndexScopeBuilder;
import org.hibernate.search.engine.backend.session.spi.BackendSessionContext;
import org.hibernate.search.engine.backend.work.execution.DocumentCommitStrategy;
import org.hibernate.search.engine.backend.work.execution.DocumentRefreshStrategy;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.engine.backend.work.execution.spi.DocumentContributor;
import org.hibernate.search.engine.backend.work.execution.spi.IndexIndexer;
import org.hibernate.search.engine.backend.work.execution.spi.IndexIndexingPlan;
import org.hibernate.search.engine.backend.work.execution.spi.IndexWorkspace;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.cfg.spi.OptionalConfigurationProperty;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.impl.Futures;
import org.hibernate.search.util.common.impl.SuppressingCloser;
import org.hibernate.search.util.common.reporting.EventContext;
import com.google.gson.JsonObject;

class ElasticsearchIndexManagerImpl implements IndexManagerImplementor, ElasticsearchIndexManager, WorkExecutionIndexManagerContext {

    private static final OptionalConfigurationProperty<String> OBSOLETE_LIFECYCLE_STRATEGY = ConfigurationProperty.forKey("lifecycle.strategy").asString().build();

    private final IndexManagerBackendContext backendContext;

    private final List<DocumentMetadataContributor> documentMetadataContributors;

    private final ElasticsearchBatchingWorkOrchestrator indexingOrchestrator;

    private final ElasticsearchIndexModel model;

    private ElasticsearchIndexSchemaManager schemaManager;

    private ElasticsearchAnalysisPerformer analysisPerformer;

    ElasticsearchIndexManagerImpl(IndexManagerBackendContext backendContext, ElasticsearchIndexModel model, List<DocumentMetadataContributor> documentMetadataContributors) {
        this.backendContext = backendContext;
        this.model = model;
        this.documentMetadataContributors = documentMetadataContributors;
        this.indexingOrchestrator = backendContext.createIndexingOrchestrator(model.hibernateSearchIndexName());
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void start(IndexManagerStartContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> preStop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void stop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getMappedTypeName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public URLEncodedString getElasticsearchIndexWriteName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toElasticsearchId(String tenantId, String id) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonObject createDocument(String tenantId, String id, DocumentContributor documentContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ElasticsearchIndexModel model() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexSchemaManager schemaManager() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexIndexingPlan createIndexingPlan(BackendSessionContext sessionContext, DocumentCommitStrategy commitStrategy, DocumentRefreshStrategy refreshStrategy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexIndexer createIndexer(BackendSessionContext sessionContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexWorkspace createWorkspace(BackendMappingContext mappingContext, Set<String> tenantIds) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <SR> IndexScopeBuilder<SR> createScopeBuilder(BackendMappingContext mappingContext, Class<SR> rootScopeType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addTo(IndexScopeBuilder<?> builder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexManager toAPI() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchBackend backend() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchIndexDescriptor descriptor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<? extends AnalysisToken> analyze(String analyzerName, String terms) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AnalysisToken normalize(String normalizerName, String terms) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletionStage<List<? extends AnalysisToken>> analyzeAsync(String analyzerName, String terms, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletionStage<AnalysisToken> normalizeAsync(String normalizerName, String terms, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    // Checked using reflection
    @SuppressWarnings("unchecked")
    public <T> T unwrap(Class<T> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private EventContext getBackendAndIndexEventContext() {
        return backendContext.getEventContext().append(EventContexts.fromIndexName(model.hibernateSearchName()));
    }
}
