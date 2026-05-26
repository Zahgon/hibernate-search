/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.common.tree.impl;

public final class DepthFilter {

    private static final DepthFilter UNCONSTRAINED = new DepthFilter(null);

    static DepthFilter unconstrained() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static DepthFilter of(Integer includeDepth) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final Integer includeDepth;

    private DepthFilter(Integer includeDepth) {
        this.includeDepth = includeDepth;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    boolean isEveryPathIncludedAtDepth(int relativeDepth) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    boolean hasDepthLimit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
