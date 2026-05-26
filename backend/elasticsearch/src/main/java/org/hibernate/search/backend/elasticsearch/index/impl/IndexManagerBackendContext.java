/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.index.impl;

import java.util.Optional;
import java.util.Set;
import org.hibernate.search.backend.elasticsearch.ElasticsearchBackend;
import org.hibernate.search.backend.elasticsearch.analysis.impl.ElasticsearchAnalysisPerformer;
import org.hibernate.search.backend.elasticsearch.cfg.ElasticsearchIndexSettings;
import org.hibernate.search.backend.elasticsearch.document.model.impl.ElasticsearchIndexModel;
import org.hibernate.search.backend.elasticsearch.document.model.lowlevel.impl.LowLevelIndexMetadataBuilder;
import org.hibernate.search.backend.elasticsearch.index.IndexStatus;
import org.hibernate.search.backend.elasticsearch.index.layout.impl.IndexNames;
import org.hibernate.search.backend.elasticsearch.link.impl.ElasticsearchLink;
import org.hibernate.search.backend.elasticsearch.logging.impl.ElasticsearchMiscLog;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.impl.IndexMetadata;
import org.hibernate.search.backend.elasticsearch.multitenancy.impl.MultiTenancyStrategy;
import org.hibernate.search.backend.elasticsearch.orchestration.impl.ElasticsearchBatchingWorkOrchestrator;
import org.hibernate.search.backend.elasticsearch.orchestration.impl.ElasticsearchParallelWorkOrchestrator;
import org.hibernate.search.backend.elasticsearch.orchestration.impl.ElasticsearchSerialWorkOrchestrator;
import org.hibernate.search.backend.elasticsearch.resources.impl.BackendThreads;
import org.hibernate.search.backend.elasticsearch.schema.management.impl.ElasticsearchIndexLifecycleExecutionOptions;
import org.hibernate.search.backend.elasticsearch.schema.management.impl.ElasticsearchIndexSchemaManager;
import org.hibernate.search.backend.elasticsearch.scope.model.impl.ElasticsearchSearchIndexScopeImpl;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ElasticsearchSearchProjection;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.SearchProjectionBackendContext;
import org.hibernate.search.backend.elasticsearch.search.query.impl.ElasticsearchSearchQueryBuilder;
import org.hibernate.search.backend.elasticsearch.search.query.impl.ElasticsearchSearchQueryIndexScope;
import org.hibernate.search.backend.elasticsearch.search.query.impl.SearchBackendContext;
import org.hibernate.search.backend.elasticsearch.validation.impl.ElasticsearchPropertyMappingValidatorProvider;
import org.hibernate.search.backend.elasticsearch.work.execution.impl.ElasticsearchIndexIndexer;
import org.hibernate.search.backend.elasticsearch.work.execution.impl.ElasticsearchIndexIndexingPlan;
import org.hibernate.search.backend.elasticsearch.work.execution.impl.ElasticsearchIndexWorkspace;
import org.hibernate.search.backend.elasticsearch.work.execution.impl.WorkExecutionBackendContext;
import org.hibernate.search.backend.elasticsearch.work.execution.impl.WorkExecutionIndexManagerContext;
import org.hibernate.search.engine.backend.mapping.spi.BackendMappingContext;
import org.hibernate.search.engine.backend.session.spi.BackendSessionContext;
import org.hibernate.search.engine.backend.work.execution.DocumentRefreshStrategy;
import org.hibernate.search.engine.backend.work.execution.spi.IndexIndexer;
import org.hibernate.search.engine.backend.work.execution.spi.IndexIndexingPlan;
import org.hibernate.search.engine.backend.work.execution.spi.IndexWorkspace;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.cfg.spi.OptionalConfigurationProperty;
import org.hibernate.search.engine.common.timing.spi.TimingSource;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.engine.search.loading.spi.SearchLoadingContextBuilder;
import org.hibernate.search.util.common.reporting.EventContext;
import com.google.gson.Gson;

public class IndexManagerBackendContext implements SearchBackendContext, WorkExecutionBackendContext {

