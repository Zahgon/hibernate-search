/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.automaticindexing.building.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoImplicitReindexingResolverNode;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathTypeNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.impl.PojoRuntimePathsBuildingHelper;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;
import org.hibernate.search.util.common.impl.Closer;

abstract class AbstractPojoImplicitReindexingResolverTypeNodeBuilder<T, U> extends AbstractPojoImplicitReindexingResolverNodeBuilder<T> {

    private final PojoImplicitReindexingResolverMarkingNodeBuilder<U> markingNodeBuilder;

    // Use a LinkedHashMap for deterministic iteration
    private final Map<String, PojoImplicitReindexingResolverPropertyNodeBuilder<U, ?>> propertyNodeBuilders = new LinkedHashMap<>();

    AbstractPojoImplicitReindexingResolverTypeNodeBuilder(BoundPojoModelPathTypeNode<U> modelPath, PojoImplicitReindexingResolverBuildingHelper buildingHelper) {
        super(buildingHelper);
        this.markingNodeBuilder = new PojoImplicitReindexingResolverMarkingNodeBuilder<>(modelPath, buildingHelper);
    }

    @Override
    void closeOnFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    abstract BoundPojoModelPathTypeNode<U> getModelPath();

    PojoTypeModel<U> getTypeModel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    PojoImplicitReindexingResolverPropertyNodeBuilder<U, ?> property(String propertyName) {
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
    final Optional<PojoImplicitReindexingResolverNode<T>> doBuild(PojoRuntimePathsBuildingHelper pathsBuildingHelper, Set<PojoModelPathValueNode> allPotentialDirtyPaths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract PojoImplicitReindexingResolverNode<T> doBuild(PojoImplicitReindexingResolverNode<? super U> nestedNode);

    private PojoImplicitReindexingResolverPropertyNodeBuilder<U, ?> getOrCreatePropertyBuilder(String propertyName) {
        return propertyNodeBuilders.computeIfAbsent(propertyName, this::createPropertyBuilder);
    }

    private PojoImplicitReindexingResolverPropertyNodeBuilder<U, ?> createPropertyBuilder(String propertyName) {
        checkNotFrozen();
        return new PojoImplicitReindexingResolverPropertyNodeBuilder<>(getModelPath().property(propertyName), buildingHelper);
    }
}
