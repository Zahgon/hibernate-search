/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.mapping.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeMirror;
import org.hibernate.search.mapper.pojo.model.spi.PojoBootstrapIntrospector;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.processor.model.impl.BuiltInBridgeResolverTypes;
import org.hibernate.search.processor.model.impl.HibernateSearchProcessorEnum;
import org.hibernate.search.processor.model.impl.ProcessorPojoRawTypeModel;
import org.hibernate.search.processor.model.impl.ProcessorTypeOrdering;
import org.hibernate.search.util.common.reflect.spi.ValueHandleFactory;

public class ProcessorPojoModelsBootstrapIntrospector implements PojoBootstrapIntrospector {

    private final Map<Name, PojoRawTypeModel<?>> elementTypeModelCache = new HashMap<>();

    private final ProcessorIntrospectorContext context;

    private final PojoBootstrapIntrospector delegate;

    private final ProcessorTypeOrdering typeOrdering;

    public ProcessorPojoModelsBootstrapIntrospector(ProcessorIntrospectorContext context, PojoBootstrapIntrospector delegate) {
        this.context = context;
        this.delegate = delegate;
        this.typeOrdering = new ProcessorTypeOrdering(context.processorContext());
        elementTypeModelCache.put(context.elementUtils().getName(HibernateSearchProcessorEnum.class.getName()), HibernateSearchProcessorEnum.MODEL);
    }

    @Override
    // we checked the type through equals
    @SuppressWarnings("unchecked")
    public <T> PojoRawTypeModel<T> typeModel(Class<T> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoRawTypeModel<?> typeModel(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PojoRawTypeModel<?> typeModel(TypeElement typeElement) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PojoRawTypeModel<?> typeModel(TypeMirror typeMirror) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ValueHandleFactory annotationValueHandleFactory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ProcessorTypeOrdering typeOrdering() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
