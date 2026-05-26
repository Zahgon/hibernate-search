/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.codec.impl;

import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneLongDomain;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneNumericDomain;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.IndexableField;

public final class LuceneLongFieldCodec extends AbstractLuceneNumericFieldCodec<Long, Long> {

    public LuceneLongFieldCodec(Indexing indexing, DocValues docValues, Storage storage, Long indexNullAsValue) {
        super(indexing, docValues, storage, indexNullAsValue);
    }

    @Override
    void addStoredToDocument(LuceneDocumentContent documentBuilder, String absoluteFieldPath, Long value, Long encodedValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long decode(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long raw(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long encode(Long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long decode(Long encoded) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneNumericDomain<Long> getDomain() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Class<Long> encodedType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
