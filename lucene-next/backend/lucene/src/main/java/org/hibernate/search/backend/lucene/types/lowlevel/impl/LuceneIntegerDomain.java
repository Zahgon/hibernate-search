/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.lowlevel.impl;

import java.util.Collection;
import java.util.Comparator;
import org.hibernate.search.backend.lucene.lowlevel.comparator.impl.IntValuesSourceComparator;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.LongMultiValuesToSingleValuesSource;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.MultiValueMode;
import org.hibernate.search.backend.lucene.lowlevel.join.impl.NestedDocsProvider;
import org.hibernate.search.engine.cfg.spi.NumberUtils;
import org.hibernate.search.util.common.data.Range;
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.document.SortedNumericDocValuesField;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.search.FieldComparator;
import org.apache.lucene.search.Pruning;
import org.apache.lucene.search.Query;

public class LuceneIntegerDomain implements LuceneNumericDomain<Integer> {

    private static final LuceneNumericDomain<Integer> INSTANCE = new LuceneIntegerDomain();

    public static LuceneNumericDomain<Integer> get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Integer getMinValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Integer getMaxValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Integer getPreviousValue(Integer value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Integer getNextValue(Integer value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Comparator<Integer> createComparator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Query createExactQuery(String absoluteFieldPath, Integer value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Query createRangeQuery(String absoluteFieldPath, Integer lowerLimit, Integer upperLimit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Query createSetQuery(String absoluteFieldPath, Collection<Integer> values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Integer sortedDocValueToTerm(long longValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Integer doubleToTerm(double doubleValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double sortedDocValueToDouble(long longValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EffectiveRange[] createEffectiveRanges(Collection<? extends Range<? extends Integer>> ranges) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexableField createIndexField(String absoluteFieldPath, Integer numericValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexableField createSortedDocValuesField(String absoluteFieldPath, Integer numericValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FieldComparator<Integer> createFieldComparator(String fieldName, int numHits, Integer missingValue, boolean reversed, Pruning pruning, MultiValueMode multiValueMode, NestedDocsProvider nestedDocsProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
