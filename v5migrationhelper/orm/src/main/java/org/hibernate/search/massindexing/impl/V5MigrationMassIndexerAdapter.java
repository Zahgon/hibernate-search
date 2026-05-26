/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.massindexing.impl;

import java.util.concurrent.Future;
import org.hibernate.CacheMode;
import org.hibernate.search.MassIndexer;
import org.hibernate.search.batchindexing.MassIndexerProgressMonitor;
import org.hibernate.search.util.common.annotation.Incubating;

public class V5MigrationMassIndexerAdapter implements MassIndexer {

    private final org.hibernate.search.mapper.orm.massindexing.MassIndexer delegate;

    public V5MigrationMassIndexerAdapter(org.hibernate.search.mapper.orm.massindexing.MassIndexer delegate) {
        this.delegate = delegate;
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
    public MassIndexer cacheMode(CacheMode cacheMode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer optimizeOnFinish(boolean optimize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer optimizeAfterPurge(boolean optimize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer purgeAllOnStart(boolean purgeAll) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @Incubating
    public MassIndexer limitIndexedObjectsTo(long maximum) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Future<?> start() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void startAndWait() throws InterruptedException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer idFetchSize(int idFetchSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer transactionTimeout(int timeoutInSeconds) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer progressMonitor(MassIndexerProgressMonitor monitor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer threadsForSubsequentFetching(int numberOfThreads) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
