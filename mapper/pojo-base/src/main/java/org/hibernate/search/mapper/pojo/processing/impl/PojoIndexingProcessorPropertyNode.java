/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.processing.impl;

import org.hibernate.search.engine.backend.document.DocumentElement;
import org.hibernate.search.mapper.pojo.common.annotation.impl.SearchProcessingWithContextException;
import org.hibernate.search.mapper.pojo.logging.impl.IndexingLog;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPath;
import org.hibernate.search.mapper.pojo.processing.spi.PojoIndexingProcessorRootContext;
import org.hibernate.search.mapper.pojo.reporting.spi.PojoEventContexts;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.reflect.spi.ValueReadHandle;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

/**
 * A node inside a {@link PojoIndexingProcessor} responsible for extracting the value of a property,
 * and applying nested processor nodes
 * ({@link PojoIndexingProcessorPropertyBridgeNode}, {@link PojoIndexingProcessorValueBridgeNode}, etc.).
 *
 * @param <T> The property holder type
 * @param <P> The property type
 */
public class PojoIndexingProcessorPropertyNode<T, P> extends PojoIndexingProcessor<T> {

    private final ValueReadHandle<P> handle;

    private final PojoIndexingProcessor<? super P> nested;

    private final PojoModelPath modelPath;

    public PojoIndexingProcessorPropertyNode(ValueReadHandle<P> handle, PojoIndexingProcessor<? super P> nested, PojoModelPath modelPath) {
        this.handle = handle;
        this.nested = nested;
        this.modelPath = modelPath;
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
    public final void process(DocumentElement target, T source, PojoIndexingProcessorRootContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
