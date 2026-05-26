/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.impl;

import java.util.Optional;
import org.hibernate.search.mapper.pojo.model.PojoModelConstructorParameter;
import org.hibernate.search.mapper.pojo.model.spi.PojoBootstrapIntrospector;
import org.hibernate.search.mapper.pojo.model.spi.PojoMethodParameterModel;

/**
 * @param <P> The type of the constructor parameter used as a root element.
 */
public class PojoModelConstructorParameterRootElement<P> implements PojoModelConstructorParameter {

    private final PojoBootstrapIntrospector introspector;

    private final PojoMethodParameterModel<P> parameterModel;

    public PojoModelConstructorParameterRootElement(PojoBootstrapIntrospector introspector, PojoMethodParameterModel<P> parameterModel) {
        this.introspector = introspector;
        this.parameterModel = parameterModel;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isAssignableTo(Class<?> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<String> name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Class<?> rawType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
