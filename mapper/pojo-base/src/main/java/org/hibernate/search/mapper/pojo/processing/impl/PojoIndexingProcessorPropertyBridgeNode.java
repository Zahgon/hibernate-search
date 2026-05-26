/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.processing.impl;

import org.hibernate.search.engine.backend.document.DocumentElement;
import org.hibernate.search.engine.environment.bean.BeanHolder;
import org.hibernate.search.mapper.pojo.bridge.PropertyBridge;
import org.hibernate.search.mapper.pojo.processing.spi.PojoIndexingProcessorRootContext;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

/**
 * A node inside a {@link PojoIndexingProcessor} responsible for applying a {@link PropertyBridge}.
 *
 * @param <P> The type of the processed property.
 */
public class PojoIndexingProcessorPropertyBridgeNode<P> extends PojoIndexingProcessor<P> {

    private final BeanHolder<? extends PropertyBridge<? super P>> bridgeHolder;

    public PojoIndexingProcessorPropertyBridgeNode(BeanHolder<? extends PropertyBridge<? super P>> bridgeHolder) {
        this.bridgeHolder = bridgeHolder;
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void appendTo(ToStringTreeAppender appender) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final void process(DocumentElement target, P source, PojoIndexingProcessorRootContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
