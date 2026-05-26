/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.impl;

import org.hibernate.search.engine.backend.types.Aggregable;
import org.hibernate.search.engine.backend.types.Norms;
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.bridge.mapping.annotation.ValueBinderRef;
import org.hibernate.search.mapper.pojo.bridge.mapping.annotation.ValueBridgeRef;
import org.hibernate.search.mapper.pojo.extractor.mapping.annotation.ContainerExtraction;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingKeywordFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingNonFullTextFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;

public class KeywordFieldProcessor extends AbstractNonFullTextFieldAnnotationProcessor<KeywordField> {

    @Override
    PropertyMappingNonFullTextFieldOptionsStep<?> initSortableFieldMappingContext(PropertyMappingStep mappingContext, KeywordField annotation, String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    String getName(KeywordField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    Projectable getProjectable(KeywordField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    Searchable getSearchable(KeywordField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    Sortable getSortable(KeywordField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    Aggregable getAggregable(KeywordField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    String getIndexNullAs(KeywordField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    ValueBridgeRef getValueBridge(KeywordField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    ValueBinderRef getValueBinder(KeywordField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    ContainerExtraction getExtraction(KeywordField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
