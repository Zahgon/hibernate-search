/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.backend.common.spi;

import java.util.Optional;
import org.hibernate.search.util.common.pattern.spi.SimpleGlobPattern;

public class FieldPaths {

    public static final char PATH_SEPARATOR = '.';

    public static final String PATH_SEPARATOR_STRING = String.valueOf(PATH_SEPARATOR);

    public static final String PATH_SEPARATOR_REGEX_STRING = "\\.";

    private FieldPaths() {
    }

    public static String prefix(String prefix, String relativeFieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static SimpleGlobPattern prefix(String prefix, SimpleGlobPattern relativeFieldPathGlob) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String compose(String absolutePath, String relativeFieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static SimpleGlobPattern compose(String absolutePath, SimpleGlobPattern relativeFieldPathGlob) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static SimpleGlobPattern absolutize(String absoluteParentPath, String prefix, SimpleGlobPattern relativeFieldPathGlob) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static RelativizedPath relativize(String absolutePath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static boolean isStrictPrefix(String prefixCandidatePath, String path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String[] split(String absoluteFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static final class RelativizedPath {

        public final Optional<String> parentPath;

        public final String relativePath;

        private RelativizedPath(Optional<String> parentPath, String relativePath) {
            this.parentPath = parentPath;
            this.relativePath = relativePath;
        }
    }
}
