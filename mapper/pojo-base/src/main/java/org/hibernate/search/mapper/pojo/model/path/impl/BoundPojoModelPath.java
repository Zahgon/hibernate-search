/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.path.impl;

import org.hibernate.search.mapper.pojo.extractor.impl.BoundContainerExtractorPath;
import org.hibernate.search.mapper.pojo.extractor.impl.ContainerExtractorBinder;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPath;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathPropertyNode;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathValueNode;
import org.hibernate.search.mapper.pojo.model.path.spi.PojoModelPathWalker;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;

/**
 * Represents an arbitrarily long access path bound to a specific POJO model.
 * <p>
 * This class and its various subclasses are similar to {@link PojoModelPath},
 * except they provide information about the types they are bound to.
 * As a result, they include type node. For instance the path could be:
 * <code>
 * Type A =&gt; property "propertyOfA" =&gt; extractor "MapValueExtractor" =&gt; Type B =&gt; property "propertyOfB"
 * </code>
 */
public abstract class BoundPojoModelPath {

    public static Walker walker(ContainerExtractorBinder containerExtractorBinder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> BoundPojoModelPathOriginalTypeNode<T> root(PojoTypeModel<T> typeModel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    BoundPojoModelPath() {
        // Package-protected constructor
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public abstract BoundPojoModelPath getParent();

    public abstract PojoTypeModel<?> getRootType();

    public abstract PojoModelPath toUnboundPath();

    abstract void appendSelfPath(StringBuilder builder);

    private void appendPath(StringBuilder builder) {
        BoundPojoModelPath parent = getParent();
        if (parent == null) {
            appendSelfPath(builder);
        } else {
            parent.appendPath(builder);
            builder.append(" => ");
            appendSelfPath(builder);
        }
    }

    abstract void appendSelfPath(PojoModelPath.Builder builder);

    final void appendPath(PojoModelPath.Builder builder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Walker implements PojoModelPathWalker<Void, BoundPojoModelPathTypeNode<?>, BoundPojoModelPathPropertyNode<?, ?>, BoundPojoModelPathValueNode<?, ?, ?>> {

        private final ContainerExtractorBinder containerExtractorBinder;

        private Walker(ContainerExtractorBinder containerExtractorBinder) {
            this.containerExtractorBinder = containerExtractorBinder;
        }

        @Override
        public BoundPojoModelPathPropertyNode<?, ?> property(Void context, BoundPojoModelPathTypeNode<?> typeNode, PojoModelPathPropertyNode pathNode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public BoundPojoModelPathValueNode<?, ?, ?> value(Void context, BoundPojoModelPathPropertyNode<?, ?> propertyNode, PojoModelPathValueNode pathNode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public BoundPojoModelPathTypeNode<?> type(Void context, BoundPojoModelPathValueNode<?, ?, ?> valueNode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public <P> BoundPojoModelPathValueNode<?, P, ?> value(BoundPojoModelPathPropertyNode<?, P> propertyNode, ContainerExtractorPath extractorPath) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
