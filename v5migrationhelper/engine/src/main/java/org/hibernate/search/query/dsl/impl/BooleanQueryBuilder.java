/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.search.backend.lucene.LuceneExtension;
import org.hibernate.search.backend.lucene.search.spi.LuceneMigrationUtils;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.BooleanPredicateClausesStep;
import org.hibernate.search.engine.search.predicate.dsl.SearchPredicateFactory;
import org.hibernate.search.query.dsl.BooleanJunction;
import org.hibernate.search.query.dsl.MustJunction;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.logging.impl.LoggerFactory;
import org.hibernate.search.util.logging.impl.MigrationHelperLog;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.Query;

/**
 * @author Emmanuel Bernard
 */
class BooleanQueryBuilder implements MustJunction {

    private static final MigrationHelperLog log = LoggerFactory.make(MethodHandles.lookup());

    private final QueryBuildingContext queryContext;

    private final List<BooleanClause> clauses;

    private BooleanClause lastClause;

    private final QueryCustomizer queryCustomizer;

    private MinimumShouldMatchContextImpl minimumShouldMatchContext;

    BooleanQueryBuilder(QueryBuildingContext queryContext) {
        this.queryContext = queryContext;
        clauses = new ArrayList<>(5);
        queryCustomizer = new QueryCustomizer();
    }

    @Override
    public BooleanJunction not() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BooleanJunction disableScoring() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void replaceLastMustWith(Occur replacementOccur) {
        if (lastClause == null) {
            return;
        }
        if (!lastClause.getOccur().equals(Occur.MUST)) {
            throw new AssertionFailure("Cannot negate or disable scoring on class: " + lastClause.getOccur());
        }
        final int lastIndex = clauses.size() - 1;
        clauses.set(lastIndex, new BooleanClause(lastClause.getQuery(), replacementOccur));
    }

    @Override
    public BooleanJunction should(Query query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MustJunction must(Query query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MustJunction boostedTo(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MustJunction withConstantScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MustJunction filteredBy(Query filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Query createQuery() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private SearchPredicate createPredicate() {
        final int nbrOfClauses = clauses.size();
        if (nbrOfClauses == 0) {
            throw log.booleanQueryWithoutClauses();
        }
        SearchPredicateFactory factory = queryContext.getScope().predicate();
        BooleanPredicateClausesStep<?, ?> step = factory.bool();
        for (BooleanClause clause : clauses) {
            SearchPredicate predicate = factory.extension(LuceneExtension.get()).fromLuceneQuery(clause.getQuery()).toPredicate();
            switch(clause.getOccur()) {
                case MUST:
                    step = step.must(predicate);
                    break;
                case FILTER:
                    step = step.filter(predicate);
                    break;
                case SHOULD:
                    step = step.should(predicate);
                    break;
                case MUST_NOT:
                    step = step.mustNot(predicate);
                    break;
            }
        }
        if (minimumShouldMatchContext != null) {
            minimumShouldMatchContext.applyMinimum(step);
        }
        queryCustomizer.applyScoreOptions(step);
        queryCustomizer.applyFilter(factory, step);
        return step.toPredicate();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BooleanJunction minimumShouldMatchNumber(int matchingClausesNumber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BooleanJunction minimumShouldMatchPercent(int matchingClausesPercent) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private MinimumShouldMatchContextImpl getMinimumShouldMatchContext() {
        if (minimumShouldMatchContext == null) {
            minimumShouldMatchContext = new MinimumShouldMatchContextImpl();
        }
        return minimumShouldMatchContext;
    }
}
