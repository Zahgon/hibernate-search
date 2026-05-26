/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.automaticindexing.building.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.search.mapper.pojo.extractor.impl.BoundContainerExtractorPath;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathValueNode;
import org.hibernate.search.util.common.data.impl.LinkedNode;

/**
 * A node representing a value in a dependency collector,
 * and considering that the type holding the property/value
 * has the different metadata from its subtypes.
 *
 * @param <P> The property type
 * @param <V> The extracted value type
 *
 * @see AbstractPojoIndexingDependencyCollectorDirectValueNode
 * @see PojoIndexingDependencyCollectorTypeNode
 */
public class PojoIndexingDependencyCollectorPolymorphicDirectValueNode<P, V> extends AbstractPojoIndexingDependencyCollectorDirectValueNode<P, V> {

    static <P, V> AbstractPojoIndexingDependencyCollectorDirectValueNode<P, V> create(PojoIndexingDependencyCollectorPropertyNode<?, P> parentNode, BoundPojoModelPathValueNode<?, P, V> modelPathFromLastEntityNode, PojoImplicitReindexingResolverBuildingHelper buildingHelper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final List<PojoIndexingDependencyCollectorMonomorphicDirectValueNode<? extends P, V>> monomorphicValueNodes;

    PojoIndexingDependencyCollectorPolymorphicDirectValueNode(PojoIndexingDependencyCollectorPropertyNode<?, P> parentNode, BoundPojoModelPathValueNode<?, P, V> modelPathFromLastEntityNode, Metadata metadata, List<PojoIndexingDependencyCollectorMonomorphicDirectValueNode<? extends P, V>> monomorphicValueNodes, PojoImplicitReindexingResolverBuildingHelper buildingHelper) {
        super(parentNode, modelPathFromLastEntityNode, metadata, buildingHelper);
        this.monomorphicValueNodes = monomorphicValueNodes;
    }

    @Override
    public void collectDependency() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    void collectDependency(BoundPojoModelPathValueNode<?, ?, ?> dirtyPathFromEntityType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    void doCollectDependency(LinkedNode<DerivedDependencyWalkingInfo> derivedDependencyPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    void markForReindexing(AbstractPojoImplicitReindexingResolverTypeNodeBuilder<?, ?> inverseSideEntityTypeNodeBuilder, BoundPojoModelPathValueNode<?, ?, ?> dependencyPathFromInverseSideEntityTypeNode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
