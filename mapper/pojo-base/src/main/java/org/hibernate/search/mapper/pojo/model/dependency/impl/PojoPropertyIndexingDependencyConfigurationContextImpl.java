/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.dependency.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.search.mapper.pojo.automaticindexing.building.impl.AbstractPojoIndexingDependencyCollectorDirectValueNode;
import org.hibernate.search.mapper.pojo.automaticindexing.building.impl.PojoIndexingDependencyCollectorNode;
import org.hibernate.search.mapper.pojo.automaticindexing.building.impl.PojoIndexingDependencyCollectorPropertyNode;
import org.hibernate.search.mapper.pojo.automaticindexing.building.impl.PojoIndexingDependencyCollectorTypeNode;
import org.hibernate.search.mapper.pojo.extractor.impl.ContainerExtractorBinder;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.impl.PojoTypeAdditionalMetadataProvider;
import org.hibernate.search.mapper.pojo.model.dependency.PojoOtherEntityIndexingDependencyConfigurationContext;
import org.hibernate.search.mapper.pojo.model.dependency.PojoPropertyIndexingDependencyConfigurationContext;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathOriginalTypeNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathPropertyNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.spi.PojoModelPathBinder;
import org.hibernate.search.mapper.pojo.model.spi.PojoBootstrapIntrospector;

public class PojoPropertyIndexingDependencyConfigurationContextImpl<P> extends AbstractPojoBridgedElementDependencyContext implements PojoPropertyIndexingDependencyConfigurationContext {

    private final BoundPojoModelPathPropertyNode<?, P> modelPath;

    private final Map<ContainerExtractorPath, ValueDependencyContext> valueDependencyContexts = new LinkedHashMap<>();

    public PojoPropertyIndexingDependencyConfigurationContextImpl(PojoBootstrapIntrospector introspector, ContainerExtractorBinder containerExtractorBinder, PojoTypeAdditionalMetadataProvider typeAdditionalMetadataProvider, BoundPojoModelPathPropertyNode<?, P> modelPath) {
        super(introspector, containerExtractorBinder, typeAdditionalMetadataProvider);
        this.modelPath = modelPath;
    }

    @Override
    public PojoPropertyIndexingDependencyConfigurationContext use(ContainerExtractorPath extractorPathFromBridgedProperty, PojoModelPathValueNode pathFromExtractedBridgedPropertyValueToUsedValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoOtherEntityIndexingDependencyConfigurationContext fromOtherEntity(ContainerExtractorPath extractorPathFromBridgedProperty, Class<?> otherEntityType, PojoModelPathValueNode pathFromOtherEntityTypeToBridgedPropertyExtractedType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void useRootOnly() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean hasNonRootDependency() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void contributeDependencies(PojoIndexingDependencyCollectorPropertyNode<?, P> dependencyCollector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class ValueDependencyContext {

        private final BoundPojoModelPathOriginalTypeNode<?> valueTypePath;

        private final List<PojoModelPathValueNode> usedPaths = new ArrayList<>();

        private final List<PojoOtherEntityIndexingDependencyConfigurationContextImpl<?>> otherEntityDependencyContexts = new ArrayList<>();

        private ValueDependencyContext(ContainerExtractorPath extractorPathFromBridgedProperty) {
            BoundPojoModelPathValueNode<?, ?, ?> valuePath = bindingPathWalker.value(modelPath, extractorPathFromBridgedProperty);
            valueTypePath = valuePath.type();
        }

        public void contributeDependencies(AbstractPojoIndexingDependencyCollectorDirectValueNode<?, ?> dependencyCollectorValueNode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private PojoOtherEntityIndexingDependencyConfigurationContextImpl<?> addOtherEntityDependencyContext(Class<?> otherEntityType, PojoModelPathValueNode pathFromOtherEntityTypeToBridgedPropertyExtractedType) {
            PojoOtherEntityIndexingDependencyConfigurationContextImpl<?> otherContext = createOtherEntityDependencyContext(valueTypePath.getTypeModel().rawType(), otherEntityType, pathFromOtherEntityTypeToBridgedPropertyExtractedType);
            // If we get here, the path is valid
            otherEntityDependencyContexts.add(otherContext);
            return otherContext;
        }

        public void use(PojoModelPathValueNode pathFromExtractedBridgedPropertyValueToUsedValue) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public boolean hasExplicitDependency() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
