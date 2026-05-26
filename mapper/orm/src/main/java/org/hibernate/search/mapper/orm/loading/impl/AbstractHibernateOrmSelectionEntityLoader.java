/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.loading.impl;

import java.util.List;
import jakarta.persistence.PersistenceException;
import org.hibernate.QueryTimeoutException;
import org.hibernate.exception.LockTimeoutException;
import org.hibernate.metamodel.mapping.EntityMappingType;
import org.hibernate.query.Query;
import org.hibernate.search.engine.common.timing.Deadline;
import org.hibernate.search.mapper.orm.loading.spi.EntityGraphHint;
import org.hibernate.search.mapper.orm.loading.spi.HibernateOrmLoadingSessionContext;
import org.hibernate.search.mapper.orm.loading.spi.MutableEntityLoadingOptions;
import org.hibernate.search.mapper.orm.search.query.spi.HibernateOrmSearchQueryHints;
import org.hibernate.search.mapper.pojo.loading.spi.PojoSelectionEntityLoader;

abstract class AbstractHibernateOrmSelectionEntityLoader<E> implements PojoSelectionEntityLoader<E> {

    protected static final String IDS_PARAMETER_NAME = "ids";

    protected final EntityMappingType entityMappingType;

    protected final HibernateOrmLoadingSessionContext sessionContext;

    protected final MutableEntityLoadingOptions loadingOptions;

    protected final TypeQueryFactory<E, ?> queryFactory;

    public AbstractHibernateOrmSelectionEntityLoader(EntityMappingType entityMappingType, TypeQueryFactory<E, ?> queryFactory, HibernateOrmLoadingSessionContext sessionContext, MutableEntityLoadingOptions loadingOptions) {
        this.entityMappingType = entityMappingType;
        this.sessionContext = sessionContext;
        this.loadingOptions = loadingOptions;
        this.queryFactory = queryFactory;
    }

    @Override
    public final List<E> loadBlocking(List<?> identifiers, Deadline deadline) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract List<E> doLoadEntities(List<?> allIds, Long timeout);

    @SuppressWarnings("unchecked")
    final Query<E> createQuery(int fetchSize, Long timeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
