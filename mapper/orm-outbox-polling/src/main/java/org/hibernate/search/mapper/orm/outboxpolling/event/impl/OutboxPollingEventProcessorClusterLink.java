/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.event.impl;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.hibernate.search.engine.reporting.FailureContext;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.Agent;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.AgentPersister;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.AgentState;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.AgentType;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.ClusterDescriptor;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.ShardAssignmentDescriptor;
import org.hibernate.search.mapper.orm.outboxpolling.logging.impl.OutboxPollingEventsLog;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.SearchException;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

public final class OutboxPollingEventProcessorClusterLink extends AbstractAgentClusterLink<OutboxPollingEventProcessingInstructions> {

    private final ShardAssignment.Provider shardAssignmentProvider;

    // Accessible for test purposes
    final boolean shardAssignmentIsStatic;

    ShardAssignment lastShardAssignment;

    public OutboxPollingEventProcessorClusterLink(String agentName, FailureHandler failureHandler, Clock clock, ShardAssignment.Provider shardAssignmentProvider, Duration pollingInterval, Duration pulseInterval, Duration pulseExpiration, ShardAssignmentDescriptor staticShardAssignment) {
        super(new AgentPersister(staticShardAssignment == null ? AgentType.EVENT_PROCESSING_DYNAMIC_SHARDING : AgentType.EVENT_PROCESSING_STATIC_SHARDING, agentName, staticShardAssignment), failureHandler, clock, pollingInterval, pulseInterval, pulseExpiration);
        this.shardAssignmentProvider = shardAssignmentProvider;
        if (staticShardAssignment == null) {
            this.shardAssignmentIsStatic = false;
            this.lastShardAssignment = null;
        } else {
            this.shardAssignmentIsStatic = true;
            this.lastShardAssignment = shardAssignmentProvider.create(staticShardAssignment);
        }
    }

    @Override
    public void appendTo(ToStringTreeAppender appender) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected WriteAction<OutboxPollingEventProcessingInstructions> doPulse(List<Agent> allAgentsInIdOrder, Agent currentSelf) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean excludedAgentsAreOutOfCluster(List<Agent> excludedAgents) {
        if (excludedAgents.isEmpty()) {
            return true;
        }
        AgentState expectedState = AgentState.SUSPENDED;
        for (Agent agent : excludedAgents) {
            if (!expectedState.equals(agent.getState())) {
                OutboxPollingEventsLog.INSTANCE.agentWaitingAgentReachState(selfReference(), agent.getReference(), expectedState);
                return false;
            }
        }
        OutboxPollingEventsLog.INSTANCE.agentExcluded(selfReference(), expectedState);
        return true;
    }

    private boolean clusterMembersAreInCluster(List<Agent> clusterMembersInShardOrder, ClusterDescriptor clusterDescriptor) {
        int expectedTotalShardCount = clusterMembersInShardOrder.size();
        int expectedAssignedShardIndex = 0;
        Set<AgentState> expectedStates = AgentState.WAITING_OR_RUNNING;
        for (Agent agent : clusterMembersInShardOrder) {
            AgentState state = agent.getState();
            if (!expectedStates.contains(agent.getState())) {
                OutboxPollingEventsLog.INSTANCE.clusterMembersAreInClusterWaitingForState(selfReference(), agent.getReference(), state, expectedStates);
                return false;
            }
            Integer totalShardCount = agent.getTotalShardCount();
            if (totalShardCount == null || expectedTotalShardCount != totalShardCount) {
                OutboxPollingEventsLog.INSTANCE.clusterMembersAreInClusterShardCountExpectation(selfReference(), agent.getReference(), totalShardCount, expectedTotalShardCount);
                return false;
            }
            Integer assignedShardIndex = agent.getAssignedShardIndex();
            if (assignedShardIndex == null || expectedAssignedShardIndex != assignedShardIndex) {
                OutboxPollingEventsLog.INSTANCE.clusterMembersAreInClusterSharIndexExpectation(selfReference(), agent.getReference(), assignedShardIndex, expectedAssignedShardIndex);
                return false;
            }
            ++expectedAssignedShardIndex;
        }
        OutboxPollingEventsLog.INSTANCE.clusterMembersAreInClusterReachedExpectedStates(selfReference(), expectedStates, clusterDescriptor);
        return true;
    }

    @Override
    protected OutboxPollingEventProcessingInstructions instructCommitAndRetryPulseAfterDelay(Instant now, Duration delay) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private OutboxPollingEventProcessingInstructions instructProceedWithEventProcessing(Instant now) {
        Instant expiration = now.plus(pulseInterval);
        OutboxPollingEventsLog.INSTANCE.instructProceedWithEventProcessing(selfReference(), pulseInterval, expiration);
        return new OutboxPollingEventProcessingInstructions(clock, expiration, Optional.of(lastShardAssignment.eventFinder));
    }
}
