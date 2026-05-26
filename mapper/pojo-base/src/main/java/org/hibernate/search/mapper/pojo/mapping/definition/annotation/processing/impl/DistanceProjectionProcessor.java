/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.impl;

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.DistanceProjection;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.MethodParameterMappingAnnotationProcessor;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.MethodParameterMappingAnnotationProcessorContext;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.MethodParameterMappingStep;
import org.hibernate.search.mapper.pojo.search.definition.binding.builtin.DistanceProjectionBinder;

public final class DistanceProjectionProcessor implements MethodParameterMappingAnnotationProcessor<DistanceProjection> {

    @Override
    public void process(MethodParameterMappingStep mapping, DistanceProjection annotation, MethodParameterMappingAnnotationProcessorContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
