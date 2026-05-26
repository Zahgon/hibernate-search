/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.standalone.mapping.impl;

import org.hibernate.search.engine.backend.reporting.spi.BackendMappingHints;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoContainedTypeExtendedMappingCollector;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoIndexedTypeExtendedMappingCollector;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoMapperDelegate;
import org.hibernate.search.mapper.pojo.mapping.spi.PojoMappingDelegate;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.standalone.reporting.impl.StandalonePojoMappingHints;

public final class StandalonePojoMapperDelegate implements PojoMapperDelegate<StandalonePojoMappingPartialBuildState> {

    private final StandalonePojoTypeContextContainer.Builder typeContextContainerBuilder;

    public StandalonePojoMapperDelegate() {
        this.typeContextContainerBuilder = new StandalonePojoTypeContextContainer.Builder();
    }

    @Override
    public void closeOnFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <E> PojoIndexedTypeExtendedMappingCollector createIndexedTypeExtendedMappingCollector(PojoRawTypeModel<E> rawTypeModel, String entityName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <E> PojoContainedTypeExtendedMappingCollector createContainedTypeExtendedMappingCollector(PojoRawTypeModel<E> rawTypeModel, String entityName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public StandalonePojoMappingPartialBuildState prepareBuild(PojoMappingDelegate mappingDelegate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BackendMappingHints hints() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
