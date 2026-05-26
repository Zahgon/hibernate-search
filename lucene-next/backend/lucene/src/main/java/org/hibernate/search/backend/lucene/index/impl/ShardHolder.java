/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.index.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import org.hibernate.search.backend.lucene.cfg.LuceneIndexSettings;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexModel;
import org.hibernate.search.backend.lucene.index.spi.ShardingStrategy;
import org.hibernate.search.backend.lucene.lowlevel.reader.impl.DirectoryReaderCollector;
import org.hibernate.search.backend.lucene.lowlevel.reader.impl.ReadIndexManagerContext;
import org.hibernate.search.backend.lucene.orchestration.impl.LuceneParallelWorkOrchestrator;
import org.hibernate.search.backend.lucene.orchestration.impl.LuceneSerialWorkOrchestrator;
import org.hibernate.search.backend.lucene.schema.management.impl.SchemaManagementIndexManagerContext;
import org.hibernate.search.backend.lucene.work.execution.impl.WorkExecutionIndexManagerContext;
import org.hibernate.search.engine.backend.index.spi.IndexManagerStartContext;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.common.resources.spi.SavedState;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.util.common.impl.Closer;

class ShardHolder implements ReadIndexManagerContext, WorkExecutionIndexManagerContext, SchemaManagementIndexManagerContext {

    private static final SavedState.Key<Map<String, SavedState>> SHARDS_KEY = SavedState.key("shards");

    private final IndexManagerBackendContext backendContext;

    private final LuceneIndexModel model;

    private BeanHolder<? extends ShardingStrategy> shardingStrategyHolder;

    private final Map<String, Shard> shards = new LinkedHashMap<>();

    private final List<LuceneParallelWorkOrchestrator> managementOrchestrators = new ArrayList<>();

    ShardHolder(IndexManagerBackendContext backendContext, LuceneIndexModel model) {
        this.backendContext = backendContext;
        this.model = model;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SavedState saveForRestart() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private ConfigurationPropertySource toShardPropertySource(ConfigurationPropertySource indexPropertySource, String shardIdOrNull) {
        return shardIdOrNull != null ? indexPropertySource.withMask(LuceneIndexSettings.SHARDS).withMask(shardIdOrNull).withFallback(indexPropertySource) : indexPropertySource;
    }

    void preStart(IndexManagerStartContext startContext, SavedState savedState) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void start(IndexManagerStartContext startContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    CompletableFuture<?> preStop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void stop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void openIndexReaders(Set<String> routingKeys, DirectoryReaderCollector readerCollector) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String mappedTypeName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneSerialWorkOrchestrator indexingOrchestrator(String documentId, String routingKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<LuceneParallelWorkOrchestrator> managementOrchestrators(Set<String> routingKeys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<LuceneParallelWorkOrchestrator> allManagementOrchestrators() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<String> backendName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<Shard> shardsForTests() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Collection<Shard> toShards(Set<String> routingKeys) {
        if (shardingStrategyHolder == null || routingKeys.isEmpty()) {
            // No sharding or no routing key => target all shards
            return shards.values();
        }
        Set<String> shardIdentifiers = shardingStrategyHolder.get().toShardIdentifiers(routingKeys);
        Collection<Shard> enabledShards = new HashSet<>();
        for (String shardId : shardIdentifiers) {
            enabledShards.add(shards.get(shardId));
        }
        return enabledShards;
    }

    private Shard toShard(String documentId, String routingKey) {
        if (shardingStrategyHolder == null) {
            // Sharding is disabled: there's only one shard
            return shards.values().iterator().next();
        }
        String shardId = shardingStrategyHolder.get().toShardIdentifier(documentId, routingKey);
        return shards.get(shardId);
    }
}
