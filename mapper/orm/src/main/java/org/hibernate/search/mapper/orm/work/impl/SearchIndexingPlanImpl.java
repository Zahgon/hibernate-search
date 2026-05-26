/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.work.impl;

import org.hibernate.search.mapper.orm.work.SearchIndexingPlan;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.route.DocumentRoutesDescriptor;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoTypeIndexingPlan;

public final class SearchIndexingPlanImpl implements SearchIndexingPlan {

    private final SearchIndexingPlanTypeContextProvider typeContextProvider;

    private final SearchIndexingPlanSessionContext sessionContext;

    public SearchIndexingPlanImpl(SearchIndexingPlanTypeContextProvider typeContextProvider, SearchIndexingPlanSessionContext sessionContext) {
        this.typeContextProvider = typeContextProvider;
        this.sessionContext = sessionContext;
    }

    @Override
    public void addOrUpdate(Object entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void delete(Object entity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void purge(Class<?> entityClass, Object providedId, String providedRoutingKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void purge(String entityName, Object providedId, String providedRoutingKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void process() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private PojoIndexingPlan delegate(boolean createIfDoesNotExist) {
        sessionContext.checkOpen();
        return sessionContext.currentIndexingPlan(createIfDoesNotExist);
    }

    private <T> PojoRawTypeIdentifier<? extends T> getTypeIdentifier(T entity) {
        return sessionContext.runtimeIntrospector().detectEntityType(entity);
    }

    private PojoRawTypeIdentifier<?> getTypeIdentifier(Class<?> entityType) {
        return typeContextProvider.forExactClass(entityType).typeIdentifier();
    }

    private PojoRawTypeIdentifier<?> getTypeIdentifier(String entityName) {
        return typeContextProvider.byEntityName().getOrFail(entityName).typeIdentifier();
    }
}
