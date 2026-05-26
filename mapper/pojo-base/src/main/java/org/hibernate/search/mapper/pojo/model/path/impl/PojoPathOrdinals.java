/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.path.impl;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class PojoPathOrdinals {

    private final Map<String, Integer> ordinalByPath = new HashMap<>();

    private final List<String> pathByOrdinal = new ArrayList<>();

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Integer toOrdinal(String path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String toPath(int ordinal) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BitSet toPathSelection(Collection<String> paths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Set<String> toPathSet(BitSet pathSelection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int toExistingOrNewOrdinal(String path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
