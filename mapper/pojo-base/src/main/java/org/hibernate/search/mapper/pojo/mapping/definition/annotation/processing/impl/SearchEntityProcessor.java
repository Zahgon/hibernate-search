/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.impl;

import java.util.Map;
import java.util.Optional;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.mapper.pojo.loading.mapping.annotation.EntityLoadingBinderRef;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.SearchEntity;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.TypeMappingAnnotationProcessor;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.TypeMappingAnnotationProcessorContext;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.TypeMappingSearchEntityStep;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.TypeMappingStep;

public class SearchEntityProcessor implements TypeMappingAnnotationProcessor<SearchEntity> {

    @Override
    public void process(TypeMappingStep mappingContext, SearchEntity annotation, TypeMappingAnnotationProcessorContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
