/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.jakarta.batch.core.massindexing.step.impl;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import jakarta.batch.api.BatchProperty;
import jakarta.batch.api.chunk.AbstractItemWriter;
import jakarta.batch.runtime.context.JobContext;
import jakarta.batch.runtime.context.StepContext;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.LockModeType;
import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.search.engine.backend.work.execution.DocumentCommitStrategy;
import org.hibernate.search.engine.backend.work.execution.DocumentRefreshStrategy;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.engine.backend.work.execution.spi.UnsupportedOperationBehavior;
import org.hibernate.search.jakarta.batch.core.logging.impl.JakartaBatchLog;
import org.hibernate.search.jakarta.batch.core.massindexing.MassIndexingJobParameters;
import org.hibernate.search.jakarta.batch.core.massindexing.impl.JobContextData;
import org.hibernate.search.jakarta.batch.core.massindexing.util.impl.EntityTypeDescriptor;
import org.hibernate.search.jakarta.batch.core.massindexing.util.impl.MassIndexingPartitionProperties;
import org.hibernate.search.jakarta.batch.core.massindexing.util.impl.PersistenceUtil;
import org.hibernate.search.jakarta.batch.core.massindexing.util.impl.SerializationUtil;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.mapping.SearchMapping;
import org.hibernate.search.mapper.orm.spi.BatchMappingContext;
import org.hibernate.search.mapper.orm.tenancy.spi.TenancyConfiguration;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexer;
import org.hibernate.search.mapper.pojo.work.spi.PojoScopeWorkspace;
import org.hibernate.search.util.common.SearchException;
import org.hibernate.search.util.common.impl.Futures;

public class EntityWriter extends AbstractItemWriter {

    private static final String ID_PARAMETER_NAME = "ids";

    @Inject
    private JobContext jobContext;

    @Inject
    private StepContext stepContext;

    @Inject
    @BatchProperty(name = MassIndexingJobParameters.CHECKPOINT_INTERVAL)
    private String serializedCheckpointInterval;

    @Inject
    @BatchProperty(name = MassIndexingJobParameters.CACHE_MODE)
    private String serializedCacheMode;

    @Inject
    @BatchProperty(name = MassIndexingJobParameters.ENTITY_FETCH_SIZE)
    private String serializedEntityFetchSize;

    @Inject
    @BatchProperty(name = MassIndexingPartitionProperties.ENTITY_NAME)
    private String entityName;

    @Inject
    @BatchProperty(name = MassIndexingPartitionProperties.PARTITION_ID)
    private String partitionIdStr;

    @Inject
    @BatchProperty(name = MassIndexingJobParameters.TENANT_ID)
    private String tenantId;

    private CacheMode cacheMode;

    private int entityFetchSize;

    private EntityManagerFactory emf;

    private BatchMappingContext mappingContext;

    private EntityTypeDescriptor<?, ?> type;

    private PojoScopeWorkspace workspace;

    private WriteMode writeMode;

    private TenancyConfiguration tenancyConfiguration;

    /**
     * The open method prepares the writer to write items.
     *
     * @param checkpoint the last checkpoint
     *
     * @throws SearchException if the entityName does not match any indexed class type in the job context data.
     */
    @Override
    public void open(Serializable checkpoint) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void writeItems(List<Object> entityIds) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // because there is no alternative till we get ORM 8 and JPA 4 ...
    @SuppressWarnings({ "removal" })
    private List<?> loadEntities(SessionImplementor session, List<Object> entityIds) {
        return type.createLoadingQuery(session, ID_PARAMETER_NAME).setParameter(ID_PARAMETER_NAME, entityIds).setReadOnly(true).setCacheable(false).setLockMode(LockModeType.NONE).setCacheMode(cacheMode).setQueryFlushMode(// FlushMode.MANUAL
        org.hibernate.query.QueryFlushMode.NO_FLUSH).setFetchSize(entityFetchSize).list();
    }

    private void indexAndWaitForCompletion(List<?> entities, PojoIndexer indexer) {
        if (entities == null || entities.isEmpty()) {
            return;
        }
        CompletableFuture<?>[] indexingFutures = new CompletableFuture<?>[entities.size()];
        for (int i = 0; i < entities.size(); i++) {
            indexingFutures[i] = writeItem(indexer, entities.get(i));
        }
        try {
            Futures.unwrappedExceptionGet(CompletableFuture.allOf(indexingFutures));
        } catch (InterruptedException e) {
            // mark current thread interrupted and raise the exception to propagate the error up
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Writer thread was interrupted", e);
        }
    }

    private CompletableFuture<?> writeItem(PojoIndexer indexer, Object entity) {
        JakartaBatchLog.INSTANCE.processEntity(entity);
        if (WriteMode.ADD.equals(writeMode)) {
            return indexer.add(type.typeIdentifier(), null, null, entity, // Commit and refresh are handled globally after all documents are indexed.
            DocumentCommitStrategy.NONE, DocumentRefreshStrategy.NONE, OperationSubmitter.blocking());
        }
        return indexer.addOrUpdate(type.typeIdentifier(), null, null, entity, // Commit and refresh are handled globally after all documents are indexed.
        DocumentCommitStrategy.NONE, DocumentRefreshStrategy.NONE, OperationSubmitter.blocking());
    }

    private enum WriteMode {

        ADD, UPDATE
    }
}
