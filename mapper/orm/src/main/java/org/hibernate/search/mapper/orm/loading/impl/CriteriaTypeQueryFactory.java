/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.loading.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import jakarta.persistence.FindOption;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.query.Query;

class CriteriaTypeQueryFactory<E, I> extends ConditionalExpressionQueryFactory<E, I> {

    public static <E, I> CriteriaTypeQueryFactory<E, I> create(Class<E> entityClass, Class<I> uniquePropertyType, String uniquePropertyName, boolean uniquePropertyIsTheEntityId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final Class<E> entityClass;

    private CriteriaTypeQueryFactory(Class<E> entityClass, Class<I> uniquePropertyType, String uniquePropertyName, boolean uniquePropertyIsTheEntityId) {
        super(uniquePropertyType, uniquePropertyName, uniquePropertyIsTheEntityId);
        this.entityClass = entityClass;
    }

    // QueryProducerImplementor is marked for removal, while the createQuery() is also present in other interfaces
    @SuppressWarnings({ "deprecation", "removal" })
    @Override
    public Query<Long> createQueryForCount(SharedSessionContractImplementor session, Set<? extends Class<? extends E>> includedTypesFilter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // QueryProducerImplementor is marked for removal, while the createQuery() is also present in other interfaces
    @SuppressWarnings({ "deprecation", "removal" })
    @Override
    public Query<I> createQueryForIdentifierListing(SharedSessionContractImplementor session, Set<? extends Class<? extends E>> includedTypesFilter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    // QueryProducerImplementor is marked for removal, while the createQuery() is also present in other interfaces
    @SuppressWarnings({ "rawtypes", "removal", "deprecation" })
    public Query<E> createQueryForLoadByUniqueProperty(SessionImplementor session, String parameterName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("removal")
    @Deprecated(forRemoval = true, since = "8.2")
    @Override
    public MultiIdentifierLoadAccess<E> createMultiIdentifierLoadAccess(SessionImplementor session) {
        return session.byMultipleIds(entityClass);
    }

    @Override
    public List<E> findMultiple(SessionImplementor session, List<?> ids, FindOption... options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
