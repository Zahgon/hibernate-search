/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.models.spi;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.model.spi.PojoMethodParameterModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;

public final class PojoModelsMethodParameterModel<T> implements PojoMethodParameterModel<T> {

    private final PojoModelsConstructorModel<?> constructorModel;

    private final int index;

    private final Parameter parameter;

    private final AnnotatedType annotatedType;

    private Annotation[] annotations;

    private PojoTypeModel<T> typeModelCache;

    public PojoModelsMethodParameterModel(PojoModelsConstructorModel<?> constructorModel, int index, Parameter parameter, AnnotatedType annotatedType, // If non-null, we're working around https://bugs.openjdk.org/browse/JDK-8303112;
    // normally we wouldn't need eager initialization here.
    Annotation[] annotationsForJDK8303112) {
        this.constructorModel = constructorModel;
        this.index = index;
        this.parameter = parameter;
        this.annotatedType = annotatedType;
        this.annotations = annotationsForJDK8303112;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int index() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<String> name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Stream<Annotation> annotations() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("unchecked")
    public PojoTypeModel<T> typeModel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isEnclosingInstance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
