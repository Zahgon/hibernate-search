/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.automaticindexing.impl;

import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

/**
 * A {@link PojoImplicitReindexingResolverNode} working at the type level, without casting.
 * <p>
 * This node may delegate to a {@link PojoImplicitReindexingResolverMarkingNode marking node}
 * to mark the input as "to reindex" as well as delegate  to
 * {@link PojoImplicitReindexingResolverPropertyNode property nodes} for deeper resolution.
 *
 * @param <T> The type of "dirty" objects received as input.
 */
public class PojoImplicitReindexingResolverOriginalTypeNode<T> extends PojoImplicitReindexingResolverNode<T> {

    private final PojoImplicitReindexingResolverNode<? super T> nested;

    public PojoImplicitReindexingResolverOriginalTypeNode(PojoImplicitReindexingResolverNode<? super T> nested) {
        this.nested = nested;
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
    public void resolveEntitiesToReindex(PojoReindexingCollector collector, T dirty, PojoImplicitReindexingResolverRootContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
