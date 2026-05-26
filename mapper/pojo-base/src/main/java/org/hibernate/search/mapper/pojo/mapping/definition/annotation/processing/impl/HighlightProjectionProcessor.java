/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.impl;

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.HighlightProjection;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.MethodParameterMappingAnnotationProcessor;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.MethodParameterMappingAnnotationProcessorContext;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.MethodParameterMappingStep;
import org.hibernate.search.mapper.pojo.search.definition.binding.builtin.HighlightProjectionBinder;

public final class HighlightProjectionProcessor implements MethodParameterMappingAnnotationProcessor<HighlightProjection> {

    @Override
    public void process(MethodParameterMappingStep mapping, HighlightProjection annotation, MethodParameterMappingAnnotationProcessorContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
