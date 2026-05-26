/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.loading.impl;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.cache.spi.access.EntityDataAccess;
import org.hibernate.engine.spi.EntityKey;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.metamodel.RepresentationMode;
import org.hibernate.metamodel.mapping.EntityMappingType;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.search.mapper.orm.logging.impl.OrmMiscLog;
import org.hibernate.search.util.common.annotation.impl.SuppressForbiddenApis;

/**
 * A lookup strategy that checks the persistence context (first level cache),
 * then the second level cache.
 * <p>
 * Ported from Search 5: {@code org.hibernate.search.query.hibernate.impl.SecondLevelCacheObjectInitializer}.
 *
 * @author Emmanuel Bernard
 */
@SuppressForbiddenApis(reason = "EntityPersister is needed to retrieve/use EntityDataAccess")
abstract class PersistenceContextThenSecondLevelCacheLookupStrategy implements EntityLoadingCacheLookupStrategyImplementor {

    static EntityLoadingCacheLookupStrategyImplementor create(EntityMappingType entityMappingType, SessionImplementor session) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final EntityLoadingCacheLookupStrategyImplementor persistenceContextLookupStrategy;

    private final EntityDataAccess cacheAccess;

    protected final EntityPersister persister;

    protected final SessionImplementor session;

    private PersistenceContextThenSecondLevelCacheLookupStrategy(EntityLoadingCacheLookupStrategyImplementor persistenceContextLookupStrategy, EntityPersister persister, EntityDataAccess cacheAccess, SessionImplementor session) {
        this.persistenceContextLookupStrategy = persistenceContextLookupStrategy;
        this.persister = persister;
        this.cacheAccess = cacheAccess;
        this.session = session;
    }

    @Override
    public Object lookup(EntityKey entityKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract Object lookupByIdentifier(EntityKey entityKey);

    @SuppressForbiddenApis(reason = "EntityPersister is needed to retrieve/use EntityDataAccess")
    private static class DynamicMapPersistenceContextThenSecondLevelCacheLookupStrategy extends PersistenceContextThenSecondLevelCacheLookupStrategy {

        private DynamicMapPersistenceContextThenSecondLevelCacheLookupStrategy(EntityLoadingCacheLookupStrategyImplementor persistenceContextLookupStrategy, EntityPersister persister, EntityDataAccess cacheAccess, SessionImplementor session) {
            super(persistenceContextLookupStrategy, persister, cacheAccess, session);
        }

        @Override
        protected Object lookupByIdentifier(EntityKey entityKey) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @SuppressForbiddenApis(reason = "EntityPersister is needed to retrieve/use EntityDataAccess")
    private static class PojoPersistenceContextThenSecondLevelCacheLookupStrategy extends PersistenceContextThenSecondLevelCacheLookupStrategy {

        private PojoPersistenceContextThenSecondLevelCacheLookupStrategy(EntityLoadingCacheLookupStrategyImplementor persistenceContextLookupStrategy, EntityPersister persister, EntityDataAccess cacheAccess, SessionImplementor session) {
            super(persistenceContextLookupStrategy, persister, cacheAccess, session);
        }

        @Override
        protected Object lookupByIdentifier(EntityKey entityKey) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
