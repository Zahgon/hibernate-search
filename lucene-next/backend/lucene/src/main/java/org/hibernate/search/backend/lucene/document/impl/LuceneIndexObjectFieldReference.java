/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.document.impl;

import org.hibernate.search.backend.lucene.document.model.impl.LuceneIndexObjectField;
import org.hibernate.search.engine.backend.document.IndexObjectFieldReference;

public class LuceneIndexObjectFieldReference implements IndexObjectFieldReference {

    private LuceneIndexObjectField schemaNode;

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSchemaNode(LuceneIndexObjectField schemaNode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    LuceneIndexObjectField getSchemaNode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
