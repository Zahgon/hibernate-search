/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.impl;

import java.lang.annotation.Annotation;
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStandardFieldOptionsStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;

abstract class AbstractStandardFieldAnnotationProcessor<A extends Annotation> extends AbstractFieldAnnotationProcessor<A> {

    @Override
    PropertyMappingFieldOptionsStep<?> initFieldMappingContext(PropertyMappingStep mappingContext, A annotation, String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    abstract PropertyMappingStandardFieldOptionsStep<?> initStandardFieldMappingContext(PropertyMappingStep mappingContext, A annotation, String fieldName);

    abstract Projectable getProjectable(A annotation);

    abstract Searchable getSearchable(A annotation);
}
