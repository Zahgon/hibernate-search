/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.programmatic.impl;

import java.util.Map;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.RoutingBinder;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoTypeMetadataContributor;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.TypeMappingIndexedStep;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.spi.PojoAdditionalMetadataCollectorIndexedTypeNode;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.spi.PojoAdditionalMetadataCollectorTypeNode;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;

class TypeMappingIndexedStepImpl implements TypeMappingIndexedStep, PojoTypeMetadataContributor {

    private final PojoRawTypeIdentifier<?> typeIdentifier;

    private String backendName;

    private String indexName;

    private Boolean enabled;

    private RoutingBinder binder;

    private Map<String, Object> params;

    TypeMappingIndexedStepImpl(PojoRawTypeIdentifier<?> typeIdentifier) {
        this.typeIdentifier = typeIdentifier;
    }

    @Override
    public TypeMappingIndexedStep backend(String backendName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TypeMappingIndexedStep index(String indexName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TypeMappingIndexedStep enabled(boolean enabled) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TypeMappingIndexedStep routingBinder(RoutingBinder binder, Map<String, Object> params) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void contributeAdditionalMetadata(PojoAdditionalMetadataCollectorTypeNode collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
