/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.reporting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.hibernate.search.engine.common.EntityReference;

/**
 * Contextual information about a failure to index entities.
 */
public class EntityIndexingFailureContext extends FailureContext {

    public static Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final List<EntityReference> failingEntityReferences;

    private EntityIndexingFailureContext(Builder builder) {
        super(builder);
        this.failingEntityReferences = builder.failingEntityReferences == null ? Collections.emptyList() : Collections.unmodifiableList(builder.failingEntityReferences);
    }

    /**
     * @return A list of references to entities that may not be indexed correctly as a result of the failure.
     * Never {@code null}, but may be empty.
     * Use {@link Object#toString()} to get a textual representation of each reference,
     * or cast it to the mapper-specific {@code EntityReference} type.
     * @deprecated Use {@link #failingEntityReferences()} instead.
     */
    // The cast is safe because Object is a supertype of EntityReference and the list is unmodifiable.
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Deprecated(since = "6.2")
    public List<Object> entityReferences() {
        return (List<Object>) (List) failingEntityReferences;
    }

    /**
     * @return A list of references to entities that may not be indexed correctly as a result of the failure.
     * Never {@code null}, but may be empty.
     */
    public List<EntityReference> failingEntityReferences() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder extends FailureContext.Builder {

        private List<EntityReference> failingEntityReferences;

        private Builder() {
        }

        /**
         * @param entityReference A reference to an entity related to the failing operation.
         * @deprecated Use {@link #failingEntityReference(EntityReference)} instead.
         */
        @Deprecated(since = "6.2")
        public void entityReference(Object entityReference) {
            // This may fail for callers that don't retrieve the reference the usual way,
            // but we consider that acceptable as this builder should only be used by integrators
            // (mapper implementors or backend implementors).
            failingEntityReference((EntityReference) entityReference);
        }

        /**
         * @param entityReference A reference to an entity related to the failing operation.
         */
        public void failingEntityReference(EntityReference entityReference) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public EntityIndexingFailureContext build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
