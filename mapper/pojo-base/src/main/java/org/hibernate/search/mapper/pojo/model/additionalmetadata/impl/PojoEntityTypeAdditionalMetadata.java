/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.additionalmetadata.impl;

import java.util.Optional;
import org.hibernate.search.engine.environment.bean.spi.ParameterizedBeanReference;
import org.hibernate.search.mapper.pojo.model.path.spi.PojoPathDefinitionProvider;

public class PojoEntityTypeAdditionalMetadata {

    private final String entityName;

    private final String secondaryEntityName;

    private final PojoPathDefinitionProvider pathDefinitionProvider;

    private final Optional<String> entityIdPropertyName;

    private final ParameterizedBeanReference<?> loadingBinderRef;

    public PojoEntityTypeAdditionalMetadata(String entityName, String secondaryEntityName, PojoPathDefinitionProvider pathDefinitionProvider, Optional<String> entityIdPropertyName, ParameterizedBeanReference<?> loadingBinderRef) {
        this.entityName = entityName;
        this.secondaryEntityName = secondaryEntityName;
        this.pathDefinitionProvider = pathDefinitionProvider;
        this.entityIdPropertyName = entityIdPropertyName;
        this.loadingBinderRef = loadingBinderRef;
    }

    public String getEntityName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getSecondaryEntityName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PojoPathDefinitionProvider pathDefinitionProvider() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<String> getEntityIdPropertyName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ParameterizedBeanReference<?> getLoadingBinderRef() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
