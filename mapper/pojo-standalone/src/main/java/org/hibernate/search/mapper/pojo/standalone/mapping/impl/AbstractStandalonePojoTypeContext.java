/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.standalone.mapping.impl;

import java.util.Optional;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.mapper.pojo.loading.definition.spi.PojoEntityLoadingBindingContext;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoTypeExtendedMappingCollector;
import org.hibernate.search.mapper.pojo.model.PojoModelElement;
import org.hibernate.search.mapper.pojo.model.path.spi.PojoPathFilter;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.standalone.loading.MassLoadingStrategy;
import org.hibernate.search.mapper.pojo.standalone.loading.SelectionLoadingStrategy;
import org.hibernate.search.mapper.pojo.standalone.loading.binding.EntityLoadingBinder;
import org.hibernate.search.mapper.pojo.standalone.loading.binding.EntityLoadingBindingContext;
import org.hibernate.search.mapper.pojo.standalone.loading.impl.StandalonePojoMassLoadingStrategy;
import org.hibernate.search.mapper.pojo.standalone.loading.impl.StandalonePojoSelectionLoadingStrategy;
import org.hibernate.search.mapper.pojo.standalone.work.impl.SearchIndexingPlanTypeContext;

abstract class AbstractStandalonePojoTypeContext<E> implements SearchIndexingPlanTypeContext<E> {

    private final PojoRawTypeIdentifier<E> typeIdentifier;

    private final String entityName;

    private final PojoPathFilter dirtyFilter;

    AbstractStandalonePojoTypeContext(AbstractBuilder<E> builder) {
        this.typeIdentifier = builder.typeIdentifier;
        this.entityName = builder.entityName;
        this.dirtyFilter = builder.dirtyFilter;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoRawTypeIdentifier<E> typeIdentifier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Class<E> javaClass() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoPathFilter dirtyFilter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract static class AbstractBuilder<E> implements PojoTypeExtendedMappingCollector {

        private final PojoRawTypeIdentifier<E> typeIdentifier;

        private final String entityName;

        private PojoPathFilter dirtyFilter;

        AbstractBuilder(PojoRawTypeIdentifier<E> typeIdentifier, String entityName) {
            this.typeIdentifier = typeIdentifier;
            this.entityName = entityName;
        }

        @Override
        public void dirtyFilter(PojoPathFilter dirtyFilter) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void applyLoadingBinder(Object binder, PojoEntityLoadingBindingContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
