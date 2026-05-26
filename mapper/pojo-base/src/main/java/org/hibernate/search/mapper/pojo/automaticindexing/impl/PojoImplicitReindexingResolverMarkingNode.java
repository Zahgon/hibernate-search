/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.automaticindexing.impl;

import org.hibernate.search.util.common.spi.ToStringTreeAppender;

/**
 * A {@link PojoImplicitReindexingResolverNode} marking as "to reindex" any dirty object passed as an input.
 *
 * @param <T> The type of "dirty" objects received as input.
 */
public class PojoImplicitReindexingResolverMarkingNode<T> extends PojoImplicitReindexingResolverNode<T> {

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void appendTo(ToStringTreeAppender appender) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void resolveEntitiesToReindex(PojoReindexingCollector collector, T dirty, PojoImplicitReindexingResolverRootContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
