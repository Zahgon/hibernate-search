/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.loading.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.engine.spi.EntityKey;
import org.hibernate.metamodel.mapping.EntityMappingType;
import org.hibernate.query.Query;
import org.hibernate.search.mapper.orm.loading.spi.HibernateOrmLoadingSessionContext;
import org.hibernate.search.mapper.orm.loading.spi.MutableEntityLoadingOptions;
import org.hibernate.search.util.common.annotation.impl.SuppressForbiddenApis;

/**
 * An entity loader for indexed entities whose document ID is the entity ID.
 *
 * @param <E> A common supertype of loaded entities.
 */
class HibernateOrmSelectionEntityByIdLoader<E> extends AbstractHibernateOrmSelectionEntityLoader<E> {

    private final PersistenceContextLookupStrategy persistenceContextLookup;

    private final EntityLoadingCacheLookupStrategyImplementor cacheLookupStrategyImplementor;

    HibernateOrmSelectionEntityByIdLoader(EntityMappingType rootEntityMappingType, TypeQueryFactory<E, ?> queryFactory, HibernateOrmLoadingSessionContext sessionContext, PersistenceContextLookupStrategy persistenceContextLookup, EntityLoadingCacheLookupStrategyImplementor cacheLookupStrategyImplementor, MutableEntityLoadingOptions loadingOptions) {
        super(rootEntityMappingType, queryFactory, sessionContext, loadingOptions);
        this.persistenceContextLookup = persistenceContextLookup;
        this.cacheLookupStrategyImplementor = cacheLookupStrategyImplementor;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected List<E> doLoadEntities(List<?> allIds, Long timeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressForbiddenApis(reason = "generateEntityKey requires passing an EntityPersister")
    private EntityKey[] toEntityKeys(List<?> ids) {
        EntityKey[] entityKeys = new EntityKey[ids.size()];
        for (int i = 0; i < ids.size(); i++) {
            Object id = ids.get(i);
            EntityKey entityKey = sessionContext.session().generateEntityKey(id, entityMappingType.getEntityPersister());
            entityKeys[i] = (entityKey);
        }
        return entityKeys;
    }

    private static <T> List<T> createListContainingNulls(int size) {
        List<T> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(null);
        }
        return list;
    }
}
