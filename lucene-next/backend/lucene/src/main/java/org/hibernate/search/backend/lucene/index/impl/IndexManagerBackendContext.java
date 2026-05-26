/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.index.impl;

import java.util.Set;
import org.hibernate.search.backend.lucene.LuceneBackend;
import org.hibernate.search.backend.lucene.analysis.model.impl.LuceneAnalysisDefinitionRegistry;
import org.hibernate.search.backend.lucene.cfg.LuceneIndexSettings;
import org.hibernate.search.backend.lucene.document.impl.LuceneIndexEntryFactory;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexModel;
import org.hibernate.search.backend.lucene.lowlevel.directory.spi.DirectoryHolder;
import org.hibernate.search.backend.lucene.lowlevel.index.IOStrategyName;
import org.hibernate.search.backend.lucene.lowlevel.index.impl.DebugIOStrategy;
import org.hibernate.search.backend.lucene.lowlevel.index.impl.IOStrategy;
import org.hibernate.search.backend.lucene.lowlevel.index.impl.IndexAccessorImpl;
import org.hibernate.search.backend.lucene.lowlevel.index.impl.NearRealTimeIOStrategy;
import org.hibernate.search.backend.lucene.lowlevel.writer.impl.IndexWriterConfigSource;
import org.hibernate.search.backend.lucene.multitenancy.impl.MultiTenancyStrategy;
import org.hibernate.search.backend.lucene.orchestration.impl.LuceneBatchedWorkProcessor;
import org.hibernate.search.backend.lucene.orchestration.impl.LuceneParallelWorkOrchestratorImpl;
import org.hibernate.search.backend.lucene.orchestration.impl.LuceneSerialWorkOrchestratorImpl;
import org.hibernate.search.backend.lucene.orchestration.impl.LuceneSyncWorkOrchestrator;
import org.hibernate.search.backend.lucene.resources.impl.BackendThreads;
import org.hibernate.search.backend.lucene.schema.management.impl.LuceneIndexSchemaManager;
import org.hibernate.search.backend.lucene.schema.management.impl.SchemaManagementIndexManagerContext;
import org.hibernate.search.backend.lucene.scope.model.impl.LuceneScopeIndexManagerContext;
import org.hibernate.search.backend.lucene.scope.model.impl.LuceneSearchIndexScopeImpl;
import org.hibernate.search.backend.lucene.search.projection.impl.LuceneSearchProjection;
import org.hibernate.search.backend.lucene.search.query.impl.LuceneSearchQueryBuilder;
import org.hibernate.search.backend.lucene.search.query.impl.LuceneSearchQueryIndexScope;
import org.hibernate.search.backend.lucene.search.query.impl.SearchBackendContext;
import org.hibernate.search.backend.lucene.work.execution.impl.LuceneIndexIndexer;
import org.hibernate.search.backend.lucene.work.execution.impl.LuceneIndexIndexingPlan;
import org.hibernate.search.backend.lucene.work.execution.impl.LuceneIndexWorkspace;
import org.hibernate.search.backend.lucene.work.execution.impl.WorkExecutionBackendContext;
import org.hibernate.search.backend.lucene.work.execution.impl.WorkExecutionIndexManagerContext;
import org.hibernate.search.backend.lucene.work.impl.LuceneWorkFactory;
import org.hibernate.search.engine.backend.mapping.spi.BackendMappingContext;
import org.hibernate.search.engine.backend.session.spi.BackendSessionContext;
import org.hibernate.search.engine.backend.work.execution.DocumentCommitStrategy;
import org.hibernate.search.engine.backend.work.execution.DocumentRefreshStrategy;
import org.hibernate.search.engine.backend.work.execution.spi.IndexIndexer;
import org.hibernate.search.engine.backend.work.execution.spi.IndexIndexingPlan;
import org.hibernate.search.engine.backend.work.execution.spi.IndexWorkspace;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.common.timing.spi.TimingSource;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.engine.search.loading.spi.SearchLoadingContextBuilder;
import org.hibernate.search.util.common.reporting.EventContext;
import org.apache.lucene.search.similarities.Similarity;

