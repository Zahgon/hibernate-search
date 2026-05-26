/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.build.report.forbiddenapis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.jboss.jandex.AnnotationTarget;
import org.jboss.jandex.DotName;
import org.jboss.jandex.FieldInfo;
import org.jboss.jandex.Index;
import org.jboss.jandex.IndexReader;
import org.jboss.jandex.IndexWriter;
import org.jboss.jandex.MethodInfo;
import org.jboss.jandex.MethodParameterInfo;

final class ReportGeneratorHelper {

    private static final String INDEX_FILE_NAME = "hibernate-search-report-index.idx";

    private ReportGeneratorHelper() {
    }

    static Index createIndex(String sourcesPath) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static String determinePath(AnnotationTarget usageLocation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static String parameters(MethodInfo methodInfo) {
        return methodInfo.parameters().stream().map(ReportGeneratorHelper::parameterTypeToString).collect(Collectors.joining(",", "(", ")"));
    }

    private static String parameterTypeToString(MethodParameterInfo parameter) {
        switch(parameter.type().kind()) {
            case CLASS:
            case PRIMITIVE:
            case VOID:
            case TYPE_VARIABLE:
            case UNRESOLVED_TYPE_VARIABLE:
            case WILDCARD_TYPE:
            case TYPE_VARIABLE_REFERENCE:
            case PARAMETERIZED_TYPE:
                return parameter.type().name().toString();
            case ARRAY:
                return parameter.type().asArrayType().constituent().name().toString() + "[]";
            default:
                throw new AssertionError("Unknown parameter type: " + parameter.type().kind());
        }
    }

    static void writeReportLines(Writer writer, String path, Optional<Pattern> rule) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
