/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.impl;

import java.lang.annotation.Annotation;
import java.util.Optional;
import java.util.stream.Stream;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.MappingAnnotatedProperty;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.PropertyMappingAnnotationProcessorContext;
import org.hibernate.search.mapper.pojo.mapping.spi.PojoMappingConfigurationContext;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPath;
import org.hibernate.search.mapper.pojo.model.spi.PojoPropertyModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.reporting.spi.PojoEventContexts;
import org.hibernate.search.util.common.reflect.spi.AnnotationHelper;
import org.hibernate.search.util.common.reporting.EventContext;

public class PropertyMappingAnnotationProcessorContextImpl extends AbstractMappingAnnotationProcessorContext implements PropertyMappingAnnotationProcessorContext, MappingAnnotatedProperty {

    private final PojoRawTypeModel<?> typeModel;

    private final PojoPropertyModel<?> propertyModel;

    private final Annotation annotation;

    private final PojoMappingConfigurationContext configurationContext;

    public PropertyMappingAnnotationProcessorContextImpl(PojoRawTypeModel<?> typeModel, PojoPropertyModel<?> propertyModel, Annotation annotation, AnnotationHelper annotationHelper, PojoMappingConfigurationContext configurationContext) {
        super(annotationHelper);
        this.typeModel = typeModel;
        this.propertyModel = propertyModel;
        this.annotation = annotation;
        this.configurationContext = configurationContext;
    }

    @Override
    public MappingAnnotatedProperty annotatedElement() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EventContext eventContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Class<?> javaClass() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<Class<?>> javaClass(ContainerExtractorPath extractorPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Stream<Annotation> allAnnotations() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
