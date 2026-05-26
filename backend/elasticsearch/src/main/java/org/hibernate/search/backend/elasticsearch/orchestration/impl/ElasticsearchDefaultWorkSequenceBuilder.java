/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.orchestration.impl;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import org.hibernate.search.backend.elasticsearch.logging.spi.ElasticsearchClientLog;
import org.hibernate.search.backend.elasticsearch.work.impl.BulkableWork;
import org.hibernate.search.backend.elasticsearch.work.impl.ElasticsearchWork;
import org.hibernate.search.backend.elasticsearch.work.impl.ElasticsearchWorkExecutionContext;
import org.hibernate.search.backend.elasticsearch.work.impl.NonBulkableWork;
import org.hibernate.search.backend.elasticsearch.work.result.impl.BulkResult;
import org.hibernate.search.util.common.impl.Futures;

/**
 * A simple implementation of {@link ElasticsearchWorkSequenceBuilder}.
 */
class ElasticsearchDefaultWorkSequenceBuilder implements ElasticsearchWorkSequenceBuilder {

    private final ElasticsearchWorkExecutionContext context;

    private SequenceContext currentlyBuildingSequenceContext;

    ElasticsearchDefaultWorkSequenceBuilder(ElasticsearchWorkExecutionContext context) {
        this.context = context;
    }

    @Override
    public void init(CompletableFuture<?> previous) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Add a step to execute a new work.
     * <p>
     * A failure in the previous work will lead to the new work being marked as skipped,
     * and a failure during the new work will lead to the new work being marked
     * as failed.
     *
     * @param work The work to be executed
     */
    @Override
    public <T> CompletableFuture<T> addNonBulkExecution(NonBulkableWork<T> work) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Add a step to execute a bulk work.
     * <p>
     * The bulk work won't be marked as skipped or failed, regardless of errors.
     * Only the bulked works will be marked (as skipped) if a previous work or the bulk work fails.
     *
     * @param workFuture The work to be executed
     */
    @Override
    public CompletableFuture<BulkResult> addBulkExecution(CompletableFuture<? extends NonBulkableWork<BulkResult>> workFuture) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> CompletableFuture<T> addBulkResultExtraction(CompletableFuture<BulkResult> bulkResultFuture, BulkableWork<T> bulkedWork, int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<Void> build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final class PreviousWorkException extends RuntimeException {

        public PreviousWorkException(Throwable cause) {
            super(cause);
        }
    }

    /**
     * Regroups all objects that may be shared among multiple steps in the same sequence.
     * <p>
     * This was introduced to make references to data from a previous sequence less likely;
     * see
     * org.hibernate.search.backend.elasticsearch.orchestration.impl.ElasticsearchDefaultWorkSequenceBuilderTest#intertwinedSequenceExecution()
     * for an example of what can go wrong if we don't take care to avoid that.
     */
    private static final class SequenceContext {

        private final ElasticsearchWorkExecutionContext executionContext;

        private CompletableFuture<Void> tail;

        SequenceContext(ElasticsearchWorkExecutionContext executionContext, CompletableFuture<?> previous) {
            this.executionContext = executionContext;
            updateTail(previous);
        }

        <T> CompletionStage<T> execute(NonBulkableWork<T> work) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void updateTail(CompletableFuture<?> workFuture) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private abstract static class AbstractWorkExecutionState<T, W extends ElasticsearchWork> {

        protected final SequenceContext sequenceContext;

        protected final W work;

        /*
		 * Use a different future for the caller than the one used in the sequence,
		 * because we manipulate internal exceptions in the sequence
		 * that should not be exposed to the caller.
		 */
        final CompletableFuture<T> workFutureForCaller = new CompletableFuture<>();

        private AbstractWorkExecutionState(SequenceContext sequenceContext, W work) {
            this.sequenceContext = sequenceContext;
            this.work = work;
        }

        protected CompletableFuture<T> addPostExecutionHandlers(CompletableFuture<T> workExecutionFuture) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected T fail(Throwable throwable) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class NonBulkedWorkExecutionState<R> extends AbstractWorkExecutionState<R, NonBulkableWork<R>> {

        private NonBulkedWorkExecutionState(SequenceContext sequenceContext, NonBulkableWork<R> work) {
            super(sequenceContext, work);
        }

        CompletableFuture<R> onPreviousWorkComplete(Object ignored) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class BulkedWorkExecutionState<R> extends AbstractWorkExecutionState<R, BulkableWork<R>> {

        private final BulkableWork<R> bulkedWork;

        private final int index;

        private BulkResult bulkResult;

        private BulkedWorkExecutionState(SequenceContext sequenceContext, BulkableWork<R> bulkedWork, int index) {
            super(sequenceContext, bulkedWork);
            this.bulkedWork = bulkedWork;
            this.index = index;
        }

        void onBulkWorkComplete(Object ignored, Throwable throwable) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        CompletableFuture<R> onBulkWorkSuccess(BulkResult bulkResult) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private CompletableFuture<R> extract() {
            return CompletableFuture.completedFuture(bulkResult.extract(sequenceContext.executionContext, bulkedWork, index));
        }
    }
}
