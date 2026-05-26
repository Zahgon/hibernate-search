/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.model.models.spi;

import java.lang.reflect.Type;
import org.hibernate.search.mapper.pojo.model.spi.GenericContextAwarePojoGenericTypeModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoPropertyModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;

public class PojoModelsGenericContextHelper implements GenericContextAwarePojoGenericTypeModel.Helper {

    private final AbstractPojoModelsBootstrapIntrospector introspector;

    public PojoModelsGenericContextHelper(AbstractPojoModelsBootstrapIntrospector introspector) {
        this.introspector = introspector;
    }

    @Override
    public <T> PojoRawTypeModel<T> rawTypeModel(Class<T> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object propertyCacheKey(PojoPropertyModel<?> rawPropertyModel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Type propertyGenericType(PojoPropertyModel<?> rawPropertyModel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
