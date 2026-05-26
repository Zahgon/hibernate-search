/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.codec.impl;

import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneFloatDomain;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneNumericDomain;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.IndexableField;

public final class LuceneFloatFieldCodec extends AbstractLuceneNumericFieldCodec<Float, Float> {

    public LuceneFloatFieldCodec(Indexing indexing, DocValues docValues, Storage storage, Float indexNullAsValue) {
        super(indexing, docValues, storage, indexNullAsValue);
    }

    @Override
    void addStoredToDocument(LuceneDocumentContent documentBuilder, String absoluteFieldPath, Float value, Float encodedValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Float decode(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Float raw(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Float encode(Float value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Float decode(Float encoded) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneNumericDomain<Float> getDomain() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Class<Float> encodedType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
