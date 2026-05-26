/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.processing.impl;

import org.hibernate.search.engine.backend.document.DocumentElement;
import org.hibernate.search.mapper.pojo.extractor.ValueProcessor;
import org.hibernate.search.mapper.pojo.extractor.impl.ContainerExtractorHolder;
import org.hibernate.search.mapper.pojo.processing.spi.PojoIndexingProcessorRootContext;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

/**
 * A node inside a {@link PojoIndexingProcessor} responsible for extracting elements from a container
 * and applying nested processor nodes to the elements.
 *
 * @param <C> The container type
 * @param <V> The extracted value type
 */
public class PojoIndexingProcessorContainerElementNode<C, V> extends PojoIndexingProcessor<C> {

    private final ContainerExtractorHolder<C, V> extractorHolder;

    private final PojoIndexingProcessor<? super V> nested;

    private final ValueProcessor<DocumentElement, ? super C, PojoIndexingProcessorRootContext> extractingDelegate;

    public PojoIndexingProcessorContainerElementNode(ContainerExtractorHolder<C, V> extractorHolder, PojoIndexingProcessor<? super V> nested) {
        this.extractorHolder = extractorHolder;
        this.nested = nested;
        this.extractingDelegate = extractorHolder.wrap((target, value, sessionContext, extractionContext) -> nested.process(target, value, sessionContext));
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
    public final void process(DocumentElement target, C source, PojoIndexingProcessorRootContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
