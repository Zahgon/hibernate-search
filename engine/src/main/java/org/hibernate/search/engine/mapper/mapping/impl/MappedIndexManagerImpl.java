/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.mapper.mapping.impl;

import java.util.Set;
import org.hibernate.search.engine.backend.index.IndexManager;
import org.hibernate.search.engine.backend.index.spi.IndexManagerImplementor;
import org.hibernate.search.engine.backend.mapping.spi.BackendMappingContext;
import org.hibernate.search.engine.backend.schema.management.spi.IndexSchemaManager;
import org.hibernate.search.engine.backend.session.spi.BackendSessionContext;
import org.hibernate.search.engine.backend.work.execution.DocumentCommitStrategy;
import org.hibernate.search.engine.backend.work.execution.DocumentRefreshStrategy;
import org.hibernate.search.engine.backend.work.execution.spi.IndexIndexer;
import org.hibernate.search.engine.backend.work.execution.spi.IndexIndexingPlan;
import org.hibernate.search.engine.backend.work.execution.spi.IndexWorkspace;
import org.hibernate.search.engine.mapper.mapping.spi.MappedIndexManager;
import org.hibernate.search.engine.mapper.scope.impl.MappedIndexScopeBuilderImpl;
import org.hibernate.search.engine.mapper.scope.spi.MappedIndexScopeBuilder;

public class MappedIndexManagerImpl implements MappedIndexManager {

    private final IndexManagerImplementor implementor;

    public MappedIndexManagerImpl(IndexManagerImplementor implementor) {
        this.implementor = implementor;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexManager toAPI() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexSchemaManager schemaManager() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexIndexingPlan createIndexingPlan(BackendSessionContext sessionContext, DocumentCommitStrategy commitStrategy, DocumentRefreshStrategy refreshStrategy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexIndexer createIndexer(BackendSessionContext sessionContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexWorkspace createWorkspace(BackendMappingContext mappingContext, Set<String> tenantIds) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <SR, R, E> MappedIndexScopeBuilder<SR, R, E> createScopeBuilder(BackendMappingContext mappingContext, Class<SR> rootScope) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addTo(MappedIndexScopeBuilder<?, ?, ?> builder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
