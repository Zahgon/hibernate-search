/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.automaticindexing.building.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoImplicitReindexingResolverNode;
import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoImplicitReindexingResolverPropertyNode;
import org.hibernate.search.mapper.pojo.extractor.impl.BoundContainerExtractorPath;
import org.hibernate.search.mapper.pojo.extractor.impl.ContainerExtractorHolder;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathPropertyNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.impl.PojoRuntimePathsBuildingHelper;
import org.hibernate.search.util.common.impl.Closer;

class PojoImplicitReindexingResolverPropertyNodeBuilder<T, P> extends AbstractPojoImplicitReindexingResolverNodeBuilder<T> {

    private final BoundPojoModelPathPropertyNode<T, P> modelPath;

    private final PojoImplicitReindexingResolverValueNodeBuilderDelegate<P> valueWithoutExtractorsBuilderDelegate;

    // Use a LinkedHashMap for deterministic iteration
    private final Map<ContainerExtractorPath, PojoImplicitReindexingResolverContainerElementNodeBuilder<? super P, ?>> containerElementNodeBuilders = new LinkedHashMap<>();

    PojoImplicitReindexingResolverPropertyNodeBuilder(BoundPojoModelPathPropertyNode<T, P> modelPath, PojoImplicitReindexingResolverBuildingHelper buildingHelper) {
        super(buildingHelper);
        this.modelPath = modelPath;
        BoundContainerExtractorPath<P, P> noExtractorsBoundPath = BoundContainerExtractorPath.noExtractors(modelPath.getPropertyModel().typeModel());
        this.valueWithoutExtractorsBuilderDelegate = new PojoImplicitReindexingResolverValueNodeBuilderDelegate<>(modelPath.value(noExtractorsBoundPath), buildingHelper);
    }

    @Override
    BoundPojoModelPathPropertyNode<T, P> getModelPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    void closeOnFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    PojoImplicitReindexingResolverValueNodeBuilderDelegate<?> value(ContainerExtractorPath extractorPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void onFreeze(Set<PojoModelPathValueNode> dirtyPathsTriggeringReindexingCollector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    Optional<PojoImplicitReindexingResolverNode<T>> doBuild(PojoRuntimePathsBuildingHelper pathsBuildingHelper, Set<PojoModelPathValueNode> allPotentialDirtyPaths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /*
	 * This generic method is necessary to make it clear to the compiler
	 * that the extracted type and extractor have compatible generic arguments.
	 */
    private <V> PojoImplicitReindexingResolverContainerElementNodeBuilder<? super P, V> createContainerBuilder(BoundContainerExtractorPath<P, V> boundExtractorPath) {
        ContainerExtractorHolder<P, V> extractorHolder = buildingHelper.createExtractors(boundExtractorPath);
        BoundPojoModelPathValueNode<T, P, V> containerElementPath = modelPath.value(boundExtractorPath);
        return new PojoImplicitReindexingResolverContainerElementNodeBuilder<>(containerElementPath, extractorHolder, buildingHelper);
    }
}
