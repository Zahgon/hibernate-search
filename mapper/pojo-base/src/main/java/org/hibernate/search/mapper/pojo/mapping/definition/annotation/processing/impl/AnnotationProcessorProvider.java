/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.impl;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.reporting.spi.FailureCollector;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.ConstructorMapping;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.ConstructorMappingAnnotationProcessor;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.ConstructorMappingAnnotationProcessorRef;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.MethodParameterMapping;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.MethodParameterMappingAnnotationProcessor;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.MethodParameterMappingAnnotationProcessorRef;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.PropertyMapping;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.PropertyMappingAnnotationProcessor;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.PropertyMappingAnnotationProcessorRef;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.TypeMapping;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.TypeMappingAnnotationProcessor;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.TypeMappingAnnotationProcessorRef;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.spi.MappingAnnotationProcessorUtils;
import org.hibernate.search.mapper.pojo.reporting.spi.PojoEventContexts;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.impl.SuppressingCloser;
import org.hibernate.search.util.common.reflect.impl.GenericTypeContext;
import org.hibernate.search.util.common.reflect.impl.ReflectionUtils;

// Using reflection for checks
@SuppressWarnings("rawtypes")
public class AnnotationProcessorProvider {

    private final BeanResolver beanResolver;

    private final FailureCollector rootFailureCollector;

    private final Map<Class<? extends Annotation>, Optional<BeanReference<? extends TypeMappingAnnotationProcessor>>> typeAnnotationProcessorReferenceCache = new HashMap<>();

    private final Map<Class<? extends Annotation>, Optional<BeanReference<? extends ConstructorMappingAnnotationProcessor>>> constructorAnnotationProcessorReferenceCache = new HashMap<>();

    private final Map<Class<? extends Annotation>, Optional<BeanReference<? extends MethodParameterMappingAnnotationProcessor>>> methodParameterAnnotationProcessorReferenceCache = new HashMap<>();

    private final Map<Class<? extends Annotation>, Optional<BeanReference<? extends PropertyMappingAnnotationProcessor>>> propertyAnnotationProcessorReferenceCache = new HashMap<>();

    public AnnotationProcessorProvider(BeanResolver beanResolver, FailureCollector rootFailureCollector) {
        this.beanResolver = beanResolver;
        this.rootFailureCollector = rootFailureCollector;
    }

