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
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingNonFullTextFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;

public class GenericFieldProcessor extends AbstractNonFullTextFieldAnnotationProcessor<GenericField> {

    @Override
    PropertyMappingNonFullTextFieldOptionsStep<?> initSortableFieldMappingContext(PropertyMappingStep mappingContext, GenericField annotation, String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    String getName(GenericField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    Projectable getProjectable(GenericField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    Searchable getSearchable(GenericField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    Sortable getSortable(GenericField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    Aggregable getAggregable(GenericField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    String getIndexNullAs(GenericField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    ValueBridgeRef getValueBridge(GenericField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    ValueBinderRef getValueBinder(GenericField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    ContainerExtraction getExtraction(GenericField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
