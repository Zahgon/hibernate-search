/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.jakarta.batch.core.massindexing.util.impl;

/**
 * Information about a target partition which can not be stored in the partition properties as String values. In
 * particular, the boundary properties help us to identify the lower boundary and upper boundary of a given partition,
 * with which the two ends of the scrollable results can be defined and be applied to
 * {@link jakarta.batch.api.chunk.ItemReader#open}.
 *
 * @author Mincong Huang
 */
public class PartitionBound {

    private EntityTypeDescriptor<?, ?> entityType;

    private Object lowerBound;

    private Object upperBound;

    public PartitionBound(EntityTypeDescriptor<?, ?> entityType, Object lowerBound, Object upperBound) {
        this.entityType = entityType;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public String getEntityName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Object getLowerBound() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Object getUpperBound() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
