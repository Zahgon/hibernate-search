/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.event.impl;

import java.time.Clock;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.PessimisticLockException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.search.engine.backend.orchestration.spi.SingletonTask;
import org.hibernate.search.engine.cfg.ConfigurationPropertySource;
import org.hibernate.search.engine.cfg.spi.ConfigurationProperty;
import org.hibernate.search.engine.cfg.spi.OptionalConfigurationProperty;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.mapper.orm.automaticindexing.spi.AutomaticIndexingMappingContext;
import org.hibernate.search.mapper.orm.common.spi.SessionHelper;
import org.hibernate.search.mapper.orm.common.spi.TransactionHelper;
import org.hibernate.search.mapper.orm.outboxpolling.cfg.HibernateOrmMapperOutboxPollingSettings;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.AgentRepositoryProvider;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.ShardAssignmentDescriptor;
import org.hibernate.search.mapper.orm.outboxpolling.logging.impl.OutboxPollingEventsLog;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.spi.ToStringTreeAppendable;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

public final class OutboxPollingEventProcessor implements ToStringTreeAppendable {

    public static String namePrefix(String tenantId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final ConfigurationProperty<Integer> POLLING_INTERVAL = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.EVENT_PROCESSOR_POLLING_INTERVAL).asIntegerStrictlyPositive().withDefault(HibernateOrmMapperOutboxPollingSettings.Defaults.COORDINATION_EVENT_PROCESSOR_POLLING_INTERVAL).build();

