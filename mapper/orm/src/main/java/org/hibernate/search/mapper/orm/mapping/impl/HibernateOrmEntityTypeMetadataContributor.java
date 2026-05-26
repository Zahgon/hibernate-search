/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.mapping.impl;

import java.util.Map;
import java.util.Optional;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.bean.spi.ParameterizedBeanReference;
import org.hibernate.search.mapper.orm.model.impl.HibernateOrmPathDefinitionProvider;
import org.hibernate.search.mapper.pojo.mapping.building.spi.PojoTypeMetadataContributor;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.spi.PojoAdditionalMetadataCollectorTypeNode;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;

final class HibernateOrmEntityTypeMetadataContributor implements PojoTypeMetadataContributor {

    private final PojoRawTypeModel<?> typeModel;

    private final PersistentClass persistentClass;

    private final Optional<String> identifierPropertyNameOptional;

    HibernateOrmEntityTypeMetadataContributor(PojoRawTypeModel<?> typeModel, PersistentClass persistentClass, Optional<String> identifierPropertyNameOptional) {
        this.typeModel = typeModel;
        this.persistentClass = persistentClass;
        this.identifierPropertyNameOptional = identifierPropertyNameOptional;
    }

    @Override
    public void contributeAdditionalMetadata(PojoAdditionalMetadataCollectorTypeNode collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
