/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.event.impl;

import java.util.function.Consumer;
import java.util.function.Function;
import org.hibernate.search.mapper.orm.common.spi.SessionHelper;
import org.hibernate.search.mapper.orm.common.spi.TransactionHelper;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.AgentRepositoryProvider;

public class AgentClusterLinkContextProvider {

    private final TransactionHelper transactionHelper;

    private final SessionHelper sessionHelper;

    private final AgentRepositoryProvider agentRepositoryProvider;

    public AgentClusterLinkContextProvider(TransactionHelper transactionHelper, SessionHelper sessionHelper, AgentRepositoryProvider agentRepositoryProvider) {
        this.transactionHelper = transactionHelper;
        this.sessionHelper = sessionHelper;
        this.agentRepositoryProvider = agentRepositoryProvider;
    }

    public final void inTransaction(Consumer<AgentClusterLinkContext> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <T> T inTransaction(Function<AgentClusterLinkContext, T> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
