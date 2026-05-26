/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.event.impl;

import java.util.BitSet;
import org.hibernate.HibernateException;
import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.AbstractCollectionEvent;
import org.hibernate.event.spi.AutoFlushEvent;
import org.hibernate.event.spi.AutoFlushEventListener;
import org.hibernate.event.spi.ClearEvent;
import org.hibernate.event.spi.ClearEventListener;
import org.hibernate.event.spi.EventSource;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.FlushEvent;
import org.hibernate.event.spi.FlushEventListener;
import org.hibernate.event.spi.PostCollectionRecreateEvent;
import org.hibernate.event.spi.PostCollectionRecreateEventListener;
import org.hibernate.event.spi.PostCollectionRemoveEvent;
import org.hibernate.event.spi.PostCollectionRemoveEventListener;
import org.hibernate.event.spi.PostCollectionUpdateEvent;
import org.hibernate.event.spi.PostCollectionUpdateEventListener;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.metamodel.mapping.EntityMappingType;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.search.mapper.orm.common.impl.HibernateOrmUtils;
import org.hibernate.search.mapper.orm.logging.impl.ConfigurationLog;
import org.hibernate.search.mapper.pojo.work.spi.PojoIndexingPlan;
import org.hibernate.search.mapper.pojo.work.spi.PojoTypeIndexingPlan;
import org.hibernate.search.util.common.annotation.impl.SuppressForbiddenApis;

/**
 * Hibernate ORM event listener called by various ORM life cycle events. This listener must be registered in order
 * to enable automatic index updates.
 *
 * @author Gavin King
 * @author Emmanuel Bernard
 * @author Mattias Arbin
 * @author Sanne Grinovero
 * @author Hardy Ferentschik
 */
public final class HibernateSearchEventListener implements PostDeleteEventListener, PostInsertEventListener, PostUpdateEventListener, PostCollectionRecreateEventListener, PostCollectionRemoveEventListener, PostCollectionUpdateEventListener, FlushEventListener, AutoFlushEventListener, ClearEventListener {

    private final HibernateOrmListenerContextProvider contextProvider;

    private final boolean dirtyCheckingEnabled;

    public HibernateSearchEventListener(HibernateOrmListenerContextProvider contextProvider, boolean dirtyCheckingEnabled) {
        this.contextProvider = contextProvider;
        this.dirtyCheckingEnabled = dirtyCheckingEnabled;
        ConfigurationLog.INSTANCE.dirtyChecksEnabled(dirtyCheckingEnabled);
    }

    public void registerTo(SessionFactoryImplementor sessionFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onPostDelete(PostDeleteEvent event) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onPostInsert(PostInsertEvent event) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onPostUpdate(PostUpdateEvent event) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onPostRecreateCollection(PostCollectionRecreateEvent event) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onPostRemoveCollection(PostCollectionRemoveEvent event) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onPostUpdateCollection(PostCollectionUpdateEvent event) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Make sure the indexes are updated right after the hibernate flush,
     * avoiding entity loading during a flush. Not needed during transactions.
     */
    @Override
    public void onFlush(FlushEvent event) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onAutoFlush(AutoFlushEvent event) throws HibernateException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onClear(ClearEvent event) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private PojoTypeIndexingPlan getCurrentIndexingPlanIfTypeIncluded(SharedSessionContractImplementor sessionImplementor, HibernateOrmListenerTypeContext typeContext) {
        return contextProvider.currentIndexingPlanIfTypeIncluded(sessionImplementor, typeContext.typeIdentifier());
    }

    private PojoIndexingPlan getCurrentIndexingPlanIfExisting(SessionImplementor sessionImplementor) {
        return contextProvider.currentIndexingPlanIfExisting(sessionImplementor);
    }

    private HibernateOrmListenerTypeContext getTypeContextOrNull(EntityMappingType entityMappingType) {
        String entityName = entityMappingType.getEntityName();
        return contextProvider.typeContextProvider().byHibernateOrmEntityName().getOrNull(entityName);
    }

    private void processCollectionEvent(AbstractCollectionEvent event) {
        if (!contextProvider.listenerEnabled()) {
            return;
        }
        Object ownerEntity = event.getAffectedOwnerOrNull();
        if (ownerEntity == null) {
            //Hibernate cannot determine every single time the owner especially in case detached objects are involved
            // or property-ref is used
            //Should log really but we don't know if we're interested in this collection for indexing
            return;
        }
        HibernateOrmListenerTypeContext typeContext = contextProvider.typeContextProvider().byHibernateOrmEntityName().getOrNull(event.getAffectedOwnerEntityName());
        if (typeContext == null) {
            // This type is not indexed, nor contained in an indexed type.
            // Return early, to avoid creating an indexing plan.
            return;
        }
        PojoTypeIndexingPlan plan = getCurrentIndexingPlanIfTypeIncluded(event.getSession(), typeContext);
        if (plan == null) {
            // This type is excluded through filters.
            // Return early, to avoid unnecessary processing.
            return;
        }
        BitSet dirtyPaths;
        if (dirtyCheckingEnabled) {
            PersistentCollection<?> persistentCollection = event.getCollection();
            String collectionRole = null;
            if (persistentCollection != null) {
                collectionRole = persistentCollection.getRole();
            }
            if (collectionRole != null) {
                // Collection role will only be non-null for PostCollectionUpdateEvents.
                // For those events, we can determine whether the collection has any impact on indexing.
                dirtyPaths = typeContext.dirtyFilter().filter(collectionRole);
                if (dirtyPaths == null) {
                    // This collection is not relevant for indexing.
                    // Return early, to avoid creating an indexing plan.
                    return;
                }
            } else {
                // We don't know which collection is being changed,
                // so we have to default to reindexing, just in case.
                dirtyPaths = null;
            }
        } else {
            // Dirty checking is disabled.
            // Just assume everything is dirty.
            dirtyPaths = null;
        }
        Object providedId = typeContext.toIndexingPlanProvidedId(event.getAffectedOwnerIdOrNull());
        if (dirtyPaths != null) {
            plan.addOrUpdate(providedId, null, ownerEntity, false, false, dirtyPaths);
        } else {
            plan.addOrUpdate(providedId, null, ownerEntity, true, true, null);
        }
    }

    /**
     * Required since Hibernate ORM 4.3
     */
    @Override
    @SuppressForbiddenApis(reason = "We are forced to implement this method and it requires accepting an EntityPersister")
    public boolean requiresPostCommitHandling(EntityPersister persister) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
