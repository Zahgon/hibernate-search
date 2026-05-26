/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.additionalmetadata.building.impl;

import java.util.Optional;
import org.hibernate.search.engine.environment.bean.spi.ParameterizedBeanReference;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.spi.PojoAdditionalMetadataCollectorEntityTypeNode;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.impl.PojoEntityTypeAdditionalMetadata;
import org.hibernate.search.mapper.pojo.model.path.impl.SimplePojoPathsDefinitionProvider;
import org.hibernate.search.mapper.pojo.model.path.spi.PojoPathDefinitionProvider;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;

class PojoEntityTypeAdditionalMetadataBuilder implements PojoAdditionalMetadataCollectorEntityTypeNode {

    private String entityName;

    private String secondaryEntityName;

    private PojoPathDefinitionProvider pathDefinitionProvider = SimplePojoPathsDefinitionProvider.INSTANCE;

    private String entityIdPropertyName;

    private ParameterizedBeanReference<?> loadingBinderRef;

    PojoEntityTypeAdditionalMetadataBuilder() {
    }

    @Override
    public void entityName(String entityName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void secondaryEntityName(String secondaryEntityName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void pathDefinitionProvider(PojoPathDefinitionProvider pathDefinitionProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void entityIdPropertyName(String propertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void loadingBinder(ParameterizedBeanReference<?> binderRef) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PojoEntityTypeAdditionalMetadata build(PojoRawTypeModel<?> typeModel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
