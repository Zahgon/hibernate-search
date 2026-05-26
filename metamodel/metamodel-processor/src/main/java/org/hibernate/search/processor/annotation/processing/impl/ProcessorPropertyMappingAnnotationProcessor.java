/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.annotation.processing.impl;

import java.util.Optional;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import org.hibernate.search.mapper.pojo.bridge.binding.PropertyBindingContext;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;

public interface ProcessorPropertyMappingAnnotationProcessor {

    static boolean documentId(AnnotationMirror annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static boolean ormId(AnnotationMirror annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static Optional<ProcessorPropertyMappingAnnotationProcessor> processor(AnnotationMirror annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static Name getQualifiedName(AnnotationMirror annotation) {
        return ((TypeElement) annotation.getAnnotationType().asElement()).getQualifiedName();
    }

    void process(PropertyMappingStep mapping, AnnotationMirror annotation, Element element, ProcessorAnnotationProcessorContext context);

    void process(PropertyBindingContext bindingContext, AnnotationMirror annotation, ProcessorAnnotationProcessorContext context, Element element);
}
