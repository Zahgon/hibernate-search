/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.sort.comparatorsource.impl;

import java.io.IOException;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.MultiValueMode;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.ReplaceMissingSortedDocValues;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.TextMultiValuesToSingleValuesSource;
import org.hibernate.search.backend.lucene.types.sort.impl.SortMissingValue;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.index.SortedDocValues;
import org.apache.lucene.search.FieldComparator;
import org.apache.lucene.search.Pruning;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.comparators.TermOrdValComparator;
import org.apache.lucene.util.BytesRef;

public class LuceneTextFieldComparatorSource extends LuceneFieldComparatorSource {

    private final Object missingValue;

    private final MultiValueMode multiValueMode;

    public LuceneTextFieldComparatorSource(String nestedDocumentPath, Object missingValue, MultiValueMode multiValueMode, Query luceneFilter) {
        super(nestedDocumentPath, luceneFilter);
        this.missingValue = missingValue;
        this.multiValueMode = multiValueMode;
    }

    @Override
    public FieldComparator<?> newComparator(String fieldname, int numHits, Pruning pruning, boolean reversed) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean isOneOfSortMissingValues() {
        return missingValue instanceof SortMissingValue;
    }
}
