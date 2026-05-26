/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.processing.impl;

import org.hibernate.search.engine.backend.document.DocumentElement;
import org.hibernate.search.mapper.pojo.processing.spi.PojoIndexingProcessorRootContext;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

class NoOpPojoIndexingProcessor extends PojoIndexingProcessor<Object> {

    private static final NoOpPojoIndexingProcessor INSTANCE = new NoOpPojoIndexingProcessor();

    // This instance works for any T
    @SuppressWarnings("unchecked")
    public static <T> PojoIndexingProcessor<T> get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void process(DocumentElement target, Object source, PojoIndexingProcessorRootContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void appendTo(ToStringTreeAppender appender) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