    private static final OptionalConfigurationProperty<IndexStatus> LIFECYCLE_MINIMAL_REQUIRED_STATUS = ConfigurationProperty.forKey(ElasticsearchIndexSettings.SCHEMA_MANAGEMENT_MINIMAL_REQUIRED_STATUS).as(IndexStatus.class, IndexStatus::of).build();

    private static final ConfigurationProperty<Integer> LIFECYCLE_MINIMAL_REQUIRED_STATUS_WAIT_TIMEOUT = ConfigurationProperty.forKey(ElasticsearchIndexSettings.SCHEMA_MANAGEMENT_MINIMAL_REQUIRED_STATUS_WAIT_TIMEOUT).asIntegerPositiveOrZero().withDefault(ElasticsearchIndexSettings.Defaults.SCHEMA_MANAGEMENT_MINIMAL_REQUIRED_STATUS_WAIT_TIMEOUT).build();

    private final ElasticsearchBackend backendAPI;

    private final EventContext eventContext;

    private final BackendThreads threads;

    private final ElasticsearchLink link;

    private final Gson userFacingGson;

    private final MultiTenancyStrategy multiTenancyStrategy;

    private final FailureHandler failureHandler;

    private final TimingSource timingSource;

    private final ElasticsearchParallelWorkOrchestrator generalPurposeOrchestrator;

    private final ElasticsearchPropertyMappingValidatorProvider propertyMappingValidatorProvider;

    public IndexManagerBackendContext(ElasticsearchBackend backendAPI, EventContext eventContext, BackendThreads threads, ElasticsearchLink link, Gson userFacingGson, MultiTenancyStrategy multiTenancyStrategy, FailureHandler failureHandler, TimingSource timingSource, ElasticsearchParallelWorkOrchestrator generalPurposeOrchestrator, ElasticsearchPropertyMappingValidatorProvider propertyMappingValidatorProvider) {
        this.backendAPI = backendAPI;
        this.eventContext = eventContext;
        this.threads = threads;
        this.link = link;
        this.userFacingGson = userFacingGson;
        this.multiTenancyStrategy = multiTenancyStrategy;
        this.failureHandler = failureHandler;
        this.timingSource = timingSource;
        this.generalPurposeOrchestrator = generalPurposeOrchestrator;
        this.propertyMappingValidatorProvider = propertyMappingValidatorProvider;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexIndexingPlan createIndexingPlan(ElasticsearchSerialWorkOrchestrator orchestrator, WorkExecutionIndexManagerContext indexManagerContext, BackendSessionContext sessionContext, DocumentRefreshStrategy refreshStrategy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexIndexer createIndexer(ElasticsearchSerialWorkOrchestrator orchestrator, WorkExecutionIndexManagerContext indexManagerContext, BackendSessionContext sessionContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexWorkspace createWorkspace(WorkExecutionIndexManagerContext indexManagerContext, Set<String> tenantIds) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchProjectionBackendContext getSearchProjectionBackendContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <SR> ElasticsearchSearchQueryIndexScope<SR, ?> createSearchContext(BackendMappingContext mappingContext, Class<SR> rootScopeType, Set<ElasticsearchIndexModel> indexModels) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <H> ElasticsearchSearchQueryBuilder<H> createSearchQueryBuilder(ElasticsearchSearchIndexScope<?> scope, BackendSessionContext sessionContext, SearchLoadingContextBuilder<?, ?> loadingContextBuilder, ElasticsearchSearchProjection<H> rootProjection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    ElasticsearchBackend toAPI() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    EventContext getEventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    ElasticsearchIndexSchemaManager createSchemaManager(ElasticsearchIndexModel model, ConfigurationPropertySource indexPropertySource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    ElasticsearchBatchingWorkOrchestrator createIndexingOrchestrator(String indexName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    String toElasticsearchId(String tenantId, String id) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ElasticsearchAnalysisPerformer createAnalysisPerformer(ElasticsearchIndexModel model) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IndexNames createIndexNames(String hibernateSearchIndexName, String mappedTypeName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
