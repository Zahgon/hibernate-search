/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.work.impl;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import org.hibernate.search.engine.backend.work.execution.DocumentCommitStrategy;
import org.hibernate.search.engine.backend.work.execution.DocumentRefreshStrategy;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.engine.backend.work.execution.spi.DocumentReferenceProvider;
import org.hibernate.search.engine.backend.work.execution.spi.IndexIndexer;
import org.hibernate.search.mapper.pojo.bridge.runtime.impl.NoOpDocumentRouter;
import org.hibernate.search.mapper.pojo.processing.spi.PojoIndexingProcessorRootContext;
import org.hibernate.search.mapper.pojo.processing.spi.PojoIndexingProcessorSessionContext;
import org.hibernate.search.mapper.pojo.route.DocumentRouteDescriptor;
import org.hibernate.search.mapper.pojo.route.DocumentRoutesDescriptor;
import org.hibernate.search.mapper.pojo.work.spi.PojoWorkSessionContext;

public class PojoTypeIndexer<I, E> implements PojoIndexingProcessorRootContext {

    private final PojoWorkSessionContext sessionContext;

    private final PojoWorkIndexedTypeContext<I, E> typeContext;

    private final IndexIndexer delegate;

    public PojoTypeIndexer(PojoWorkIndexedTypeContext<I, E> typeContext, PojoWorkSessionContext sessionContext, IndexIndexer delegate) {
        this.sessionContext = sessionContext;
        this.typeContext = typeContext;
        this.delegate = delegate;
    }

    @Override
    public PojoIndexingProcessorSessionContext sessionContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isDeleted(Object unproxiedObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    CompletableFuture<?> add(Object providedId, DocumentRoutesDescriptor providedRoutes, Object entity, DocumentCommitStrategy commitStrategy, DocumentRefreshStrategy refreshStrategy, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    CompletableFuture<?> addOrUpdate(Object providedId, DocumentRoutesDescriptor providedRoutes, Object entity, DocumentCommitStrategy commitStrategy, DocumentRefreshStrategy refreshStrategy, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    CompletableFuture<?> delete(Object providedId, DocumentRoutesDescriptor providedRoutes, Object entity, DocumentCommitStrategy commitStrategy, DocumentRefreshStrategy refreshStrategy, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    CompletableFuture<?> delete(Object providedId, DocumentRoutesDescriptor providedRoutes, DocumentCommitStrategy commitStrategy, DocumentRefreshStrategy refreshStrategy, OperationSubmitter operationSubmitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private CompletableFuture<?> deletePrevious(String documentIdentifier, Collection<DocumentRouteDescriptor> previousRoutes, I identifier, DocumentCommitStrategy commitStrategy, DocumentRefreshStrategy refreshStrategy, OperationSubmitter operationSubmitter) {
        if (previousRoutes.isEmpty()) {
            return CompletableFuture.completedFuture(null);
        }
        CompletableFuture<?>[] futures = new CompletableFuture[previousRoutes.size()];
        int i = 0;
        for (DocumentRouteDescriptor route : previousRoutes) {
            DocumentReferenceProvider referenceProvider = new PojoDocumentReferenceProvider(documentIdentifier, route.routingKey(), identifier);
            futures[i++] = delegate.delete(referenceProvider, commitStrategy, refreshStrategy, operationSubmitter);
        }
        return CompletableFuture.allOf(futures);
    }
}
