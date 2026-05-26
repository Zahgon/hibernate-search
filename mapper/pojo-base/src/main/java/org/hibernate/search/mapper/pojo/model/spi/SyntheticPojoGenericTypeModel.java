/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.spi;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.hibernate.search.util.common.impl.CollectionHelper;

/**
 * A synthetic implementation of {@link PojoTypeModel},
 * i.e. one that is not bound to an actual Java type, but simulates one.
 */
public final class SyntheticPojoGenericTypeModel<T> extends AbstractPojoGenericTypeModel<T> {

    public static <T> PojoTypeModel<T[]> array(PojoRawTypeModel<? super T[]> rawTypeModel, PojoTypeModel<T> elementType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> PojoTypeModel<T> genericType(PojoRawTypeModel<? super T> rawTypeModel, PojoTypeModel<?> firstTypeArgument, PojoTypeModel<?>... otherTypeArguments) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // For types that should not report implementing an interface, even though they do
    // Example: dynamic Map types, that should not be treated as maps when it comes to container extractors.
    public static <T> PojoTypeModel<T> opaqueType(PojoRawTypeModel<T> rawTypeModel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final PojoTypeModel<?> arrayElementType;

    private final List<PojoTypeModel<?>> genericTypeArguments;

    private SyntheticPojoGenericTypeModel(PojoRawTypeModel<? super T> rawTypeModel, PojoTypeModel<?> arrayElementType, List<PojoTypeModel<?>> genericTypeArguments) {
        super(rawTypeModel);
        this.arrayElementType = arrayElementType;
        this.genericTypeArguments = genericTypeArguments;
    }

    @Override
    public String name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <U> Optional<PojoTypeModel<? extends U>> castTo(Class<U> target) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<PojoTypeModel<?>> arrayElementType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<? extends PojoTypeModel<?>> typeArgument(Class<?> rawSuperType, int typeParameterIndex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
