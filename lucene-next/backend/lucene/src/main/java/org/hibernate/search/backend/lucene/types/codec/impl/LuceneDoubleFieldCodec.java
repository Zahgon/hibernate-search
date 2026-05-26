/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.codec.impl;

import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneDoubleDomain;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneNumericDomain;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.IndexableField;

public final class LuceneDoubleFieldCodec extends AbstractLuceneNumericFieldCodec<Double, Double> {

    public LuceneDoubleFieldCodec(Indexing indexing, DocValues docValues, Storage storage, Double indexNullAsValue) {
        super(indexing, docValues, storage, indexNullAsValue);
    }

    @Override
    void addStoredToDocument(LuceneDocumentContent documentBuilder, String absoluteFieldPath, Double value, Double encodedValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Double decode(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Double raw(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Double encode(Double value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Double decode(Double encoded) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneNumericDomain<Double> getDomain() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Class<Double> encodedType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
