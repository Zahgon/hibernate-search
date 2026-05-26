/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.typepattern.impl;

import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;

class AndTypePatternMatcher implements TypePatternMatcher {

    private final TypePatternMatcher left;

    private final TypePatternMatcher right;

    AndTypePatternMatcher(TypePatternMatcher left, TypePatternMatcher right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean matches(PojoTypeModel<?> typeToInspect) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
