/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.orchestration.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import org.hibernate.search.backend.elasticsearch.work.impl.BulkableWork;
import org.hibernate.search.backend.elasticsearch.work.impl.NonBulkableWork;
import org.hibernate.search.backend.elasticsearch.work.result.impl.BulkResult;
import org.hibernate.search.engine.backend.work.execution.DocumentRefreshStrategy;

class ElasticsearchDefaultWorkBulker implements ElasticsearchWorkBulker {

    private final ElasticsearchWorkSequenceBuilder sequenceBuilder;

    private final BiFunction<List<? extends BulkableWork<?>>, DocumentRefreshStrategy, NonBulkableWork<BulkResult>> bulkWorkFactory;

    private final int maxBulkSize;

    private final List<BulkableWork<?>> currentBulkItems;

    private DocumentRefreshStrategy currentBulkRefreshStrategy;

    private CompletableFuture<NonBulkableWork<BulkResult>> currentBulkWorkFuture;

    private CompletableFuture<BulkResult> currentBulkResultFuture;

    /**
     * @param sequenceBuilder The sequence builder to add works to
     * @param bulkWorkFactory The factory for bulk works
     * @param maxBulkSize Maximum number of works in a single bulk.
     * If a bulk reaches this size, it will be automatically
     * {@link #finalizeBulkWork() finalized}.
     */
    public ElasticsearchDefaultWorkBulker(ElasticsearchWorkSequenceBuilder sequenceBuilder, BiFunction<List<? extends BulkableWork<?>>, DocumentRefreshStrategy, NonBulkableWork<BulkResult>> bulkWorkFactory, int maxBulkSize) {
        this.sequenceBuilder = sequenceBuilder;
        this.bulkWorkFactory = bulkWorkFactory;
        this.maxBulkSize = maxBulkSize;
        this.currentBulkItems = new ArrayList<>();
        this.currentBulkWorkFuture = null;
        this.currentBulkResultFuture = null;
    }

    @Override
    public <T> CompletableFuture<T> add(BulkableWork<T> work) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void finalizeBulkWork() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
