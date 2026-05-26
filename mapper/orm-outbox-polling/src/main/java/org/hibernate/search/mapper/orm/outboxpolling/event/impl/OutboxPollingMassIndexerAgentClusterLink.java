/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.event.impl;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.Agent;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.AgentPersister;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.AgentState;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.AgentType;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.ClusterDescriptor;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.ShardAssignmentDescriptor;
import org.hibernate.search.mapper.orm.outboxpolling.logging.impl.OutboxPollingEventsLog;

public final class OutboxPollingMassIndexerAgentClusterLink extends AbstractAgentClusterLink<OutboxPollingMassIndexingInstructions> {

    private static final ClusterDescriptor SINGLE_NODE_CLUSTER_DESCRIPTOR = null;

    private static final ShardAssignmentDescriptor SINGLE_NODE_SHARD_ASSIGNMENT = null;

    public OutboxPollingMassIndexerAgentClusterLink(String agentName, FailureHandler failureHandler, Clock clock, Duration pollingInterval, Duration pulseInterval, Duration pulseExpiration) {
        super(new AgentPersister(AgentType.MASS_INDEXING, agentName, null), failureHandler, clock, pollingInterval, pulseInterval, pulseExpiration);
    }

    @Override
    protected WriteAction<OutboxPollingMassIndexingInstructions> doPulse(List<Agent> allAgentsInIdOrder, Agent currentSelf) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean eventProcessorsAreSuspended(List<Agent> eventProcessors) {
        AgentState expectedState = AgentState.SUSPENDED;
        for (Agent eventProcessor : eventProcessors) {
            if (!expectedState.equals(eventProcessor.getState())) {
                OutboxPollingEventsLog.INSTANCE.agentWaitingForEvents(selfReference(), eventProcessor.getReference(), expectedState);
                return false;
            }
        }
        OutboxPollingEventsLog.INSTANCE.agentProcessorsExpired(selfReference(), expectedState);
        return true;
    }

    @Override
    protected OutboxPollingMassIndexingInstructions instructCommitAndRetryPulseAfterDelay(Instant now, Duration delay) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private OutboxPollingMassIndexingInstructions instructProceedWithMassIndexing(Instant now) {
        Instant expiration = now.plus(pulseInterval);
        OutboxPollingEventsLog.INSTANCE.agentProceedMassIndexing(selfReference(), pulseInterval, expiration);
        return new OutboxPollingMassIndexingInstructions(clock, expiration, true);
    }
}
