/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.path.impl;

import java.util.BitSet;
import org.hibernate.search.mapper.pojo.model.path.spi.PojoPathFilter;

final class PojoPathFilterImpl implements PojoPathFilter {

    private final PojoPathOrdinals ordinals;

    private final BitSet acceptedPaths;

    public PojoPathFilterImpl(PojoPathOrdinals ordinals, BitSet acceptedPaths) {
        this.ordinals = ordinals;
        this.acceptedPaths = acceptedPaths;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean test(BitSet pathSelection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BitSet filter(String path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BitSet filter(String... paths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BitSet filter(int[] pathOrdinals) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BitSet filter(int pathOrdinal) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BitSet all() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
