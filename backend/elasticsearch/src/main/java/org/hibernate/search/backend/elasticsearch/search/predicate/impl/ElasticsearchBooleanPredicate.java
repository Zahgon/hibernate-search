/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.predicate.impl;

import static org.hibernate.search.backend.elasticsearch.search.predicate.impl.ElasticsearchMatchAllPredicate.MATCH_ALL_ACCESSOR;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import org.hibernate.search.backend.elasticsearch.gson.impl.GsonUtils;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.BooleanPredicateBuilder;
import com.google.gson.JsonObject;

class ElasticsearchBooleanPredicate extends AbstractElasticsearchPredicate {

    private static final String MUST_PROPERTY_NAME = "must";

    private static final String MUST_NOT_PROPERTY_NAME = "must_not";

    private static final String SHOULD_PROPERTY_NAME = "should";

    private static final String FILTER_PROPERTY_NAME = "filter";

    private static final JsonAccessor<String> MINIMUM_SHOULD_MATCH_ACCESSOR = JsonAccessor.root().property("minimum_should_match").asString();

    private final List<ElasticsearchSearchPredicate> mustClauses;

    private final List<ElasticsearchSearchPredicate> mustNotClauses;

    private final List<ElasticsearchSearchPredicate> shouldClauses;

    private final List<ElasticsearchSearchPredicate> filterClauses;

    // NOTE: below modifiers (minimumShouldMatchConstraints) are used to implement hasNoModifiers() which is based on a
    // parent implementation.
    // IMPORTANT: Review where current modifiers are used and how the new modifier affects that logic, when adding a new modifier.
    private final ElasticsearchCommonMinimumShouldMatchConstraints minimumShouldMatchConstraints;

    private ElasticsearchBooleanPredicate(Builder builder) {
        super(builder);
        mustClauses = builder.mustClauses;
        mustNotClauses = builder.mustNotClauses;
        shouldClauses = builder.shouldClauses;
        filterClauses = builder.filterClauses;
        minimumShouldMatchConstraints = builder.minimumShouldMatchConstraints;
        // Ensure illegal attempts to mutate the predicate will fail
        builder.mustClauses = null;
        builder.mustNotClauses = null;
        builder.shouldClauses = null;
        builder.filterClauses = null;
        builder.minimumShouldMatchConstraints = null;
    }

    @Override
    public void checkNestableWithin(PredicateNestingContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected JsonObject doToJsonQuery(PredicateRequestContext context, JsonObject outerObject, JsonObject innerObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void contributeClauses(PredicateRequestContext context, JsonObject innerObject, String occurProperty, List<ElasticsearchSearchPredicate> clauses) {
        if (clauses == null) {
            return;
        }
        for (ElasticsearchSearchPredicate clause : clauses) {
            GsonUtils.setOrAppendToArray(innerObject, occurProperty, clause.toJsonQuery(context));
        }
    }

    private void checkAcceptableWithin(PredicateNestingContext context, List<ElasticsearchSearchPredicate> clauses) {
        if (clauses == null) {
            return;
        }
        for (ElasticsearchSearchPredicate clause : clauses) {
            clause.checkNestableWithin(context);
        }
    }

    private boolean isOnlyMustNot(JsonObject innerObject) {
        return innerObject.has(MUST_NOT_PROPERTY_NAME) && !innerObject.has(MUST_PROPERTY_NAME) && !innerObject.has(SHOULD_PROPERTY_NAME) && !innerObject.has(FILTER_PROPERTY_NAME);
    }

    private boolean hasAnyClauses(JsonObject innerObject) {
        return innerObject.has(MUST_NOT_PROPERTY_NAME) || innerObject.has(MUST_PROPERTY_NAME) || innerObject.has(SHOULD_PROPERTY_NAME) || innerObject.has(FILTER_PROPERTY_NAME);
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

    static class Builder extends AbstractElasticsearchPredicate.AbstractBuilder implements BooleanPredicateBuilder {

        private List<ElasticsearchSearchPredicate> mustClauses;

        private List<ElasticsearchSearchPredicate> mustNotClauses;

        private List<ElasticsearchSearchPredicate> shouldClauses;

        private List<ElasticsearchSearchPredicate> filterClauses;

        // NOTE: below modifiers (minimumShouldMatchConstraints) are used to implement hasNoModifiers() which is based on a
        // parent implementation.
        // IMPORTANT: Review where current modifiers are used and how the new modifier affects that logic, when adding a new modifier.
        private ElasticsearchCommonMinimumShouldMatchConstraints minimumShouldMatchConstraints;

        Builder(ElasticsearchSearchIndexScope<?> scope) {
            super(scope);
            this.minimumShouldMatchConstraints = new ElasticsearchCommonMinimumShouldMatchConstraints();
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

        private void optimizeClauseCollection(List<ElasticsearchSearchPredicate> collection, Consumer<ElasticsearchSearchPredicate> newCollection) {
            if (collection != null) {
                Iterator<ElasticsearchSearchPredicate> iterator = collection.iterator();
                while (iterator.hasNext()) {
                    ElasticsearchSearchPredicate clause = iterator.next();
                    if (clause instanceof ElasticsearchBooleanPredicate && ((ElasticsearchBooleanPredicate) clause).hasOnlyOneMustNotClause() && ((ElasticsearchBooleanPredicate) clause).hasNoModifiers()) {
                        iterator.remove();
                        newCollection.accept(((ElasticsearchBooleanPredicate) clause).mustNotClauses.get(0));
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

        private boolean hasAtLeastOneMustOrFilterPredicate() {
            return mustClauses != null || filterClauses != null;
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
