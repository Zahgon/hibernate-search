/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.event.impl;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.search.mapper.orm.common.spi.SessionHelper;
import org.hibernate.search.mapper.orm.common.spi.TransactionHelper;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.AgentRepository;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.AgentRepositoryProvider;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.impl.SuppressingCloser;

public class AgentClusterLinkContext {

    private final TransactionHelper transactionHelper;

    private final SessionHelper sessionHelper;

    private final AgentRepositoryProvider agentRepositoryProvider;

    private SessionImplementor session;

    private AgentRepository agentRepository;

    public AgentClusterLinkContext(TransactionHelper transactionHelper, SessionHelper sessionHelper, AgentRepositoryProvider agentRepositoryProvider) {
        this.transactionHelper = transactionHelper;
        this.sessionHelper = sessionHelper;
        this.agentRepositoryProvider = agentRepositoryProvider;
    }

    void begin() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AgentRepository agentRepository() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void commitAndBeginNewTransaction() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void commit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void rollbackLatestTransactionSafely(Throwable t) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
