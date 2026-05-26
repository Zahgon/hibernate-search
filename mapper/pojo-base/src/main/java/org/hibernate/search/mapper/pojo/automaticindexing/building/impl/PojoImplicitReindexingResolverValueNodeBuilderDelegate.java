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
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.impl.PojoRuntimePathsBuildingHelper;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.impl.Closer;

class PojoImplicitReindexingResolverValueNodeBuilderDelegate<V> {

    private final BoundPojoModelPathValueNode<?, ?, V> modelPath;

    private final PojoImplicitReindexingResolverBuildingHelper buildingHelper;

    private PojoImplicitReindexingResolverOriginalTypeNodeBuilder<V> typeNodeBuilder;

    // Use a LinkedHashMap for deterministic iteration
    private final Map<PojoRawTypeModel<?>, PojoImplicitReindexingResolverCastedTypeNodeBuilder<V, ?>> castedTypeNodeBuilders = new LinkedHashMap<>();

    private boolean frozen = false;

    PojoImplicitReindexingResolverValueNodeBuilderDelegate(BoundPojoModelPathValueNode<?, ?, V> modelPath, PojoImplicitReindexingResolverBuildingHelper buildingHelper) {
        this.modelPath = modelPath;
        this.buildingHelper = buildingHelper;
    }

    void closeOnFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    PojoTypeModel<V> getTypeModel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    <U> AbstractPojoImplicitReindexingResolverTypeNodeBuilder<V, ?> type(PojoRawTypeModel<U> targetTypeModel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    PojoImplicitReindexingResolverOriginalTypeNodeBuilder<V> type() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Freeze the builder delegate, signaling that no mutating method will be called anymore
     * and that derived data can be safely computed.
     */
    void freeze(Set<PojoModelPathValueNode> dirtyPathsTriggeringReindexingCollector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    Collection<PojoImplicitReindexingResolverNode<V>> buildTypeNodes(PojoRuntimePathsBuildingHelper pathsBuildingHelper, Set<PojoModelPathValueNode> allPotentialDirtyPaths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void checkNotFrozen() {
        if (frozen) {
            throw new AssertionFailure("A mutating method was called on " + this + " after it was frozen.");
        }
    }

    final void checkFrozen() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // We know builders have this exact type, by construction
    @SuppressWarnings("unchecked")
    private <U> PojoImplicitReindexingResolverCastedTypeNodeBuilder<V, ? extends U> getOrCreateCastedTypeNodeBuilder(PojoRawTypeModel<U> targetTypeModel) {
        return (PojoImplicitReindexingResolverCastedTypeNodeBuilder<V, ? extends U>) castedTypeNodeBuilders.computeIfAbsent(targetTypeModel, this::createCastedTypeNodeBuilder);
    }

    private <U> PojoImplicitReindexingResolverCastedTypeNodeBuilder<V, ? extends U> createCastedTypeNodeBuilder(PojoRawTypeModel<U> targetTypeModel) {
        checkNotFrozen();
        return new PojoImplicitReindexingResolverCastedTypeNodeBuilder<>(modelPath.type().castTo(targetTypeModel), buildingHelper);
    }
}
