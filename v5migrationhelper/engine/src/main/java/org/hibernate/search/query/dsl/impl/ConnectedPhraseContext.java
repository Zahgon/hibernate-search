/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.query.dsl.PhraseContext;
import org.hibernate.search.query.dsl.PhraseMatchingContext;
import org.apache.lucene.search.Query;

/**
 * @author Emmanuel Bernard
 */
class ConnectedPhraseContext implements PhraseContext {

    private final QueryBuildingContext queryContext;

    private final QueryCustomizer queryCustomizer;

    private final PhraseQueryContext phraseContext;

    public ConnectedPhraseContext(QueryBuildingContext queryContext) {
        this.queryCustomizer = new QueryCustomizer();
        this.phraseContext = new PhraseQueryContext();
        this.queryContext = queryContext;
    }

    @Override
    public PhraseContext withSlop(int slop) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PhraseMatchingContext onField(String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PhraseContext boostedTo(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PhraseContext withConstantScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PhraseContext filteredBy(Query filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
