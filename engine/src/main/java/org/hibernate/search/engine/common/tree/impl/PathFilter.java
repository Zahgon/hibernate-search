/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.common.tree.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class PathFilter {

    static PathFilter unconstrained() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static PathFilter of(Set<String> includedPaths, Set<String> excludedPaths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Paths that filter works with.
     */
    protected final Set<String> paths;

    private PathFilter(Set<String> paths) {
        this.paths = paths;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract boolean isExplicitlyIncluded(String relativePath);

    abstract boolean isExplicitlyExcluded(String relativePath);

    abstract boolean isPotentiallyExcluded(String path);

    abstract boolean isAnyPathExplicitlyIncluded();

    private static class IncludePathFilter extends PathFilter {

        private IncludePathFilter(Set<String> paths) {
            super(paths);
        }

        @Override
        boolean isExplicitlyIncluded(String relativePath) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        boolean isExplicitlyExcluded(String relativePath) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        boolean isPotentiallyExcluded(String path) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        boolean isAnyPathExplicitlyIncluded() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class ExcludePathFilter extends PathFilter {

        private ExcludePathFilter(Set<String> paths) {
            super(paths);
        }

        @Override
        boolean isExplicitlyIncluded(String relativePath) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        boolean isExplicitlyExcluded(String relativePath) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        boolean isPotentiallyExcluded(String pathToTest) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        boolean isAnyPathExplicitlyIncluded() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Unconstrained extends PathFilter {

        private static final PathFilter INSTANCE = new Unconstrained();

        private Unconstrained() {
            super(Collections.emptySet());
        }

        @Override
        boolean isExplicitlyIncluded(String relativePath) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        boolean isExplicitlyExcluded(String relativePath) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        boolean isPotentiallyExcluded(String path) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        boolean isAnyPathExplicitlyIncluded() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static void addSubPathsFromRoot(Set<String> collector, String path) {
        int afterPreviousDotIndex = 0;
        int nextDotIndex = path.indexOf('.', afterPreviousDotIndex);
        while (nextDotIndex >= 0) {
            String subPath = path.substring(0, nextDotIndex);
            collector.add(subPath);
            afterPreviousDotIndex = nextDotIndex + 1;
            nextDotIndex = path.indexOf('.', afterPreviousDotIndex);
        }
    }
}
