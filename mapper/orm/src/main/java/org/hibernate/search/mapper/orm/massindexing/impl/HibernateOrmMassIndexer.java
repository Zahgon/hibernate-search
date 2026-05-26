/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.massindexing.impl;

import java.util.concurrent.CompletionStage;
import org.hibernate.CacheMode;
import org.hibernate.search.mapper.orm.loading.spi.ConditionalExpression;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.massindexing.MassIndexerFilteringTypeStep;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingEnvironment;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingFailureHandler;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingMonitor;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexer;

public class HibernateOrmMassIndexer implements MassIndexer {

    private final PojoMassIndexer delegate;

    private final HibernateOrmMassIndexingContext context;

    public HibernateOrmMassIndexer(PojoMassIndexer delegate, HibernateOrmMassIndexingContext context) {
        this.delegate = delegate;
        this.context = context;
    }

    @Override
    public MassIndexer transactionTimeout(int timeoutInSeconds) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer cacheMode(CacheMode cacheMode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexerFilteringTypeStep type(Class<?> type) {
        throw new UnsupportedOperationException("STUB: not implemented");
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
    public HibernateOrmMassIndexer batchSizeToLoadObjects(int batchSize) {
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
    public HibernateOrmMassIndexer limitIndexedObjectsTo(long maximum) {
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
    public HibernateOrmMassIndexer idFetchSize(int idFetchSize) {
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
    public MassIndexer failFast(boolean failFast) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    ConditionalExpression reindexOnly(Class<?> type, String conditionalExpression) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexer environment(MassIndexingEnvironment environment) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
