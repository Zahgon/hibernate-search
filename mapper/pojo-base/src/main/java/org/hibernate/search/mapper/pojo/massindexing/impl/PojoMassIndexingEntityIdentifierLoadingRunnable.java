/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.massindexing.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassIdentifierLoader;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassIdentifierLoadingContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassIdentifierSink;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassLoadingContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassLoadingStrategy;
import org.hibernate.search.mapper.pojo.logging.impl.MassIndexingLog;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingEnvironment;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingTypeGroupMonitor;
import org.hibernate.search.mapper.pojo.reporting.impl.PojoMassIndexerMessages;

public class PojoMassIndexingEntityIdentifierLoadingRunnable<E, I> extends PojoMassIndexingFailureHandledRunnable {

    private final MassIndexingTypeGroupMonitor typeGroupMonitor;

    private final MassIndexingTypeGroupContext<E> massIndexingTypeGroupContext;

    private final PojoMassIndexingIndexedTypeGroup<E> typeGroup;

    private final PojoMassLoadingStrategy<E, I> loadingStrategy;

    private final PojoProducerConsumerQueue<List<I>> identifierQueue;

    private final MassIndexingEnvironment.EntityIdentifierLoadingContext identifierLoadingContext;

    public PojoMassIndexingEntityIdentifierLoadingRunnable(PojoMassIndexingNotifier notifier, MassIndexingTypeGroupMonitor typeGroupMonitor, MassIndexingTypeGroupContext<E> massIndexingTypeGroupContext, MassIndexingEnvironment environment, PojoMassIndexingIndexedTypeGroup<E> typeGroup, PojoMassLoadingStrategy<E, I> loadingStrategy, PojoProducerConsumerQueue<List<I>> identifierQueue) {
        super(notifier, environment);
        this.typeGroupMonitor = typeGroupMonitor;
        this.massIndexingTypeGroupContext = massIndexingTypeGroupContext;
        this.loadingStrategy = loadingStrategy;
        this.typeGroup = typeGroup;
        this.identifierQueue = identifierQueue;
        this.identifierLoadingContext = new EntityIdentifierLoadingContextImpl();
    }

    @Override
    protected void runWithFailureHandler() throws InterruptedException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void cleanUpOnFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void cleanUpOnInterruption() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected MassIndexingEnvironment.Context createMassIndexingEnvironmentContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected boolean supportsThreadLifecycleHooks() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected String operationName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class LoadingContext implements PojoMassIdentifierLoadingContext<I> {

        private boolean done = false;

        @Override
        public PojoMassLoadingContext parent() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public PojoMassIdentifierSink<I> createSink() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String tenantIdentifier() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class EntityIdentifierLoadingContextImpl implements MassIndexingEnvironment.EntityIdentifierLoadingContext {
    }
}
