/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.index.impl;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.hibernate.search.backend.lucene.cfg.LuceneIndexSettings;
import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexModel;
import org.hibernate.search.backend.lucene.index.spi.ShardingStrategy;
import org.hibernate.search.backend.lucene.index.spi.ShardingStrategyInitializationContext;
import org.hibernate.search.backend.lucene.logging.impl.ConfigurationLog;
import org.hibernate.search.engine.backend.index.spi.IndexManagerStartContext;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.bean.BeanResolver;

class ShardingStrategyInitializationContextImpl implements ShardingStrategyInitializationContext {

    private static final ConfigurationProperty<BeanReference<? extends ShardingStrategy>> SHARDING_STRATEGY = ConfigurationProperty.forKey(LuceneIndexSettings.ShardingRadicals.STRATEGY).asBeanReference(ShardingStrategy.class).withDefault(BeanReference.of(ShardingStrategy.class, LuceneIndexSettings.Defaults.SHARDING_STRATEGY)).build();

    private final IndexManagerBackendContext backendContext;

    private final LuceneIndexModel model;

    private final IndexManagerStartContext startContext;

    private final ConfigurationPropertySource shardingPropertySource;

    private Set<String> shardIdentifiers = new LinkedHashSet<>();

    ShardingStrategyInitializationContextImpl(IndexManagerBackendContext backendContext, LuceneIndexModel model, IndexManagerStartContext startContext, ConfigurationPropertySource indexPropertySource) {
        this.backendContext = backendContext;
        this.model = model;
        this.startContext = startContext;
        this.shardingPropertySource = indexPropertySource.withMask("sharding");
    }

    @Override
    public void shardIdentifiers(Set<String> shardIdentifiers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void disableSharding() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String indexName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BeanResolver beanResolver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConfigurationPropertySource configurationPropertySource() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BeanHolder<? extends ShardingStrategy> create(Map<String, Shard> shardCollector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void contributeShard(Map<String, Shard> shardCollector, Optional<String> shardId) {
        Shard shard = new Shard(shardId, backendContext, model);
        shardCollector.put(shardId.orElse(null), shard);
    }
}
