/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.impl;

import java.util.Optional;
import org.hibernate.search.mapper.pojo.extractor.impl.BoundContainerExtractorPath;
import org.hibernate.search.mapper.pojo.extractor.impl.ContainerExtractorBinder;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.mapping.spi.PojoMappingConfigurationContext;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;

public final class PojoMappingConfigurationContextImpl implements PojoMappingConfigurationContext {

    private final ContainerExtractorBinder extractorBinder;

    public PojoMappingConfigurationContextImpl(ContainerExtractorBinder extractorBinder) {
        this.extractorBinder = extractorBinder;
    }

    @Override
    public Optional<PojoTypeModel<?>> extractedValueType(PojoTypeModel<?> sourceType, ContainerExtractorPath extractorPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
