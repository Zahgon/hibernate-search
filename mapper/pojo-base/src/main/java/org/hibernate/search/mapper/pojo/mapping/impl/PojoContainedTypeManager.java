/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.impl;

import java.util.Optional;
import org.hibernate.search.mapper.pojo.identity.impl.IdentifierMappingImplementor;
import org.hibernate.search.mapper.pojo.identity.impl.PojoRootIdentityMappingCollector;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoContainedTypeExtendedMappingCollector;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.scope.impl.PojoScopeContainedTypeContext;
import org.hibernate.search.mapper.pojo.work.impl.PojoWorkContainedTypeContext;

/**
 * @param <I> The identifier type for the contained entity type.
 * @param <E> The contained entity type.
 */
public class PojoContainedTypeManager<I, E> extends AbstractPojoTypeManager<I, E> implements PojoWorkContainedTypeContext<I, E>, PojoScopeContainedTypeContext<I, E> {

    private PojoContainedTypeManager(Builder<E> builder, IdentifierMappingImplementor<I, E> identifierMapping) {
        super(builder, identifierMapping);
    }

    @Override
    public Optional<PojoContainedTypeManager<I, E>> asContained() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder<E> extends AbstractPojoTypeManager.Builder<E> {

        private final PojoContainedTypeExtendedMappingCollector extendedMappingCollector;

        Builder(PojoRawTypeModel<E> typeModel, String entityName, String secondaryEntityName, PojoRootIdentityMappingCollector<E> identityMappingCollector, PojoContainedTypeExtendedMappingCollector extendedMappingCollector) {
            super(typeModel, entityName, secondaryEntityName, identityMappingCollector);
            this.extendedMappingCollector = extendedMappingCollector;
        }

        @Override
        protected PojoContainedTypeExtendedMappingCollector extendedMappingCollector() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public PojoContainedTypeManager<?, E> build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
