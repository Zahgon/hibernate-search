/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.massindexing.impl;

import java.util.List;
import java.util.OptionalLong;
import java.util.Set;
import java.util.stream.Collectors;
import org.hibernate.search.mapper.pojo.loading.spi.PojoLoadingTypeContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassIdentifierLoader;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassIdentifierLoadingContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassIdentifierSink;
import org.hibernate.search.mapper.pojo.loading.spi.PojoMassLoadingContext;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingType;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingTypeGroupMonitorContext;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingTypeGroupMonitorCreateContext;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexingContext;
import org.hibernate.search.util.common.AssertionFailure;

class MassIndexingTypeGroupContext<E> implements MassIndexingTypeGroupMonitorCreateContext, MassIndexingTypeGroupMonitorContext {

    private final Set<MassIndexingType> includedTypes;

    private final PojoMassIndexingIndexedTypeGroup<E> typeGroup;

    private final PojoMassIndexingContext massIndexingContext;

    private final String tenantId;

    public MassIndexingTypeGroupContext(PojoMassIndexingIndexedTypeGroup<E> typeGroup, PojoMassIndexingContext massIndexingContext, String tenantId) {
        this.includedTypes = typeGroup.includedTypes().stream().map(PojoLoadingTypeContext::entityName).map(MassIndexingTypeImpl::new).collect(Collectors.toSet());
        this.typeGroup = typeGroup;
        this.massIndexingContext = massIndexingContext;
        this.tenantId = tenantId;
    }

    PojoMassIndexingContext massIndexingContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<MassIndexingType> includedTypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public OptionalLong totalCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private PojoMassIdentifierLoader createLoader() {
        return typeGroup.loadingStrategy().createIdentifierLoader(typeGroup.includedTypes(), new DummyIdentifierLoadingContext<>());
    }

    public String tenantIdentifier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MassIndexingTypeGroupMonitorContext withIdentifierLoader(PojoMassIdentifierLoader loader) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class MassIndexingTypeImpl implements MassIndexingType {

        private final String entityName;

        private MassIndexingTypeImpl(String entityName) {
            this.entityName = entityName;
        }

        @Override
        public String entityName() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private class DummyIdentifierLoadingContext<I> implements PojoMassIdentifierLoadingContext<I> {

        @Override
        public PojoMassLoadingContext parent() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public PojoMassIdentifierSink<I> createSink() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String tenantIdentifier() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
