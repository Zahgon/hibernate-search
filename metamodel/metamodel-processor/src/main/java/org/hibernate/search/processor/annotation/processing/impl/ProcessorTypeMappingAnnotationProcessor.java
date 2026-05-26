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
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.TypeMappingStep;

public interface ProcessorTypeMappingAnnotationProcessor {

    static Optional<ProcessorTypeMappingAnnotationProcessor> processor(AnnotationMirror annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void process(TypeMappingStep mapping, AnnotationMirror annotation, Element element, ProcessorAnnotationProcessorContext context);
}
