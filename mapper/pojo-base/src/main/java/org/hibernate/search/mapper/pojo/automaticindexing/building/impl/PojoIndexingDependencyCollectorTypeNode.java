/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.automaticindexing.building.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.hibernate.search.mapper.pojo.automaticindexing.ReindexOnUpdate;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPath;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathCastedTypeNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathPropertyNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathTypeNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;
import org.hibernate.search.util.common.AssertionFailure;

/**
 * A node representing a type in a dependency collector.
 *
 * @see AbstractPojoIndexingDependencyCollectorDirectValueNode
 *
 * @param <T> The represented type
 */
public class PojoIndexingDependencyCollectorTypeNode<T> extends PojoIndexingDependencyCollectorNode {

    private final AbstractPojoIndexingDependencyCollectorValueNode parentNode;

    /**
     * The path to this node from this node, i.e. a root to be used to build model paths for child nodes.
     */
    private final BoundPojoModelPathTypeNode<T> modelPathFromCurrentNode;

    /**
     * The last entity node among the ancestor nodes,
     * i.e. the closest type node representing an entity type.
     */
    private final PojoIndexingDependencyCollectorTypeNode<?> lastEntityNode;

    private final BoundPojoModelPathTypeNode<T> modelPathFromLastEntityNode;

    private final ReindexOnUpdate reindexOnUpdate;

    PojoIndexingDependencyCollectorTypeNode(PojoRawTypeModel<T> typeModel, PojoImplicitReindexingResolverBuildingHelper buildingHelper) {
        this(null, BoundPojoModelPath.root(typeModel), buildingHelper);
    }

    PojoIndexingDependencyCollectorTypeNode(AbstractPojoIndexingDependencyCollectorValueNode parentNode, BoundPojoModelPathTypeNode<T> modelPathFromLastEntityNode, PojoImplicitReindexingResolverBuildingHelper buildingHelper) {
        super(buildingHelper);
        this.parentNode = parentNode;
        PojoTypeModel<T> typeModel = modelPathFromLastEntityNode.getTypeModel();
        this.modelPathFromCurrentNode = BoundPojoModelPath.root(typeModel);
        if (parentNode == null || buildingHelper.isEntity(typeModel.rawType())) {
            this.lastEntityNode = this;
            this.modelPathFromLastEntityNode = modelPathFromCurrentNode;
        } else {
            this.lastEntityNode = parentNode.lastEntityNode();
            this.modelPathFromLastEntityNode = modelPathFromLastEntityNode;
        }
        this.reindexOnUpdate = parentNode != null ? parentNode.composeReindexOnUpdate(lastEntityNode, null) : buildingHelper.getDefaultReindexOnUpdate();
    }

    /*
	 * modelPathFromCurrentNode, modelPathFromRootEntityNode and modelPathFromLastEntityNode
	 * reference the same type, just from a different root.
	 * Thus fetching the same property results in the same property type.
	 */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public PojoIndexingDependencyCollectorPropertyNode<T, ?> property(String propertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PojoIndexingDependencyCollectorDisjointValueNode<?> disjointValue(BoundPojoModelPathValueNode<?, ?, ?> inverseAssociationPath) {
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

    void collectDependency(BoundPojoModelPathValueNode<?, ?, ?> dirtyPathFromEntityType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void markForReindexing(PojoImplicitReindexingResolverValueNodeBuilderDelegate<?> valueNodeBuilderDelegate, Set<? extends PojoRawTypeModel<?>> valueNodeTypeConcreteEntitySubTypes, BoundPojoModelPathValueNode<?, ?, ?> dependencyPathFromInverseSideEntityTypeNode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /*
	 * The entities to reindex will always be instances of both the entity type on the original side
	 * (because that's the one we want to reindex)
	 * and the type targeted by the inverse side of the association
	 * (because that's all we will ever retrieve at runtime).
	 * Thus we will only consider the most specific type of the two when resolving entities to reindex.
	 */
    Set<? extends PojoRawTypeModel<?>> getConcreteEntitySubTypesForTypeToReindex(PojoRawTypeModel<?> originalSideRawType, PojoRawTypeModel<?> inverseSideRawType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    PojoTypeModel<T> typeModel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    List<PojoIndexingDependencyCollectorTypeNode<? extends T>> polymorphic() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Casting a raw or generic type to a raw subtype always results in a subtype (generic or not)
    @SuppressWarnings("unchecked")
    private PojoIndexingDependencyCollectorTypeNode<? extends T> castToRawSubType(PojoRawTypeModel<?> concreteSubType) {
        return new PojoIndexingDependencyCollectorTypeNode<>(parentNode, (BoundPojoModelPathCastedTypeNode<?, ? extends T>) modelPathFromLastEntityNode.castTo(concreteSubType), buildingHelper);
    }
}
