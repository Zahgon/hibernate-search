/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.query.impl;

import java.util.Collections;
import java.util.Map;
import org.hibernate.search.backend.elasticsearch.logging.impl.QueryLog;
import org.hibernate.search.backend.elasticsearch.lowlevel.syntax.search.impl.ElasticsearchSearchSyntax;
import org.hibernate.search.backend.elasticsearch.search.aggregation.impl.AggregationRequestContext;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.backend.elasticsearch.search.highlighter.impl.ElasticsearchSearchHighlighter;
import org.hibernate.search.backend.elasticsearch.search.highlighter.impl.ElasticsearchSearchHighlighterImpl;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.DistanceSortKey;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.FieldProjectionRequestContext;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ProjectionRequestContext;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ProjectionRequestRootContext;
import org.hibernate.search.engine.backend.session.spi.BackendSessionContext;
import org.hibernate.search.engine.search.common.NamedValues;
import org.hibernate.search.engine.search.common.spi.SearchQueryElementTypeKey;
import org.hibernate.search.engine.search.loading.spi.SearchLoadingContext;
import org.hibernate.search.engine.search.projection.ProjectionCollector;
import org.hibernate.search.engine.search.query.spi.QueryParameters;
import org.hibernate.search.engine.spatial.GeoPoint;
import com.google.gson.JsonObject;

/**
 * The context holding all the useful information pertaining to the Elasticsearch search query,
 * to be used:
 * <ul>
 *     <li>When building later parts of the query, to get information on more basic parts of the query.
 *     For example distance projections need to inspect distance sorts (if any) for optimization purposes.
 *     ({@link #getDistanceSortIndex(String, GeoPoint)}</li>
 *     <li>When extracting data from the response, to get an "extract" context linked to the session/loading context
 *     ({@link #createExtractContext(JsonObject)}</li>
 * </ul>
 */
class ElasticsearchSearchQueryRequestContext implements ProjectionRequestRootContext, AggregationRequestContext {

    private final ElasticsearchSearchIndexScope<?> scope;

    private final BackendSessionContext sessionContext;

    private final SearchLoadingContext<?> loadingContext;

    private final PredicateRequestContext rootPredicateContext;

    private final Map<DistanceSortKey, Integer> distanceSorts;

    private final Map<String, ElasticsearchSearchHighlighter> namedHighlighters;

    private final ElasticsearchSearchHighlighter queryHighlighter;

    private final QueryParameters parameters;

    ElasticsearchSearchQueryRequestContext(ElasticsearchSearchIndexScope<?> scope, BackendSessionContext sessionContext, SearchLoadingContext<?> loadingContext, PredicateRequestContext rootPredicateContext, Map<DistanceSortKey, Integer> distanceSorts, Map<String, ElasticsearchSearchHighlighter> namedHighlighters, ElasticsearchSearchHighlighter queryHighlighter, QueryParameters parameters) {
        this.scope = scope;
        this.sessionContext = sessionContext;
        this.loadingContext = loadingContext;
        this.rootPredicateContext = rootPredicateContext;
        this.distanceSorts = distanceSorts != null ? Collections.unmodifiableMap(distanceSorts) : null;
        this.namedHighlighters = namedHighlighters;
        this.queryHighlighter = queryHighlighter;
        this.parameters = parameters;
    }

    @Override
    public PredicateRequestContext getRootPredicateContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isRootContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Integer getDistanceSortIndex(String absoluteFieldPath, GeoPoint location) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchSearchSyntax getSearchSyntax() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void checkValidField(String absoluteFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void checkNotNested(SearchQueryElementTypeKey<?> projectionKey, String hint) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectionRequestRootContext root() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectionRequestContext forField(String absoluteFieldPath, String[] absoluteFieldPathComponents) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String absoluteCurrentFieldPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String[] relativeCurrentFieldPathComponents() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public NamedValues queryParameters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean projectionCardinalityCorrectlyAddressed(String requiredContextAbsoluteFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchSearchHighlighter highlighter(String highlighterName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchSearchHighlighter queryHighlighter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleHighlighter(String highlighterName, ProjectionCollector.Provider<?, ?> collectorProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    ElasticsearchSearchQueryExtractContext createExtractContext(JsonObject responseBody) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
