/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.automaticindexing.building.impl;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoImplicitReindexingResolver;
import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoImplicitReindexingResolverImpl;
import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoImplicitReindexingResolverNode;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathPropertyNode;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPath;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.impl.PojoRuntimePathsBuildingHelper;
import org.hibernate.search.mapper.pojo.model.path.spi.PojoModelPathWalker;
import org.hibernate.search.mapper.pojo.model.path.spi.PojoPathFilter;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.util.common.AssertionFailure;

class PojoImplicitReindexingResolverBuilder<T> {

    static Walker walker() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final PojoRawTypeModel<T> rawTypeModel;

    private final PojoImplicitReindexingResolverBuildingHelper buildingHelper;

    // Use a LinkedHashSet for deterministic iteration
    private final Set<PojoModelPathValueNode> dirtyPathsTriggeringSelfReindexing = new LinkedHashSet<>();

    private final Map<PojoModelPathValueNode, Map<PojoRawTypeModel<?>, PojoModelPathValueNode>> containingAssociationPaths = new LinkedHashMap<>();

    private final PojoImplicitReindexingResolverOriginalTypeNodeBuilder<T> containingEntitiesResolverRootBuilder;

    private boolean frozen = false;

    PojoImplicitReindexingResolverBuilder(PojoRawTypeModel<T> rawTypeModel, PojoImplicitReindexingResolverBuildingHelper buildingHelper) {
        this.rawTypeModel = rawTypeModel;
        this.buildingHelper = buildingHelper;
        this.containingEntitiesResolverRootBuilder = new PojoImplicitReindexingResolverOriginalTypeNodeBuilder<>(BoundPojoModelPath.root(rawTypeModel), buildingHelper);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void closeOnFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void addDirtyPathTriggeringSelfReindexing(BoundPojoModelPathValueNode<?, ?, ?> dirtyPathFromEntityType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void addContainingAssociationPath(PojoModelPathValueNode pathFromContainedSide, PojoRawTypeModel<?> containingType, PojoModelPathValueNode pathFromContainingSide) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    PojoImplicitReindexingResolverOriginalTypeNodeBuilder<T> containingEntitiesResolverRoot() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    final Optional<PojoImplicitReindexingResolver<T>> build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Freeze the builder, signaling that no mutating method will be called anymore
     * and that derived data can be safely computed.
     */
    private void freeze() {
        if (!frozen) {
            frozen = true;
            containingEntitiesResolverRootBuilder.freeze();
        }
    }

    private void checkNotFrozen() {
        if (frozen) {
            throw new AssertionFailure("A mutating method was called on " + this + " after it was frozen.");
        }
    }

    static class Walker implements PojoModelPathWalker<Void, AbstractPojoImplicitReindexingResolverTypeNodeBuilder<?, ?>, PojoImplicitReindexingResolverPropertyNodeBuilder<?, ?>, PojoImplicitReindexingResolverValueNodeBuilderDelegate<?>> {

        public static final Walker INSTANCE = new Walker();

        @Override
        public PojoImplicitReindexingResolverPropertyNodeBuilder<?, ?> property(Void context, AbstractPojoImplicitReindexingResolverTypeNodeBuilder<?, ?> typeNode, PojoModelPathPropertyNode pathNode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public PojoImplicitReindexingResolverValueNodeBuilderDelegate<?> value(Void context, PojoImplicitReindexingResolverPropertyNodeBuilder<?, ?> propertyNode, PojoModelPathValueNode pathNode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public AbstractPojoImplicitReindexingResolverTypeNodeBuilder<?, ?> type(Void context, PojoImplicitReindexingResolverValueNodeBuilderDelegate<?> valueNode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
