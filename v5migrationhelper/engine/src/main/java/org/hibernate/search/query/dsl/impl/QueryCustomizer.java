/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.backend.lucene.LuceneExtension;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.BooleanPredicateClausesStep;
import org.hibernate.search.engine.search.predicate.dsl.BooleanPredicateOptionsCollector;
import org.hibernate.search.engine.search.predicate.dsl.PredicateScoreStep;
import org.hibernate.search.engine.search.predicate.dsl.SearchPredicateFactory;
import org.hibernate.search.query.dsl.QueryCustomization;
import org.apache.lucene.search.Query;

/**
 * @author Emmanuel Bernard
 */
class QueryCustomizer implements QueryCustomization<QueryCustomizer> {

    private float boost = 1f;

    private boolean constantScore;

    private Query filter;

    @Override
    public QueryCustomizer boostedTo(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public QueryCustomizer withConstantScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public QueryCustomizer filteredBy(Query filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // TODO: this is ugly: we probably need to rethink how this is built to not depend on Lucene behavior
    public float getBoost() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void applyScoreOptions(PredicateScoreStep<?> step) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchPredicate applyFilter(SearchPredicateFactory factory, SearchPredicate predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void applyFilter(SearchPredicateFactory factory, BooleanPredicateOptionsCollector<?, ?> collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
