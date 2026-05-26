/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.automaticindexing.impl;

import org.hibernate.search.util.common.spi.ToStringTreeAppender;

class NoOpPojoImplicitReindexingResolverNode extends PojoImplicitReindexingResolverNode<Object> {

    private static final NoOpPojoImplicitReindexingResolverNode INSTANCE = new NoOpPojoImplicitReindexingResolverNode();

    // This instance works for any T
    @SuppressWarnings("unchecked")
    public static <T> PojoImplicitReindexingResolverNode<T> get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void resolveEntitiesToReindex(PojoReindexingCollector collector, Object dirty, PojoImplicitReindexingResolverRootContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void appendTo(ToStringTreeAppender appender) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
