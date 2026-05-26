/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.models.spi;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.model.spi.PojoConstructorModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoMethodParameterModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.util.common.logging.impl.CommaSeparatedClassesFormatter;
import org.hibernate.search.util.common.reflect.spi.ValueCreateHandle;

public class PojoModelsConstructorModel<T> implements PojoConstructorModel<T> {

    private final AbstractPojoModelsBootstrapIntrospector introspector;

    final AbstractPojoModelsRawTypeModel<T, ?> declaringTypeModel;

    private final Constructor<T> constructor;

    private List<PojoMethodParameterModel<?>> declaredParameters;

    private ValueCreateHandle<T> handleCache;

    public PojoModelsConstructorModel(AbstractPojoModelsBootstrapIntrospector introspector, AbstractPojoModelsRawTypeModel<T, ?> declaringTypeModel, Constructor<T> constructor) {
        this.introspector = introspector;
        this.declaringTypeModel = declaringTypeModel;
        this.constructor = constructor;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Stream<Annotation> annotations() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoRawTypeModel<T> typeModel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ValueCreateHandle<T> handle() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoMethodParameterModel<?> parameter(int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<PojoMethodParameterModel<?>> declaredParameters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * This is a workaround for <a href="https://bugs.openjdk.org/browse/JDK-8303112">JDK-8303112</a>.
     * @param parameters The result of calling {@link Constructor#getParameters()}
     * @param parameterAnnotationsArray The result of calling  {@link Constructor#getParameterAnnotations()}
     * @return A fixed version of {@code parameterAnnotationsArray},
     * or {@code null} if {@code parameterAnnotationsArray} is fine an unaffected by JDK-8303112.
     */
    private static Annotation[][] recomputeParameterAnnotationsForJDK8303112(Parameter[] parameters, Annotation[][] parameterAnnotationsArray) {
        int parameterCount = parameters.length;
        if (parameterAnnotationsArray.length == parameterCount) {
            // Not affected by JDK-8303112
            return null;
        }
        // We're in a situation where parameter.getAnnotation()/parameter.getAnnotations()
        // is buggy when there are implicit/synthetic parameters,
        // because constructor.getParameterAnnotations() (wrongly) ignores implicit/synthetic parameters
        // while parameter.getAnnotations() (rightly) assumes they are present in the array.
        Annotation[][] annotationsForJDK8303112;
        annotationsForJDK8303112 = new Annotation[parameterCount][];
        int nonImplicitNorSyntheticParamIndex = 0;
        for (int i = 0; i < parameterCount; i++) {
            Parameter parameter = parameters[i];
            if (parameter.isImplicit() || parameter.isSynthetic()) {
                annotationsForJDK8303112[i] = new Annotation[0];
            } else if (nonImplicitNorSyntheticParamIndex < parameterAnnotationsArray.length) {
                annotationsForJDK8303112[i] = parameterAnnotationsArray[nonImplicitNorSyntheticParamIndex];
                ++nonImplicitNorSyntheticParamIndex;
            } else {
                // Something is wrong; most likely the class wasn't compiled with -parameters
                // and so isImplicit/isSynthetic always return false.
                // As a last resort, assume the implicit/synthetic parameters are the first ones.
                nonImplicitNorSyntheticParamIndex = parameterCount - parameterAnnotationsArray.length;
                Arrays.fill(annotationsForJDK8303112, 0, nonImplicitNorSyntheticParamIndex, new Annotation[0]);
                System.arraycopy(parameterAnnotationsArray, 0, annotationsForJDK8303112, nonImplicitNorSyntheticParamIndex, parameterAnnotationsArray.length);
                return annotationsForJDK8303112;
            }
        }
        return annotationsForJDK8303112;
    }

    @Override
    public Class<?>[] parametersJavaTypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