public class IndexManagerBackendContext implements WorkExecutionBackendContext, SearchBackendContext {

    private static final ConfigurationProperty<IOStrategyName> IO_STRATEGY = ConfigurationProperty.forKey(LuceneIndexSettings.IO_STRATEGY).as(IOStrategyName.class, IOStrategyName::of).withDefault(LuceneIndexSettings.Defaults.IO_STRATEGY).build();

    private final LuceneBackend backendAPI;

    private final EventContext eventContext;

    private final BackendThreads threads;

    private final Similarity similarity;

    private final LuceneWorkFactory workFactory;

    private final MultiTenancyStrategy multiTenancyStrategy;

    private final TimingSource timingSource;

    private final LuceneAnalysisDefinitionRegistry analysisDefinitionRegistry;

    private final FailureHandler failureHandler;

    private final LuceneSyncWorkOrchestrator readOrchestrator;

    public IndexManagerBackendContext(LuceneBackend backendAPI, EventContext eventContext, BackendThreads threads, Similarity similarity, LuceneWorkFactory workFactory, MultiTenancyStrategy multiTenancyStrategy, TimingSource timingSource, LuceneAnalysisDefinitionRegistry analysisDefinitionRegistry, FailureHandler failureHandler, LuceneSyncWorkOrchestrator readOrchestrator) {
        this.backendAPI = backendAPI;
        this.eventContext = eventContext;
        this.threads = threads;
        this.similarity = similarity;
        this.multiTenancyStrategy = multiTenancyStrategy;
        this.timingSource = timingSource;
        this.analysisDefinitionRegistry = analysisDefinitionRegistry;
        this.workFactory = workFactory;
        this.failureHandler = failureHandler;
        this.readOrchestrator = readOrchestrator;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexIndexingPlan createIndexingPlan(WorkExecutionIndexManagerContext indexManagerContext, LuceneIndexEntryFactory indexEntryFactory, BackendSessionContext sessionContext, DocumentCommitStrategy commitStrategy, DocumentRefreshStrategy refreshStrategy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexIndexer createIndexer(WorkExecutionIndexManagerContext indexManagerContext, LuceneIndexEntryFactory indexEntryFactory, BackendSessionContext sessionContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexWorkspace createWorkspace(WorkExecutionIndexManagerContext indexManagerContext, Set<String> tenantIds) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <SR> LuceneSearchQueryIndexScope<SR, ?> createSearchContext(BackendMappingContext mappingContext, Class<SR> scopeRootType, Set<? extends LuceneScopeIndexManagerContext> indexManagerContexts) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <H> LuceneSearchQueryBuilder<H> createSearchQueryBuilder(LuceneSearchQueryIndexScope<?, ?> scope, BackendSessionContext sessionContext, SearchLoadingContextBuilder<?, ?> loadingContextBuilder, LuceneSearchProjection<H> rootProjection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    LuceneBackend toAPI() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    EventContext getEventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    LuceneIndexEntryFactory createLuceneIndexEntryFactory(LuceneIndexModel model) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    IOStrategy createIOStrategy(ConfigurationPropertySource propertySource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    LuceneIndexSchemaManager createSchemaManager(String indexName, SchemaManagementIndexManagerContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    IndexAccessorImpl createIndexAccessor(LuceneIndexModel model, EventContext shardEventContext, DirectoryHolder directoryHolder, IOStrategy ioStrategy, ConfigurationPropertySource propertySource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    LuceneParallelWorkOrchestratorImpl createIndexManagementOrchestrator(EventContext eventContext, IndexAccessorImpl indexAccessor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    LuceneSerialWorkOrchestratorImpl createIndexingOrchestrator(EventContext eventContext, IndexAccessorImpl indexAccessor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
