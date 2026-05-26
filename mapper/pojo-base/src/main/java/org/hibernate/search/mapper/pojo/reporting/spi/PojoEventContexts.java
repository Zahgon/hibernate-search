/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.reporting.spi;

import static org.hibernate.search.engine.reporting.spi.EventContexts.singleton;
import java.lang.annotation.Annotation;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPath;
import org.hibernate.search.mapper.pojo.model.spi.PojoConstructorModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoMethodParameterModel;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.reporting.impl.PojoEventContextMessages;
import org.hibernate.search.util.common.reporting.EventContext;
import org.hibernate.search.util.common.reporting.impl.AbstractSimpleEventContextElement;

public final class PojoEventContexts {

    private static final PojoEventContextMessages MESSAGES = PojoEventContextMessages.INSTANCE;

    private static final EventContext PROJECTION_CONSTRUCTOR = singleton(MESSAGES::projectionConstructor);

    private PojoEventContexts() {
    }

    public static EventContext fromType(PojoRawTypeModel<?> typeModel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromType(PojoRawTypeIdentifier<?> typeIdentifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext projectionConstructor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromConstructor(PojoConstructorModel<?> constructor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromMethodParameter(PojoMethodParameterModel<?> parameter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromPath(PojoModelPath unboundPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromAnnotation(Annotation annotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static EventContext fromAnnotationType(Class<? extends Annotation> annotationType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
