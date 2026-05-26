/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.annotation.processing.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import org.hibernate.search.engine.backend.types.IndexFieldType;
import org.hibernate.search.engine.backend.types.dsl.IndexFieldTypeFinalStep;
import org.hibernate.search.mapper.pojo.bridge.binding.PropertyBindingContext;
import org.hibernate.search.mapper.pojo.extractor.mapping.annotation.ContainerExtract;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.util.common.AssertionFailure;

abstract class AbstractProcessorAnnotationProcessor implements ProcessorPropertyMappingAnnotationProcessor {

    protected static final String[] EMPTY = new String[0];

    @Override
    public final void process(PropertyBindingContext bindingContext, AnnotationMirror annotation, ProcessorAnnotationProcessorContext context, Element element) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract Optional<IndexFieldTypeFinalStep<?>> configureField(PropertyBindingContext bindingContext, AnnotationMirror annotation, ProcessorAnnotationProcessorContext context, Element element, TypeMirror fieldType);

    protected ContainerExtractorPath toContainerExtractorPath(AnnotationMirror extraction, ProcessorAnnotationProcessorContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected ContainerExtractorPath toContainerExtractorPath(AnnotationMirror extraction, String defaultValue, ProcessorAnnotationProcessorContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected AnnotationMirror getAnnotationProperty(AnnotationMirror annotation, String annotationName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected String getAnnotationValueAsString(AnnotationMirror annotation, String name, String defaultValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected String getAnnotationValueAsString(AnnotationMirror annotation, String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected int getAnnotationValueAsInt(AnnotationMirror annotation, String name, int defaultValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected AnnotationValue getAnnotationValue(AnnotationMirror annotation, String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected String[] toStringArray(AnnotationValue value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
