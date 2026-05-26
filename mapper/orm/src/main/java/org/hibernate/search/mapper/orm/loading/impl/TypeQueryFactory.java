/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.loading.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import jakarta.persistence.FindOption;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.graph.RootGraph;
import org.hibernate.metamodel.model.domain.EntityDomainType;
import org.hibernate.query.Query;
import org.hibernate.search.mapper.orm.loading.spi.ConditionalExpression;

public interface TypeQueryFactory<E, I> {

    @SuppressWarnings({ "unchecked" })
    static <E, I> TypeQueryFactory<E, I> create(SessionFactoryImplementor sessionFactoryImplementor, Class<E> entityClass, String ormEntityName, Class<I> uniquePropertyType, String uniquePropertyName, boolean uniquePropertyIsTheEntityId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    Query<Long> createQueryForCount(SharedSessionContractImplementor session, Set<? extends Class<? extends E>> includedTypesFilter);

    Query<I> createQueryForIdentifierListing(SharedSessionContractImplementor session, Set<? extends Class<? extends E>> includedTypesFilter);

    Query<Long> createQueryForCount(SharedSessionContractImplementor session, EntityDomainType<?> entityDomainType, Set<? extends Class<? extends E>> includedTypesFilter, List<ConditionalExpression> conditionalExpressions);

    Query<I> createQueryForIdentifierListing(SharedSessionContractImplementor session, EntityDomainType<?> entityDomainType, Set<? extends Class<? extends E>> includedTypesFilter, List<ConditionalExpression> conditionalExpressions, String order);

    Query<E> createQueryForLoadByUniqueProperty(SessionImplementor session, String parameterName);

    /**
     * @deprecated Use {@link #findMultiple(SessionImplementor, List, FindOption...)} instead.
     */
    @SuppressWarnings("removal")
    @Deprecated(forRemoval = true, since = "8.2")
    org.hibernate.MultiIdentifierLoadAccess<E> createMultiIdentifierLoadAccess(SessionImplementor session);

    List<E> findMultiple(SessionImplementor session, List<?> ids, FindOption... options);

    boolean uniquePropertyIsTheEntityId();
}
