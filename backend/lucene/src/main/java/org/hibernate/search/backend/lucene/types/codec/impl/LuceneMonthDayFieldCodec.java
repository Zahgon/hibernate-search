/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.codec.impl;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.util.Locale;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneIntegerDomain;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneNumericDomain;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.IndexableField;

public final class LuceneMonthDayFieldCodec extends AbstractLuceneNumericFieldCodec<MonthDay, Integer> {

    static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder().appendLiteral("--").appendValue(MONTH_OF_YEAR, 2).appendLiteral('-').appendValue(DAY_OF_MONTH, 2).toFormatter(Locale.ROOT).withResolverStyle(ResolverStyle.STRICT);

    public LuceneMonthDayFieldCodec(Indexing indexing, DocValues docValues, Storage storage, MonthDay indexNullAsValue) {
        super(indexing, docValues, storage, indexNullAsValue);
    }

    @Override
    void addStoredToDocument(LuceneDocumentContent documentBuilder, String absoluteFieldPath, MonthDay value, Integer encodedValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MonthDay decode(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Integer raw(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Integer encode(MonthDay value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MonthDay decode(Integer encoded) {
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
