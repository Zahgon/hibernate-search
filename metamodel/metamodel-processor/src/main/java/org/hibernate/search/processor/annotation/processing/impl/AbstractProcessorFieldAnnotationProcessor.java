/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.annotation.processing.impl;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.tools.Diagnostic;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;

public abstract class AbstractProcessorFieldAnnotationProcessor extends AbstractProcessorAnnotationProcessor {

    @Override
    public final void process(PropertyMappingStep mapping, AnnotationMirror annotation, Element element, ProcessorAnnotationProcessorContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected String getName(AnnotationMirror annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract PropertyMappingFieldOptionsStep<?> initFieldMappingContext(PropertyMappingStep mappingContext, AnnotationMirror annotation, String fieldName);

    private AnnotationMirror getExtraction(AnnotationMirror annotation) {
        return getAnnotationProperty(annotation, "extraction");
    }

    private AnnotationMirror getValueBinder(AnnotationMirror annotation) {
        return getAnnotationProperty(annotation, "valueBinder");
    }

    private AnnotationMirror getValueBridge(AnnotationMirror annotation) {
        return getAnnotationProperty(annotation, "valueBridge");
    }
}
