/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.execution.impl;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import org.hibernate.search.backend.elasticsearch.lowlevel.query.impl.Queries;
import org.hibernate.search.backend.elasticsearch.multitenancy.impl.MultiTenancyStrategy;
import org.hibernate.search.backend.elasticsearch.orchestration.impl.ElasticsearchParallelWorkOrchestrator;
import org.hibernate.search.backend.elasticsearch.work.factory.impl.ElasticsearchWorkFactory;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.engine.backend.work.execution.spi.IndexWorkspace;
import org.hibernate.search.engine.backend.work.execution.spi.UnsupportedOperationBehavior;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ElasticsearchIndexWorkspace implements IndexWorkspace {

    private final ElasticsearchWorkFactory workFactory;

    private final MultiTenancyStrategy multiTenancyStrategy;

    private final ElasticsearchParallelWorkOrchestrator orchestrator;

    private final URLEncodedString indexName;

    private final Set<String> tenantIds;

    public ElasticsearchIndexWorkspace(ElasticsearchWorkFactory workFactory, MultiTenancyStrategy multiTenancyStrategy, ElasticsearchParallelWorkOrchestrator orchestrator, WorkExecutionIndexManagerContext indexManagerContext, Set<String> tenantIds) {
        this.workFactory = workFactory;
        this.multiTenancyStrategy = multiTenancyStrategy;
        this.orchestrator = orchestrator;
        this.indexName = indexManagerContext.getElasticsearchIndexWriteName();
        this.tenantIds = tenantIds;
    }

    @Override
    public CompletableFuture<?> mergeSegments(OperationSubmitter operationSubmitter, UnsupportedOperationBehavior unsupportedOperationBehavior) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> purge(Set<String> routingKeys, OperationSubmitter operationSubmitter, UnsupportedOperationBehavior unsupportedOperationBehavior) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> flush(OperationSubmitter operationSubmitter, UnsupportedOperationBehavior unsupportedOperationBehavior) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> refresh(OperationSubmitter operationSubmitter, UnsupportedOperationBehavior unsupportedOperationBehavior) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
