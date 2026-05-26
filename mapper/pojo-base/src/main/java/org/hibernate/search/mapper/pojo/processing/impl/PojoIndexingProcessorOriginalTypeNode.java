/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.processing.impl;

import org.hibernate.search.engine.backend.document.DocumentElement;
import org.hibernate.search.engine.backend.document.IndexObjectFieldReference;
import org.hibernate.search.mapper.pojo.processing.spi.PojoIndexingProcessorRootContext;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

/**
 * A node inside a {@link PojoIndexingProcessor} responsible for applying processor nodes
 * ({@link PojoIndexingProcessorTypeBridgeNode}, {@link PojoIndexingProcessorPropertyNode}, etc.).
 * without casting the value first (on contrary to {@link PojoIndexingProcessorCastedTypeNode}).
 *
 * @param <T> The processed type
 */
public class PojoIndexingProcessorOriginalTypeNode<T> extends PojoIndexingProcessor<T> {

    private final Iterable<IndexObjectFieldReference> parentIndexObjectReferences;

    private final PojoIndexingProcessor<? super T> nested;

    private final boolean isEntityType;

    public PojoIndexingProcessorOriginalTypeNode(Iterable<IndexObjectFieldReference> parentIndexObjectReferences, PojoIndexingProcessor<? super T> nested, boolean isEntityType) {
        this.parentIndexObjectReferences = parentIndexObjectReferences;
        this.nested = nested;
        this.isEntityType = isEntityType;
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
    // As long as T is not a proxy-specific interface, it will also be implemented by the unproxified object
    @SuppressWarnings("unchecked")
    public final void process(DocumentElement target, T source, PojoIndexingProcessorRootContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
