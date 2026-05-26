/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.mapping.impl;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Messager;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import org.hibernate.search.processor.annotation.processing.impl.ProcessorAnnotationProcessorContext;
import org.hibernate.search.processor.impl.HibernateSearchMetamodelProcessorContext;

public final class ProcessorIntrospectorContext {

    private final HibernateSearchMetamodelProcessorContext processorContext;

    private final Map<String, TypeElement> typeElements = new HashMap<>();

    private ProcessorAnnotationProcessorContext processorAnnotationProcessorContext;

    public ProcessorIntrospectorContext(HibernateSearchMetamodelProcessorContext processorContext) {
        this.processorContext = processorContext;
    }

    public HibernateSearchMetamodelProcessorContext processorContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Elements elementUtils() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Types typeUtils() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Messager messager() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void typeElementsByName(String typeName, TypeElement indexedEntityType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public TypeElement typeElementsByName(String typeName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void processorAnnotationProcessorContext(ProcessorAnnotationProcessorContext processorAnnotationProcessorContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ProcessorAnnotationProcessorContext processorAnnotationProcessorContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
