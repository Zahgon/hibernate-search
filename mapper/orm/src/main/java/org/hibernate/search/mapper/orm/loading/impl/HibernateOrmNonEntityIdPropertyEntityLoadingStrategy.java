/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.loading.impl;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.search.mapper.orm.common.impl.HibernateOrmUtils;
import org.hibernate.search.mapper.orm.loading.spi.HibernateOrmEntityLoadingStrategy;
import org.hibernate.search.mapper.orm.loading.spi.HibernateOrmLoadingSessionContext;
import org.hibernate.search.mapper.orm.loading.spi.MutableEntityLoadingOptions;
import org.hibernate.search.mapper.orm.logging.impl.OrmMiscLog;
import org.hibernate.search.mapper.orm.model.impl.DocumentIdSourceProperty;
import org.hibernate.search.mapper.orm.search.loading.EntityLoadingCacheLookupStrategy;
import org.hibernate.search.mapper.pojo.loading.spi.PojoLoadingTypeContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoSelectionEntityLoader;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.reflect.spi.ValueReadHandle;

public class HibernateOrmNonEntityIdPropertyEntityLoadingStrategy<E, I> extends AbstractHibernateOrmLoadingStrategy<E, I> {

    public static <I> HibernateOrmEntityLoadingStrategy<?, ? super I> create(PersistentClass persistentClass, DocumentIdSourceProperty<I> documentIdSourceProperty) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <E, I> HibernateOrmNonEntityIdPropertyEntityLoadingStrategy<E, I> create(PersistentClass persistentClass, Class<I> documentIdSourcePropertyClass, String documentIdSourcePropertyName, ValueReadHandle<? extends I> documentIdSourceHandle) {
        var idProperty = persistentClass.getIdentifierProperty();
        return new HibernateOrmNonEntityIdPropertyEntityLoadingStrategy<>(persistentClass.getRootClass().getEntityName(), persistentClass.getEntityName(), GroupingAllowed.determine(persistentClass), documentIdSourcePropertyClass, documentIdSourcePropertyName, idProperty != null && documentIdSourcePropertyName.equals(idProperty.getName()), documentIdSourceHandle);
    }

    private final String entityName;

    private final String documentIdSourcePropertyName;

    private final ValueReadHandle<? extends I> documentIdSourceHandle;

    private final boolean uniquePropertyIsTheEntityId;

    private HibernateOrmNonEntityIdPropertyEntityLoadingStrategy(String rootEntityName, String entityName, GroupingAllowed groupingAllowed, Class<I> documentIdSourcePropertyType, String documentIdSourcePropertyName, boolean uniquePropertyIsTheEntityId, ValueReadHandle<? extends I> documentIdSourceHandle) {
        super(rootEntityName, documentIdSourcePropertyType, documentIdSourcePropertyName, groupingAllowed);
        this.entityName = entityName;
        this.documentIdSourcePropertyName = documentIdSourcePropertyName;
        this.documentIdSourceHandle = documentIdSourceHandle;
        this.uniquePropertyIsTheEntityId = uniquePropertyIsTheEntityId;
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoSelectionEntityLoader<E> createEntityLoader(Set<? extends PojoLoadingTypeContext<? extends E>> targetEntityTypeContexts, HibernateOrmSelectionLoadingContext loadingContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected TypeQueryFactory<E, I> createFactory(SessionFactoryImplementor sessionFactoryImplementor, Class<E> entityClass, String ormEntityName, Class<I> uniquePropertyType, String uniquePropertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private PojoSelectionEntityLoader<E> doCreate(PojoLoadingTypeContext<? extends E> targetEntityTypeContext, HibernateOrmLoadingSessionContext sessionContext, EntityLoadingCacheLookupStrategy cacheLookupStrategy, MutableEntityLoadingOptions loadingOptions) {
        if (!entityName.equals(targetEntityTypeContext.secondaryEntityName())) {
            throw invalidTypeException(targetEntityTypeContext);
        }
        var sessionFactory = sessionContext.session().getSessionFactory();
        var entityMapping = HibernateOrmUtils.entityMappingType(sessionFactory, targetEntityTypeContext.secondaryEntityName());
        /*
		 * We checked just above that "entityMappingType" is equal to "targetEntityTypeContext.entityMappingType()",
		 * so this loader will actually return entities of type E.
		 */
        @SuppressWarnings("unchecked")
        PojoSelectionEntityLoader<E> result = new HibernateOrmSelectionEntityByNonIdPropertyLoader<>(entityMapping, (PojoLoadingTypeContext<E>) targetEntityTypeContext, createFactory(sessionFactory, entityMapping), documentIdSourcePropertyName, documentIdSourceHandle, sessionContext, loadingOptions);
        if (!EntityLoadingCacheLookupStrategy.SKIP.equals(cacheLookupStrategy)) {
            /*
			 * We can't support preliminary cache lookup with this strategy,
			 * because document IDs are not entity IDs.
			 * However, we can't throw an exception either,
			 * because this setting may still be relevant for other entity types targeted by the same query.
			 * Let's log something, at least.
			 */
            OrmMiscLog.INSTANCE.skippingPreliminaryCacheLookupsForNonEntityIdEntityLoader(targetEntityTypeContext.entityName(), cacheLookupStrategy);
        }
        return result;
    }

    private AssertionFailure invalidTypeException(PojoLoadingTypeContext<?> otherType) {
        throw new AssertionFailure("Attempt to use a criteria-based entity loader with an unexpected target entity type." + " Expected entity name: " + entityName + " Targeted entity name: " + otherType.secondaryEntityName());
    }

    private AssertionFailure multipleTypesException(Set<? extends PojoLoadingTypeContext<?>> targetEntityTypeContexts) {
        return new AssertionFailure("Attempt to use a criteria-based entity loader with multiple target entity types." + " Expected entity name: " + entityName + " Targeted entity names: " + targetEntityTypeContexts.stream().map(PojoLoadingTypeContext::secondaryEntityName).collect(Collectors.toUnmodifiableList()));
    }
}
