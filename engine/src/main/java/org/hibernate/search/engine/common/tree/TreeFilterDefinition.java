/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.common.tree;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import org.hibernate.search.engine.logging.impl.MappingLog;

public final class TreeFilterDefinition {

    private static final TreeFilterDefinition INCLUDE_ALL = new TreeFilterDefinition(null, null, null);

    public static TreeFilterDefinition includeAll() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final Set<String> includePaths;

    private final Set<String> excludePaths;

    private final Integer includeDepth;

    /**
     * @param includeDepth The maximum depth beyond which all created fields will be ignored. {@code null} for no limit.
     * @param includePaths The exhaustive list of paths of fields that are to be included. {@code null} for no limit.
     * Cannot be used with a non-empty {@code excludePaths}.
     * @param excludePaths The list of paths of fields that are to be excluded. {@code null} for no exclusion.
     * Cannot be used with a non-empty {@code includePaths}.
     */
    public TreeFilterDefinition(Integer includeDepth, Set<String> includePaths, Set<String> excludePaths) {
        this.includePaths = includePaths == null ? Collections.emptySet() : new LinkedHashSet<>(includePaths);
        this.excludePaths = excludePaths == null ? Collections.emptySet() : new LinkedHashSet<>(excludePaths);
        if (!this.includePaths.isEmpty() && !this.excludePaths.isEmpty()) {
            throw MappingLog.INSTANCE.cannotIncludeAndExcludePathsWithinSameFilter(includePaths, excludePaths);
        }
        if (includeDepth == null && !this.includePaths.isEmpty()) {
            /*
			 * If no max depth was provided and included paths were provided,
			 * the remaining composition depth is implicitly set to 0,
			 * meaning no composition is allowed and paths are excluded unless
			 * explicitly listed in "includePaths".
			 */
            this.includeDepth = 0;
        } else {
            this.includeDepth = includeDepth;
        }
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Set<String> includePaths() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Set<String> excludePaths() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Integer includeDepth() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
