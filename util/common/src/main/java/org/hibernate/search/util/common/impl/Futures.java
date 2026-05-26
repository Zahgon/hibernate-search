/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.impl;

import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import org.hibernate.search.util.common.annotation.impl.SuppressForbiddenApis;

public final class Futures {

    private Futures() {
    }

    /**
     * Create a {@link CompletableFuture} using the given supplier.
     * <p>
     * This method is guaranteed to never throw any exception: any exception thrown by
     * the given supplier will instead complete the resulting future
     * {@link CompletableFuture#completeExceptionally(Throwable) exceptionally}.
     * <p>
     * This is useful in particular if you want to handle errors during the {@link CompletableFuture}
     * creation the same way as errors thrown during post-processing operations
     * (for instance operations passed to {@link CompletableFuture#thenApply(Function)}).
     *
     * @param initiator A supplier that will initiate (synchronously) the asynchronous operation.
     * @return A {@link CompletableFuture} wrapping the result of both the initiation and execution of the operation.
     */
    public static <T> CompletableFuture<T> create(Supplier<CompletableFuture<T>> initiator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a future handler that will delegate to the given {@link Function}
     * after having unwrapped the throwable passed as input if it is a {@link CompletionException}.
     * <p>
     * This method is meant to be used in conjunction with {@link CompletableFuture#exceptionally(Function)}.
     *
     * @param delegate The exception function to delegate to
     * @return The new, delegating exception function.
     */
    public static <T> Function<Throwable, T> handler(Function<Throwable, T> delegate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a future handler that will delegate to the given {@link BiFunction}
     * after having unwrapped the throwable passed as input if it is a {@link CompletionException}.
     * <p>
     * This method is meant to be used in conjunction with {@link CompletableFuture#handle(BiFunction)}.
     *
     * @param delegate The handler to delegate to
     * @return The new, delegating handler.
     */
    public static <T, R> BiFunction<T, Throwable, R> handler(BiFunction<T, Throwable, R> delegate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a future handler that will delegate to the given {@link BiConsumer}
     * after having unwrapped the throwable passed as input if it is a {@link CompletionException}.
     * <p>
     * This method is meant to be used in conjunction with {@link CompletableFuture#whenComplete(BiConsumer)}.
     *
     * @param delegate The handler to delegate to
     * @return The new, delegating handler.
     */
    public static <T> BiConsumer<T, Throwable> handler(BiConsumer<T, Throwable> delegate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a future handler that will copy the state of the handled future
     * to the given future.
     * <p>
     * This method is meant to be used in conjunction with {@link CompletableFuture#whenComplete(BiConsumer)}.
     *
     * @param copyFuture The future to copy to
     * @return the copy handler
     */
    public static <T> BiConsumer<T, Throwable> copyHandler(CompletableFuture<T> copyFuture) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a composition function that will delegate to the given {@link Function}
     * but will catch any exception during composition to return a future completed exceptionally.
     * <p>
     * This method is meant to be used in conjunction with {@link CompletableFuture#thenCompose(Function)}.
     * It is useful in particular when you want to apply the same error handling to the composition
     * function and to the resulting future.
     *
     * @param delegate The composition function to delegate to.
     * @return The new, delegating composition function .
     */
    public static <T, R> Function<T, CompletionStage<R>> safeComposer(Function<? super T, ? extends CompletionStage<R>> delegate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Compose the given future with another as soon as it's complete,
     * regardless of errors, and return a completable future that
     * will take errors of both parent futures into account
     * (using {@link Throwable#addSuppressed(Throwable)} if need be).
     *
     * @param self The future to wait for before launching the next one
     * @param action the composition consumer
     * @return A completable future that will be complete once {@code self} finished executing and
     * {@code action} and its resulting future finished executing.
     */
    public static <T> CompletableFuture<T> whenCompleteExecute(CompletableFuture<?> self, Supplier<? extends CompletionStage<T>> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Call {@link CompletableFuture#join()} and unwrap any {@link CompletionException},
     * expecting the exception to be a {@link RuntimeException}.
     * @param future The future to join on.
     * @param <T> The type of result the future will return.
     * @return The result returned by the future.
     * @throws RuntimeException If the future fails.
     */
    @SuppressForbiddenApis(reason = "Safer wrapper")
    public static <T> T unwrappedExceptionJoin(CompletableFuture<T> future) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Call {@link CompletableFuture#get()} and unwrap any {@link java.util.concurrent.ExecutionException},
     * expecting the exception to be a {@link RuntimeException}.
     * @param future The future to join on.
     * @param <T> The type of result the future will return.
     * @return The result returned by the future.
     * @throws RuntimeException If the future fails.
     * @throws InterruptedException If the thread is interrupted.
     */
    public static <T> T unwrappedExceptionGet(Future<T> future) throws InterruptedException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Similar to {@link CompletableFuture#runAsync(Runnable, Executor)},
     * but calling {@link CompletableFuture#cancel(boolean)} on the returned future actually has an effect
     * and may interrupt the thread.
     * <p>
     * This is mainly useful when the task to execute includes blocking calls,
     * which is usually not the case when dealing with {@link CompletableFuture}.
     *
     * @param runnable the task to submit
     * @param executor an executor to submit the task to
     * @return a {@link CompletableFuture} that will complete once the given runnable has finished executing,
     * potentially with an exception.
     * @throws RejectedExecutionException if the task cannot be scheduled for execution.
     * @throws NullPointerException if the task is null.
     */
    public static CompletableFuture<Void> runAsync(Runnable runnable, ExecutorService executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static RuntimeException wrap(Throwable throwable) {
        if (throwable instanceof RuntimeException) {
            return (RuntimeException) throwable;
        } else {
            return new CompletionException(throwable);
        }
    }

    public static Throwable getThrowableNow(CompletableFuture<?> future) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return a {@link CompletableFuture} that will complete either when one of the future completes exceptionally,
     * or when all futures complete successfully, whichever happens first.
     */
    public static CompletableFuture<?> firstFailureOrAllOf(List<CompletableFuture<?>> allFutures) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
