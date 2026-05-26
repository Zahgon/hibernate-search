/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.backend.document.spi;

import org.hibernate.search.engine.backend.document.DocumentElement;
import org.hibernate.search.engine.backend.document.IndexFieldReference;
import org.hibernate.search.engine.backend.document.IndexObjectFieldReference;

public class NoOpDocumentElement implements DocumentElement {

    static final NoOpDocumentElement INSTANCE = new NoOpDocumentElement();

    public static NoOpDocumentElement get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private NoOpDocumentElement() {
    }

    @Override
    public <F> void addValue(IndexFieldReference<F> fieldReference, F value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DocumentElement addObject(IndexObjectFieldReference fieldReference) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addNullObject(IndexObjectFieldReference fieldReference) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addValue(String relativeFieldName, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DocumentElement addObject(String relativeFieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addNullObject(String relativeFieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
