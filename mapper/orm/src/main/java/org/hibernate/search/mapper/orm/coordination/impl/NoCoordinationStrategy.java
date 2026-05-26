/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.coordination.impl;

import java.util.concurrent.CompletableFuture;
import org.hibernate.search.mapper.orm.coordination.common.spi.CoordinationConfigurationContext;
import org.hibernate.search.mapper.orm.coordination.common.spi.CoordinationStrategy;
import org.hibernate.search.mapper.orm.coordination.common.spi.CoordinationStrategyPreStopContext;
import org.hibernate.search.mapper.orm.coordination.common.spi.CoordinationStrategyStartContext;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexerAgent;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexerAgentCreateContext;

public class NoCoordinationStrategy implements CoordinationStrategy {

    public static final String NAME = "none";

    @Override
    public CompletableFuture<?> start(CoordinationStrategyStartContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void configure(CoordinationConfigurationContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoMassIndexerAgent createMassIndexerAgent(PojoMassIndexerAgentCreateContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> completion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> preStop(CoordinationStrategyPreStopContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void stop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
