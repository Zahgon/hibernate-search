/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.schema.management.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import org.hibernate.search.backend.elasticsearch.index.IndexStatus;
import org.hibernate.search.backend.elasticsearch.index.layout.impl.IndexNames;
import org.hibernate.search.backend.elasticsearch.logging.spi.ElasticsearchClientLog;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.aliases.impl.IndexAliasDefinition;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.RootTypeMapping;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.settings.impl.IndexSettings;
import org.hibernate.search.backend.elasticsearch.orchestration.impl.ElasticsearchParallelWorkOrchestrator;
import org.hibernate.search.backend.elasticsearch.work.factory.impl.ElasticsearchWorkFactory;
import org.hibernate.search.backend.elasticsearch.work.impl.NonBulkableWork;
import org.hibernate.search.backend.elasticsearch.work.result.impl.CreateIndexResult;
import org.hibernate.search.backend.elasticsearch.work.result.impl.ExistingIndexMetadata;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.util.common.impl.Futures;
import org.hibernate.search.util.common.impl.Throwables;

/**
 * A utility implementing primitives for the various {@code ElasticsearchSchema*Impl}.
 * @author Gunnar Morling
 */
final class ElasticsearchSchemaAccessor {

    private final ElasticsearchWorkFactory workFactory;

    private final ElasticsearchParallelWorkOrchestrator orchestrator;

    public ElasticsearchSchemaAccessor(ElasticsearchWorkFactory workFactory, ElasticsearchParallelWorkOrchestrator orchestrator) {
        this.workFactory = workFactory;
        this.orchestrator = orchestrator;
    }

    public CompletableFuture<?> createIndexAssumeNonExisting(URLEncodedString primaryIndexName, Map<String, IndexAliasDefinition> aliases, IndexSettings settings, RootTypeMapping mapping, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param primaryIndexName The name of the created index.
     * @param aliases The aliases for the newly created index.
     * @param settings The settings for the newly created index.
     * @param mapping The root mapping for the newly created index.
     * @return A future holding {@code true} if the index was actually created, {@code false} if it already existed.
     */
    public CompletableFuture<Boolean> createIndexIgnoreExisting(URLEncodedString primaryIndexName, Map<String, IndexAliasDefinition> aliases, IndexSettings settings, RootTypeMapping mapping, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CompletableFuture<ExistingIndexMetadata> getCurrentIndexMetadata(IndexNames indexNames, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CompletableFuture<ExistingIndexMetadata> getCurrentIndexMetadataOrNull(IndexNames indexNames, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private CompletableFuture<ExistingIndexMetadata> getCurrentIndexMetadata(IndexNames indexNames, boolean allowNull, OperationSubmitter operationSubmitter) {
        NonBulkableWork<List<ExistingIndexMetadata>> work = getWorkFactory().getIndexMetadata().index(indexNames.write()).index(indexNames.read()).build();
        return execute(work, operationSubmitter).exceptionally(Futures.handler(e -> {
            throw ElasticsearchClientLog.INSTANCE.elasticsearchIndexMetadataRetrievalFailed(e.getMessage(), Throwables.expectException(e));
        })).thenApply(list -> {
            if (list.isEmpty()) {
                if (allowNull) {
                    return null;
                } else {
                    throw ElasticsearchClientLog.INSTANCE.indexMissing(indexNames.write(), indexNames.read());
                }
            }
            if (list.size() > 1) {
                throw ElasticsearchClientLog.INSTANCE.elasticsearchIndexNameAndAliasesMatchMultipleIndexes(indexNames.write(), indexNames.read(), list.stream().map(ExistingIndexMetadata::getPrimaryName).collect(Collectors.toSet()));
            }
            return list.get(0);
        });
    }

    public CompletableFuture<?> updateAliases(URLEncodedString indexName, Map<String, IndexAliasDefinition> aliases, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CompletableFuture<?> updateSettings(URLEncodedString indexName, IndexSettings settings, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CompletableFuture<?> updateMapping(URLEncodedString indexName, RootTypeMapping mapping, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CompletableFuture<?> waitForIndexStatus(IndexNames indexNames, ElasticsearchIndexLifecycleExecutionOptions executionOptions, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CompletableFuture<?> dropIndexIfExisting(URLEncodedString indexName, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CompletableFuture<?> closeIndex(URLEncodedString indexName, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CompletableFuture<?> openIndex(URLEncodedString indexName, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private ElasticsearchWorkFactory getWorkFactory() {
        return workFactory;
    }

    private <T> CompletableFuture<T> execute(NonBulkableWork<T> work, OperationSubmitter operationSubmitter) {
        return orchestrator.submit(work, operationSubmitter);
    }
}
