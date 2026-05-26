/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.predicate.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.BooleanPredicateBuilder;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;

class LuceneBooleanPredicate extends AbstractLuceneSearchPredicate {

    private final List<LuceneSearchPredicate> mustClauses;

    private final List<LuceneSearchPredicate> mustNotClauses;

    private final List<LuceneSearchPredicate> shouldClauses;

    private final List<LuceneSearchPredicate> filterClauses;

    // NOTE: below modifiers (minimumShouldMatchConstraints) are used to implement hasNoModifiers() which is based on a
    // parent implementation.
    // IMPORTANT: Review where current modifiers are used and how the new modifier affects that logic, when adding a new modifier.
    private final LuceneCommonMinimumShouldMatchConstraints minimumShouldMatchConstraint;

    private LuceneBooleanPredicate(Builder builder) {
        super(builder);
        mustClauses = builder.mustClauses;
        mustNotClauses = builder.mustNotClauses;
        shouldClauses = builder.shouldClauses;
        filterClauses = builder.filterClauses;
        minimumShouldMatchConstraint = builder.minimumShouldMatchBuilder;
        // Ensure illegal attempts to mutate the predicate will fail
        builder.mustClauses = null;
        builder.shouldClauses = null;
        builder.mustNotClauses = null;
        builder.filterClauses = null;
        builder.minimumShouldMatchBuilder = null;
    }

    @Override
    public void checkNestableWithin(String expectedParentNestedPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Query doToQuery(PredicateRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void contributeQueries(PredicateRequestContext context, BooleanQuery.Builder booleanQueryBuilder, List<LuceneSearchPredicate> clauses, Occur occur) {
        if (clauses == null) {
            return;
        }
        for (LuceneSearchPredicate clause : clauses) {
            booleanQueryBuilder.add(clause.toQuery(context), occur);
        }
    }

    private void checkNestableWithin(String expectedParentNestedPath, List<LuceneSearchPredicate> clauses) {
        if (clauses == null) {
            return;
        }
        for (LuceneSearchPredicate clause : clauses) {
            clause.checkNestableWithin(expectedParentNestedPath);
        }
    }

    private boolean isOnlyMustNot() {
        return mustNotClauses != null && !mustNotClauses.isEmpty() && (mustClauses == null || mustClauses.isEmpty()) && (shouldClauses == null || shouldClauses.isEmpty()) && (filterClauses == null || filterClauses.isEmpty());
    }

    private boolean hasOnlyOneMustNotClause() {
        return isOnlyMustNot() && mustNotClauses.size() == 1;
    }

    @Override
    protected boolean hasNoModifiers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class Builder extends AbstractBuilder implements BooleanPredicateBuilder {

        private List<LuceneSearchPredicate> mustClauses;

        private List<LuceneSearchPredicate> mustNotClauses;

        private List<LuceneSearchPredicate> shouldClauses;

        private List<LuceneSearchPredicate> filterClauses;

        // NOTE: below modifiers (minimumShouldMatchConstraints) are used to implement hasNoModifiers() which is based on a
        // parent implementation.
        // IMPORTANT: Review where current modifiers are used and how the new modifier affects that logic, when adding a new modifier.
        private LuceneCommonMinimumShouldMatchConstraints minimumShouldMatchBuilder;

        Builder(LuceneSearchIndexScope<?> scope) {
            super(scope);
            minimumShouldMatchBuilder = new LuceneCommonMinimumShouldMatchConstraints();
        }

        @Override
        public void must(SearchPredicate clause) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void mustNot(SearchPredicate clause) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void should(SearchPredicate clause) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void filter(SearchPredicate clause) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void minimumShouldMatchNumber(int ignoreConstraintCeiling, int matchingClausesNumber) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void minimumShouldMatchPercent(int ignoreConstraintCeiling, int matchingClausesPercent) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean hasClause() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchPredicate build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void optimizeClauseCollection(List<LuceneSearchPredicate> collection, Consumer<LuceneSearchPredicate> newCollection) {
            if (collection != null) {
                Iterator<LuceneSearchPredicate> iterator = collection.iterator();
                while (iterator.hasNext()) {
                    LuceneSearchPredicate clause = iterator.next();
                    if (clause instanceof LuceneBooleanPredicate && ((LuceneBooleanPredicate) clause).hasOnlyOneMustNotClause() && ((LuceneBooleanPredicate) clause).hasNoModifiers()) {
                        iterator.remove();
                        newCollection.accept(((LuceneBooleanPredicate) clause).mustNotClauses.get(0));
                    }
                }
            }
        }

        private void checkAndClearClauseCollections() {
            if (mustClauses != null && mustClauses.isEmpty()) {
                mustClauses = null;
            }
            if (mustNotClauses != null && mustNotClauses.isEmpty()) {
                mustNotClauses = null;
            }
        }

        private boolean hasOnlyOneMustClause() {
            return mustClauses != null && mustClauses.size() == 1 && (mustNotClauses == null || mustNotClauses.isEmpty()) && (shouldClauses == null || shouldClauses.isEmpty()) && (filterClauses == null || filterClauses.isEmpty());
        }

        private boolean hasOnlyOneShouldClause() {
            return shouldClauses != null && shouldClauses.size() == 1 && (mustNotClauses == null || mustNotClauses.isEmpty()) && (mustClauses == null || mustClauses.isEmpty()) && (filterClauses == null || filterClauses.isEmpty());
        }

        @Override
        protected boolean hasNoModifiers() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
