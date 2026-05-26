/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.cluster.impl;

import java.time.Instant;
import java.util.Collections;
import org.hibernate.search.mapper.orm.outboxpolling.logging.impl.OutboxPollingEventsLog;
import org.hibernate.search.util.common.spi.ToStringTreeAppendable;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

public final class AgentPersister implements ToStringTreeAppendable {

    private final AgentType type;

    private final String name;

    private final ShardAssignmentDescriptor staticShardAssignment;

    private AgentReference selfReference;

    public AgentPersister(AgentType type, String name, ShardAssignmentDescriptor staticShardAssignment) {
        this.type = type;
        this.name = name;
        this.staticShardAssignment = staticShardAssignment;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void appendTo(ToStringTreeAppender appender) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AgentReference selfReference() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Accessible for test purposes only
    public void setSelfReferenceForTests(AgentReference selfReference) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Agent findSelf(AgentRepository agentRepository) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void createSelf(AgentRepository agentRepository, Instant expiration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void leaveCluster(AgentRepository store) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSuspended(Agent self) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setWaiting(Agent self, ClusterDescriptor clusterDescriptor, ShardAssignmentDescriptor shardAssignment) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRunning(Agent self, ClusterDescriptor clusterDescriptor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
