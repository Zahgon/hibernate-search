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
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.VectorSimilarity;
import org.hibernate.search.engine.backend.types.dsl.IndexFieldTypeFinalStep;
import org.hibernate.search.engine.backend.types.dsl.VectorFieldTypeOptionsStep;
import org.hibernate.search.mapper.pojo.bridge.binding.PropertyBindingContext;
import org.hibernate.search.mapper.pojo.extractor.mapping.annotation.ContainerExtract;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.AnnotationDefaultValues;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingVectorFieldOptionsStep;
import org.hibernate.search.processor.model.impl.BuiltInBridgeResolverTypes;

class ProcessorVectorFieldProcessor extends AbstractProcessorFieldAnnotationProcessor {

    @Override
    PropertyMappingFieldOptionsStep<?> initFieldMappingContext(PropertyMappingStep mappingContext, AnnotationMirror annotation, String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Optional<IndexFieldTypeFinalStep<?>> configureField(PropertyBindingContext bindingContext, AnnotationMirror annotation, ProcessorAnnotationProcessorContext context, Element element, TypeMirror fieldType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected ContainerExtractorPath toContainerExtractorPath(AnnotationMirror extraction, ProcessorAnnotationProcessorContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected VectorSimilarity getVectorSimilarity(AnnotationMirror annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected Searchable getSearchable(AnnotationMirror annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected Projectable getProjectable(AnnotationMirror annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected String getIndexNullAs(AnnotationMirror annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
