/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.common.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.binder.internal.TenantIdBinder;
import org.hibernate.boot.Metadata;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;
import org.hibernate.metamodel.MappingMetamodel;
import org.hibernate.metamodel.mapping.EntityMappingType;
import org.hibernate.metamodel.model.domain.EntityDomainType;
import org.hibernate.search.mapper.orm.logging.impl.OrmMiscLog;
import org.hibernate.search.mapper.pojo.loading.spi.PojoLoadingTypeContext;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.annotation.impl.SuppressForbiddenApis;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.spi.ServiceBinding;
import org.hibernate.service.spi.ServiceRegistryImplementor;

public final class HibernateOrmUtils {

    private HibernateOrmUtils() {
    }

    public static SessionFactoryImplementor toSessionFactoryImplementor(EntityManagerFactory entityManagerFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Session toSession(EntityManager entityManager) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static SessionImplementor toSessionImplementor(EntityManager entityManager) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static boolean isSuperTypeOf(EntityMappingType type1, EntityMappingType type2) {
        return type1.getSubclassEntityNames().contains(type2.getEntityName());
    }

    public static EntityMappingType entityMappingType(SessionFactoryImplementor sessionFactory, String entityName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EntityDomainType<?> entityDomainType(SessionFactoryImplementor sessionFactory, String entityName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Class<?> entityClass(PersistentClass persistentClass) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EntityMappingType toMostSpecificCommonEntitySuperType(EntityMappingType type1, EntityMappingType type2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static boolean targetsAllConcreteSubTypes(SessionFactoryImplementor sessionFactory, EntityMappingType commonSupertype, Collection<? extends PojoLoadingTypeContext<?>> targetConcreteSubTypes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressForbiddenApis(reason = "Safer wrapper")
    public static <T extends Service> T getServiceOrFail(ServiceRegistry serviceRegistry, Class<T> serviceClass) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressForbiddenApis(reason = "Safer wrapper")
    public static <T extends Service> Optional<T> getServiceOrEmpty(ServiceRegistry serviceRegistry, Class<T> serviceClass) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static List<Property> sortedNonSyntheticProperties(Iterator<Property> propertyIterator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static boolean isDiscriminatorMultiTenancyEnabled(Metadata metadata) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
