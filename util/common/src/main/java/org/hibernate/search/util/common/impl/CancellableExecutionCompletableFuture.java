/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.impl;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.hibernate.search.util.common.logging.impl.CommonMiscLog;

/**
 * A {@link CompletableFuture} that, upon cancellation,
 * will not only change its state, but also try to cancel (abort) the corresponding operation.
 * @param <T> The return type of the future.
 */
class CancellableExecutionCompletableFuture<T> extends CompletableFuture<T> {

    private final Future<?> future;

    CancellableExecutionCompletableFuture(Runnable runnable, ExecutorService executor) {
        this.future = executor.submit(new CompletingRunnable<>(this, runnable));
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class CompletingRunnable<T> implements Runnable {

        private final CompletableFuture<T> future;

        private final Runnable delegate;

        private CompletingRunnable(CompletableFuture<T> future, Runnable delegate) {
            this.future = future;
            this.delegate = delegate;
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void run() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
