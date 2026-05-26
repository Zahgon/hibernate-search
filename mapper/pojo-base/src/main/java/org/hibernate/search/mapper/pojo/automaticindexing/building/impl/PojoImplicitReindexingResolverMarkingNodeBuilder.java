/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.automaticindexing.building.impl;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoImplicitReindexingResolverMarkingNode;
import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoImplicitReindexingResolverNode;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPath;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathTypeNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.impl.PojoRuntimePathsBuildingHelper;

class PojoImplicitReindexingResolverMarkingNodeBuilder<T> extends AbstractPojoImplicitReindexingResolverNodeBuilder<T> {

    private final BoundPojoModelPath modelPath;

    // Use a LinkedHashSet for deterministic iteration
    private final Set<PojoModelPathValueNode> dirtyPathsTriggeringReindexing = new LinkedHashSet<>();

    PojoImplicitReindexingResolverMarkingNodeBuilder(BoundPojoModelPathTypeNode<T> modelPath, PojoImplicitReindexingResolverBuildingHelper buildingHelper) {
        super(buildingHelper);
        this.modelPath = modelPath;
    }

    @Override
    BoundPojoModelPath getModelPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    void closeOnFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void addDirtyPathTriggeringReindexing(BoundPojoModelPathValueNode<?, ?, ?> dirtyPathFromEntityType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    void onFreeze(Set<PojoModelPathValueNode> dirtyPathsTriggeringReindexingCollector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    Optional<PojoImplicitReindexingResolverNode<T>> doBuild(PojoRuntimePathsBuildingHelper pathsBuildingHelper, Set<PojoModelPathValueNode> allPotentialDirtyPaths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
