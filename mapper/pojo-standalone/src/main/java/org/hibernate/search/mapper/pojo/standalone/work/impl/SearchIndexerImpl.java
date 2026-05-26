/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.standalone.work.impl;

import java.util.concurrent.CompletionStage;
import org.hibernate.search.engine.backend.work.execution.DocumentCommitStrategy;
import org.hibernate.search.engine.backend.work.execution.DocumentRefreshStrategy;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.model.spi.PojoRuntimeIntrospector;
import org.hibernate.search.mapper.pojo.route.DocumentRoutesDescriptor;
import org.hibernate.search.mapper.pojo.standalone.work.SearchIndexer;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexer;

public class SearchIndexerImpl implements SearchIndexer {

    private final PojoRuntimeIntrospector introspector;

    private final PojoIndexer delegate;

    private final DocumentCommitStrategy commitStrategy;

    private final DocumentRefreshStrategy refreshStrategy;

    public SearchIndexerImpl(PojoRuntimeIntrospector introspector, PojoIndexer delegate, DocumentCommitStrategy commitStrategy, DocumentRefreshStrategy refreshStrategy) {
        this.introspector = introspector;
        this.delegate = delegate;
        this.commitStrategy = commitStrategy;
        this.refreshStrategy = refreshStrategy;
    }

    @Override
    public CompletionStage<?> add(Object providedId, DocumentRoutesDescriptor providedRoutes, Object entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletionStage<?> add(Class<?> entityClass, Object providedId, DocumentRoutesDescriptor providedRoutes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletionStage<?> addOrUpdate(Object providedId, DocumentRoutesDescriptor providedRoutes, Object entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletionStage<?> addOrUpdate(Class<?> entityClass, Object providedId, DocumentRoutesDescriptor providedRoutes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletionStage<?> delete(Object providedId, DocumentRoutesDescriptor providedRoutes, Object entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletionStage<?> delete(Class<?> entityClass, Object providedId, DocumentRoutesDescriptor providedRoutes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private <T> PojoRawTypeIdentifier<? extends T> getTypeIdentifier(T entity) {
        return introspector.detectEntityType(entity);
    }

    private <T> PojoRawTypeIdentifier<T> getTypeIdentifier(Class<T> entityType) {
        return PojoRawTypeIdentifier.of(entityType);
    }
}
