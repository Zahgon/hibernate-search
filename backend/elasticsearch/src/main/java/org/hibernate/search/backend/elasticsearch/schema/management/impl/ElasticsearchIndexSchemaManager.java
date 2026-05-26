/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.schema.management.impl;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import org.hibernate.search.backend.elasticsearch.index.layout.IndexLayoutStrategy;
import org.hibernate.search.backend.elasticsearch.index.layout.impl.IndexNames;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.impl.IndexMetadata;
import org.hibernate.search.backend.elasticsearch.orchestration.impl.ElasticsearchParallelWorkOrchestrator;
import org.hibernate.search.backend.elasticsearch.validation.impl.ElasticsearchPropertyMappingValidatorProvider;
import org.hibernate.search.backend.elasticsearch.work.factory.impl.ElasticsearchWorkFactory;
import org.hibernate.search.engine.backend.schema.management.spi.IndexSchemaCollector;
import org.hibernate.search.engine.backend.schema.management.spi.IndexSchemaManager;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.engine.reporting.spi.ContextualFailureCollector;
import com.google.gson.Gson;

public class ElasticsearchIndexSchemaManager implements IndexSchemaManager {

    private final ElasticsearchSchemaAccessor schemaAccessor;

    private final ElasticsearchSchemaCreator schemaCreator;

    private final ElasticsearchSchemaDropper schemaDropper;

    private final ElasticsearchSchemaValidator schemaValidator;

    private final ElasticsearchSchemaMigrator schemaMigrator;

    private final ElasticsearchSchemaExporter schemaExporter;

    private final IndexNames indexNames;

    private final IndexMetadata expectedMetadata;

    private final ElasticsearchIndexLifecycleExecutionOptions executionOptions;

    private final Optional<String> backendName;

    public ElasticsearchIndexSchemaManager(Optional<String> backendName, Gson userFacingGson, ElasticsearchWorkFactory workFactory, ElasticsearchParallelWorkOrchestrator workOrchestrator, IndexLayoutStrategy indexLayoutStrategy, IndexNames indexNames, IndexMetadata expectedMetadata, ElasticsearchIndexLifecycleExecutionOptions executionOptions, ElasticsearchPropertyMappingValidatorProvider propertyMappingValidatorProvider) {
        this.schemaAccessor = new ElasticsearchSchemaAccessor(workFactory, workOrchestrator);
        this.schemaCreator = new ElasticsearchSchemaCreator(schemaAccessor, indexLayoutStrategy);
        this.schemaDropper = new ElasticsearchSchemaDropper(schemaAccessor);
        this.schemaValidator = new ElasticsearchSchemaValidator(propertyMappingValidatorProvider);
        this.schemaMigrator = new ElasticsearchSchemaMigrator(schemaAccessor, schemaValidator);
        this.schemaExporter = new ElasticsearchSchemaExporter(userFacingGson, workFactory, indexLayoutStrategy);
        this.indexNames = indexNames;
        this.expectedMetadata = expectedMetadata;
        this.executionOptions = executionOptions;
        this.backendName = backendName;
    }

    @Override
    public CompletableFuture<?> createIfMissing(OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> createOrValidate(ContextualFailureCollector failureCollector, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> createOrUpdate(OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> dropIfExisting(OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> dropAndCreate(OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> validate(ContextualFailureCollector failureCollector, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void exportExpectedSchema(IndexSchemaCollector collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
