/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.codec.impl;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.util.Locale;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneLongDomain;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneNumericDomain;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.IndexableField;

public final class LuceneLocalDateFieldCodec extends AbstractLuceneNumericFieldCodec<LocalDate, Long> {

    static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder().append(LuceneYearMonthFieldCodec.FORMATTER).appendLiteral('-').appendValue(DAY_OF_MONTH, 2).toFormatter(Locale.ROOT).withResolverStyle(ResolverStyle.STRICT);

    public LuceneLocalDateFieldCodec(Indexing indexing, DocValues docValues, Storage storage, LocalDate indexNullAsValue) {
        super(indexing, docValues, storage, indexNullAsValue);
    }

    @Override
    void addStoredToDocument(LuceneDocumentContent documentBuilder, String absoluteFieldPath, LocalDate value, Long encodedValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LocalDate decode(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long raw(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long encode(LocalDate value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LocalDate decode(Long encoded) {
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
