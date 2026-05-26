/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.processing.impl;

import org.hibernate.search.engine.backend.document.DocumentElement;
import org.hibernate.search.mapper.pojo.processing.spi.PojoIndexingProcessorRootContext;
import org.hibernate.search.util.common.spi.ToStringTreeAppendable;

/**
 * A POJO processor responsible for transferring data from the POJO to a document to index.
 *
 * @param <T> The processed type
 */
public abstract class PojoIndexingProcessor<T> implements AutoCloseable, ToStringTreeAppendable {

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public abstract void process(DocumentElement target, T source, PojoIndexingProcessorRootContext context);

    public static <T> PojoIndexingProcessor<T> noOp() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
