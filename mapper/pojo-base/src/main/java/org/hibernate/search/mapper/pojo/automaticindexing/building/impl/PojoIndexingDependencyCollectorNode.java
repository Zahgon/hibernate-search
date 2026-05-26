/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.automaticindexing.building.impl;

import org.hibernate.search.mapper.pojo.automaticindexing.ReindexOnUpdate;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathPropertyNode;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.spi.PojoModelPathWalker;
import org.hibernate.search.util.common.data.impl.LinkedNode;

public abstract class PojoIndexingDependencyCollectorNode {

    public static Walker walker() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static Walker walker(LinkedNode<DerivedDependencyWalkingInfo> derivedDependencyPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    final PojoImplicitReindexingResolverBuildingHelper buildingHelper;

    PojoIndexingDependencyCollectorNode(PojoImplicitReindexingResolverBuildingHelper buildingHelper) {
        this.buildingHelper = buildingHelper;
    }

    ReindexOnUpdate composeReindexOnUpdate(PojoIndexingDependencyCollectorTypeNode<?> otherEntityNode, ReindexOnUpdate otherReindexOnUpdate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private ReindexOnUpdate getStrictestReindexOnUpdate(ReindexOnUpdate left, ReindexOnUpdate right) {
        // From the least strict to most strict: DEFAULT, SHALLOW, NO.
        // That's also the ordinal order, so we just usse that.
        return left.ordinal() < right.ordinal() ? right : left;
    }

    /**
     * The last entity node among the ancestor nodes (this node included).
     * The "last entity node" might be the same as the last type node
     * if the last type node represents an entity type.
     * If not (e.g. if the last type node represents an embeddable type),
     * then the "last entity node" will be the closest ancestor type node representing an entity type.
     */
    abstract PojoIndexingDependencyCollectorTypeNode<?> lastEntityNode();

    abstract ReindexOnUpdate reindexOnUpdate();

    static class Walker implements PojoModelPathWalker<Void, PojoIndexingDependencyCollectorTypeNode<?>, PojoIndexingDependencyCollectorPropertyNode<?, ?>, AbstractPojoIndexingDependencyCollectorDirectValueNode<?, ?>> {

        private final LinkedNode<DerivedDependencyWalkingInfo> derivedDependencyPath;

        Walker(LinkedNode<DerivedDependencyWalkingInfo> derivedDependencyPath) {
            this.derivedDependencyPath = derivedDependencyPath;
        }

        @Override
        public PojoIndexingDependencyCollectorPropertyNode<?, ?> property(Void context, PojoIndexingDependencyCollectorTypeNode<?> typeNode, PojoModelPathPropertyNode pathNode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public AbstractPojoIndexingDependencyCollectorDirectValueNode<?, ?> value(Void context, PojoIndexingDependencyCollectorPropertyNode<?, ?> propertyNode, PojoModelPathValueNode pathNode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public PojoIndexingDependencyCollectorTypeNode<?> type(Void context, AbstractPojoIndexingDependencyCollectorDirectValueNode<?, ?> valueNode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
