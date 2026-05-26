/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.backend.orchestration.spi;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import org.hibernate.search.engine.logging.impl.ExecutorLog;
import org.hibernate.search.engine.reporting.FailureContext;
import org.hibernate.search.engine.reporting.FailureHandler;
import org.hibernate.search.util.common.impl.Futures;

/**
 * A task that can be scheduled for a run and is guaranteed to never run concurrently,
 * regardless of the thread pool it's submitted to.
 */
public final class SingletonTask {

    private final String name;

    private final Runnable runnable;

    private final Scheduler scheduler;

    private final FailureHandler failureHandler;

    private final AtomicReference<Status> status = new AtomicReference<>(Status.IDLE);

    private volatile boolean needsRun;

    private volatile Future<?> nextExecutionFuture;

    private volatile CompletableFuture<?> completionFuture;

    public SingletonTask(String name, Worker worker, Scheduler scheduler, FailureHandler failureHandler) {
        this.name = name;
        this.runnable = new RunnableWrapper(worker);
        this.scheduler = scheduler;
        this.failureHandler = failureHandler;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Ensures the task will run in the future.
     * <ul>
     * <li>If the task is neither scheduled nor running, this schedules the task for execution.</li>
     * <li>If the task is already scheduled but not running, this does nothing: the task remains scheduled.</li>
     * <li>If the task is running: the task execution continues and will trigger re-scheduling
     * when it finishes.</li>
     * </ul>
     */
    public void ensureScheduled() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return A future that completes when all works submitted to the executor so far are completely executed.
     * Works submitted to the executor after entering this method may delay the wait.
     */
    public CompletableFuture<?> completion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Stop the task.
     * <p>
     * Callers must call this as the very last method on this object;
     * any concurrent call may lead to unpredictable results.
     */
    public void stop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void cancelIfNotNull(Future<?> futureToCancel) {
        if (futureToCancel != null) {
            futureToCancel.cancel(false);
        }
    }

    public interface Worker {

        /**
         * Executes a unit of work.
         * <p>
         * If there is no work to do, this shouldn't do anything.
         *
         * @return A future completing when the executor is allowed to call this method again.
         */
        CompletableFuture<?> work();

        /**
         * Executes any outstanding operation, or schedule their execution.
         * <p>
         * Called when the worker is not expected to work in the foreseeable future.
         */
        void complete();
    }

    public interface Scheduler {

        Future<?> schedule(Runnable runnable);
    }

    private enum Status {

        IDLE, SCHEDULED
    }

    /**
     * A wrapper for runnables that ensures:
     * <ul>
     *     <li>Failures are reported to the failure handler</li>
     *     <li>The task is re-scheduled after it ran if necessary.</li>
     * </ul>
     */
    private class RunnableWrapper implements Runnable {

        private final Worker worker;

        private final BiFunction<Object, Throwable, Object> workFinishedHandler = Futures.handler(this::onWorkFinished);

        public RunnableWrapper(Worker worker) {
            this.worker = worker;
        }

        @Override
        public void run() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private Void onWorkFinished(Object ignored, Throwable throwable) {
            if (throwable != null) {
                handleUnexpectedFailure(throwable, "Executing task '" + name + "'");
            }
            try {
                afterRun();
            } catch (Throwable e) {
                handleUnexpectedFailure(e, "Handling post-execution in task '" + name + "'");
            }
            return null;
        }

        private void afterRun() {
            if (!needsRun) {
                // We're done running this task.
                // First, tell the worker that we're done.
                try {
                    ExecutorLog.INSTANCE.completedTask(name);
                    worker.complete();
                } catch (Throwable e) {
                    handleUnexpectedFailure(e, "Calling worker.complete() in task '" + name + "'");
                }
                // Tell callers of getCompletion()
                CompletableFuture<?> justFinishedExecutionFuture = completionFuture;
                completionFuture = null;
                justFinishedExecutionFuture.complete(null);
            }
            // Allow this thread (or others) to run processing again.
            status.set(Status.IDLE);
            // A call to ensureScheduled() may have happened before we reset the status above,
            // in which case it did not schedule the task because it was running.
            // If there is still work to do, ensure the task is scheduled
            // and will ultimately take care of the remaining work.
            if (needsRun) {
                ensureScheduled();
            }
        }

        // This will only be called if there is a bug in the task, but we don't want to fail silently.
        private void handleUnexpectedFailure(Throwable throwable, String failingOperation) {
            FailureContext.Builder contextBuilder = FailureContext.builder();
            contextBuilder.throwable(throwable);
            contextBuilder.failingOperation(failingOperation);
            failureHandler.handle(contextBuilder.build());
        }
    }
}
