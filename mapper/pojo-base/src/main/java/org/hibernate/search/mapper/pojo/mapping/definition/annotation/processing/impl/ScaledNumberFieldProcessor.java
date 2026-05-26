/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.impl;

import org.hibernate.search.engine.backend.types.Aggregable;
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.bridge.mapping.annotation.ValueBinderRef;
import org.hibernate.search.mapper.pojo.bridge.mapping.annotation.ValueBridgeRef;
import org.hibernate.search.mapper.pojo.extractor.mapping.annotation.ContainerExtraction;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.AnnotationDefaultValues;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.ScaledNumberField;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingNonFullTextFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingScaledNumberFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;

public class ScaledNumberFieldProcessor extends AbstractNonFullTextFieldAnnotationProcessor<ScaledNumberField> {

    @Override
    PropertyMappingNonFullTextFieldOptionsStep<?> initSortableFieldMappingContext(PropertyMappingStep mappingContext, ScaledNumberField annotation, String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    String getName(ScaledNumberField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    Projectable getProjectable(ScaledNumberField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    Searchable getSearchable(ScaledNumberField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    Sortable getSortable(ScaledNumberField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    Aggregable getAggregable(ScaledNumberField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    String getIndexNullAs(ScaledNumberField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    ValueBridgeRef getValueBridge(ScaledNumberField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    ValueBinderRef getValueBinder(ScaledNumberField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    ContainerExtraction getExtraction(ScaledNumberField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
