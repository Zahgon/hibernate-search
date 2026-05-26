/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.impl;

import org.hibernate.search.engine.backend.types.ObjectStructure;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.PropertyMappingAnnotationProcessor;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.PropertyMappingAnnotationProcessorContext;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.spi.MappingAnnotationProcessorUtils;
import org.hibernate.search.mapper.pojo.mapping.definition.programmatic.PropertyMappingStep;

public class IndexedEmbeddedProcessor implements PropertyMappingAnnotationProcessor<IndexedEmbedded> {

    @Override
    // For IndexedEmbedded.prefix
    @SuppressWarnings("deprecation")
    public void process(PropertyMappingStep mappingContext, IndexedEmbedded annotation, PropertyMappingAnnotationProcessorContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
