/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.event.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.search.engine.reporting.EntityIndexingFailureContext;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.mapper.orm.outboxpolling.logging.impl.OutboxPollingEventsLog;
import org.hibernate.search.util.common.SearchException;

public class OutboxEventUpdater {

    private static final int MAX_RETRIES = 3;

    private final FailureHandler failureHandler;

    private final OutboxEventLoader loader;

    private final OutboxEventProcessingPlan processingPlan;

    private final SessionImplementor session;

    private final String processorName;

    private final int retryAfter;

    private final Set<UUID> eventsIds;

    private final Set<UUID> failedEventIds;

    public OutboxEventUpdater(FailureHandler failureHandler, OutboxEventLoader loader, OutboxEventProcessingPlan processingPlan, SessionImplementor session, String processorName, int retryAfter) {
        this.failureHandler = failureHandler;
        this.loader = loader;
        this.processingPlan = processingPlan;
        this.session = session;
        this.processorName = processorName;
        this.retryAfter = retryAfter;
        this.eventsIds = processingPlan.getEvents().stream().map(OutboxEvent::getId).collect(Collectors.toSet());
        this.failedEventIds = processingPlan.getFailedEvents().stream().map(OutboxEvent::getId).collect(Collectors.toSet());
    }

    public boolean thereAreStillEventsToProcess() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Set<UUID> eventsToProcess() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void process() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void notifyMaxRetriesReached(OutboxEvent failedEvent) {
        EntityIndexingFailureContext.Builder builder = EntityIndexingFailureContext.builder();
        SearchException exception = OutboxPollingEventsLog.INSTANCE.maxRetryExhausted(MAX_RETRIES);
        builder.throwable(exception);
        builder.failingOperation("Processing an outbox event.");
        builder.failingEntityReference(processingPlan.entityReference(failedEvent.getEntityName(), failedEvent.getEntityId(), exception));
        failureHandler.handle(builder.build());
    }
}
