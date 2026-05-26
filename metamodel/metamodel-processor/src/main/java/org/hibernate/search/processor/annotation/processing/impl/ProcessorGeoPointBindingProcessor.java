/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.annotation.processing.impl;

import static org.hibernate.search.processor.impl.ProcessorElementUtils.collectExtraTypes;
import java.util.Optional;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.engine.backend.types.dsl.IndexFieldTypeFinalStep;
import org.hibernate.search.mapper.pojo.bridge.binding.PropertyBindingContext;
import org.hibernate.search.mapper.pojo.bridge.builtin.programmatic.GeoPointBinder;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.TypeMappingStep;

class ProcessorGeoPointBindingProcessor extends AbstractProcessorAnnotationProcessor implements ProcessorTypeMappingAnnotationProcessor {

    @Override
    public void process(PropertyMappingStep mapping, AnnotationMirror annotation, Element element, ProcessorAnnotationProcessorContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void process(TypeMappingStep mapping, AnnotationMirror annotation, Element element, ProcessorAnnotationProcessorContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Optional<IndexFieldTypeFinalStep<?>> configureField(PropertyBindingContext bindingContext, AnnotationMirror annotation, ProcessorAnnotationProcessorContext context, Element element, TypeMirror fieldType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private GeoPointBinder createBinder(AnnotationMirror annotation) {
        return GeoPointBinder.create().fieldName(getAnnotationValueAsString(annotation, "fieldName", "")).markerSet(getAnnotationValueAsString(annotation, "markerSet", "")).projectable(getProjectable(annotation)).sortable(getSortable(annotation));
    }

    protected Sortable getSortable(AnnotationMirror annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected Projectable getProjectable(AnnotationMirror annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
