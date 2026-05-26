/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.dependency.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.search.mapper.pojo.automaticindexing.building.impl.PojoIndexingDependencyCollectorNode;
import org.hibernate.search.mapper.pojo.automaticindexing.building.impl.PojoIndexingDependencyCollectorTypeNode;
import org.hibernate.search.mapper.pojo.extractor.impl.ContainerExtractorBinder;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.impl.PojoTypeAdditionalMetadataProvider;
import org.hibernate.search.mapper.pojo.model.dependency.PojoOtherEntityIndexingDependencyConfigurationContext;
import org.hibernate.search.mapper.pojo.model.dependency.PojoTypeIndexingDependencyConfigurationContext;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPath;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathTypeNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.spi.PojoModelPathBinder;
import org.hibernate.search.mapper.pojo.model.spi.PojoBootstrapIntrospector;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;

public class PojoTypeIndexingDependencyConfigurationContextImpl<T> extends AbstractPojoBridgedElementDependencyContext implements PojoTypeIndexingDependencyConfigurationContext {

    private final BoundPojoModelPathTypeNode<T> modelPath;

    private final List<BoundPojoModelPathValueNode<?, ?, ?>> usedPaths = new ArrayList<>();

    private final List<PojoOtherEntityIndexingDependencyConfigurationContextImpl<?>> otherEntityDependencyContexts = new ArrayList<>();

    public PojoTypeIndexingDependencyConfigurationContextImpl(PojoBootstrapIntrospector introspector, ContainerExtractorBinder containerExtractorBinder, PojoTypeAdditionalMetadataProvider typeAdditionalMetadataProvider, PojoTypeModel<T> typeModel) {
        super(introspector, containerExtractorBinder, typeAdditionalMetadataProvider);
        this.modelPath = BoundPojoModelPath.root(typeModel);
    }

    @Override
    public boolean hasNonRootDependency() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoTypeIndexingDependencyConfigurationContext use(PojoModelPathValueNode pathFromBridgedTypeToUsedValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoOtherEntityIndexingDependencyConfigurationContext fromOtherEntity(Class<?> otherEntityType, PojoModelPathValueNode pathFromOtherEntityTypeToBridgedType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void contributeDependencies(PojoIndexingDependencyCollectorTypeNode<T> dependencyCollector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
