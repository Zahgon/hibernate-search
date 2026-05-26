/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.outboxpolling.cluster.impl;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ClusterDescriptor {

    public final List<UUID> memberIdsInShardOrder;

    public ClusterDescriptor(List<UUID> memberIdsInShardOrder) {
        this.memberIdsInShardOrder = memberIdsInShardOrder;
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
