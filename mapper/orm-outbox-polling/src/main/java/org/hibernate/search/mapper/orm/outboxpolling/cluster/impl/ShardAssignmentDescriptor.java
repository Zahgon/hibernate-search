/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.cluster.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class ShardAssignmentDescriptor {

    public static Optional<ShardAssignmentDescriptor> fromClusterMemberList(List<UUID> clusterMembersInShardOrder, UUID selfId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public final int totalShardCount;

    public final int assignedShardIndex;

    public ShardAssignmentDescriptor(int totalShardCount, int assignedShardIndex) {
        this.totalShardCount = totalShardCount;
        this.assignedShardIndex = assignedShardIndex;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
