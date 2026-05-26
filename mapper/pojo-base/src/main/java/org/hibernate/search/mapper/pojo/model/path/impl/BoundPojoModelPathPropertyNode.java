/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.path.impl;

import org.hibernate.search.mapper.pojo.extractor.impl.BoundContainerExtractorPath;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPath;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathPropertyNode;
import org.hibernate.search.mapper.pojo.model.spi.PojoPropertyModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;

/**
 * @param <T> The property holder type of this node, i.e. the type from which the property is retrieved.
 * @param <P> The type of the property represented by this node.
 */
public class BoundPojoModelPathPropertyNode<T, P> extends BoundPojoModelPath {

    private final BoundPojoModelPathTypeNode<T> parent;

    private final PojoPropertyModel<P> propertyModel;

    BoundPojoModelPathPropertyNode(BoundPojoModelPathTypeNode<T> parent, PojoPropertyModel<P> propertyModel) {
        this.parent = parent;
        this.propertyModel = propertyModel;
    }

    @Override
    public BoundPojoModelPathTypeNode<T> getParent() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoTypeModel<?> getRootType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoModelPathPropertyNode toUnboundPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BoundPojoModelPathValueNode<T, P, P> valueWithoutExtractors() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <V> BoundPojoModelPathValueNode<T, P, V> value(BoundContainerExtractorPath<? super P, V> extractorPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PojoPropertyModel<P> getPropertyModel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    void appendSelfPath(StringBuilder builder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    void appendSelfPath(PojoModelPath.Builder builder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
