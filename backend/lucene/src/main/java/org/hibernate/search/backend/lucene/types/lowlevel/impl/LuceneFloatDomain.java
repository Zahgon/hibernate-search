/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.lowlevel.impl;

import java.util.Collection;
import java.util.Comparator;
import org.hibernate.search.backend.lucene.lowlevel.comparator.impl.FloatValuesSourceComparator;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.DoubleMultiValuesToSingleValuesSource;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.MultiValueMode;
import org.hibernate.search.backend.lucene.lowlevel.join.impl.NestedDocsProvider;
import org.hibernate.search.engine.cfg.spi.NumberUtils;
import org.hibernate.search.util.common.data.Range;
import org.apache.lucene.document.FloatPoint;
import org.apache.lucene.document.SortedNumericDocValuesField;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.search.FieldComparator;
import org.apache.lucene.search.Pruning;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.NumericUtils;

public class LuceneFloatDomain implements LuceneNumericDomain<Float> {

    private static final LuceneNumericDomain<Float> INSTANCE = new LuceneFloatDomain();

    public static LuceneNumericDomain<Float> get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Float getMinValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Float getMaxValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Float getPreviousValue(Float value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Float getNextValue(Float value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Comparator<Float> createComparator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Query createExactQuery(String absoluteFieldPath, Float value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Query createRangeQuery(String absoluteFieldPath, Float lowerLimit, Float upperLimit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Query createSetQuery(String absoluteFieldPath, Collection<Float> values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Float sortedDocValueToTerm(long longValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double sortedDocValueToDouble(long longValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Float doubleToTerm(double doubleValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EffectiveRange[] createEffectiveRanges(Collection<? extends Range<? extends Float>> ranges) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexableField createIndexField(String absoluteFieldPath, Float numericValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexableField createSortedDocValuesField(String absoluteFieldPath, Float numericValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FieldComparator<Float> createFieldComparator(String fieldName, int numHits, Float missingValue, boolean reversed, Pruning pruning, MultiValueMode multiValueMode, NestedDocsProvider nestedDocsProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
