/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.engine.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.engine.search.query.dsl.SearchQueryOptionsStep;
import org.hibernate.search.query.dsl.impl.FacetingRequestImpl;
import org.hibernate.search.query.engine.spi.FacetManager;
import org.hibernate.search.query.facet.Facet;
import org.hibernate.search.query.facet.FacetingRequest;

/**
 * Default implementation of the {@link FacetManager} implementation.
 *
 * @author Hardy Ferentschik
 */
public class FacetManagerImpl implements FacetManager {

    /**
     * The map of currently active/enabled facet requests.
     */
    private Map<String, FacetingRequestImpl<?>> facetRequests;

    /**
     * Keeps track of faceting results. This map gets populated once the query gets executed and needs to be
     * reset on any query changing call.
     */
    private Map<String, List<Facet>> facetResults;

    /**
     * The query from which this manager was retrieved
     */
    private final HSQueryImpl<?> query;

    public FacetManagerImpl(HSQueryImpl<?> query) {
        this.query = query;
    }

    @Override
    public FacetManager enableFaceting(FacetingRequest facetingRequest) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void disableFaceting(String facetingName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<Facet> getFacets(String facetingName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    <LOS> SearchQueryOptionsStep<?, ?, ?, LOS, ?, ?> contributeAggregations(SearchQueryOptionsStep<?, ?, ?, LOS, ?, ?> optionsStep) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void setFacetResults(SearchResult<?> result) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean hasFacets() {
        return facetRequests != null && !facetRequests.isEmpty();
    }

    private <LOS, A> SearchQueryOptionsStep<?, ?, ?, LOS, ?, ?> requestAggregation(SearchQueryOptionsStep<?, ?, ?, LOS, ?, ?> optionsStep, FacetingRequestImpl<A> facetRequest) {
        return optionsStep.aggregation(facetRequest.getKey(), facetRequest::requestAggregation);
    }

    private <A> List<Facet> extractFacets(SearchResult<?> result, FacetingRequestImpl<A> facetRequest) {
        A aggregation = result.aggregation(facetRequest.getKey());
        return facetRequest.toFacets(aggregation);
    }

    private void facetsHaveChanged() {
        this.facetResults = null;
    }
}
