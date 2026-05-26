/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.extraction.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorExecutionContext;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.CollectorFactory;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.StoredFieldsValuesDelegate;
import org.hibernate.search.backend.lucene.lowlevel.reader.impl.IndexReaderMetadataResolver;
import org.hibernate.search.engine.search.timeout.spi.TimeoutManager;
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.CollectorManager;
import org.apache.lucene.search.FieldDoc;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TopDocsCollector;
import org.apache.lucene.search.TopFieldCollector;
import org.apache.lucene.search.TopFieldCollectorManager;
import org.apache.lucene.search.TopFieldDocs;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.search.TopScoreDocCollectorManager;
import org.apache.lucene.search.TotalHitCountCollectorManager;

/**
 * Regroups information about the data used as input of extraction (projections or aggregations):
 * collectors, stored fields, nested document IDs, ...
 */
public final class ExtractionRequirements {

    private final boolean requireScore;

    private final Set<CollectorFactory<?, ?, ?>> requiredCollectorForAllMatchingDocsFactories;

    private final StoredFieldsValuesDelegate.Factory storedFieldsSourceFactoryOrNull;

    private ExtractionRequirements(Builder builder) {
        requireScore = builder.requireScore;
        requiredCollectorForAllMatchingDocsFactories = builder.requiredCollectorForAllMatchingDocsFactories;
        storedFieldsSourceFactoryOrNull = builder.createStoredFieldsSourceFactoryOrNull();
    }

    public LuceneCollectors createCollectors(IndexSearcher indexSearcher, Query originalLuceneQuery, Sort sort, IndexReaderMetadataResolver metadataResolver, int maxDocs, int offset, TimeoutManager timeoutManager, int requestedTotalHitCountThreshold) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean isDescendingScoreSort(Sort sort) {
        SortField[] fields = sort.getSort();
        return fields.length == 1 && isDescendingScoreSort(fields[0]);
    }

    private boolean isDescendingScoreSort(SortField sortField) {
        return SortField.Type.SCORE == sortField.getType() && !sortField.getReverse();
    }

    private Integer getScoreSortFieldIndexOrNull(Sort sort) {
        SortField[] sortFields = sort.getSort();
        for (int i = 0; i < sortFields.length; i++) {
            SortField sortField = sortFields[i];
            if (sortField.getType() == SortField.Type.SCORE) {
                return i;
            }
        }
        return null;
    }

    public static class Builder {

        private boolean requireScore;

        private final Set<CollectorFactory<?, ?, ?>> requiredCollectorForAllMatchingDocsFactories = new LinkedHashSet<>();

        private boolean requireAllStoredFields = false;

        private final Set<String> requiredStoredFields = new HashSet<>();

        private final Set<String> requiredNestedDocumentPathsForStoredFields = new HashSet<>();

        public void requireScore() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public <C extends Collector, T, CM extends CollectorManager<C, T>> void requireCollectorForAllMatchingDocs(CollectorFactory<C, T, CM> collectorFactory) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void requireAllStoredFields() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void requireNestedObjects(Collection<String> paths) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void requireStoredField(String absoluteFieldPath, String nestedDocumentPath) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ExtractionRequirements build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private StoredFieldsValuesDelegate.Factory createStoredFieldsSourceFactoryOrNull() {
            ReusableDocumentStoredFieldVisitor storedFieldVisitor;
            if (requireAllStoredFields) {
                storedFieldVisitor = new ReusableDocumentStoredFieldVisitor();
            } else if (!requiredStoredFields.isEmpty()) {
                storedFieldVisitor = new ReusableDocumentStoredFieldVisitor(requiredStoredFields);
            } else {
                return null;
            }
            return new StoredFieldsValuesDelegate.Factory(storedFieldVisitor, requiredNestedDocumentPathsForStoredFields);
        }
    }

    private static final class HibernateSearchTopScoreDocCollectorManager extends TopScoreDocCollectorManager {

        private final int numHits;

        private final int offset;

        public HibernateSearchTopScoreDocCollectorManager(int offset, int numHits, ScoreDoc after, int totalHitsThreshold) {
            super(numHits, after, totalHitsThreshold);
            this.numHits = numHits;
            this.offset = offset;
        }

        @Override
        public TopDocs reduce(Collection<TopScoreDocCollector> collectors) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class HibernateSearchTopFieldCollectorManager extends TopFieldCollectorManager {

        private final int numHits;

        private final Sort sort;

        private final int offset;

        public HibernateSearchTopFieldCollectorManager(int offset, Sort sort, int numHits, FieldDoc after, int totalHitsThreshold) {
            super(sort, numHits, after, totalHitsThreshold);
            this.numHits = numHits;
            this.offset = offset;
            this.sort = sort;
        }

        @Override
        public TopFieldDocs reduce(Collection<TopFieldCollector> collectors) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
