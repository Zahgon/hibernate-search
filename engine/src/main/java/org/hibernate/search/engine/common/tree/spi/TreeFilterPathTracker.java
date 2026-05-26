/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.common.tree.spi;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.hibernate.search.engine.common.tree.TreeFilterDefinition;

/**
 * A tracker for paths actually affected by a {@link TreeFilterDefinition}.
 * <p>
 * Used to detect invalid configuration in a filter definition,
 * for example useless includePaths.
 */
public final class TreeFilterPathTracker {

    private final TreeFilterDefinition definition;

    /**
     * The {@code paths} that were encountered.
     */
    // Use a LinkedHashSet, since the set will be exposed through a getter and may be iterated on
    private final Map<String, Boolean> encounteredFieldPaths = new LinkedHashMap<>();

    public TreeFilterPathTracker(TreeFilterDefinition definition) {
        this.definition = definition;
    }

    public Set<String> uselessIncludePaths() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Set<String> uselessExcludePaths() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Set<String> encounteredFieldPaths() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void markAsEncountered(String relativePath, boolean includedByThis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
