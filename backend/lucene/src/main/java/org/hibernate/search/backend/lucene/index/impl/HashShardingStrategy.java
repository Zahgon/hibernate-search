/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.index.impl;

import java.util.LinkedHashSet;
import java.util.Set;
import org.hibernate.search.backend.lucene.cfg.LuceneIndexSettings;
import org.hibernate.search.backend.lucene.index.spi.ShardingStrategy;
import org.hibernate.search.backend.lucene.index.spi.ShardingStrategyInitializationContext;
import org.hibernate.search.backend.lucene.logging.impl.ConfigurationLog;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.cfg.spi.OptionalConfigurationProperty;
import org.hibernate.search.util.common.data.impl.HashTable;
import org.hibernate.search.util.common.data.impl.ModuloHashTable;
import org.hibernate.search.util.common.data.impl.SimpleHashFunction;

public class HashShardingStrategy implements ShardingStrategy {

    public static final String NAME = "hash";

    private static final OptionalConfigurationProperty<Integer> NUMBER_OF_SHARDS = ConfigurationProperty.forKey(LuceneIndexSettings.ShardingRadicals.NUMBER_OF_SHARDS).asIntegerStrictlyPositive().build();

    private HashTable<String> shardIds;

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

    private String toShardIdentifier(String routingKey) {
        return shardIds.get(routingKey);
    }
}
