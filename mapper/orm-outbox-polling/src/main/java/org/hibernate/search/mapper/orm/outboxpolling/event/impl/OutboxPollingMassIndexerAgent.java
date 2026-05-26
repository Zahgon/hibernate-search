/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.event.impl;

import java.time.Clock;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.hibernate.search.engine.backend.orchestration.spi.SingletonTask;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.mapper.orm.automaticindexing.spi.AutomaticIndexingMappingContext;
import org.hibernate.search.mapper.orm.common.spi.SessionHelper;
import org.hibernate.search.mapper.orm.common.spi.TransactionHelper;
import org.hibernate.search.mapper.orm.outboxpolling.cfg.HibernateOrmMapperOutboxPollingSettings;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.AgentRepositoryProvider;
import org.hibernate.search.mapper.orm.outboxpolling.logging.impl.OutboxPollingEventsLog;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexerAgent;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexerAgentStartContext;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.spi.ToStringTreeAppendable;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

public final class OutboxPollingMassIndexerAgent implements PojoMassIndexerAgent, ToStringTreeAppendable {

    private static String name(String tenantId) {
        StringBuilder prefix = new StringBuilder("Mass indexer agent");
        if (tenantId != null) {
            prefix.append(" - Tenant <").append(tenantId).append(">");
        }
        return prefix.toString();
    }

    private static final ConfigurationProperty<Integer> POLLING_INTERVAL = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.MASS_INDEXER_POLLING_INTERVAL).asIntegerStrictlyPositive().withDefault(HibernateOrmMapperOutboxPollingSettings.Defaults.COORDINATION_MASS_INDEXER_POLLING_INTERVAL).build();

    private static final ConfigurationProperty<Integer> PULSE_INTERVAL = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.MASS_INDEXER_PULSE_INTERVAL).asIntegerStrictlyPositive().withDefault(HibernateOrmMapperOutboxPollingSettings.Defaults.COORDINATION_MASS_INDEXER_PULSE_INTERVAL).build();

    private static final ConfigurationProperty<Integer> PULSE_EXPIRATION = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.MASS_INDEXER_PULSE_EXPIRATION).asIntegerStrictlyPositive().withDefault(HibernateOrmMapperOutboxPollingSettings.Defaults.COORDINATION_MASS_INDEXER_PULSE_EXPIRATION).build();

    public static Factory factory(AutomaticIndexingMappingContext mapping, Clock clock, String tenantId, ConfigurationPropertySource configurationSource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Factory {

        private final AutomaticIndexingMappingContext mapping;

        private final Clock clock;

        private final String tenantId;

        private final Duration pollingInterval;

        private final Duration pulseInterval;

        private final Duration pulseExpiration;

        private Factory(AutomaticIndexingMappingContext mapping, Clock clock, String tenantId, Duration pollingInterval, Duration pulseInterval, Duration pulseExpiration) {
            this.mapping = mapping;
            this.clock = clock;
            this.tenantId = tenantId;
            this.pollingInterval = pollingInterval;
            this.pulseInterval = pulseInterval;
            this.pulseExpiration = pulseExpiration;
        }

        public OutboxPollingMassIndexerAgent create(AgentRepositoryProvider agentRepositoryProvider) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private enum Status {

        STOPPED, STARTED
    }

    private final String name;

    private final long pollingInterval;

    private final AtomicReference<Status> status = new AtomicReference<>(Status.STOPPED);

    private final OutboxPollingMassIndexerAgentClusterLink clusterLink;

    private final AgentClusterLinkContextProvider clusterLinkContextProvider;

    private final Worker worker;

    private SingletonTask processingTask;

    private OutboxPollingMassIndexerAgent(String name, Factory factory, AgentRepositoryProvider agentRepositoryProvider, OutboxPollingMassIndexerAgentClusterLink clusterLink) {
        this.name = name;
        AutomaticIndexingMappingContext mapping = factory.mapping;
        this.pollingInterval = factory.pollingInterval.toMillis();
        Object tenantId = mapping.tenancyConfiguration().convert(factory.tenantId);
        this.clusterLink = clusterLink;
        TransactionHelper transactionHelper = new TransactionHelper(mapping.sessionFactory(), null);
        SessionHelper sessionHelper = new SessionHelper(mapping.sessionFactory(), tenantId);
        this.clusterLinkContextProvider = new AgentClusterLinkContextProvider(transactionHelper, sessionHelper, agentRepositoryProvider);
        this.worker = new Worker();
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void appendTo(ToStringTreeAppender appender) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> start(PojoMassIndexerAgentStartContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> preStop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void stop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void leaveCluster() {
        clusterLinkContextProvider.inTransaction(clusterLink::leaveCluster);
    }

    private class Worker implements SingletonTask.Worker {

        private volatile OutboxPollingMassIndexingInstructions instructions;

        private final CompletableFuture<?> agentFullyStartedFuture = new CompletableFuture<>();

        @Override
        public CompletableFuture<?> work() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void complete() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void ensureScheduled() {
            // Only schedule the task while the Hibernate Search is started;
            // as soon as Hibernate Search stops,
            // we will finish processing the current batch of events and leave
            // the remaining events to be processed when the application restarts.
            if (status.get() == Status.STARTED) {
                processingTask.ensureScheduled();
            }
        }
    }

    private class Scheduler implements SingletonTask.Scheduler {

        private final ScheduledExecutorService delegate;

        private Scheduler(ScheduledExecutorService delegate) {
            this.delegate = delegate;
        }

        @Override
        public Future<?> schedule(Runnable runnable) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
