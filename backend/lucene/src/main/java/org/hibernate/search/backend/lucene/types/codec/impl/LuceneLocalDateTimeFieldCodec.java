/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.codec.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.util.Locale;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneLongDomain;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneNumericDomain;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.IndexableField;

public final class LuceneLocalDateTimeFieldCodec extends AbstractLuceneNumericFieldCodec<LocalDateTime, Long> {

    static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder().append(LuceneLocalDateFieldCodec.FORMATTER).appendLiteral('T').append(LuceneLocalTimeFieldCodec.FORMATTER).toFormatter(Locale.ROOT).withResolverStyle(ResolverStyle.STRICT);

    public LuceneLocalDateTimeFieldCodec(Indexing indexing, DocValues docValues, Storage storage, LocalDateTime indexNullAsValue) {
        super(indexing, docValues, storage, indexNullAsValue);
    }

    @Override
    void addStoredToDocument(LuceneDocumentContent documentBuilder, String absoluteFieldPath, LocalDateTime value, Long encodedValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LocalDateTime decode(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long raw(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long encode(LocalDateTime value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LocalDateTime decode(Long encoded) {
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
