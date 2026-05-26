/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.annotation.processing.impl;

import javax.lang.model.element.AnnotationMirror;
import org.hibernate.search.engine.backend.types.Aggregable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.AnnotationDefaultValues;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingNonFullTextFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStandardFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;

abstract class AbstractProcessorNonFullTextFieldAnnotationProcessor extends AbstractProcessorStandardFieldAnnotationProcessor {

    @Override
    PropertyMappingStandardFieldOptionsStep<?> initStandardFieldMappingContext(PropertyMappingStep mappingContext, AnnotationMirror annotation, String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract PropertyMappingNonFullTextFieldOptionsStep<?> initSortableFieldMappingContext(PropertyMappingStep mappingContext, AnnotationMirror annotation, String fieldName);

    protected Sortable getSortable(AnnotationMirror annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected Aggregable getAggregable(AnnotationMirror annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected String getIndexNullAs(AnnotationMirror annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
