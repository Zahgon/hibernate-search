/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.codec.impl;

import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneNumericDomain;

public abstract class AbstractLuceneNumericFieldCodec<F, E extends Number> implements LuceneFieldCodec<F, E> {

    private final Indexing indexing;

    private final DocValues docValues;

    private final Storage storage;

    private final F indexNullAsValue;

    public AbstractLuceneNumericFieldCodec(Indexing indexing, DocValues docValues, Storage storage, F indexNullAsValue) {
        this.indexing = indexing;
        this.docValues = docValues;
        this.storage = storage;
        this.indexNullAsValue = indexNullAsValue;
    }

    @Override
    public final void addToDocument(LuceneDocumentContent documentBuilder, String absoluteFieldPath, F value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleWith(LuceneFieldCodec<?, ?> obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public abstract LuceneNumericDomain<E> getDomain();

    abstract void addStoredToDocument(LuceneDocumentContent documentBuilder, String absoluteFieldPath, F value, E encodedValue);

    public Double sortedDocValueToDouble(Long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
