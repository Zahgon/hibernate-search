/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.automaticindexing.building.impl;

import java.util.Set;
import org.hibernate.search.mapper.pojo.automaticindexing.ReindexOnUpdate;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPath;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.spi.PojoModelPathBinder;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;
import org.hibernate.search.util.common.AssertionFailure;

/**
 * A node representing a disjoint value in a dependency collector,
 * i.e. a value whose path from the parent node is unknown.
 * <p>
 * This is useful for bridges that need to declare reindexing
 * without being able to specify which path they use exactly.
 *
 * @param <V> The extracted value type
 */
public class PojoIndexingDependencyCollectorDisjointValueNode<V> extends AbstractPojoIndexingDependencyCollectorValueNode {

    private final PojoIndexingDependencyCollectorTypeNode<?> parentNode;

    private final PojoRawTypeModel<V> inverseSideEntityTypeModel;

    private final BoundPojoModelPathValueNode<?, ?, ?> inverseAssociationPath;

    PojoIndexingDependencyCollectorDisjointValueNode(PojoIndexingDependencyCollectorTypeNode<?> parentNode, PojoRawTypeModel<V> inverseSideEntityTypeModel, BoundPojoModelPathValueNode<?, ?, ?> inverseAssociationPath, PojoImplicitReindexingResolverBuildingHelper buildingHelper) {
        super(buildingHelper);
        this.parentNode = parentNode;
        this.inverseSideEntityTypeModel = inverseSideEntityTypeModel;
        this.inverseAssociationPath = inverseAssociationPath;
        if (!buildingHelper.isEntity(inverseSideEntityTypeModel)) {
            throw new AssertionFailure("Encountered a type node whose parent is a disjoint value node, but does not represent an entity type?");
        }
        if (!inverseAssociationPath.getRootType().equals(inverseSideEntityTypeModel)) {
            throw new AssertionFailure("Inconsistent root type for " + inverseAssociationPath + "; expected " + inverseSideEntityTypeModel);
        }
    }

    @Override
    public PojoIndexingDependencyCollectorTypeNode<?> type() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    PojoIndexingDependencyCollectorTypeNode<?> lastEntityNode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    ReindexOnUpdate reindexOnUpdate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    void collectDependency(BoundPojoModelPathValueNode<?, ?, ?> dirtyPathFromEntityType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    void markForReindexing(AbstractPojoImplicitReindexingResolverTypeNodeBuilder<?, ?> inverseSideEntityTypeNodeBuilder, BoundPojoModelPathValueNode<?, ?, ?> dependencyPathFromInverseSideEntityTypeNode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
