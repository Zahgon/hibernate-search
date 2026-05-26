/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.processor.writer.impl;

import java.util.Optional;
import org.hibernate.search.util.common.annotation.Incubating;

@Incubating
record TraitReferenceDetails(Class<?> referenceClass, String implementationLabel, TraitKind traitKind, String extraPropertyName) implements Comparable<TraitReferenceDetails> {

    public TraitReferenceDetails(Class<?> referenceClass, String implementationLabel, TraitKind traitKind) {
        this(referenceClass, implementationLabel, traitKind, null);
    }

    public String asString(String input, String output) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<ClassProperty> formatExtraProperty(String input, String output) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int compareTo(TraitReferenceDetails o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
