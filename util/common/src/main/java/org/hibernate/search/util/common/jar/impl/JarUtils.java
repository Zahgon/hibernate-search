/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.jar.impl;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.jar.Manifest;

public final class JarUtils {

    private JarUtils() {
    }

    private static final String META_INF_MANIFEST = "META-INF/MANIFEST.MF";

    /*
	 * Code originally released under ASL 2.0.
	 * <p>
	 * Original code:
	 * https://github.com/quarkusio/quarkus/blob/8d4d3459b01203d2ce35d7847874a88941960443/independent-projects/bootstrap/core/src/main/java/io/quarkus/bootstrap/classloading/JarClassPathElement.java#L37-L56
	 */
    private static final int JAVA_VERSION;

    static {
        int version = 8;
        try {
            Method versionMethod = Runtime.class.getMethod("version");
            Object v = versionMethod.invoke(null);
            @SuppressWarnings({ "unchecked", "raw" })
            List<Integer> list = (List<Integer>) v.getClass().getMethod("version").invoke(v);
            version = list.get(0);
        } catch (Exception e) {
            //version 8
        }
        JAVA_VERSION = version;
    }

    public static int javaVersion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Optional<URL> codeSourceLocation(Class<?> classFromJar) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Code originally released under ASL 2.0.
     * <p>
     * Original code: https://github.com/smallrye/smallrye-common/blob/main/io/src/main/java/io/smallrye/common/io/jar/JarFiles.java#L45-L60
     */
    static boolean isMultiRelease(Path jarRoot) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
