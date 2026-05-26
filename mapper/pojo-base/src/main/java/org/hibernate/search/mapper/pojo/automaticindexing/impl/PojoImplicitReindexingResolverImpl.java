/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.automaticindexing.impl;

import org.hibernate.search.mapper.pojo.model.path.spi.PojoPathFilter;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

public class PojoImplicitReindexingResolverImpl<T> implements PojoImplicitReindexingResolver<T> {

    private final PojoPathFilter dirtySelfFilter;

    private final PojoPathFilter dirtySelfOrContainingFilter;

    private final PojoImplicitReindexingResolverNode<T> containingEntitiesResolverRoot;

    private final PojoImplicitReindexingAssociationInverseSideResolver associationInverseSideResolver;

    public PojoImplicitReindexingResolverImpl(PojoPathFilter dirtySelfFilter, PojoPathFilter dirtySelfOrContainingFilter, PojoImplicitReindexingResolverNode<T> containingEntitiesResolverRoot, PojoImplicitReindexingAssociationInverseSideResolver associationInverseSideResolver) {
        this.dirtySelfFilter = dirtySelfFilter;
        this.dirtySelfOrContainingFilter = dirtySelfOrContainingFilter;
        this.containingEntitiesResolverRoot = containingEntitiesResolverRoot;
        this.associationInverseSideResolver = associationInverseSideResolver;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
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
    public PojoPathFilter dirtySelfFilter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoPathFilter dirtySelfOrContainingFilter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void resolveEntitiesToReindex(PojoReindexingCollector collector, T dirty, PojoImplicitReindexingResolverRootContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoImplicitReindexingAssociationInverseSideResolver associationInverseSideResolver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
