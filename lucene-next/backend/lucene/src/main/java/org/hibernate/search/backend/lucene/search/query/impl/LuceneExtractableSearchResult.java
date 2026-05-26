/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.query.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.TopDocsDataCollector;
import org.hibernate.search.backend.lucene.lowlevel.collector.impl.TopDocsDataCollectorExecutionContext;
import org.hibernate.search.backend.lucene.search.aggregation.impl.AggregationExtractContext;
import org.hibernate.search.backend.lucene.search.aggregation.impl.LuceneSearchAggregation;
import org.hibernate.search.backend.lucene.search.aggregation.impl.RootAggregationExtractContext;
import org.hibernate.search.backend.lucene.search.extraction.impl.LuceneCollectors;
import org.hibernate.search.backend.lucene.search.projection.impl.LuceneSearchProjection;
import org.hibernate.search.backend.lucene.search.projection.impl.ProjectionExtractContext;
import org.hibernate.search.engine.backend.types.converter.runtime.FromDocumentValueConvertContext;
import org.hibernate.search.engine.backend.types.converter.runtime.spi.FromDocumentValueConvertContextImpl;
import org.hibernate.search.engine.search.aggregation.AggregationKey;
import org.hibernate.search.engine.search.loading.spi.ProjectionHitMapper;
import org.hibernate.search.engine.search.query.SearchResultTotal;
import org.hibernate.search.engine.search.timeout.spi.TimeoutManager;
import com.carrotsearch.hppc.IntObjectHashMap;
import com.carrotsearch.hppc.IntObjectMap;
import org.apache.lucene.search.CollectorManager;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

public class LuceneExtractableSearchResult<H> {

    private final LuceneSearchQueryRequestContext requestContext;

    private final FromDocumentValueConvertContext fromDocumentValueConvertContext;

    private final IndexSearcher indexSearcher;

    private final LuceneCollectors luceneCollectors;

    private final LuceneSearchProjection.Extractor<?, H> rootExtractor;

    private final Map<AggregationKey<?>, LuceneSearchAggregation.Extractor<?>> aggregations;

    private final TimeoutManager timeoutManager;

    LuceneExtractableSearchResult(LuceneSearchQueryRequestContext requestContext, IndexSearcher indexSearcher, LuceneCollectors luceneCollectors, LuceneSearchProjection.Extractor<?, H> rootExtractor, Map<AggregationKey<?>, LuceneSearchAggregation.Extractor<?>> aggregations, TimeoutManager timeoutManager) {
        this.requestContext = requestContext;
        this.fromDocumentValueConvertContext = new FromDocumentValueConvertContextImpl(requestContext.getSessionContext());
        this.indexSearcher = indexSearcher;
        this.luceneCollectors = luceneCollectors;
        this.rootExtractor = rootExtractor;
        this.aggregations = aggregations;
        this.timeoutManager = timeoutManager;
    }

    public LuceneLoadableSearchResult<H> extract() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public LuceneLoadableSearchResult<H> extract(int startInclusive, int endExclusive) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int hitSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    SearchResultTotal total() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private List<Object> extractHits(ProjectionHitMapper<?> projectionHitMapper, int startInclusive, int endExclusive) throws IOException {
        TopDocs topDocs = luceneCollectors.getTopDocs();
        if (topDocs == null) {
            return Collections.emptyList();
        }
        TopDocsDataCollectorFactory collectorFactory = new TopDocsDataCollectorFactory(projectionHitMapper);
        return luceneCollectors.collectTopDocsData(collectorFactory, startInclusive, endExclusive);
    }

    private Map<AggregationKey<?>, ?> extractAggregations() throws IOException {
        AggregationExtractContext aggregationExtractContext = new RootAggregationExtractContext(requestContext.getQueryIndexScope(), requestContext.getSessionContext(), indexSearcher.getIndexReader(), fromDocumentValueConvertContext, luceneCollectors.collectedMultiResults(), requestContext.getRoutingKeys(), requestContext.getQueryParameters());
        Map<AggregationKey<?>, Object> extractedMap = new LinkedHashMap<>();
        for (Map.Entry<AggregationKey<?>, LuceneSearchAggregation.Extractor<?>> entry : aggregations.entrySet()) {
            // Check for timeout before every element.
            // Do this *before* the element, so that we don't fail after the last element.
            if (timeoutManager.checkTimedOut()) {
                break;
            }
            AggregationKey<?> key = entry.getKey();
            LuceneSearchAggregation.Extractor<?> aggregation = entry.getValue();
            Object extracted = aggregation.extract(aggregationExtractContext);
            extractedMap.put(key, extracted);
        }
        return extractedMap;
    }

    private class TopDocsDataCollectorFactory implements TopDocsDataCollector.Factory<Object> {

        private final ProjectionHitMapper<?> projectionHitMapper;

        public TopDocsDataCollectorFactory(ProjectionHitMapper<?> projectionHitMapper) {
            this.projectionHitMapper = projectionHitMapper;
        }

        @Override
        public CollectorManager<TopDocsDataCollector<Object>, IntObjectMap<Object>> create(TopDocsDataCollectorExecutionContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
