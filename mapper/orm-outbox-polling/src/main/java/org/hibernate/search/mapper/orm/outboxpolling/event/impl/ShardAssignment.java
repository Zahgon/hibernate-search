/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.event.impl;

import java.util.Optional;
import org.hibernate.search.mapper.orm.outboxpolling.cluster.impl.ShardAssignmentDescriptor;
import org.hibernate.search.util.common.data.Range;
import org.hibernate.search.util.common.data.impl.Murmur3HashFunction;
import org.hibernate.search.util.common.data.impl.RangeCompatibleHashFunction;
import org.hibernate.search.util.common.data.impl.RangeHashTable;
import org.hibernate.search.util.common.spi.ToStringTreeAppendable;
import org.hibernate.search.util.common.spi.ToStringTreeAppender;

final class ShardAssignment {

    // Note the hash function / table implementations MUST NOT CHANGE,
    // otherwise existing indexes will no longer work correctly.
    public static final RangeCompatibleHashFunction HASH_FUNCTION = Murmur3HashFunction.INSTANCE;

    public static class Provider implements ToStringTreeAppendable {

        private final OutboxEventFinderProvider finderProvider;

        public Provider(OutboxEventFinderProvider finderProvider) {
            this.finderProvider = finderProvider;
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void appendTo(ToStringTreeAppender appender) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        ShardAssignment create(ShardAssignmentDescriptor descriptor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    final ShardAssignmentDescriptor descriptor;

    final OutboxEventFinder eventFinder;

    // Exposed for testing purposes only
    ShardAssignment(ShardAssignmentDescriptor descriptor, OutboxEventFinder eventFinder) {
        this.descriptor = descriptor;
        this.eventFinder = eventFinder;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
