/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.automaticindexing.impl;

import java.util.Map;
import org.hibernate.search.mapper.pojo.model.path.impl.PojoPathOrdinalReference;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

/**
 * A {@link PojoImplicitReindexingAssociationInverseSideResolverNode} marking as "to reindex"
 * object passed as an input.
 */
public class PojoImplicitReindexingAssociationInverseSideResolverMarkingNode extends PojoImplicitReindexingAssociationInverseSideResolverNode<Object> {

    private final Map<PojoRawTypeIdentifier<?>, PojoPathOrdinalReference> inverseSidePathOrdinalByType;

    public PojoImplicitReindexingAssociationInverseSideResolverMarkingNode(Map<PojoRawTypeIdentifier<?>, PojoPathOrdinalReference> inverseSidePathOrdinalByType) {
        this.inverseSidePathOrdinalByType = inverseSidePathOrdinalByType;
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
    void resolveEntitiesToReindex(PojoReindexingAssociationInverseSideCollector collector, Object entity, PojoImplicitReindexingAssociationInverseSideResolverRootContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
