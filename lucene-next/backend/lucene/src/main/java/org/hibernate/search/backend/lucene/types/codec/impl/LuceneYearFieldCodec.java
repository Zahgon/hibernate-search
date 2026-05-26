/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.codec.impl;

import java.time.Year;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneIntegerDomain;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneNumericDomain;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.IndexableField;

public final class LuceneYearFieldCodec extends AbstractLuceneNumericFieldCodec<Year, Integer> {

    public LuceneYearFieldCodec(Indexing indexing, DocValues docValues, Storage storage, Year indexNullAsValue) {
        super(indexing, docValues, storage, indexNullAsValue);
    }

    @Override
    void addStoredToDocument(LuceneDocumentContent documentBuilder, String absoluteFieldPath, Year value, Integer encodedValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Year decode(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Integer raw(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Integer encode(Year value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Year decode(Integer encoded) {
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