    private static final ConfigurationProperty<Integer> PULSE_INTERVAL = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.EVENT_PROCESSOR_PULSE_INTERVAL).asIntegerStrictlyPositive().withDefault(HibernateOrmMapperOutboxPollingSettings.Defaults.COORDINATION_EVENT_PROCESSOR_PULSE_INTERVAL).build();

    private static final ConfigurationProperty<Integer> PULSE_EXPIRATION = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.EVENT_PROCESSOR_PULSE_EXPIRATION).asIntegerStrictlyPositive().withDefault(HibernateOrmMapperOutboxPollingSettings.Defaults.COORDINATION_EVENT_PROCESSOR_PULSE_EXPIRATION).build();

    private static final ConfigurationProperty<Integer> BATCH_SIZE = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.EVENT_PROCESSOR_BATCH_SIZE).asIntegerStrictlyPositive().withDefault(HibernateOrmMapperOutboxPollingSettings.Defaults.COORDINATION_EVENT_PROCESSOR_BATCH_SIZE).build();

    private static final OptionalConfigurationProperty<Integer> TRANSACTION_TIMEOUT = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.EVENT_PROCESSOR_TRANSACTION_TIMEOUT).asIntegerStrictlyPositive().build();

    private static final ConfigurationProperty<Integer> RETRY_DELAY = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.EVENT_PROCESSOR_RETRY_DELAY).asIntegerPositiveOrZero().withDefault(HibernateOrmMapperOutboxPollingSettings.Defaults.COORDINATION_EVENT_PROCESSOR_RETRY_DELAY).build();

    private static final ConfigurationProperty<Integer> EVENT_PROCESSOR_EVENT_LOCK_RETRY_MAX = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.EVENT_PROCESSOR_EVENT_LOCK_RETRY_MAX).asIntegerPositiveOrZero().withDefault(HibernateOrmMapperOutboxPollingSettings.Defaults.COORDINATION_EVENT_PROCESSOR_EVENT_LOCK_RETRY_MAX).build();

    private static final ConfigurationProperty<Integer> EVENT_PROCESSOR_EVENT_LOCK_RETRY_DELAY = ConfigurationProperty.forKey(HibernateOrmMapperOutboxPollingSettings.CoordinationRadicals.EVENT_PROCESSOR_EVENT_LOCK_RETRY_DELAY).asIntegerPositiveOrZero().withDefault(HibernateOrmMapperOutboxPollingSettings.Defaults.COORDINATION_EVENT_PROCESSOR_EVENT_LOCK_RETRY_DELAY).build();

    public static Factory factory(AutomaticIndexingMappingContext mapping, Clock clock, String tenantId, ConfigurationPropertySource configurationSource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Factory {

        private final AutomaticIndexingMappingContext mapping;

        private final Clock clock;

        private final String tenantId;

        private final OutboxEventLoader loader;

        private final Duration pollingInterval;

        private final Duration pulseInterval;

        private final Duration pulseExpiration;

        private final int batchSize;

        private final int retryDelay;

        private final Integer transactionTimeout;

        private final int lockEventsMaxRetry;

        private final long lockEventsInterval;

        private Factory(AutomaticIndexingMappingContext mapping, Clock clock, String tenantId, OutboxEventLoader loader, Duration pollingInterval, Duration pulseInterval, Duration pulseExpiration, int batchSize, int retryDelay, Integer transactionTimeout, int lockEventsMaxRetry, long lockEventsInterval) {
            this.mapping = mapping;
            this.clock = clock;
            this.tenantId = tenantId;
            this.loader = loader;
            this.pollingInterval = pollingInterval;
            this.pulseInterval = pulseInterval;
            this.pulseExpiration = pulseExpiration;
            this.batchSize = batchSize;
            this.retryDelay = retryDelay;
            this.transactionTimeout = transactionTimeout;
            this.lockEventsMaxRetry = lockEventsMaxRetry;
            this.lockEventsInterval = lockEventsInterval;
        }

        public OutboxPollingEventProcessor create(ScheduledExecutorService scheduledExecutor, OutboxEventFinderProvider finderProvider, AgentRepositoryProvider agentRepositoryProvider, ShardAssignmentDescriptor shardAssignmentOrNull) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private enum Status {

        STOPPED, STARTED
    }

    private final String name;

    private final AutomaticIndexingMappingContext mapping;

    private final OutboxEventLoader loader;

    private final long pollingInterval;

    private final int batchSize;

    private final int retryDelay;

    private final int lockEventsMaxRetry;

    private final long lockEventsInterval;

    private final AtomicReference<Status> status = new AtomicReference<>(Status.STOPPED);

    private final OutboxPollingEventProcessorClusterLink clusterLink;

    private final TransactionHelper transactionHelper;

    private final SessionHelper sessionHelper;

    private final AgentClusterLinkContextProvider clusterLinkContextProvider;

    private final FailureHandler failureHandler;

    private final Worker worker;

    private final SingletonTask processingTask;

    public OutboxPollingEventProcessor(String name, Factory factory, ScheduledExecutorService executor, AgentRepositoryProvider agentRepositoryProvider, OutboxPollingEventProcessorClusterLink clusterLink) {
        this.name = name;
        this.mapping = factory.mapping;
        Object tenantId = mapping.tenancyConfiguration().convert(factory.tenantId);
        this.loader = factory.loader;
        this.pollingInterval = factory.pollingInterval.toMillis();
        this.batchSize = factory.batchSize;
        this.retryDelay = factory.retryDelay;
        this.lockEventsMaxRetry = factory.lockEventsMaxRetry;
        this.lockEventsInterval = factory.lockEventsInterval;
        this.clusterLink = clusterLink;
        transactionHelper = new TransactionHelper(mapping.sessionFactory(), factory.transactionTimeout);
        sessionHelper = new SessionHelper(mapping.sessionFactory(), tenantId);
        this.clusterLinkContextProvider = new AgentClusterLinkContextProvider(transactionHelper, sessionHelper, agentRepositoryProvider);
        failureHandler = mapping.failureHandler();
        this.worker = new Worker();
        processingTask = new SingletonTask(name, worker, new Scheduler(executor), failureHandler);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void appendTo(ToStringTreeAppender appender) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void start() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CompletableFuture<?> completion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CompletableFuture<?> preStop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void stop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void leaveCluster() {
        clusterLinkContextProvider.inTransaction(clusterLink::leaveCluster);
    }

    private class Worker implements SingletonTask.Worker {

        private volatile OutboxPollingEventProcessingInstructions instructions;

        private volatile boolean lastExecutionProcessedEvents;

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
