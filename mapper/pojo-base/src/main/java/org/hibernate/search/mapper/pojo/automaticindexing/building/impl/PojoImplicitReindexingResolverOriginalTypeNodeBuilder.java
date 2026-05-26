/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.automaticindexing.building.impl;

import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoImplicitReindexingResolverNode;
import org.hibernate.search.mapper.pojo.automaticindexing.impl.PojoImplicitReindexingResolverOriginalTypeNode;
import org.hibernate.search.mapper.pojo.model.path.impl.BoundPojoModelPathTypeNode;

class PojoImplicitReindexingResolverOriginalTypeNodeBuilder<T> extends AbstractPojoImplicitReindexingResolverTypeNodeBuilder<T, T> {

    private final BoundPojoModelPathTypeNode<T> modelPath;

    PojoImplicitReindexingResolverOriginalTypeNodeBuilder(BoundPojoModelPathTypeNode<T> modelPath, PojoImplicitReindexingResolverBuildingHelper buildingHelper) {
        super(modelPath, buildingHelper);
        this.modelPath = modelPath;
    }

    @Override
    public BoundPojoModelPathTypeNode<T> getModelPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    PojoImplicitReindexingResolverNode<T> doBuild(PojoImplicitReindexingResolverNode<? super T> nestedNode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
