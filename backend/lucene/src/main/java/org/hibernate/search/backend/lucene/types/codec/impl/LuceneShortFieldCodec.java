/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.codec.impl;

import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneIntegerDomain;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneNumericDomain;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.IndexableField;

public final class LuceneShortFieldCodec extends AbstractLuceneNumericFieldCodec<Short, Integer> {

    public LuceneShortFieldCodec(Indexing indexing, DocValues docValues, Storage storage, Short indexNullAsValue) {
        super(indexing, docValues, storage, indexNullAsValue);
    }

    @Override
    void addStoredToDocument(LuceneDocumentContent documentBuilder, String absoluteFieldPath, Short value, Integer encodedValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Short decode(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Integer raw(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Integer encode(Short value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Short decode(Integer encoded) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneNumericDomain<Integer> getDomain() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Class<Integer> encodedType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
