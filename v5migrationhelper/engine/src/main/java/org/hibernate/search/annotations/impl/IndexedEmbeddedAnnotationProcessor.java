/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.annotations.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.engine.backend.types.ObjectStructure;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.PropertyMappingAnnotationProcessor;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.PropertyMappingAnnotationProcessorContext;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;

@Deprecated
public class IndexedEmbeddedAnnotationProcessor implements PropertyMappingAnnotationProcessor<IndexedEmbedded> {

    @Override
    public void process(PropertyMappingStep mappingContext, IndexedEmbedded annotation, PropertyMappingAnnotationProcessorContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
