/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.additionalmetadata.building.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.spi.PojoAdditionalMetadataCollectorPropertyNode;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.spi.PojoAdditionalMetadataCollectorTypeNode;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.impl.PojoPropertyAdditionalMetadata;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.impl.PojoTypeAdditionalMetadata;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;

class PojoTypeAdditionalMetadataBuilder implements PojoAdditionalMetadataCollectorTypeNode {

    private final BeanResolver beanResolver;

    private final PojoRawTypeModel<?> rawTypeModel;

    private PojoEntityTypeAdditionalMetadataBuilder entityTypeMetadataBuilder;

    private PojoIndexedTypeAdditionalMetadataBuilder indexedTypeMetadataBuilder;

    // Use a LinkedHashMap for deterministic iteration
    private final Map<String, List<Consumer<PojoAdditionalMetadataCollectorPropertyNode>>> propertyContributors = new LinkedHashMap<>();

    PojoTypeAdditionalMetadataBuilder(BeanResolver beanResolver, PojoRawTypeModel<?> rawTypeModel) {
        this.beanResolver = beanResolver;
        this.rawTypeModel = rawTypeModel;
    }

    @Override
    public PojoRawTypeIdentifier<?> typeIdentifier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoEntityTypeAdditionalMetadataBuilder markAsEntity() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoIndexedTypeAdditionalMetadataBuilder markAsIndexed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void property(String propertyName, Consumer<PojoAdditionalMetadataCollectorPropertyNode> propertyMetadataContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PojoTypeAdditionalMetadata build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
