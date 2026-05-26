/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.massindexing.impl;

import java.time.Duration;
import java.util.OptionalLong;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import org.hibernate.search.mapper.pojo.logging.impl.MassIndexingLog;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingMonitor;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingType;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingTypeGroupMonitor;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingTypeGroupMonitorContext;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingTypeGroupMonitorCreateContext;

/**
 * A very simple implementation of {@code MassIndexerProgressMonitor} which
 * uses the logger at INFO level to output indexing speed statistics.
 *
 * @author Sanne Grinovero
 */
public class PojoMassIndexingLoggingMonitor implements MassIndexingMonitor {

    private final AtomicLong documentsDoneCounter = new AtomicLong();

    private final AtomicReference<StatusMessageInfo> lastMessageInfo = new AtomicReference<>();

    private final LongAdder totalCounter = new LongAdder();

    private volatile long startTime;

    private final int logAfterNumberOfDocuments;

    private boolean countOnStart;

    private boolean countOnBeforeType;

    private final AtomicLong typesToIndex = new AtomicLong();

    private final AtomicLong groupsWithUnknownTotal = new AtomicLong();

    /**
     * Logs progress of indexing job every 50 documents written.
     */
    public PojoMassIndexingLoggingMonitor() {
        this(50);
    }

    /**
     * Logs progress of indexing job every {@code logAfterNumberOfDocuments}
     * documents written.
     *
     * @param logAfterNumberOfDocuments log each time the specified number of documents has been added
     */
    public PojoMassIndexingLoggingMonitor(int logAfterNumberOfDocuments) {
        this(logAfterNumberOfDocuments, false, true);
    }

    public PojoMassIndexingLoggingMonitor(boolean countOnStart, boolean countOnBeforeType) {
        this(50, countOnStart, countOnBeforeType);
    }

    public PojoMassIndexingLoggingMonitor(int logAfterNumberOfDocuments, boolean countOnStart, boolean countOnBeforeType) {
        this.logAfterNumberOfDocuments = logAfterNumberOfDocuments;
        this.countOnStart = countOnStart;
        this.countOnBeforeType = countOnBeforeType;
    }

    @Override
    public MassIndexingTypeGroupMonitor typeGroupMonitor(MassIndexingTypeGroupMonitorCreateContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void documentsAdded(long increment) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void documentsBuilt(long number) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void entitiesLoaded(long size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void indexingCompleted() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected int getStatusMessagePeriod() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void printStatusMessage(long startTime, long currentTime, long totalTodoCount, long doneCount, long typesToIndex, boolean remainingUnknown) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class StatusMessageInfo {

        public static final BinaryOperator<StatusMessageInfo> UPDATE_IF_MORE_UP_TO_DATE_FUNCTION = (StatusMessageInfo storedVal, StatusMessageInfo newVal) -> newVal.isMoreUpToDateThan(storedVal) ? newVal : storedVal;

        public final long currentTime;

        public final long documentsDone;

        public StatusMessageInfo(long currentTime, long documentsDone) {
            this.currentTime = currentTime;
            this.documentsDone = documentsDone;
        }

        public boolean isMoreUpToDateThan(StatusMessageInfo other) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private class MassIndexingTypeGroupMonitorImpl implements MassIndexingTypeGroupMonitor {

        private final long numberOfTypes;

        private final OptionalLong totalBefore;

        private boolean totalUnknown = true;

        public MassIndexingTypeGroupMonitorImpl(MassIndexingTypeGroupMonitorCreateContext context) {
            this.numberOfTypes = context.includedTypes().size();
            if (countOnStart) {
                totalBefore = context.totalCount();
                if (totalBefore.isPresent()) {
                    totalUnknown = false;
                    long count = totalBefore.getAsLong();
                    totalCounter.add(count);
                    MassIndexingLog.INSTANCE.indexingEntitiesApprox(count, context.includedTypes().stream().map(MassIndexingType::entityName).collect(Collectors.joining(", ", "[ ", " ]")));
                }
            } else {
                totalBefore = OptionalLong.empty();
            }
        }

        @Override
        public void documentsIndexed(long increment) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void indexingStarted(MassIndexingTypeGroupMonitorContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void indexingCompleted(MassIndexingTypeGroupMonitorContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
