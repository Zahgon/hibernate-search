/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.model.impl;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import javax.lang.model.element.ElementKind;
import org.hibernate.search.engine.mapper.model.spi.MappableTypeModel;
import org.hibernate.search.mapper.pojo.bridge.IdentifierBridge;
import org.hibernate.search.mapper.pojo.bridge.ValueBridge;
import org.hibernate.search.mapper.pojo.bridge.binding.IdentifierBindingContext;
import org.hibernate.search.mapper.pojo.bridge.binding.ValueBindingContext;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.IdentifierBinder;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.ValueBinder;
import org.hibernate.search.mapper.pojo.bridge.runtime.IdentifierBridgeFromDocumentIdentifierContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.IdentifierBridgeToDocumentIdentifierContext;
import org.hibernate.search.mapper.pojo.bridge.runtime.ValueBridgeToIndexedValueContext;
import org.hibernate.search.mapper.pojo.model.impl.PojoModelValueElement;
import org.hibernate.search.mapper.pojo.model.spi.PojoCaster;
import org.hibernate.search.mapper.pojo.model.spi.PojoConstructorModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoPropertyModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoTypeModel;
import org.hibernate.search.util.common.annotation.impl.SuppressJQAssistant;

public enum HibernateSearchProcessorEnum {
    ;

    public static final Binder BINDER = new Binder();

    public static final Model MODEL = new Model();

    @SuppressJQAssistant(reason = "Need to cast to an impl type to get access to not-yet exposed method")
    public static class Binder implements ValueBinder, IdentifierBinder {

        @Override
        public void bind(IdentifierBindingContext<?> context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void bind(ValueBindingContext<?> context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class Model implements PojoRawTypeModel<HibernateSearchProcessorEnum> {

        @Override
        public PojoRawTypeIdentifier<HibernateSearchProcessorEnum> typeIdentifier() {
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

        @Override
        public Stream<? extends PojoRawTypeModel<? super HibernateSearchProcessorEnum>> ascendingSuperTypes() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Stream<? extends PojoRawTypeModel<? super HibernateSearchProcessorEnum>> descendingSuperTypes() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Stream<? extends Annotation> annotations() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public PojoConstructorModel<HibernateSearchProcessorEnum> mainConstructor() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public PojoConstructorModel<HibernateSearchProcessorEnum> constructor(Class<?>... parameterTypes) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Collection<PojoConstructorModel<HibernateSearchProcessorEnum>> declaredConstructors() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Collection<PojoPropertyModel<?>> declaredProperties() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @SuppressWarnings("unchecked")
        @Override
        public PojoTypeModel<? extends HibernateSearchProcessorEnum> cast(PojoTypeModel<?> other) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public PojoCaster<HibernateSearchProcessorEnum> caster() {
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

        @Override
        public <U> Optional<PojoTypeModel<? extends U>> castTo(Class<U> target) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Optional<? extends PojoTypeModel<?>> typeArgument(Class<?> rawSuperType, int typeParameterIndex) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Optional<? extends PojoTypeModel<?>> arrayElementType() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public record Bridge(String valueType) implements ValueBridge<Object, String>, IdentifierBridge<Object> {

        @Override
        public String toIndexedValue(Object value, ValueBridgeToIndexedValueContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void close() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toDocumentIdentifier(Object propertyValue, IdentifierBridgeToDocumentIdentifierContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Object fromDocumentIdentifier(String documentIdentifier, IdentifierBridgeFromDocumentIdentifierContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
