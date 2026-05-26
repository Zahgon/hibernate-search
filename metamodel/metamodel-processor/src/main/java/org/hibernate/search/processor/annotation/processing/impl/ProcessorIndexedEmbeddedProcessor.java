/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.annotation.processing.impl;

import static org.hibernate.search.processor.impl.ProcessorElementUtils.collectExtraTypes;
import java.util.Optional;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import org.hibernate.search.engine.backend.types.ObjectStructure;
import org.hibernate.search.engine.backend.types.dsl.IndexFieldTypeFinalStep;
import org.hibernate.search.mapper.pojo.automaticindexing.ReindexOnUpdate;
import org.hibernate.search.mapper.pojo.bridge.binding.PropertyBindingContext;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.spi.MappingAnnotationProcessorUtils;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;

class ProcessorIndexedEmbeddedProcessor extends AbstractProcessorAnnotationProcessor {

    @SuppressWarnings("deprecation")
    @Override
    public void process(PropertyMappingStep mapping, AnnotationMirror annotation, Element element, ProcessorAnnotationProcessorContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Optional<IndexFieldTypeFinalStep<?>> configureField(PropertyBindingContext bindingContext, AnnotationMirror annotation, ProcessorAnnotationProcessorContext context, Element element, TypeMirror fieldType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private AnnotationMirror getExtraction(AnnotationMirror annotation) {
        return getAnnotationProperty(annotation, "extraction");
    }
}
