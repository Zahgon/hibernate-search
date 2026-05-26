/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.loading.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.hibernate.FlushMode;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.mapping.JoinedSubclass;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.RootClass;
import org.hibernate.mapping.SingleTableSubclass;
import org.hibernate.metamodel.mapping.EntityMappingType;
import org.hibernate.metamodel.model.domain.EntityDomainType;
import org.hibernate.search.mapper.orm.common.impl.HibernateOrmUtils;
import org.hibernate.search.mapper.orm.loading.spi.ConditionalExpression;
import org.hibernate.search.mapper.orm.loading.spi.HibernateOrmEntityLoadingStrategy;
import org.hibernate.search.mapper.orm.loading.spi.HibernateOrmQueryLoader;
import org.hibernate.search.mapper.pojo.loading.spi.PojoLoadingTypeContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassEntityLoader;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassEntityLoadingContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassEntitySink;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassIdentifierLoader;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassIdentifierLoadingContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassIdentifierSink;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassLoadingContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoSelectionEntityLoader;
import org.hibernate.search.mapper.pojo.loading.spi.PojoSelectionLoadingContext;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.impl.SuppressingCloser;

public abstract class AbstractHibernateOrmLoadingStrategy<E, I> implements HibernateOrmEntityLoadingStrategy<E, I> {

    enum GroupingAllowed {

        NEVER {

            @Override
            public boolean allowed(boolean hasNonIndexedConcreteSubtypes) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
        , ALWAYS {

            @Override
            public boolean allowed(boolean hasNonIndexedConcreteSubtypes) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
        , ONLY_FOR_NO_NON_INDEXED_CONCRETE_SUBTYPES {

            @Override
            public boolean allowed(boolean hasNonIndexedConcreteSubtypes) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
        ;

        public static GroupingAllowed determine(PersistentClass persistentClass) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private static boolean isFromInheritanceType(PersistentClass persistentClass, Class<? extends PersistentClass> kind) {
            return kind.isAssignableFrom(persistentClass.getClass()) || persistentClass instanceof RootClass && persistentClass.getSubclasses().stream().anyMatch(c -> kind.isAssignableFrom(c.getClass()));
        }

        public abstract boolean allowed(boolean hasNonIndexedConcreteSubtypes);
    }

    protected final String rootEntityName;

    protected final Class<I> uniquePropertyType;

    protected final String uniquePropertyName;

    private final GroupingAllowed groupingAllowed;

    AbstractHibernateOrmLoadingStrategy(String rootEntityName, Class<I> uniquePropertyType, String uniquePropertyName, GroupingAllowed groupingAllowed) {
        this.rootEntityName = rootEntityName;
        this.uniquePropertyType = uniquePropertyType;
        this.uniquePropertyName = uniquePropertyName;
        this.groupingAllowed = groupingAllowed;
    }

    @Override
    public final PojoSelectionEntityLoader<E> createEntityLoader(Set<? extends PojoLoadingTypeContext<? extends E>> expectedTypes, PojoSelectionLoadingContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public abstract PojoSelectionEntityLoader<E> createEntityLoader(Set<? extends PojoLoadingTypeContext<? extends E>> targetEntityTypeContexts, HibernateOrmSelectionLoadingContext loadingContext);

    @Override
    public final boolean groupingAllowed(PojoLoadingTypeContext<? extends E> type, PojoMassLoadingContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final PojoMassIdentifierLoader createIdentifierLoader(Set<? extends PojoLoadingTypeContext<? extends E>> expectedTypes, PojoMassIdentifierLoadingContext<I> context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final PojoMassEntityLoader<I> createEntityLoader(Set<? extends PojoLoadingTypeContext<? extends E>> expectedTypes, PojoMassEntityLoadingContext<E> context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private List<ConditionalExpression> conditionalExpressions(Set<? extends PojoLoadingTypeContext<? extends E>> expectedTypes, HibernateOrmMassLoadingContext context) {
        if (expectedTypes.size() != 1) {
            // We know there's no condition, see groupingAllowed()
            // TODO HSEARCH-4252 Apply a condition to multiple types in the same query
            return List.of();
        }
        var condition = context.conditionalExpression(expectedTypes.iterator().next());
        return condition.isPresent() ? List.of(condition.get()) : List.of();
    }

    @Override
    public HibernateOrmQueryLoader<E, I> createQueryLoader(SessionFactoryImplementor sessionFactory, Set<? extends PojoLoadingTypeContext<? extends E>> typeContexts, List<ConditionalExpression> conditionalExpressions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HibernateOrmQueryLoader<E, I> createQueryLoader(SessionFactoryImplementor sessionFactory, Set<? extends PojoLoadingTypeContext<? extends E>> typeContexts, List<ConditionalExpression> conditionalExpressions, String order) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract TypeQueryFactory<E, I> createFactory(SessionFactoryImplementor sessionFactoryImplementor, Class<E> entityClass, String ormEntityName, Class<I> uniquePropertyType, String uniquePropertyName);

    @SuppressWarnings("unchecked")
    protected TypeQueryFactory<E, I> createFactory(SessionFactoryImplementor sessionFactoryImplementor, EntityMappingType entityMappingType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static EntityMappingType toMostSpecificCommonEntitySuperType(SessionFactoryImplementor sessionFactory, Iterable<? extends PojoLoadingTypeContext<?>> targetEntityTypeContexts) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected org.hibernate.AssertionFailure invalidTypesException(Set<? extends PojoLoadingTypeContext<?>> targetEntityTypeContexts) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
