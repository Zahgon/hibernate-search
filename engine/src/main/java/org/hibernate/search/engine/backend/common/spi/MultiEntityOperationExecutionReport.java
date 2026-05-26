/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.backend.common.spi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.hibernate.search.engine.common.EntityReference;
import org.hibernate.search.util.common.AssertionFailure;

public final class MultiEntityOperationExecutionReport {

    public static MultiEntityOperationExecutionReport.Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static CompletableFuture<MultiEntityOperationExecutionReport> allOf(List<CompletableFuture<MultiEntityOperationExecutionReport>> reportFutures) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final Throwable throwable;

    private final List<EntityReference> failingEntityReferences;

    private MultiEntityOperationExecutionReport(Builder builder) {
        this.failingEntityReferences = builder.failingEntityReferences == null ? Collections.emptyList() : Collections.unmodifiableList(builder.failingEntityReferences);
        if (builder.throwable == null && !failingEntityReferences.isEmpty()) {
            this.throwable = new AssertionFailure("Unknown throwable: missing throwable when reporting the failure.");
        } else {
            this.throwable = builder.throwable;
        }
    }

    public Optional<Throwable> throwable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<EntityReference> failingEntityReferences() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static final class Builder {

        private Throwable throwable;

        private List<EntityReference> failingEntityReferences;

        private Builder() {
        }

        public Builder add(MultiEntityOperationExecutionReport report) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder throwable(Throwable throwable) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder failingEntityReference(EntityReference reference) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder failingEntityReference(EntityReferenceFactory referenceFactory, String typeName, Object entityIdentifier) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public MultiEntityOperationExecutionReport build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
