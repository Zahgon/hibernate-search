/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.massindexing.impl;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import org.hibernate.search.engine.tenancy.spi.TenancyMode;
import org.hibernate.search.mapper.pojo.logging.impl.MassIndexingLog;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingDefaultCleanOperation;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingEnvironment;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingFailureHandler;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingMonitor;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexer;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexingContext;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexingMappingContext;
import org.hibernate.search.mapper.pojo.schema.management.spi.PojoScopeSchemaManager;
import org.hibernate.search.mapper.pojo.scope.spi.PojoScopeDelegate;
import org.hibernate.search.util.common.impl.Futures;

/**
 * Prepares and configures a BatchIndexingWorkspace to start rebuilding
 * the indexes for all entity instances in the database.The type of these entities is either all indexed entities or a
 * subset, always including all subtypes.
 *
 * @author Sanne Grinovero
 */
public class PojoDefaultMassIndexer implements PojoMassIndexer {

    private static final MassIndexingEnvironment DO_NOTHING_ENVIRONMENT = new MassIndexingEnvironment() {

        @Override
        public void beforeExecution(Context context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void afterExecution(Context context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    };

    private final PojoMassIndexingContext massIndexingContext;

    private final PojoMassIndexingMappingContext mappingContext;

    private final PojoMassIndexingTypeContextProvider typeContextProvider;

    private final Set<? extends PojoMassIndexingIndexedTypeContext<?>> targetedIndexedTypes;

    private final PojoScopeSchemaManager scopeSchemaManager;

    private final PojoScopeDelegate<?, ?, ?, ?> pojoScopeDelegate;

    // default settings defined here:
    private int typesToIndexInParallel = 1;

    private int documentBuilderThreads = 6;

    private Boolean mergeSegmentsOnFinish;

    private Boolean dropAndCreateSchemaOnStart;

    private Boolean purgeAtStart;

    private Boolean mergeSegmentsAfterPurge;

    private Boolean failFast;

    private Long failureFloodingThreshold = null;

    private MassIndexingFailureHandler failureHandler;

    private MassIndexingMonitor monitor;

    private MassIndexingEnvironment environment;

    public PojoDefaultMassIndexer(PojoMassIndexingContext massIndexingContext, PojoMassIndexingMappingContext mappingContext, PojoMassIndexingTypeContextProvider typeContextProvider, Set<? extends PojoMassIndexingIndexedTypeContext<?>> targetedIndexedTypes, PojoScopeSchemaManager scopeSchemaManager, PojoScopeDelegate<?, ?, ?, ?> pojoScopeDelegate) {
        this.massIndexingContext = massIndexingContext;
        this.mappingContext = mappingContext;
        this.typeContextProvider = typeContextProvider;
        this.targetedIndexedTypes = targetedIndexedTypes;
        this.scopeSchemaManager = scopeSchemaManager;
        this.pojoScopeDelegate = pojoScopeDelegate;
    }

    @Override
    public PojoDefaultMassIndexer typesToIndexInParallel(int numberOfThreads) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoDefaultMassIndexer threadsToLoadObjects(int numberOfThreads) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoDefaultMassIndexer mergeSegmentsOnFinish(boolean enable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoDefaultMassIndexer mergeSegmentsAfterPurge(boolean enable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoDefaultMassIndexer dropAndCreateSchemaOnStart(boolean enable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoDefaultMassIndexer purgeAllOnStart(boolean enable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoDefaultMassIndexer monitor(MassIndexingMonitor monitor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<?> start() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void startAndWait() throws InterruptedException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private PojoMassIndexingBatchCoordinator createCoordinator() {
        List<PojoMassIndexingIndexedTypeGroup<?>> typeGroupsToIndex = PojoMassIndexingIndexedTypeGroup.disjoint(mappingContext, typeContextProvider, targetedIndexedTypes, massIndexingContext);
        typesToIndexInParallel = Math.min(typesToIndexInParallel, typeGroupsToIndex.size());
        PojoMassIndexingNotifier notifier = new PojoMassIndexingNotifier(getOrCreateFailureHandler(), getOrCreateMonitor(), failureFloodingThreshold);
        if (dropAndCreateSchemaOnStart == null && purgeAtStart == null) {
            // we should decide the defaults:
            MassIndexingDefaultCleanOperation operation = massIndexingContext.massIndexingDefaultCleanOperation();
            purgeAtStart = MassIndexingDefaultCleanOperation.PURGE.equals(operation);
            dropAndCreateSchemaOnStart = MassIndexingDefaultCleanOperation.DROP_AND_CREATE.equals(operation);
        }
        boolean actualDropAndCreateSchemaOnStart = Boolean.TRUE.equals(dropAndCreateSchemaOnStart);
        if (actualDropAndCreateSchemaOnStart) {
            if (Boolean.TRUE.equals(purgeAtStart)) {
                MassIndexingLog.INSTANCE.redundantPurgeAfterDrop();
            }
            if (TenancyMode.MULTI_TENANCY.equals(massIndexingContext.tenancyMode())) {
                // Users are not setting the tenants explicitly,
                //  hence if multitenancy is enabled we cannot  drop the schema:
                throw MassIndexingLog.INSTANCE.schemaDropNotAllowedWithMultitenancy(massIndexingContext.tenantIds());
            }
        }
        return new PojoMassIndexingBatchCoordinator(mappingContext, notifier, typeGroupsToIndex, massIndexingContext, scopeSchemaManager, pojoScopeDelegate, resolvedMassIndexingEnvironment(), typesToIndexInParallel, documentBuilderThreads, mergeSegmentsOnFinish, // false by default:
        actualDropAndCreateSchemaOnStart, // false if not set explicitly and dropAndCreateSchemaOnStart is set to true, otherwise true by default:
        purgeAtStart == null ? !actualDropAndCreateSchemaOnStart : purgeAtStart, mergeSegmentsAfterPurge);
    }

    @Override
    public PojoDefaultMassIndexer failureHandler(MassIndexingFailureHandler failureHandler) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoMassIndexer environment(MassIndexingEnvironment environment) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoMassIndexer failureFloodingThreshold(long threshold) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoMassIndexer failFast(boolean failFast) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private MassIndexingFailureHandler getOrCreateFailureHandler() {
        MassIndexingFailureHandler handler = failureHandler;
        if (handler == null) {
            handler = new PojoMassIndexingDelegatingFailureHandler(mappingContext.failureHandler());
        }
        return new PojoMassIndexingFailSafeFailureHandlerWrapper(handler, Boolean.TRUE.equals(failFast));
    }

    private MassIndexingMonitor getOrCreateMonitor() {
        if (monitor != null) {
            return monitor;
        }
        return new PojoMassIndexingLoggingMonitor();
    }

    private MassIndexingEnvironment resolvedMassIndexingEnvironment() {
        return environment != null ? environment : DO_NOTHING_ENVIRONMENT;
    }
}
