/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.orchestration.impl;

import java.util.concurrent.CompletableFuture;
import org.hibernate.search.backend.lucene.work.impl.IndexingWork;
import org.hibernate.search.engine.backend.orchestration.spi.BatchedWork;

public class LuceneBatchedWork<T> implements BatchedWork<LuceneBatchedWorkProcessor> {

    public final IndexingWork<T> work;

    public final CompletableFuture<T> future;

    LuceneBatchedWork(IndexingWork<T> work, CompletableFuture<T> future) {
        this.work = work;
        this.future = future;
    }

    @Override
    public void submitTo(LuceneBatchedWorkProcessor processor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void markAsFailed(Throwable t) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    String getQueuingKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
