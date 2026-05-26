/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.jakarta.batch.core.massindexing.util.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.metamodel.mapping.EmbeddableMappingType;
import org.hibernate.metamodel.mapping.EntityIdentifierMapping;
import org.hibernate.query.SelectionQuery;
import org.hibernate.search.mapper.orm.loading.spi.ConditionalExpression;
import org.hibernate.search.mapper.orm.loading.spi.HibernateOrmEntityLoadingStrategy;
import org.hibernate.search.mapper.orm.loading.spi.HibernateOrmLoadingTypeContext;
import org.hibernate.search.mapper.orm.loading.spi.HibernateOrmQueryLoader;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;

public class EntityTypeDescriptor<E, I> {

    public static <E> EntityTypeDescriptor<E, ?> create(SessionFactoryImplementor sessionFactory, HibernateOrmLoadingTypeContext<E> type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final SessionFactoryImplementor sessionFactory;

    private final HibernateOrmLoadingTypeContext<E> delegate;

    private final HibernateOrmEntityLoadingStrategy<? super E, I> loadingStrategy;

    private final IdOrder idOrder;

    public EntityTypeDescriptor(SessionFactoryImplementor sessionFactory, HibernateOrmLoadingTypeContext<E> delegate, HibernateOrmEntityLoadingStrategy<? super E, I> loadingStrategy, IdOrder idOrder) {
        this.sessionFactory = sessionFactory;
        this.delegate = delegate;
        this.loadingStrategy = loadingStrategy;
        this.idOrder = idOrder;
    }

    public PojoRawTypeIdentifier<E> typeIdentifier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Class<E> javaClass() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String jpaEntityName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IdOrder idOrder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SelectionQuery<Long> createCountQuery(SharedSessionContractImplementor session, List<ConditionalExpression> conditions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SelectionQuery<I> createIdentifiersQuery(SharedSessionContractImplementor session, List<ConditionalExpression> conditions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SelectionQuery<? super E> createLoadingQuery(SessionImplementor session, String idParameterName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private HibernateOrmQueryLoader<? super E, I> queryLoader(List<ConditionalExpression> conditions, String order) {
        return loadingStrategy.createQueryLoader(sessionFactory, Set.of(delegate.delegate()), conditions, order);
    }
}
