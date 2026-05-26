/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.predicate.impl;

import java.util.Map;
import org.hibernate.search.backend.lucene.logging.impl.QueryLog;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.types.predicate.impl.LuceneCommonQueryStringPredicateBuilderFieldState;
import org.hibernate.search.engine.search.common.BooleanOperator;
import org.hibernate.search.engine.search.common.RewriteMethod;
import org.hibernate.search.engine.search.common.ValueModel;
import org.hibernate.search.engine.search.common.spi.SearchQueryElementTypeKey;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;
import org.hibernate.search.engine.search.predicate.spi.QueryStringPredicateBuilder;
import org.hibernate.search.util.common.AssertionFailure;
import org.hibernate.search.util.common.data.RangeBoundInclusion;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.MatchNoDocsQuery;
import org.apache.lucene.search.MultiTermQuery;
import org.apache.lucene.search.Query;

public class LuceneQueryStringPredicate extends LuceneCommonQueryStringPredicate {

    private LuceneQueryStringPredicate(Builder builder) {
        super(builder);
    }

    public static class Builder extends LuceneCommonQueryStringPredicate.Builder implements QueryStringPredicateBuilder {

        private Boolean allowLeadingWildcard = true;

        private Boolean enablePositionIncrements = true;

        private Integer phraseSlop;

        private RewriteMethod rewriteMethod;

        private Integer rewriteN;

        Builder(LuceneSearchIndexScope<?> scope) {
            super(scope);
        }

        @Override
        public void allowLeadingWildcard(boolean allowLeadingWildcard) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void enablePositionIncrements(boolean enablePositionIncrements) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void phraseSlop(Integer phraseSlop) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void rewriteMethod(RewriteMethod rewriteMethod, Integer n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchPredicate build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected SearchQueryElementTypeKey<LuceneCommonQueryStringPredicateBuilderFieldState> typeKey() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Query buildQuery(PredicateRequestContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private MultiFieldQueryParser create(Map<String, Float> weights, Analyzer analyzer, Map<String, LuceneCommonQueryStringPredicateBuilderFieldState> fieldStateMap) {
            return new HibernateSearchMultiFieldQueryParser(analyzer, weights, fieldStateMap, scope);
        }

        private MultiTermQuery.RewriteMethod toRewriteMethod(RewriteMethod rewriteMethod, Integer n) {
            switch(rewriteMethod) {
                case CONSTANT_SCORE:
                    return MultiTermQuery.CONSTANT_SCORE_REWRITE;
                case CONSTANT_SCORE_BOOLEAN:
                    return MultiTermQuery.CONSTANT_SCORE_BOOLEAN_REWRITE;
                case SCORING_BOOLEAN:
                    return MultiTermQuery.SCORING_BOOLEAN_REWRITE;
                case TOP_TERMS_BLENDED_FREQS_N:
                    return new MultiTermQuery.TopTermsBlendedFreqScoringRewrite(n);
                case TOP_TERMS_BOOST_N:
                    return new MultiTermQuery.TopTermsBoostOnlyBooleanQueryRewrite(n);
                case TOP_TERMS_N:
                    return new MultiTermQuery.TopTermsScoringBooleanQueryRewrite(n);
                default:
                    throw new AssertionFailure("Unknown rewrite: " + rewriteMethod);
            }
        }

        private static QueryParser.Operator toOperator(BooleanOperator operator) {
            switch(operator) {
                case AND:
                    return QueryParser.Operator.AND;
                case OR:
                    return QueryParser.Operator.OR;
                default:
                    throw new AssertionFailure("Unknown boolean operator: " + operator);
            }
        }
    }

    private static class HibernateSearchMultiFieldQueryParser extends MultiFieldQueryParser {

        private final Map<String, LuceneCommonQueryStringPredicateBuilderFieldState> fieldStates;

        private final LuceneSearchIndexScope<?> scope;

        public HibernateSearchMultiFieldQueryParser(Analyzer analyzer, Map<String, Float> boosts, Map<String, LuceneCommonQueryStringPredicateBuilderFieldState> fieldStates, LuceneSearchIndexScope<?> scope) {
            super(boosts.keySet().toArray(String[]::new), analyzer, boosts);
            this.fieldStates = fieldStates;
            this.scope = scope;
        }

        @Override
        protected Query newFieldQuery(Analyzer analyzer, String field, String queryText, boolean quoted) throws ParseException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Query getFuzzyQuery(String field, String termStr, float minSimilarity) throws ParseException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Query getPrefixQuery(String field, String termStr) throws ParseException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Query getRegexpQuery(String field, String termStr) throws ParseException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Query getWildcardQuery(String field, String termStr) throws ParseException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Query newRangeQuery(String field, String part1, String part2, boolean startInclusive, boolean endInclusive) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
