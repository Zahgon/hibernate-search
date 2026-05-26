/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.dependency.impl;

import org.hibernate.search.mapper.pojo.extractor.impl.ContainerExtractorBinder;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.impl.PojoTypeAdditionalMetadataProvider;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPath;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathOriginalTypeNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.spi.PojoModelPathBinder;
import org.hibernate.search.mapper.pojo.model.spi.PojoBootstrapIntrospector;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;

public abstract class AbstractPojoBridgedElementDependencyContext {

    private final PojoBootstrapIntrospector introspector;

    final BoundPojoModelPath.Walker bindingPathWalker;

    private final PojoTypeAdditionalMetadataProvider typeAdditionalMetadataProvider;

    private boolean useRootOnly;

    AbstractPojoBridgedElementDependencyContext(PojoBootstrapIntrospector introspector, ContainerExtractorBinder containerExtractorBinder, PojoTypeAdditionalMetadataProvider typeAdditionalMetadataProvider) {
        this.introspector = introspector;
        this.bindingPathWalker = BoundPojoModelPath.walker(containerExtractorBinder);
        this.typeAdditionalMetadataProvider = typeAdditionalMetadataProvider;
    }

    public void useRootOnly() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isUseRootOnly() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public abstract boolean hasNonRootDependency();

    PojoOtherEntityIndexingDependencyConfigurationContextImpl<?> createOtherEntityDependencyContext(PojoRawTypeModel<?> bridgedType, Class<?> otherEntityClass, PojoModelPathValueNode pathFromOtherEntityTypeToBridgedType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
