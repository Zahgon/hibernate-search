/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.document.impl;

import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexValueField;
import org.hibernate.search.engine.backend.document.IndexFieldReference;

public class LuceneIndexFieldReference<F> implements IndexFieldReference<F> {

    private LuceneIndexValueField<F> schemaNode;

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSchemaNode(LuceneIndexValueField<F> schemaNode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    LuceneIndexValueField<F> getSchemaNode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
