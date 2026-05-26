/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.index.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.search.backend.lucene.cfg.LuceneIndexSettings;
import org.hibernate.search.backend.lucene.index.spi.ShardingStrategy;
import org.hibernate.search.backend.lucene.index.spi.ShardingStrategyInitializationContext;
import org.hibernate.search.backend.lucene.logging.impl.ConfigurationLog;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.cfg.spi.OptionalConfigurationProperty;

public class ExplicitShardingStrategy implements ShardingStrategy {

    public static final String NAME = "explicit";

    private static final OptionalConfigurationProperty<List<String>> SHARD_IDENTIFIERS = ConfigurationProperty.forKey(LuceneIndexSettings.ShardingRadicals.SHARD_IDENTIFIERS).asString().multivalued().build();

    private Set<String> shardIdSet;

    @Override
    public void initialize(ShardingStrategyInitializationContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toShardIdentifier(String documentId, String routingKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<String> toShardIdentifiers(Set<String> routingKeys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void checkShardIdentifier(String routingKey) {
        if (!shardIdSet.contains(routingKey)) {
            throw ConfigurationLog.INSTANCE.invalidRoutingKeyForExplicitShardingStrategy(routingKey, shardIdSet);
        }
    }
}
