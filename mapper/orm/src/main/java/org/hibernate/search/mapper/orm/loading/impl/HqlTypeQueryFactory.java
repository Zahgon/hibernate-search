/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.loading.impl;

import java.util.List;
import java.util.Set;
import jakarta.persistence.FindOption;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.graph.RootGraph;
import org.hibernate.query.Query;

class HqlTypeQueryFactory<E, I> extends ConditionalExpressionQueryFactory<E, I> {

    private final Class<E> entityClass;

    private final RootGraph<E> rootGraph;

    private final String ormEntityName;

    HqlTypeQueryFactory(RootGraph<E> rootGraph, Class<E> entityClass, String ormEntityName, Class<I> uniquePropertyType, String uniquePropertyName, boolean uniquePropertyIsTheEntityId) {
        super(uniquePropertyType, uniquePropertyName, uniquePropertyIsTheEntityId);
        this.rootGraph = rootGraph;
        this.entityClass = entityClass;
        this.ormEntityName = ormEntityName;
    }

    @Override
    public Query<Long> createQueryForCount(SharedSessionContractImplementor session, Set<? extends Class<? extends E>> includedTypesFilter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Query<I> createQueryForIdentifierListing(SharedSessionContractImplementor session, Set<? extends Class<? extends E>> includedTypesFilter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // QueryProducerImplementor is marked for removal, while the createQuery() is also present in other interfaces
    @SuppressWarnings({ "deprecation", "removal" })
    @Override
    public Query<E> createQueryForLoadByUniqueProperty(SessionImplementor session, String parameterName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("removal")
    @Deprecated(forRemoval = true, since = "8.2")
    @Override
    public org.hibernate.MultiIdentifierLoadAccess<E> createMultiIdentifierLoadAccess(SessionImplementor session) {
        return session.byMultipleIds(ormEntityName);
    }

    @Override
    public List<E> findMultiple(SessionImplementor session, List<?> ids, FindOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private <T> Query<T> createQueryWithTypesFilter(SharedSessionContractImplementor session, String hql, Class<T> returnedType, String entityAlias, Set<? extends Class<? extends E>> includedTypesFilter) {
        if (!includedTypesFilter.isEmpty()) {
            hql += " where type(" + entityAlias + ") in (:types)";
        }
        // QueryProducerImplementor is marked for removal, while the createQuery() is also present in other interfaces
        @SuppressWarnings({ "deprecation", "removal" })
        Query<T> query = session.createQuery(hql, returnedType);
        if (!includedTypesFilter.isEmpty()) {
            query.setParameterList("types", includedTypesFilter);
        }
        return query;
    }
}
