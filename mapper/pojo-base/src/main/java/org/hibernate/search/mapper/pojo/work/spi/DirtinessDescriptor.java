/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.work.spi;

import java.io.Serializable;
import java.util.Set;

public final class DirtinessDescriptor implements Serializable {

    private final boolean forceSelfDirty;

    private final boolean forceContainingDirty;

    private final Set<String> dirtyPaths;

    private final boolean updateBecauseOfContained;

    public DirtinessDescriptor(boolean forceSelfDirty, boolean forceContainingDirty, Set<String> dirtyPaths, boolean updatedBecauseOfContained) {
        this.forceSelfDirty = forceSelfDirty;
        this.forceContainingDirty = forceContainingDirty;
        this.dirtyPaths = dirtyPaths;
        this.updateBecauseOfContained = updatedBecauseOfContained;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean forceSelfDirty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean forceContainingDirty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Set<String> dirtyPaths() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean updatedBecauseOfContained() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
