/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.query.impl;

import static org.hibernate.search.backend.lucene.search.projection.impl.LuceneSearchProjection.Extractor.transformUnsafe;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.hibernate.search.backend.lucene.search.projection.impl.LuceneSearchProjection;
import org.hibernate.search.backend.lucene.search.projection.impl.ProjectionTransformContext;
import org.hibernate.search.backend.lucene.search.query.LuceneSearchResult;
import org.hibernate.search.engine.backend.types.converter.runtime.FromDocumentValueConvertContext;
import org.hibernate.search.engine.search.aggregation.AggregationKey;
import org.hibernate.search.engine.search.loading.spi.LoadingResult;
import org.hibernate.search.engine.search.loading.spi.ProjectionHitMapper;
import org.hibernate.search.engine.search.query.SearchResultTotal;
import org.hibernate.search.engine.search.timeout.spi.TimeoutManager;
import org.apache.lucene.search.TopDocs;

/**
 * A search result from the backend that offers a method to load data from the mapper.
 * <p>
 * Allows to run loading in the user thread, and not in the backend HTTP request threads.
 * <p>
 * <strong>WARNING:</strong> loading should only be triggered once.
 * <p>
 * <strong>WARNING:</strong> this class is not thread-safe.
 *
 * @param <H> The type of hits in the search result.
 */
public class LuceneLoadableSearchResult<H> {

    private final FromDocumentValueConvertContext fromDocumentValueConvertContext;

    private final LuceneSearchProjection.Extractor<?, H> rootExtractor;

    private final SearchResultTotal resultTotal;

    private final TopDocs topDocs;

    private List<Object> extractedData;

    private final Map<AggregationKey<?>, ?> extractedAggregations;

    private final ProjectionHitMapper<?> projectionHitMapper;

    private final Duration took;

    private final Boolean timedOut;

    private final TimeoutManager timeoutManager;

    LuceneLoadableSearchResult(FromDocumentValueConvertContext fromDocumentValueConvertContext, LuceneSearchProjection.Extractor<?, H> rootExtractor, SearchResultTotal resultTotal, TopDocs topDocs, List<Object> extractedData, Map<AggregationKey<?>, ?> extractedAggregations, ProjectionHitMapper<?> projectionHitMapper, Duration took, boolean timedOut, TimeoutManager timeoutManager) {
        this.fromDocumentValueConvertContext = fromDocumentValueConvertContext;
        this.rootExtractor = rootExtractor;
        this.resultTotal = resultTotal;
        this.topDocs = topDocs;
        this.extractedData = extractedData;
        this.extractedAggregations = extractedAggregations;
        this.projectionHitMapper = projectionHitMapper;
        this.took = took;
        this.timedOut = timedOut;
        this.timeoutManager = timeoutManager;
    }

    LuceneSearchResult<H> loadBlocking() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
