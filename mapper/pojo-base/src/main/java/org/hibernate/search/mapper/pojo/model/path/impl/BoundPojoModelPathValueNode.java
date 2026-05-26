/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.path.impl;

import org.hibernate.search.mapper.pojo.extractor.impl.BoundContainerExtractorPath;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPath;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;

/**
 * @param <T> The property holder type of this node, i.e. the type from which the property is retrieved.
 * @param <P> The property type of this node, i.e. the type of the property from which the values are extracted.
 * @param <V> The value type of this node, i.e. the type of values extracted from the property.
 */
public class BoundPojoModelPathValueNode<T, P, V> extends BoundPojoModelPath {

    private final BoundPojoModelPathPropertyNode<T, P> parent;

    private final BoundContainerExtractorPath<? super P, V> boundExtractorPath;

    private BoundPojoModelPathOriginalTypeNode<V> elementTypePathNode;

    BoundPojoModelPathValueNode(BoundPojoModelPathPropertyNode<T, P> parent, BoundContainerExtractorPath<? super P, V> boundExtractorPath) {
        this.parent = parent;
        this.boundExtractorPath = boundExtractorPath;
    }

    /**
     * @return The model path to the property from which the value represented by this node is extracted.
     */
    @Override
    public BoundPojoModelPathPropertyNode<T, P> getParent() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoTypeModel<?> getRootType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoModelPathValueNode toUnboundPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return A child path node representing the type of values represented by this node.
     */
    public BoundPojoModelPathOriginalTypeNode<V> type() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PojoTypeModel<V> getTypeModel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The bound extractor path from the parent property to this value.
     */
    public BoundContainerExtractorPath<? super P, V> getBoundExtractorPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The extractor path from the parent property to this value.
     * The path is guaranteed to be explicit (i.e. it won't be {@link ContainerExtractorPath#defaultExtractors()}).
     */
    public ContainerExtractorPath getExtractorPath() {
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
