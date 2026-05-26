/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.spi;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;

public abstract class AbstractPojoRawTypeModel<T, I extends PojoBootstrapIntrospector> implements PojoRawTypeModel<T> {

    protected final I introspector;

    protected final PojoRawTypeIdentifier<T> typeIdentifier;

    private final PojoCaster<T> caster;

    private final Map<String, PojoPropertyModel<?>> propertyModelCache = new HashMap<>();

    private List<PojoPropertyModel<?>> declaredProperties;

    private List<PojoConstructorModel<T>> declaredConstructors;

    public AbstractPojoRawTypeModel(I introspector, PojoRawTypeIdentifier<T> typeIdentifier) {
        this.introspector = introspector;
        this.typeIdentifier = typeIdentifier;
        this.caster = new JavaClassPojoCaster<>(typeIdentifier.javaClass());
    }

    @Override
    public final boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final PojoRawTypeIdentifier<T> typeIdentifier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final PojoConstructorModel<T> mainConstructor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final PojoConstructorModel<T> constructor(Class<?>... parameterTypes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Collection<PojoConstructorModel<T>> declaredConstructors() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract List<PojoConstructorModel<T>> createDeclaredConstructors();

    @Override
    public final PojoPropertyModel<?> property(String propertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Collection<PojoPropertyModel<?>> declaredProperties() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("unchecked")
    public PojoTypeModel<? extends T> cast(PojoTypeModel<?> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected PojoTypeModel<? extends T> doCast(PojoTypeModel<?> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final PojoCaster<T> caster() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <U> Optional<PojoTypeModel<? extends U>> castTo(Class<U> target) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract Stream<String> declaredPropertyNames();

    protected abstract PojoPropertyModel<?> createPropertyModel(String propertyName);

    private PojoPropertyModel<?> propertyOrNull(String propertyName) {
        return propertyModelCache.computeIfAbsent(propertyName, this::createPropertyModel);
    }
}
