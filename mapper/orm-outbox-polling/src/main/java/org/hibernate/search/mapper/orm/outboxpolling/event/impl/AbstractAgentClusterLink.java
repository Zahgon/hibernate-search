/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.event.impl;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.Agent;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.AgentPersister;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.AgentReference;
import org.hibernate.search.mapper.orm.outboxpolling.logging.impl.OutboxPollingEventsLog;
import org.hibernate.search.util.common.spi.ToStringTreeAppendable;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

abstract class AbstractAgentClusterLink<R> implements ToStringTreeAppendable {

    protected final FailureHandler failureHandler;

    protected final Clock clock;

    protected final Duration pollingInterval;

    protected final Duration pulseInterval;

    protected final Duration pulseExpiration;

    private final AgentPersister agentPersister;

    public AbstractAgentClusterLink(AgentPersister agentPersister, FailureHandler failureHandler, Clock clock, Duration pollingInterval, Duration pulseInterval, Duration pulseExpiration) {
        this.agentPersister = agentPersister;
        this.failureHandler = failureHandler;
        this.clock = clock;
        this.pollingInterval = pollingInterval;
        this.pulseInterval = pulseInterval;
        this.pulseExpiration = pulseExpiration;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void appendTo(ToStringTreeAppender appender) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public final R pulse(AgentClusterLinkContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Agent ensureRegistered(AgentClusterLinkContext context) {
        Agent self = agentPersister.findSelf(context.agentRepository());
        if (self == null) {
            Instant now = clock.instant();
            agentPersister.createSelf(context.agentRepository(), now.plus(pulseExpiration));
            // Make sure the transaction *only* registers the agent,
            // so that the risk of deadlocks (see below) is minimal
            // and other agents are made aware of this agent as soon as possible.
            // This avoids unnecessary rebalancing when multiple nodes start in quick succession.
            context.commitAndBeginNewTransaction();
            self = findSelfExpectRegistered(context);
        }
        return self;
    }

    private Agent findSelfExpectRegistered(AgentClusterLinkContext context) {
        Agent self = agentPersister.findSelf(context.agentRepository());
        if (self == null) {
            throw OutboxPollingEventsLog.INSTANCE.agentRegistrationIneffective(selfReference());
        }
        return self;
    }

    protected abstract WriteAction<R> doPulse(List<Agent> allAgentsInIdOrder, Agent self);

    /**
     * Instructs the processor to commit the transaction, wait for the given delay, then pulse again.
     * <p>
     * Use with:
     * <ul>
     * <li>pollingInterval to apply a minimal delay before the next pulse, to avoid hitting the database continuously.
     *     Useful when waiting for external changes.</li>
     * <li>pulseInterval to apply a large delay before the next pulse.
     *     Useful when suspended and waiting for a reason to resume.</li>
     * </ul>
     */
    protected abstract R instructCommitAndRetryPulseAfterDelay(Instant now, Duration delay);

    public final void leaveCluster(AgentClusterLinkContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected AgentReference selfReference() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    final AgentPersister getAgentPersisterForTests() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected interface WriteAction<R> {

        R applyAndReturnInstructions(Instant now, Agent self, AgentPersister agentPersister);
    }
}