    // Checked using reflection in createProcessorBean
    @SuppressWarnings("unchecked")
    public <A extends Annotation> Optional<BeanHolder<? extends TypeMappingAnnotationProcessor<? super A>>> createTypeAnnotationProcessor(A annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Checked using reflection in createProcessorBean
    @SuppressWarnings("unchecked")
    public <A extends Annotation> Optional<BeanHolder<? extends ConstructorMappingAnnotationProcessor<? super A>>> createConstructorAnnotationProcessor(A annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Checked using reflection in createProcessorBean
    @SuppressWarnings("unchecked")
    public <A extends Annotation> Optional<BeanHolder<? extends MethodParameterMappingAnnotationProcessor<? super A>>> createMethodParameterAnnotationProcessor(A annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Checked using reflection in createProcessorBean
    @SuppressWarnings("unchecked")
    public <A extends Annotation> Optional<BeanHolder<? extends PropertyMappingAnnotationProcessor<? super A>>> createPropertyAnnotationProcessor(A annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Optional<BeanReference<? extends TypeMappingAnnotationProcessor>> getTypeAnnotationProcessorReference(Class<? extends Annotation> annotationType) {
        Optional<BeanReference<? extends TypeMappingAnnotationProcessor>> processorReference = typeAnnotationProcessorReferenceCache.get(annotationType);
        if (processorReference == null) {
            // We really mean to check for null here (missing key in the map), not isPresent().
            processorReference = createTypeAnnotationProcessorReference(annotationType);
            typeAnnotationProcessorReferenceCache.put(annotationType, processorReference);
        }
        return processorReference;
    }

    private Optional<BeanReference<? extends ConstructorMappingAnnotationProcessor>> getConstructorAnnotationProcessorReference(Class<? extends Annotation> annotationType) {
        Optional<BeanReference<? extends ConstructorMappingAnnotationProcessor>> processorReference = constructorAnnotationProcessorReferenceCache.get(annotationType);
        if (processorReference == null) {
            // We really mean to check for null here (missing key in the map), not isPresent().
            processorReference = createConstructorAnnotationProcessorReference(annotationType);
            constructorAnnotationProcessorReferenceCache.put(annotationType, processorReference);
        }
        return processorReference;
    }

    private Optional<BeanReference<? extends MethodParameterMappingAnnotationProcessor>> getMethodParameterAnnotationProcessorReference(Class<? extends Annotation> annotationType) {
        Optional<BeanReference<? extends MethodParameterMappingAnnotationProcessor>> processorReference = methodParameterAnnotationProcessorReferenceCache.get(annotationType);
        if (processorReference == null) {
            // We really mean to check for null here (missing key in the map), not isPresent().
            processorReference = createMethodParameterAnnotationProcessorReference(annotationType);
            methodParameterAnnotationProcessorReferenceCache.put(annotationType, processorReference);
        }
        return processorReference;
    }

    private Optional<BeanReference<? extends PropertyMappingAnnotationProcessor>> getPropertyAnnotationProcessorReference(Class<? extends Annotation> annotationType) {
        Optional<BeanReference<? extends PropertyMappingAnnotationProcessor>> processorReference = propertyAnnotationProcessorReferenceCache.get(annotationType);
        if (processorReference == null) {
            // We really mean to check for null here (missing key in the map), not isPresent().
            processorReference = createPropertyAnnotationProcessorReference(annotationType);
            propertyAnnotationProcessorReferenceCache.put(annotationType, processorReference);
        }
        return processorReference;
    }

    private Optional<BeanReference<? extends TypeMappingAnnotationProcessor>> createTypeAnnotationProcessorReference(Class<? extends Annotation> annotationType) {
        TypeMapping mapping = annotationType.getAnnotation(TypeMapping.class);
        if (mapping == null) {
            // Not a type mapping annotation: ignore it.
            return Optional.empty();
        }
        TypeMappingAnnotationProcessorRef referenceAnnotation = mapping.processor();
        Optional<BeanReference<? extends TypeMappingAnnotationProcessor>> processorReference = MappingAnnotationProcessorUtils.toBeanReference(TypeMappingAnnotationProcessor.class, TypeMappingAnnotationProcessorRef.UndefinedProcessorImplementationType.class, referenceAnnotation.type(), referenceAnnotation.name(), referenceAnnotation.retrieval());
        if (!processorReference.isPresent()) {
            throw MappingLog.INSTANCE.missingProcessorReferenceInMappingAnnotation(TypeMapping.class);
        }
        return processorReference;
    }

    private <A extends Annotation> Optional<BeanReference<? extends ConstructorMappingAnnotationProcessor>> createConstructorAnnotationProcessorReference(Class<? extends A> annotationType) {
        ConstructorMapping mapping = annotationType.getAnnotation(ConstructorMapping.class);
        if (mapping == null) {
            // Not a constructor mapping annotation: ignore it.
            return Optional.empty();
        }
        ConstructorMappingAnnotationProcessorRef referenceAnnotation = mapping.processor();
        Optional<BeanReference<? extends ConstructorMappingAnnotationProcessor>> processorReference = MappingAnnotationProcessorUtils.toBeanReference(ConstructorMappingAnnotationProcessor.class, ConstructorMappingAnnotationProcessorRef.UndefinedProcessorImplementationType.class, referenceAnnotation.type(), referenceAnnotation.name(), referenceAnnotation.retrieval());
        if (!processorReference.isPresent()) {
            throw MappingLog.INSTANCE.missingProcessorReferenceInMappingAnnotation(ConstructorMapping.class);
        }
        return processorReference;
    }

    private <A extends Annotation> Optional<BeanReference<? extends MethodParameterMappingAnnotationProcessor>> createMethodParameterAnnotationProcessorReference(Class<? extends A> annotationType) {
        MethodParameterMapping mapping = annotationType.getAnnotation(MethodParameterMapping.class);
        if (mapping == null) {
            // Not a MethodParameter mapping annotation: ignore it.
            return Optional.empty();
        }
        MethodParameterMappingAnnotationProcessorRef referenceAnnotation = mapping.processor();
        Optional<BeanReference<? extends MethodParameterMappingAnnotationProcessor>> processorReference = MappingAnnotationProcessorUtils.toBeanReference(MethodParameterMappingAnnotationProcessor.class, MethodParameterMappingAnnotationProcessorRef.UndefinedProcessorImplementationType.class, referenceAnnotation.type(), referenceAnnotation.name(), referenceAnnotation.retrieval());
        if (!processorReference.isPresent()) {
            throw MappingLog.INSTANCE.missingProcessorReferenceInMappingAnnotation(MethodParameterMapping.class);
        }
        return processorReference;
    }

    private <A extends Annotation> Optional<BeanReference<? extends PropertyMappingAnnotationProcessor>> createPropertyAnnotationProcessorReference(Class<? extends A> annotationType) {
        PropertyMapping mapping = annotationType.getAnnotation(PropertyMapping.class);
        if (mapping == null) {
            // Not a property mapping annotation: ignore it.
            return Optional.empty();
        }
        PropertyMappingAnnotationProcessorRef referenceAnnotation = mapping.processor();
        Optional<BeanReference<? extends PropertyMappingAnnotationProcessor>> processorReference = MappingAnnotationProcessorUtils.toBeanReference(PropertyMappingAnnotationProcessor.class, PropertyMappingAnnotationProcessorRef.UndefinedProcessorImplementationType.class, referenceAnnotation.type(), referenceAnnotation.name(), referenceAnnotation.retrieval());
        if (!processorReference.isPresent()) {
            throw MappingLog.INSTANCE.missingProcessorReferenceInMappingAnnotation(PropertyMapping.class);
        }
        return processorReference;
    }

    private <B, A extends Annotation> BeanHolder<? extends B> createProcessorBean(Class<B> expectedType, Class<A> encounteredAnnotationType, BeanReference<? extends B> processorReference) {
        BeanHolder<? extends B> delegateHolder = processorReference.resolve(beanResolver);
        try {
            B processor = delegateHolder.get();
            GenericTypeContext bridgeTypeContext = new GenericTypeContext(processor.getClass());
            Class<?> processorAnnotationType = bridgeTypeContext.resolveTypeArgument(expectedType, 0).map(ReflectionUtils::getRawType).orElseThrow(() -> new AssertionFailure("Could not auto-detect the annotation type accepted by processor '" + processor + "'."));
            if (!processorAnnotationType.isAssignableFrom(encounteredAnnotationType)) {
                throw MappingLog.INSTANCE.invalidAnnotationTypeForAnnotationProcessor(processor, processorAnnotationType);
            }
            return delegateHolder;
        } catch (RuntimeException e) {
            new SuppressingCloser(e).push(delegateHolder);
            throw e;
        }
    }
}
