/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.impl;

import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.VectorSimilarity;
import org.hibernate.search.mapper.pojo.bridge.mapping.annotation.ValueBinderRef;
import org.hibernate.search.mapper.pojo.bridge.mapping.annotation.ValueBridgeRef;
import org.hibernate.search.mapper.pojo.extractor.mapping.annotation.ContainerExtraction;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.AnnotationDefaultValues;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.VectorField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.PropertyMappingAnnotationProcessor;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingVectorFieldOptionsStep;

public class VectorFieldAnnotationProcessor extends AbstractFieldAnnotationProcessor<VectorField> implements PropertyMappingAnnotationProcessor<VectorField> {

    @Override
    PropertyMappingFieldOptionsStep<?> initFieldMappingContext(PropertyMappingStep mappingContext, VectorField annotation, String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    ContainerExtraction getExtraction(VectorField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    String getName(VectorField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    ValueBridgeRef getValueBridge(VectorField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    ValueBinderRef getValueBinder(VectorField annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
