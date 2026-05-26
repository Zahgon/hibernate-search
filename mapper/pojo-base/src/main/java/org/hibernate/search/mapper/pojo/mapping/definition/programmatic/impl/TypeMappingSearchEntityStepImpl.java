/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.programmatic.impl;

import java.util.Map;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.bean.spi.ParameterizedBeanReference;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoTypeMetadataContributor;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.TypeMappingSearchEntityStep;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.spi.PojoAdditionalMetadataCollectorTypeNode;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;

class TypeMappingSearchEntityStepImpl implements TypeMappingSearchEntityStep, PojoTypeMetadataContributor {

    private final PojoRawTypeIdentifier<?> typeIdentifier;

    private String entityName;

    private ParameterizedBeanReference<?> loadingBinderRef;

    TypeMappingSearchEntityStepImpl(PojoRawTypeIdentifier<?> typeIdentifier) {
        this.typeIdentifier = typeIdentifier;
    }

    @Override
    public TypeMappingSearchEntityStep name(String entityName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TypeMappingSearchEntityStep loadingBinder(BeanReference<?> binderRef, Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void contributeAdditionalMetadata(PojoAdditionalMetadataCollectorTypeNode collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
