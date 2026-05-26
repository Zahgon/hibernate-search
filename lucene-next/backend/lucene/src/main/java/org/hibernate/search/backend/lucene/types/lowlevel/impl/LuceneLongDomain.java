/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.lowlevel.impl;

import java.util.Collection;
import java.util.Comparator;
import org.hibernate.search.backend.lucene.lowlevel.comparator.impl.LongValuesSourceComparator;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.LongMultiValuesToSingleValuesSource;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.MultiValueMode;
import org.hibernate.search.backend.lucene.lowlevel.join.impl.NestedDocsProvider;
import org.hibernate.search.engine.cfg.spi.NumberUtils;
import org.hibernate.search.util.common.data.Range;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.SortedNumericDocValuesField;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.search.FieldComparator;
import org.apache.lucene.search.Pruning;
import org.apache.lucene.search.Query;

public class LuceneLongDomain implements LuceneNumericDomain<Long> {

    private static final LuceneNumericDomain<Long> INSTANCE = new LuceneLongDomain();

    public static LuceneNumericDomain<Long> get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long getMinValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long getMaxValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long getPreviousValue(Long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long getNextValue(Long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Comparator<Long> createComparator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Query createExactQuery(String absoluteFieldPath, Long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Query createRangeQuery(String absoluteFieldPath, Long lowerLimit, Long upperLimit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Query createSetQuery(String absoluteFieldPath, Collection<Long> values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long sortedDocValueToTerm(long longValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double sortedDocValueToDouble(long longValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Long doubleToTerm(double doubleValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EffectiveRange[] createEffectiveRanges(Collection<? extends Range<? extends Long>> ranges) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexableField createIndexField(String absoluteFieldPath, Long numericValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexableField createSortedDocValuesField(String absoluteFieldPath, Long numericValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FieldComparator<Long> createFieldComparator(String fieldName, int numHits, Long missingValue, boolean reversed, Pruning pruning, MultiValueMode multiValueMode, NestedDocsProvider nestedDocsProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
