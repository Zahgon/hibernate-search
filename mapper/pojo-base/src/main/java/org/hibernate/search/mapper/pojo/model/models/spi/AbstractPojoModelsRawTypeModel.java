/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.models.spi;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.hibernate.models.spi.ClassDetails;
import org.hibernate.models.spi.MemberDetails;
import org.hibernate.search.engine.mapper.model.spi.MappableTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.AbstractPojoRawTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.GenericContextAwarePojoGenericTypeModel.RawTypeDeclaringContext;
import org.hibernate.search.mapper.pojo.model.spi.PojoConstructorModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;

public abstract class AbstractPojoModelsRawTypeModel<T, I extends AbstractPojoModelsBootstrapIntrospector> extends AbstractPojoRawTypeModel<T, I> {

    protected final ClassDetails classDetails;

    final RawTypeDeclaringContext<T> rawTypeDeclaringContext;

    private Map<String, MemberDetails> declaredFieldAccessPropertiesByName;

    private Map<String, List<MemberDetails>> declaredMethodAccessPropertiesByName;

    public AbstractPojoModelsRawTypeModel(I introspector, PojoRawTypeIdentifier<T> typeIdentifier, RawTypeDeclaringContext<T> rawTypeDeclaringContext) {
        super(introspector, typeIdentifier);
        this.classDetails = introspector.toModelsClass(typeIdentifier.javaClass());
        this.rawTypeDeclaringContext = rawTypeDeclaringContext;
    }

    @Override
    public boolean isAbstract() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final boolean isSubTypeOf(MappableTypeModel other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<PojoTypeModel<?>> typeArgument(Class<?> rawSuperType, int typeParameterIndex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<PojoTypeModel<?>> arrayElementType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Stream<? extends Annotation> annotations() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("unchecked")
    protected List<PojoConstructorModel<T>> createDeclaredConstructors() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    Class<T> javaClass() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected final Stream<String> declaredPropertyNames() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final Map<String, MemberDetails> declaredFieldAccessPropertiesByName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final Map<String, List<MemberDetails>> declaredMethodAccessPropertiesByName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final List<Member> declaredPropertyGetters(String propertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final Member declaredPropertyField(String propertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
