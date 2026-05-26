/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.annotation.processing.impl;

import java.util.Optional;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import org.hibernate.search.engine.backend.types.dsl.IndexFieldTypeFinalStep;
import org.hibernate.search.mapper.pojo.bridge.binding.PropertyBindingContext;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.AnnotationDefaultValues;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingNonFullTextFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingScaledNumberFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;
import org.hibernate.search.processor.model.impl.BuiltInBridgeResolverTypes;

class ProcessorScaledNumberFieldProcessor extends AbstractProcessorNonFullTextFieldAnnotationProcessor {

    @Override
    PropertyMappingNonFullTextFieldOptionsStep<?> initSortableFieldMappingContext(PropertyMappingStep mappingContext, AnnotationMirror annotation, String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Optional<IndexFieldTypeFinalStep<?>> configureField(PropertyBindingContext bindingContext, AnnotationMirror annotation, ProcessorAnnotationProcessorContext context, Element element, TypeMirror fieldType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
