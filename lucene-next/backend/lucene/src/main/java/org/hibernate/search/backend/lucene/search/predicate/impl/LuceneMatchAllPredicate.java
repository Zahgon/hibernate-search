/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.predicate.impl;

import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.MatchAllPredicateBuilder;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;

class LuceneMatchAllPredicate extends AbstractLuceneSearchPredicate {

    private LuceneMatchAllPredicate(Builder builder) {
        super(builder);
    }

    @Override
    public void checkNestableWithin(String expectedParentNestedPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Query doToQuery(PredicateRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class Builder extends AbstractBuilder implements MatchAllPredicateBuilder {

        Builder(LuceneSearchIndexScope<?> scope) {
            super(scope);
        }

        @Override
        public SearchPredicate build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
