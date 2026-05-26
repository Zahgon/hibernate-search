/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.massindexing.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;
import org.hibernate.search.engine.common.EntityReference;
import org.hibernate.search.mapper.pojo.logging.impl.MassIndexingLog;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingEntityFailureContext;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingFailureContext;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingFailureHandler;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingMonitor;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingTypeGroupMonitor;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexingSessionContext;
import org.hibernate.search.mapper.pojo.reporting.impl.PojoMassIndexerMessages;

/**
 * A central object to which various are reported,
 * responsible for notifying the user about these events.
 */
public class PojoMassIndexingNotifier {

    private final MassIndexingFailureHandler failureHandler;

    private final MassIndexingMonitor monitor;

    private final AtomicReference<RecordedFailure> firstFailure = new AtomicReference<>(null);

    private final LongAdder failureCount = new LongAdder();

    private final Map<String, AtomicLong> failureCounts = Collections.synchronizedMap(new HashMap<>());

    private final long failureFloodingThreshold;

    public PojoMassIndexingNotifier(MassIndexingFailureHandler failureHandler, MassIndexingMonitor monitor, Long failureFloodingThreshold) {
        this.failureHandler = failureHandler;
        this.monitor = monitor;
        this.failureFloodingThreshold = Optional.ofNullable(failureFloodingThreshold).orElseGet(failureHandler::failureFloodingThreshold);
    }

    MassIndexingTypeGroupMonitor typeGroupMonitor(MassIndexingTypeGroupContext<?> context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void reportError(Error error) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void reportInterrupted(InterruptedException exception) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void reportRunnableFailure(Exception exception, String operation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void reportEntitiesLoaded(int size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void reportDocumentBuilt() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void reportDocumentsAdded(int size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void reportEntityIndexingFailure(PojoMassIndexingIndexedTypeGroup<?> typeGroup, PojoMassIndexingSessionContext sessionContext, Object entity, Exception exception) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void reportEntitiesLoadingFailure(PojoMassIndexingIndexedTypeGroup<?> typeGroup, List<?> idList, Exception exception) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean shouldNotBeReported(String operation) {
        long failuresSoFar = failureCounts.computeIfAbsent(operation, s -> new AtomicLong(0)).incrementAndGet();
        return failureFloodingThreshold < failuresSoFar;
    }

    void reportIndexingCompleted() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private RecordedFailure recordFailure(Exception exception, boolean recordSuppressed) {
        RecordedFailure recordedFailure = new RecordedFailure(exception);
        boolean isFirst = firstFailure.compareAndSet(null, recordedFailure);
        failureCount.increment();
        if (!isFirst && recordSuppressed) {
            firstFailure.get().throwable.addSuppressed(exception);
        }
        return recordedFailure;
    }

    private EntityReference extractReferenceOrSuppress(PojoMassIndexingIndexedTypeGroup<?> typeGroup, PojoMassIndexingSessionContext sessionContext, Object entity, Throwable throwable) {
        try {
            return typeGroup.extractReference(sessionContext, entity);
        } catch (RuntimeException e) {
            // We failed to extract a reference.
            // Let's just give up and suppress the exception.
            throwable.addSuppressed(e);
            return null;
        }
    }

    private static class RecordedFailure {

        private final Throwable throwable;

        private volatile Object entityReference;

        RecordedFailure(Throwable throwable) {
            this.throwable = throwable;
        }
    }
}
