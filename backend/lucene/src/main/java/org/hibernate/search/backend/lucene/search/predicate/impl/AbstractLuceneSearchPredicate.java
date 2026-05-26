/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.predicate.impl;

import java.util.Set;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.engine.search.predicate.spi.SearchPredicateBuilder;
import org.apache.lucene.search.BoostQuery;
import org.apache.lucene.search.ConstantScoreQuery;
import org.apache.lucene.search.Query;

public abstract class AbstractLuceneSearchPredicate implements LuceneSearchPredicate {

    protected final Set<String> indexNames;

    // NOTE: below modifiers (boost, constant score) are used to implement hasNoModifiers() that other predicates
    // rely on and might build on to include additional predicate-specific modifiers LuceneBooleanPredicate in particular.
    // IMPORTANT: Review where current modifiers are used and how the new modifier affects that logic, when adding a new modifier.
    private final Float boost;

    private final boolean constantScore;

    protected AbstractLuceneSearchPredicate(AbstractBuilder builder) {
        indexNames = builder.scope.hibernateSearchIndexNames();
        boost = builder.boost;
        constantScore = builder.constantScore;
    }

    @Override
    public Set<String> indexNames() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Query toQuery(PredicateRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract Query doToQuery(PredicateRequestContext context);

    protected boolean hasNoModifiers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public abstract static class AbstractBuilder implements SearchPredicateBuilder {

        protected final LuceneSearchIndexScope<?> scope;

        // NOTE: below modifiers (boost, constant score) are used to implement hasNoModifiers() that other predicates
        // rely on and might build on to include additional predicate-specific modifiers ElasticsearchBooleanPredicate in particular.
        // IMPORTANT: Review where current modifiers are used and how the new modifier affects that logic, when adding a new modifier.
        private Float boost;

        private boolean constantScore;

        protected AbstractBuilder(LuceneSearchIndexScope<?> scope) {
            this.scope = scope;
        }

        @Override
        public void boost(float boost) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void constantScore() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected boolean hasNoModifiers() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
