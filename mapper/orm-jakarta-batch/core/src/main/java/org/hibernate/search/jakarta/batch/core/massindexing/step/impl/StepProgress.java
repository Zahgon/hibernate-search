/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.jakarta.batch.core.massindexing.step.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Step level progress. It contains the indexing progress of the step level. In another word, it is the sum of all the
 * elementary, partition-local level progress. The progress is initialized at the first start of the indexing job and
 * reused after the restart.
 *
 * @author Mincong Huang
 */
public class StepProgress implements Serializable {

    private static final long serialVersionUID = 7808926033388850340L;

    /**
     * A map of the total number of rows having already been indexed across all the partitions. Key: the partition id;
     * Value: the number of rows indexed.
     */
    private Map<Integer, Long> partitionProgress;

    /**
     * A map of the total number of rows having already been indexed across all the entity types. Key: the entity name
     * in string; Value: the number of rows indexed.
     */
    private Map<String, Long> entityProgress;

    /**
     * A map of the total number of rows to index across all the entity types. Key: the entity name in string; Value:
     * the number of rows to index.
     */
    private Map<String, Long> entityTotal;

    public StepProgress() {
        partitionProgress = new HashMap<>();
        entityProgress = new HashMap<>();
        entityTotal = new HashMap<>();
    }

    /**
     * Update the step-level indexing progress using the partition-level indexing progress.
     * Compared to partition-level, step-level is a higher level: one step contains multiple
     * partitions.
     *
     * @param pp partition-level indexing progress
     */
    public void updateProgress(PartitionProgress pp) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void increment(String entityName, long increment) {
        long prevDone = entityProgress.getOrDefault(entityName, 0L);
        entityProgress.put(entityName, prevDone + increment);
    }

    private void increment(int pid, long increment) {
        long prevDone = partitionProgress.getOrDefault(pid, 0L);
        partitionProgress.put(pid, prevDone + increment);
    }

    public Map<Integer, Long> getPartitionProgress() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, Long> getEntityProgress() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, Long> getEntityTotal() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRowsToIndex(String entityName, Long rowsToIndex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
