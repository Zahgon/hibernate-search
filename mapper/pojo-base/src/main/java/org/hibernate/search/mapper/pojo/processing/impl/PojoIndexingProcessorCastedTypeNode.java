/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.processing.impl;

import org.hibernate.search.engine.backend.document.DocumentElement;
import org.hibernate.search.engine.backend.document.IndexObjectFieldReference;
import org.hibernate.search.mapper.pojo.bridge.TypeBridge;
import org.hibernate.search.mapper.pojo.model.spi.PojoCaster;
import org.hibernate.search.mapper.pojo.processing.spi.PojoIndexingProcessorRootContext;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

/**
 * A node inside a {@link PojoIndexingProcessor} responsible for casting the value to a given type,
 * then applying processor property nodes
 * as well as {@link TypeBridge}s to the value.
 * <p>
 * This node will fail with an exception when values cannot be cast to type {@code U}.
 *
 * @param <T> The processed type received as input.
 * @param <U> The type the input objects will be casted to.
 */
public class PojoIndexingProcessorCastedTypeNode<T, U> extends PojoIndexingProcessor<T> {

    private final PojoCaster<? super U> caster;

    private final Iterable<IndexObjectFieldReference> parentIndexObjectReferences;

    private final PojoIndexingProcessor<? super U> nested;

    private final boolean isEntityType;

    public PojoIndexingProcessorCastedTypeNode(PojoCaster<? super U> caster, Iterable<IndexObjectFieldReference> parentIndexObjectReferences, PojoIndexingProcessor<? super U> nested, boolean isEntityType) {
        this.caster = caster;
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
