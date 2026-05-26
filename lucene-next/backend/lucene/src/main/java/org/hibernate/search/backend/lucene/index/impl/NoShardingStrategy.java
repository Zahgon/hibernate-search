/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.index.impl;

import java.util.Set;
import org.hibernate.search.backend.lucene.index.spi.ShardingStrategy;
import org.hibernate.search.backend.lucene.index.spi.ShardingStrategyInitializationContext;
import org.hibernate.search.util.common.AssertionFailure;

public class NoShardingStrategy implements ShardingStrategy {

    public static final String NAME = "none";

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

    private AssertionFailure shouldNotHappen() {
        return new AssertionFailure("This should not be called");
    }
}
