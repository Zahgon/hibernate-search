/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.cluster.impl;

import java.util.List;
import java.util.UUID;
import org.hibernate.Session;

public class DefaultAgentRepository implements AgentRepository {

    public static final class Provider implements AgentRepositoryProvider {

        @Override
        public AgentRepository create(Session session) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private final Session session;

    private DefaultAgentRepository(Session session) {
        this.session = session;
    }

    @Override
    public Agent find(UUID id) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<Agent> findAllOrderById() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void create(Agent agent) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void delete(List<Agent> agents) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
