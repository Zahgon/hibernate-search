/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.standalone.work.impl;

import java.util.BitSet;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.model.spi.PojoRuntimeIntrospector;
import org.hibernate.search.mapper.pojo.route.DocumentRoutesDescriptor;
import org.hibernate.search.mapper.pojo.standalone.work.SearchIndexingPlan;
import org.hibernate.search.mapper.pojo.work.spi.ConfiguredIndexingPlanSynchronizationStrategy;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoTypeIndexingPlan;

public class SearchIndexingPlanImpl implements SearchIndexingPlan {

    private final SearchIndexingPlanTypeContextProvider typeContextProvider;

    private final PojoRuntimeIntrospector introspector;

    private final PojoIndexingPlan delegate;

    private final ConfiguredIndexingPlanSynchronizationStrategy indexingPlanSynchronizationStrategy;

    public SearchIndexingPlanImpl(SearchIndexingPlanTypeContextProvider typeContextProvider, PojoRuntimeIntrospector introspector, PojoIndexingPlan delegate, ConfiguredIndexingPlanSynchronizationStrategy indexingPlanSynchronizationStrategy) {
        this.typeContextProvider = typeContextProvider;
        this.introspector = introspector;
        this.delegate = delegate;
        this.indexingPlanSynchronizationStrategy = indexingPlanSynchronizationStrategy;
    }

    @Override
    public void add(Object entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void add(Object providedId, DocumentRoutesDescriptor providedRoutes, Object entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void add(Class<?> entityClass, Object providedId, DocumentRoutesDescriptor providedRoutes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addOrUpdate(Object entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addOrUpdate(Object providedId, DocumentRoutesDescriptor providedRoutes, Object entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addOrUpdate(Object entity, String... dirtyPaths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addOrUpdate(Object providedId, DocumentRoutesDescriptor providedRoutes, Object entity, String... dirtyPaths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addOrUpdate(Object providedId, DocumentRoutesDescriptor providedRoutes, Object entity, boolean forceSelfDirty, boolean forceContainingDirty, String... dirtyPathsAsStrings) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addOrUpdate(Class<?> entityClass, Object providedId, DocumentRoutesDescriptor providedRoutes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void delete(Object entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void delete(Object providedId, DocumentRoutesDescriptor providedRoutes, Object entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void purge(Class<?> entityClass, Object providedId, DocumentRoutesDescriptor providedRoutes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addOrUpdateOrDelete(Class<?> entityClass, Object providedId, DocumentRoutesDescriptor providedRoutes, boolean forceSelfDirty, boolean forceContainingDirty, String... dirtyPathsAsStrings) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void execute() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private <T> PojoRawTypeIdentifier<? extends T> getTypeIdentifier(T entity) {
        return introspector.detectEntityType(entity);
    }

    private <T> PojoRawTypeIdentifier<T> getTypeIdentifier(Class<T> entityType) {
        return typeContextProvider.forExactClass(entityType).typeIdentifier();
    }
}
