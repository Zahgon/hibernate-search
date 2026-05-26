/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util.common.jar.impl;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.hibernate.search.util.common.annotation.impl.SuppressForbiddenApis;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.impl.SuppressingCloser;
import org.hibernate.search.util.common.impl.Throwables;
import org.hibernate.search.util.common.logging.impl.CommonMiscLog;

class CodeSource implements Closeable {

    private static final String JAR_URI_PATH_SEPARATOR = "!/";

    // Starting with Spring Boot 3.2 the nested jars in a repackaged app will be using an url structure as:
    //   * "jar:nested:/.../app-repackaged.jar/!BOOT-INF/classes/!/"
    //   * jar:nested:/.../app-repackaged.jar/!BOOT-INF/lib/some-packaged-lib.jar!/
    // that means that we will get the `nested:...` as a path when extracting the nested path.
    // Spring should be able to handle loading the files for such jars using their own custom filesystem and handlers
    // hence as soon as we discover such path we let it be handled by them.
    private static final String NESTED_SPEC_PREFIX = "nested:";

    private static final BiFunction<Path, URI, FileSystem> NESTED_JAR_FILESYSTEM_CREATOR;

    static {
        BiFunction<Path, URI, FileSystem> creator;
        try {
            Method newFileSystem = FileSystems.class.getMethod("newFileSystem", Path.class, Map.class);
            creator = (path, jarUri) -> {
                try {
                    return (FileSystem) newFileSystem.invoke(null, path, Collections.emptyMap());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw CommonMiscLog.INSTANCE.cannotOpenNestedJar(jarUri, e);
                }
            };
        } catch (NoSuchMethodException ignored) {
            creator = (path, jarUri) -> {
                throw CommonMiscLog.INSTANCE.cannotOpenNestedJar(jarUri, null);
            };
        }
        NESTED_JAR_FILESYSTEM_CREATOR = creator;
    }

    private final List<FileSystem> fileSystems = new ArrayList<>();

    private final URL codeSourceLocation;

    private FileSystem nonDefaultFileSystem;

    private Path classesPathInFileSystem;

    CodeSource(URL codeSourceLocation) {
        this.codeSourceLocation = codeSourceLocation;
    }

    @SuppressForbiddenApis(reason = "URL constructors are deprecated in JDK 20+ in favor of using URI.toURL()," + " but we need to start from URLs (not URIs) coming from java.security.CodeSource.")
    public InputStream readOrNull(String resourcePathString) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Path classesPathOrFail() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void initFileSystem() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void tryInitJarFileSystem(URI jarUri) throws IOException {
        try {
            changeFileSystemAndMarkPreviousOneForClosing(FileSystems.newFileSystem(jarUri, Collections.emptyMap()));
            classesPathInFileSystem = nonDefaultFileSystem.getRootDirectories().iterator().next();
            // The ZipFileSystemProvider ignores the "path inside the JAR",
            // so we need to take care of that ourselves.
            Path nestedPath = extractedJarNestedPath(jarUri);
            if (nestedPath != null && (!Files.isRegularFile(nestedPath))) {
                classesPathInFileSystem = nestedPath;
            }
        } catch (RuntimeException | IOException e) {
            new SuppressingCloser(e).push(nonDefaultFileSystem);
            nonDefaultFileSystem = null;
            classesPathInFileSystem = null;
            throw e;
        }
    }

    private Path extractedJarNestedPath(URI jarUri) {
        String spec = jarUri.getSchemeSpecificPart();
        if (spec == null || spec.startsWith(NESTED_SPEC_PREFIX)) {
            return null;
        }
        int pathSeparatorIndex = spec.indexOf(JAR_URI_PATH_SEPARATOR);
        if (pathSeparatorIndex < 0) {
            return null;
        } else {
            int afterPathSeparatorIndex = pathSeparatorIndex + JAR_URI_PATH_SEPARATOR.length();
            int secondPathSeparatorIndex = spec.indexOf(JAR_URI_PATH_SEPARATOR, afterPathSeparatorIndex);
            while (0 <= secondPathSeparatorIndex) {
                Path nestedPathInFileSystem = classesPathInFileSystem.resolve(spec.substring(afterPathSeparatorIndex, secondPathSeparatorIndex));
                if (Files.isRegularFile(nestedPathInFileSystem)) {
                    changeFileSystemAndMarkPreviousOneForClosing(NESTED_JAR_FILESYSTEM_CREATOR.apply(nestedPathInFileSystem, jarUri));
                    classesPathInFileSystem = nonDefaultFileSystem.getRootDirectories().iterator().next();
                } else {
                    return nestedPathInFileSystem;
                }
                afterPathSeparatorIndex = secondPathSeparatorIndex;
                secondPathSeparatorIndex = spec.indexOf(JAR_URI_PATH_SEPARATOR, afterPathSeparatorIndex);
            }
            return classesPathInFileSystem.resolve(spec.substring(afterPathSeparatorIndex));
        }
    }

    private void changeFileSystemAndMarkPreviousOneForClosing(FileSystem fileSystem) {
        if (this.nonDefaultFileSystem != null) {
            // we will be closing the filesystems in a reverse order:
            fileSystems.add(0, nonDefaultFileSystem);
        }
        this.nonDefaultFileSystem = fileSystem;
    }

    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
