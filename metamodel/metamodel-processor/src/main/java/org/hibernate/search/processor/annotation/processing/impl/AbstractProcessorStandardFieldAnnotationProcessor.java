/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.annotation.processing.impl;

import javax.lang.model.element.AnnotationMirror;
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStandardFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;

abstract class AbstractProcessorStandardFieldAnnotationProcessor extends AbstractProcessorFieldAnnotationProcessor {

    @Override
    PropertyMappingStandardFieldOptionsStep<?> initFieldMappingContext(PropertyMappingStep mappingContext, AnnotationMirror annotation, String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected Searchable getSearchable(AnnotationMirror annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected Projectable getProjectable(AnnotationMirror annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract PropertyMappingStandardFieldOptionsStep<?> initStandardFieldMappingContext(PropertyMappingStep mappingContext, AnnotationMirror annotation, String fieldName);
}
