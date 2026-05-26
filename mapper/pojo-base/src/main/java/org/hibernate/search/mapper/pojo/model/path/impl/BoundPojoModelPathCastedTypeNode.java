/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.path.impl;

import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;

/**
 * @param <T> The type represented by the parent node, whose values are casted to {@link U}.
 * @param <U> The type represented by this node.
 */
public class BoundPojoModelPathCastedTypeNode<T, U> extends BoundPojoModelPathTypeNode<U> {

    private final BoundPojoModelPathValueNode<?, ?, T> parent;

    private final PojoTypeModel<U> typeModel;

    BoundPojoModelPathCastedTypeNode(BoundPojoModelPathValueNode<?, ?, T> parent, PojoTypeModel<U> typeModel) {
        this.parent = parent;
        this.typeModel = typeModel;
    }

    @Override
    public BoundPojoModelPathValueNode<?, ?, T> getParent() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoTypeModel<U> getTypeModel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <U2> BoundPojoModelPathCastedTypeNode<T, ? extends U2> castTo(PojoRawTypeModel<U2> typeModel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    void appendSelfPath(StringBuilder builder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
