/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.query.impl;

import org.hibernate.search.backend.elasticsearch.orchestration.impl.ElasticsearchParallelWorkOrchestrator;
import org.hibernate.search.backend.elasticsearch.search.query.ElasticsearchSearchScroll;
import org.hibernate.search.backend.elasticsearch.search.query.ElasticsearchSearchScrollResult;
import org.hibernate.search.backend.elasticsearch.work.factory.impl.ElasticsearchWorkFactory;
import org.hibernate.search.backend.elasticsearch.work.impl.ElasticsearchSearchResultExtractor;
import org.hibernate.search.backend.elasticsearch.work.impl.NonBulkableWork;
import org.hibernate.search.backend.elasticsearch.work.impl.SearchWork;
import org.hibernate.search.engine.backend.work.execution.OperationSubmitter;
import org.hibernate.search.engine.search.timeout.spi.TimeoutManager;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.impl.Futures;

public class ElasticsearchSearchScrollImpl<H> implements ElasticsearchSearchScroll<H> {

    private final ElasticsearchParallelWorkOrchestrator queryOrchestrator;

    private final ElasticsearchWorkFactory workFactory;

    private final ElasticsearchSearchResultExtractor<ElasticsearchLoadableSearchResult<H>> searchResultExtractor;

    private final String scrollTimeoutString;

    private final SearchWork.Builder<ElasticsearchLoadableSearchResult<H>> firstScroll;

    private final TimeoutManager timeoutManager;

    private String scrollId;

    public ElasticsearchSearchScrollImpl(ElasticsearchParallelWorkOrchestrator queryOrchestrator, ElasticsearchWorkFactory workFactory, ElasticsearchSearchResultExtractor<ElasticsearchLoadableSearchResult<H>> searchResultExtractor, String scrollTimeoutString, SearchWork.Builder<ElasticsearchLoadableSearchResult<H>> firstScroll, TimeoutManager timeoutManager) {
        this.workFactory = workFactory;
        this.queryOrchestrator = queryOrchestrator;
        this.searchResultExtractor = searchResultExtractor;
        this.scrollTimeoutString = scrollTimeoutString;
        this.firstScroll = firstScroll;
        this.timeoutManager = timeoutManager;
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchSearchScrollResult<H> next() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
