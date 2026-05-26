/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.lowlevel.impl;

import java.util.Collection;
import java.util.Comparator;
import org.hibernate.search.backend.lucene.lowlevel.comparator.impl.DoubleValuesSourceComparator;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.DoubleMultiValuesToSingleValuesSource;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.MultiValueMode;
import org.hibernate.search.backend.lucene.lowlevel.join.impl.NestedDocsProvider;
import org.hibernate.search.util.common.data.Range;
import org.apache.lucene.document.DoublePoint;
import org.apache.lucene.document.SortedNumericDocValuesField;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.search.FieldComparator;
import org.apache.lucene.search.Pruning;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.NumericUtils;

public class LuceneDoubleDomain implements LuceneNumericDomain<Double> {

    private static final LuceneNumericDomain<Double> INSTANCE = new LuceneDoubleDomain();

    public static LuceneNumericDomain<Double> get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Double getMinValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Double getMaxValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Double getPreviousValue(Double value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Double getNextValue(Double value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Comparator<Double> createComparator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Query createExactQuery(String absoluteFieldPath, Double value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Query createRangeQuery(String absoluteFieldPath, Double lowerLimit, Double upperLimit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Query createSetQuery(String absoluteFieldPath, Collection<Double> values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Double sortedDocValueToTerm(long longValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double sortedDocValueToDouble(long longValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Double doubleToTerm(double doubleValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EffectiveRange[] createEffectiveRanges(Collection<? extends Range<? extends Double>> ranges) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexableField createIndexField(String absoluteFieldPath, Double numericValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexableField createSortedDocValuesField(String absoluteFieldPath, Double numericValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FieldComparator<Double> createFieldComparator(String fieldName, int numHits, Double missingValue, boolean reversed, Pruning pruning, MultiValueMode multiValueMode, NestedDocsProvider nestedDocsProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
