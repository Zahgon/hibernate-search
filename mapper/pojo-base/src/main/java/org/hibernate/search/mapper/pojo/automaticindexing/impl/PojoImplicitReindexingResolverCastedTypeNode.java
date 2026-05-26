/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.automaticindexing.impl;

import org.hibernate.search.mapper.pojo.model.spi.PojoCaster;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

/**
 * A {@link PojoImplicitReindexingResolverNode} working at the type level, but applying a cast before anything else.
 * <p>
 * This node may delegate to a {@link PojoImplicitReindexingResolverMarkingNode marking node}
 * to mark the input as "to reindex" as well as delegate to
 * {@link PojoImplicitReindexingResolverPropertyNode property nodes} for deeper resolution.
 * <p>
 * This node will ignore entities that cannot be cast to type {@code U}.
 *
 * @param <T> The type of "dirty" objects received as input.
 * @param <U> The type the input objects will be casted to, if possible.
 */
public class PojoImplicitReindexingResolverCastedTypeNode<T, U> extends PojoImplicitReindexingResolverNode<T> {

    private final PojoCaster<? super U> caster;

    private final PojoImplicitReindexingResolverNode<? super U> nested;

    public PojoImplicitReindexingResolverCastedTypeNode(PojoCaster<? super U> caster, PojoImplicitReindexingResolverNode<? super U> nested) {
        this.caster = caster;
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
    public void resolveEntitiesToReindex(PojoReindexingCollector collector, T dirty, PojoImplicitReindexingResolverRootContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
