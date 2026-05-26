/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.build.report.loggers;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import org.yaml.snakeyaml.Yaml;

@SupportedAnnotationTypes("org.hibernate.search.util.common.logging.CategorizedLogger")
@SupportedOptions({ Configuration.MODULE_NAME })
public class LoggerCategoriesProcessor extends AbstractProcessor {

    private Messager messager;

    private final Map<String, String> categories = new TreeMap<>();

    private final Map<String, Set<String>> categoryLevels = new TreeMap<>();

    private String moduleName;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private List<Map<String, Object>> toYamlCategories(Map<String, String> categories, Map<String, Set<String>> levels) {
        List<Map<String, Object>> values = new ArrayList<>();
        for (var entry : categories.entrySet()) {
            Map<String, Object> value = new LinkedHashMap<>();
            value.put(ReportConstants.CATEGORY_NAME, entry.getKey());
            value.put(ReportConstants.CATEGORY_DESCRIPTION, entry.getValue());
            value.put(ReportConstants.LOG_LEVELS, new ArrayList<>(levels.getOrDefault(entry.getKey(), Set.of())));
            values.add(value);
        }
        return values;
    }

    private boolean hasLoggingMethods(TypeElement logger) {
        for (Element element : processingEnv.getElementUtils().getAllMembers(logger)) {
            if (element.getKind() == ElementKind.METHOD) {
                ExecutableElement executable = (ExecutableElement) element;
                if (isVoid(executable) && hasLoggingAnnotation(executable)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Set<String> loggingLevels(TypeElement logger) {
        Set<String> levels = new TreeSet<>();
        for (Element element : processingEnv.getElementUtils().getAllMembers(logger)) {
            if (element.getKind() == ElementKind.METHOD) {
                ExecutableElement executable = (ExecutableElement) element;
                Optional<AnnotationMirror> logMessage = getLogMessage(executable);
                logMessage.ifPresent(annotationMirror -> levels.add(getAnnotationValueAsString(annotationMirror, "level")));
            }
        }
        return levels;
    }

    private boolean hasLoggingAnnotation(ExecutableElement executable) {
        return getLogMessage(executable).isPresent();
    }

    private Optional<AnnotationMirror> getLogMessage(ExecutableElement executable) {
        for (AnnotationMirror am : executable.getAnnotationMirrors()) {
            if (((TypeElement) am.getAnnotationType().asElement()).getQualifiedName().contentEquals("org.jboss.logging.annotations.LogMessage")) {
                return Optional.of(am);
            }
        }
        return Optional.empty();
    }

    private boolean isVoid(ExecutableElement executable) {
        return executable.getReturnType().getKind() == TypeKind.VOID;
    }

    private boolean extendsBasicLogger(TypeElement logger) {
        List<? extends TypeMirror> interfaces = logger.getInterfaces();
        for (TypeMirror anInterface : interfaces) {
            Element el = processingEnv.getTypeUtils().asElement(anInterface);
            if (((TypeElement) el).getQualifiedName().contentEquals("org.jboss.logging.BasicLogger")) {
                return true;
            }
        }
        return false;
    }

    private String getAnnotationValueAsString(AnnotationMirror annotationMirror, String name) {
        AnnotationValue annotationValue = getAnnotationValue(annotationMirror, name);
        if (annotationValue == null) {
            return "";
        }
        return annotationValue.getValue().toString();
    }

    private AnnotationValue getAnnotationValue(AnnotationMirror annotationMirror, String name) {
        var elementValues = annotationMirror.getElementValues();
        for (var entry : elementValues.entrySet()) {
            if (entry.getKey().getSimpleName().contentEquals(name)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
