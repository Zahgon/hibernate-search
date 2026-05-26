/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.impl;

import org.hibernate.search.engine.search.common.ValueModel;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FieldProjection;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.MethodParameterMappingAnnotationProcessor;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.MethodParameterMappingAnnotationProcessorContext;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.MethodParameterMappingStep;
import org.hibernate.search.mapper.pojo.search.definition.binding.builtin.FieldProjectionBinder;

public final class FieldProjectionProcessor implements MethodParameterMappingAnnotationProcessor<FieldProjection> {

    @SuppressWarnings({ "deprecation", "removal" })
    @Override
    public void process(MethodParameterMappingStep mapping, FieldProjection annotation, MethodParameterMappingAnnotationProcessorContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
