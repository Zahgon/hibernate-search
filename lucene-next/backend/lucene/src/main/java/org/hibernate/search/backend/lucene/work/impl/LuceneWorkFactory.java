/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.work.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.search.backend.lucene.document.impl.LuceneIndexEntry;
import org.hibernate.search.backend.lucene.lowlevel.common.impl.MetadataFields;
import org.hibernate.search.backend.lucene.lowlevel.query.impl.Queries;
import org.hibernate.search.backend.lucene.multitenancy.impl.MultiTenancyStrategy;
import org.apache.lucene.search.Explanation;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;

public final class LuceneWorkFactory {

    private final MultiTenancyStrategy multiTenancyStrategy;

    public LuceneWorkFactory(MultiTenancyStrategy multiTenancyStrategy) {
        this.multiTenancyStrategy = multiTenancyStrategy;
    }

    public IndexManagementWork<Void> createIndexIfMissing() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IndexManagementWork<Void> dropIndexIfExisting() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IndexManagementWork<Void> validateIndexExists() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IndexManagementWork<?> flush() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IndexManagementWork<?> refresh() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IndexManagementWork<?> mergeSegments() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IndexManagementWork<Long> computeSizeInBytes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SingleDocumentIndexingWork add(String tenantId, String entityTypeName, Object entityIdentifier, String documentIdentifier, LuceneIndexEntry indexEntry) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SingleDocumentIndexingWork update(String tenantId, String entityTypeName, Object entityIdentifier, String documentIdentifier, LuceneIndexEntry indexEntry) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SingleDocumentIndexingWork delete(String tenantId, String entityTypeName, Object entityIdentifier, String documentIdentifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IndexManagementWork<?> deleteAll(Set<String> tenantIds, Set<String> routingKeys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <R> ReadWork<R> search(LuceneSearcher<R, ?> searcher, Integer offset, Integer limit, int totalHitCountThreshold) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <ER> ReadWork<ER> scroll(LuceneSearcher<?, ER> searcher, int offset, int limit, int totalHitCountThreshold) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ReadWork<Integer> count(LuceneSearcher<?, ?> searcher) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ReadWork<Explanation> explain(LuceneSearcher<?, ?> searcher, String explainedDocumentTypeName, String explainedDocumentId, Query explainedDocumentFilter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
