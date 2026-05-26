/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.jakarta.batch.core.massindexing.step.impl;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;
import jakarta.batch.api.partition.AbstractPartitionAnalyzer;
import jakarta.batch.runtime.context.StepContext;
import jakarta.inject.Inject;
import org.hibernate.search.jakarta.batch.core.logging.impl.JakartaBatchLog;

/**
 * Progress aggregator aggregates the intermediary chunk progress received from each partition sent via the collectors.
 * It runs on the step main thread.
 *
 * @author Mincong Huang
 */
public class ProgressAggregator extends AbstractPartitionAnalyzer {

    @Inject
    private StepContext stepContext;

    /**
     * Analyze data obtained from different partition plans via partition data collectors. The current analyze is to
     * summarize to their progresses : workDone = workDone1 + workDone2 + ... + workDoneN. Then it displays the total
     * mass index progress in percentage. This method is very similar to the current simple progress monitor.
     *
     * @param fromCollector the indexing progress of one partition, obtained from partition collector's method
     * #collectPartitionData()
     */
    @Override
    public void analyzeCollectorData(Serializable fromCollector) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private String formatEntityProgress(String entity, Long processed, Long total) {
        if (total == null) {
            // Total number of entities unknown
            return String.format(Locale.ROOT, "%s: %d entities processed.", entity, processed);
        } else {
            return String.format(Locale.ROOT, "%s: %d/%d entities processed (%.2f%%).", entity, processed, total, processed * 100F / total);
        }
    }
}
