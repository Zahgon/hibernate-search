/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.common.impl;

import java.util.Objects;
import org.hibernate.search.engine.backend.common.DocumentReference;

public class LuceneDocumentReference implements DocumentReference {

    private final String typeName;

    private final String id;

    public LuceneDocumentReference(String typeName, String id) {
        this.typeName = typeName;
        this.id = id;
    }

    @Override
    public String typeName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String id() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
