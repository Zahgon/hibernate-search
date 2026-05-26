/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.standalone.massindexing.impl;

import java.util.concurrent.CompletionStage;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingEnvironment;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingFailureHandler;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingMonitor;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexer;
import org.hibernate.search.mapper.pojo.standalone.loading.impl.StandalonePojoLoadingContext;
import org.hibernate.search.mapper.pojo.standalone.massindexing.MassIndexer;

public class StandalonePojoMassIndexer implements MassIndexer {

    private final PojoMassIndexer delegate;

    private final StandalonePojoLoadingContext context;

    public StandalonePojoMassIndexer(PojoMassIndexer delegate, StandalonePojoLoadingContext context) {
        this.delegate = delegate;
        this.context = context;
    }

    @Override
    public MassIndexer typesToIndexInParallel(int threadsToIndexObjects) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer threadsToLoadObjects(int numberOfThreads) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer batchSizeToLoadObjects(int batchSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer mergeSegmentsOnFinish(boolean enable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer mergeSegmentsAfterPurge(boolean enable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer dropAndCreateSchemaOnStart(boolean dropAndCreateSchema) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer purgeAllOnStart(boolean purgeAll) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletionStage<?> start() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void startAndWait() throws InterruptedException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer monitor(MassIndexingMonitor monitor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer failureHandler(MassIndexingFailureHandler failureHandler) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer failureFloodingThreshold(long threshold) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> MassIndexer context(Class<T> contextType, T context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer environment(MassIndexingEnvironment environment) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer failFast(boolean failFast) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
