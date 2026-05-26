/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.automaticindexing.impl;

import java.util.BitSet;
import java.util.List;
import org.hibernate.search.mapper.pojo.model.path.impl.PojoPathOrdinals;
import org.hibernate.search.mapper.pojo.model.path.spi.PojoPathFilter;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.spi.ToStringTreeAppendable;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

/**
 * Information about associations involved in reindexing.
 */
public final class PojoImplicitReindexingAssociationInverseSideResolver implements AutoCloseable, ToStringTreeAppendable {

    private final PojoPathOrdinals pathOrdinals;

    private final PojoPathFilter dirtyContainingAssociationFilter;

    private final List<List<PojoImplicitReindexingAssociationInverseSideResolverNode<Object>>> resolversByOrdinal;

    public PojoImplicitReindexingAssociationInverseSideResolver(PojoPathOrdinals pathOrdinals, PojoPathFilter dirtyContainingAssociationFilter, List<List<PojoImplicitReindexingAssociationInverseSideResolverNode<Object>>> resolversByOrdinal) {
        this.pathOrdinals = pathOrdinals;
        this.dirtyContainingAssociationFilter = dirtyContainingAssociationFilter;
        this.resolversByOrdinal = resolversByOrdinal;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void appendTo(ToStringTreeAppender appender) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PojoPathFilter dirtyContainingAssociationFilter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds the inverse side of dirty associations (that should cause reindexing) to {@code collector},
     * taking into account the given "association states" and the bitset describing the dirtiness of associations.
     * @param collector A collector for entities pointed to be dirty associations, which should be reindexed.
     * @param dirtyAssociationPaths The set of dirty paths that involve associations in an entity instance.
     * @param oldState The old state of the entity whose associations are dirty.
     * May be {@code null}, in which case this state will not yield any reindexing.
     * @param newState The new state of the entity whose associations are dirty.
     * May be {@code null}, in which case this state will not yield any reindexing.
     * @param context A context related to the entity root
     */
    public void resolveEntitiesToReindex(PojoReindexingAssociationInverseSideCollector collector, BitSet dirtyAssociationPaths, Object[] oldState, Object[] newState, PojoImplicitReindexingAssociationInverseSideResolverRootContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
