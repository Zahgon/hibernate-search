/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.model.impl;

import static org.hibernate.search.processor.impl.ProcessorElementUtils.propertyElements;
import static org.hibernate.search.processor.impl.ProcessorElementUtils.propertyName;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import org.hibernate.search.engine.mapper.model.spi.MappableTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoCaster;
import org.hibernate.search.mapper.pojo.model.spi.PojoConstructorModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoPropertyModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;
import org.hibernate.search.processor.impl.HibernateSearchMetamodelProcessorContext;
import org.hibernate.search.processor.mapping.impl.ProcessorPojoModelsBootstrapIntrospector;

public class ProcessorPojoRawTypeModel<T> implements PojoRawTypeModel<T> {

    private final TypeMirror typeMirror;

    private final TypeElement typeElement;

    private final HibernateSearchMetamodelProcessorContext context;

    private final ProcessorPojoModelsBootstrapIntrospector introspector;

    private final Map<String, ProcessorPojoPropertyModel<?>> propertyModels = new HashMap<>();

    public ProcessorPojoRawTypeModel(TypeElement typeElement, HibernateSearchMetamodelProcessorContext context, ProcessorPojoModelsBootstrapIntrospector introspector) {
        this(null, typeElement, context, introspector);
    }

    public ProcessorPojoRawTypeModel(TypeMirror typeMirror, HibernateSearchMetamodelProcessorContext context, ProcessorPojoModelsBootstrapIntrospector introspector) {
        this(typeMirror, (TypeElement) context.typeUtils().asElement(typeMirror), context, introspector);
    }

    private ProcessorPojoRawTypeModel(TypeMirror typeMirror, TypeElement typeElement, HibernateSearchMetamodelProcessorContext context, ProcessorPojoModelsBootstrapIntrospector introspector) {
        this.typeMirror = typeMirror;
        if (typeElement == null && typeMirror instanceof PrimitiveType primitiveType) {
            this.typeElement = context.typeUtils().boxedClass(primitiveType);
        } else {
            this.typeElement = typeElement;
        }
        this.context = context;
        this.introspector = introspector;
    }

    @SuppressWarnings("unchecked")
    @Override
    public PojoRawTypeIdentifier<T> typeIdentifier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isAbstract() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isSubTypeOf(MappableTypeModel otherModel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @Override
    public Stream<? extends PojoRawTypeModel<? super T>> ascendingSuperTypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @Override
    public Stream<? extends PojoRawTypeModel<? super T>> descendingSuperTypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Stream<? extends Annotation> annotations() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoConstructorModel<T> mainConstructor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoConstructorModel<T> constructor(Class<?>... parameterTypes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Collection<PojoConstructorModel<T>> declaredConstructors() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Collection<PojoPropertyModel<?>> declaredProperties() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @Override
    public PojoTypeModel<? extends T> cast(PojoTypeModel<?> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @Override
    public PojoCaster<T> caster() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoPropertyModel<?> property(String propertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public TypeElement typeElement() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private ProcessorPojoPropertyModel<?> propertyModel(Element element) {
        String propertyName = propertyName(element);
        if (element.getKind() == ElementKind.FIELD) {
            return propertyModels.computeIfAbsent(propertyName, k -> new ProcessorPojoPropertyModel<>((VariableElement) element, propertyName, context, introspector));
        }
        if (element.getKind() == ElementKind.METHOD) {
            return propertyModels.computeIfAbsent(propertyName, k -> new ProcessorPojoPropertyModel<>((ExecutableElement) element, propertyName, context, introspector));
        }
        throw new IllegalArgumentException("Unsupported element kind: " + element.getKind());
    }

    @Override
    public <U> Optional<PojoTypeModel<? extends U>> castTo(Class<U> target) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<? extends PojoTypeModel<?>> typeArgument(Class<?> rawSuperType, int typeParameterIndex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private TypeMirror typeArgument(TypeMirror current, TypeMirror rawSuperType, int typeParameterIndex) {
        if (current == null || current.getKind() == TypeKind.NONE) {
            return null;
        }
        if (current instanceof DeclaredType declaredType) {
            if (context.typeUtils().isSameType(context.typeUtils().erasure(current), rawSuperType)) {
                return declaredType.getTypeArguments().get(typeParameterIndex);
            }
            TypeElement element = (TypeElement) declaredType.asElement();
            for (TypeMirror mirror : element.getInterfaces()) {
                TypeMirror argument = typeArgument(mirror, rawSuperType, typeParameterIndex);
                if (argument != null) {
                    Name name = context.typeUtils().asElement(argument).getSimpleName();
                    for (int i = 0; i < element.getTypeParameters().size(); i++) {
                        if (element.getTypeParameters().get(i).getSimpleName().equals(name)) {
                            return declaredType.getTypeArguments().get(i);
                        }
                    }
                    return argument;
                }
            }
        }
        return null;
    }

    @Override
    public Optional<? extends PojoTypeModel<?>> arrayElementType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class ProcessorPojoCaster<T> implements PojoCaster<T> {

        static ProcessorPojoCaster<?> INSTANCE = new ProcessorPojoCaster<>();

        @Override
        public T cast(Object object) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public T castOrNull(Object object) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
