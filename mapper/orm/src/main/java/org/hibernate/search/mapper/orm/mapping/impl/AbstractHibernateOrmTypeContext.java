/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.mapping.impl;

import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.metamodel.MappingMetamodel;
import org.hibernate.metamodel.mapping.EntityMappingType;
import org.hibernate.search.mapper.orm.event.impl.HibernateOrmListenerTypeContext;
import org.hibernate.search.mapper.orm.loading.spi.HibernateOrmEntityLoadingStrategy;
import org.hibernate.search.mapper.orm.loading.spi.HibernateOrmLoadingTypeContext;
import org.hibernate.search.mapper.orm.model.impl.DocumentIdSourceProperty;
import org.hibernate.search.mapper.orm.session.impl.HibernateOrmSessionTypeContext;
import org.hibernate.search.mapper.pojo.loading.definition.spi.PojoEntityLoadingBindingContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoLoadingTypeContext;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoTypeExtendedMappingCollector;
import org.hibernate.search.mapper.pojo.model.path.spi.PojoPathFilter;
import org.hibernate.search.mapper.pojo.model.spi.PojoPropertyModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeContext;

abstract class AbstractHibernateOrmTypeContext<E> implements PojoTypeContext<E>, HibernateOrmListenerTypeContext, HibernateOrmSessionTypeContext<E>, HibernateOrmLoadingTypeContext<E> {

    private final PojoRawTypeIdentifier<E> typeIdentifier;

    private final PojoLoadingTypeContext<E> delegate;

    private final String jpaEntityName;

    private final EntityMappingType entityMappingType;

    private final boolean documentIdIsEntityId;

    private final HibernateOrmEntityLoadingStrategy<? super E, ?> loadingStrategy;

    private final PojoPathFilter dirtyFilter;

    private final PojoPathFilter dirtyContainingAssociationFilter;

    AbstractHibernateOrmTypeContext(Builder<E> builder, PojoLoadingTypeContext<E> delegate, SessionFactoryImplementor sessionFactory) {
        this.typeIdentifier = builder.typeIdentifier;
        this.delegate = delegate;
        this.jpaEntityName = builder.jpaEntityName;
        MappingMetamodel metamodel = sessionFactory.getMappingMetamodel();
        this.entityMappingType = metamodel.getEntityDescriptor(builder.hibernateOrmEntityName);
        this.documentIdIsEntityId = builder.documentIdSourceProperty != null && builder.documentIdSourceProperty.name.equals(entityMappingType.getIdentifierMapping().getAttributeName());
        this.loadingStrategy = builder.loadingStrategy;
        this.dirtyFilter = builder.dirtyFilter;
        this.dirtyContainingAssociationFilter = builder.dirtyContainingAssociationFilter;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoRawTypeIdentifier<E> typeIdentifier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoLoadingTypeContext<E> delegate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String jpaEntityName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String hibernateOrmEntityName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EntityMappingType entityMappingType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HibernateOrmEntityLoadingStrategy<? super E, ?> loadingStrategy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object toIndexingPlanProvidedId(Object entityId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoPathFilter dirtyFilter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoPathFilter dirtyContainingAssociationFilter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public abstract static class Builder<E> implements PojoTypeExtendedMappingCollector {

        public final PojoRawTypeIdentifier<E> typeIdentifier;

        private final PersistentClass persistentClass;

        private final String jpaEntityName;

        private final String hibernateOrmEntityName;

        private DocumentIdSourceProperty<?> documentIdSourceProperty;

        private PojoPathFilter dirtyFilter;

        private PojoPathFilter dirtyContainingAssociationFilter;

        private HibernateOrmEntityLoadingStrategy<? super E, ?> loadingStrategy;

        Builder(PojoRawTypeModel<E> typeModel, PersistentClass persistentClass) {
            this.typeIdentifier = typeModel.typeIdentifier();
            this.persistentClass = persistentClass;
            this.jpaEntityName = persistentClass.getJpaEntityName();
            this.hibernateOrmEntityName = persistentClass.getEntityName();
        }

        @Override
        public void documentIdSourceProperty(PojoPropertyModel<?> documentIdSourceProperty) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void dirtyFilter(PojoPathFilter dirtyFilter) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void dirtyContainingAssociationFilter(PojoPathFilter filter) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        // The binder uses reflection to create a strategy of the appropriate type
        @SuppressWarnings("unchecked")
        public void applyLoadingBinder(Object binder, PojoEntityLoadingBindingContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
