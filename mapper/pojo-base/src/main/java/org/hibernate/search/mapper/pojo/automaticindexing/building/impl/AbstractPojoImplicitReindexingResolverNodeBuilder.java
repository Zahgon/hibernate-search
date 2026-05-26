/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.automaticindexing.building.impl;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoImplicitReindexingResolverDirtinessFilterNode;
import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoImplicitReindexingResolverMultiNode;
import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoImplicitReindexingResolverNode;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPath;
import org.hibernate.search.mapper.pojo.model.path.impl.PojoRuntimePathsBuildingHelper;
import org.hibernate.search.mapper.pojo.model.path.spi.PojoPathFilter;
import org.hibernate.search.util.common.AssertionFailure;

abstract class AbstractPojoImplicitReindexingResolverNodeBuilder<T> {

    final PojoImplicitReindexingResolverBuildingHelper buildingHelper;

    private boolean frozen = false;

    // Use a LinkedHashSet for deterministic iteration
    private final Set<PojoModelPathValueNode> dirtyPathsTriggeringReindexingIncludingNestedNodes = new LinkedHashSet<>();

    AbstractPojoImplicitReindexingResolverNodeBuilder(PojoImplicitReindexingResolverBuildingHelper buildingHelper) {
        this.buildingHelper = buildingHelper;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract BoundPojoModelPath getModelPath();

    abstract void closeOnFailure();

    /**
     * Freeze the builder, signaling that no mutating method will be called anymore
     * and that derived data can be safely computed.
     */
    final void freeze() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract void onFreeze(Set<PojoModelPathValueNode> dirtyPathsTriggeringReindexingCollector);

    final void checkNotFrozen() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    final void checkFrozen() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    final Set<PojoModelPathValueNode> getDirtyPathsTriggeringReindexingIncludingNestedNodes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param pathsBuildingHelper A helper to build path filters that will be used in the resolver (and its nested resolvers)
     * @param allPotentialDirtyPaths A comprehensive list of all paths that may be dirty
     * when the built resolver will be called. {@code null} if unknown.
     */
    final Optional<PojoImplicitReindexingResolverNode<T>> build(PojoRuntimePathsBuildingHelper pathsBuildingHelper, Set<PojoModelPathValueNode> allPotentialDirtyPaths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract Optional<PojoImplicitReindexingResolverNode<T>> doBuild(PojoRuntimePathsBuildingHelper pathsBuildingHelper, Set<PojoModelPathValueNode> allPotentialDirtyPaths);

    private PojoImplicitReindexingResolverNode<T> wrapWithFilter(PojoImplicitReindexingResolverNode<T> resolver, PojoRuntimePathsBuildingHelper pathsBuildingHelper, Set<PojoModelPathValueNode> immutableDirtyPathsTriggeringReindexing) {
        PojoPathFilter filter = pathsBuildingHelper.createFilter(immutableDirtyPathsTriggeringReindexing);
        return new PojoImplicitReindexingResolverDirtinessFilterNode<>(filter, resolver);
    }

    protected final <T2> PojoImplicitReindexingResolverNode<? super T2> createNested(Collection<? extends PojoImplicitReindexingResolverNode<? super T2>> elements) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
