/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.bridge.builtin.alternative.impl;

import static java.util.function.Predicate.isEqual;
import org.hibernate.search.engine.backend.document.DocumentElement;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.mapper.pojo.bridge.TypeBridge;
import org.hibernate.search.mapper.pojo.bridge.binding.TypeBindingContext;
import org.hibernate.search.mapper.pojo.bridge.builtin.programmatic.AlternativeBinder;
import org.hibernate.search.mapper.pojo.bridge.builtin.programmatic.AlternativeBinderDelegate;
import org.hibernate.search.mapper.pojo.bridge.builtin.programmatic.AlternativeValueBridge;
import org.hibernate.search.mapper.pojo.bridge.runtime.TypeBridgeWriteContext;
import org.hibernate.search.mapper.pojo.logging.impl.MappingLog;
import org.hibernate.search.mapper.pojo.model.PojoElementAccessor;
import org.hibernate.search.mapper.pojo.model.PojoModelProperty;
import org.hibernate.search.mapper.pojo.model.PojoModelType;
import org.hibernate.search.util.common.impl.StreamHelper;

public final class AlternativeBinderImpl<D, P> implements AlternativeBinder {

    private final Class<D> discriminatorType;

    private final String fieldValueSourcePropertyName;

    private final Class<P> fieldValueSourcePropertyType;

    private final BeanReference<? extends AlternativeBinderDelegate<D, P>> delegateRef;

    private String alternativeId;

    public AlternativeBinderImpl(Class<D> discriminatorType, String fieldValueSourcePropertyName, Class<P> fieldValueSourcePropertyType, BeanReference<? extends AlternativeBinderDelegate<D, P>> delegateRef) {
        this.discriminatorType = discriminatorType;
        this.fieldValueSourcePropertyName = fieldValueSourcePropertyName;
        this.fieldValueSourcePropertyType = fieldValueSourcePropertyType;
        this.delegateRef = delegateRef;
    }

    @Override
    public AlternativeBinder alternativeId(String id) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void bind(TypeBindingContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private PojoModelProperty findAlternativeDiscriminatorProperty(PojoModelType bridgedElement) {
        return bridgedElement.properties().stream().filter(p -> p.markers(AlternativeDiscriminatorBinderImpl.Marker.class).stream().map(AlternativeDiscriminatorBinderImpl.Marker::id).anyMatch(isEqual(alternativeId))).collect(StreamHelper.singleElement(() -> MappingLog.INSTANCE.cannotFindAlternativeDiscriminator(alternativeId, fieldValueSourcePropertyName), () -> MappingLog.INSTANCE.conflictingAlternativeDiscriminators(alternativeId, fieldValueSourcePropertyName)));
    }

    private static final class Bridge<D, P> implements TypeBridge<Object> {

        private final PojoElementAccessor<D> discriminatorAccessor;

        private final PojoElementAccessor<P> fieldValueSourceAccessor;

        private final AlternativeValueBridge<D, P> delegate;

        private Bridge(PojoElementAccessor<D> discriminatorAccessor, PojoElementAccessor<P> fieldValueSourceAccessor, AlternativeValueBridge<D, P> delegate) {
            this.discriminatorAccessor = discriminatorAccessor;
            this.fieldValueSourceAccessor = fieldValueSourceAccessor;
            this.delegate = delegate;
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void write(DocumentElement target, Object bridgedElement, TypeBridgeWriteContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
