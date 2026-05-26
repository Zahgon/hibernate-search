/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.massindexing.impl;

import org.hibernate.search.mapper.pojo.massindexing.MassIndexingEnvironment;
import org.hibernate.search.mapper.pojo.reporting.impl.PojoMassIndexerMessages;

/**
 * Common parent of all Runnable implementations for the batch indexing:
 * share the code for handling runtime exceptions.
 */
public abstract class PojoMassIndexingFailureHandledRunnable implements Runnable {

    private final PojoMassIndexingNotifier notifier;

    private final MassIndexingEnvironment environment;

    protected PojoMassIndexingFailureHandledRunnable(PojoMassIndexingNotifier notifier, MassIndexingEnvironment environment) {
        this.notifier = notifier;
        this.environment = environment;
    }

    @Override
    public final void run() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract void runWithFailureHandler() throws InterruptedException;

    protected abstract void cleanUpOnInterruption() throws InterruptedException;

    protected abstract void cleanUpOnFailure() throws InterruptedException;

    protected MassIndexingEnvironment.Context createMassIndexingEnvironmentContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean supportsThreadLifecycleHooks() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void beforeExecution() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void afterExecution() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final PojoMassIndexingNotifier getNotifier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final MassIndexingEnvironment getMassIndexingEnvironment() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void notifySuccess() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void notifyError(Error error) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void notifyInterrupted(InterruptedException exception) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void notifyFailure(RuntimeException exception) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected String operationName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
