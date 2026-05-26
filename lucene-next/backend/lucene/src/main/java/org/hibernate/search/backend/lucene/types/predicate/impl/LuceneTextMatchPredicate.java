/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.predicate.impl;

import org.hibernate.search.backend.lucene.analysis.model.impl.LuceneAnalysisDefinitionRegistry;
import org.hibernate.search.backend.lucene.logging.impl.AnalysisLog;
import org.hibernate.search.backend.lucene.lowlevel.common.impl.AnalyzerConstants;
import org.hibernate.search.backend.lucene.lowlevel.query.impl.FuzzyQueryBuilder;
import org.hibernate.search.backend.lucene.search.common.impl.AbstractLuceneCodecAwareSearchQueryElementFactory;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexValueFieldContext;
import org.hibernate.search.backend.lucene.search.predicate.impl.AbstractLuceneLeafSingleFieldPredicate;
import org.hibernate.search.backend.lucene.search.predicate.impl.LuceneCommonMinimumShouldMatchConstraints;
import org.hibernate.search.backend.lucene.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.backend.lucene.types.codec.impl.LuceneFieldCodec;
import org.hibernate.search.engine.search.common.ValueModel;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.MatchPredicateBuilder;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.MatchNoDocsQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.util.QueryBuilder;

public class LuceneTextMatchPredicate extends AbstractLuceneLeafSingleFieldPredicate {

    private LuceneTextMatchPredicate(Builder<?> builder) {
        super(builder);
    }

    public static class Factory<F> extends AbstractLuceneCodecAwareSearchQueryElementFactory<MatchPredicateBuilder, F, LuceneFieldCodec<F, String>> {

        public Factory(LuceneFieldCodec<F, String> codec) {
            super(codec);
        }

        @Override
        public Builder<F> create(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Builder<F> extends AbstractBuilder<F> implements MatchPredicateBuilder {

        private final LuceneFieldCodec<F, String> codec;

        private final LuceneAnalysisDefinitionRegistry analysisDefinitionRegistry;

        private final LuceneCommonMinimumShouldMatchConstraints minimumShouldMatchConstraints;

        private String value;

        private Integer maxEditDistance;

        private Integer prefixLength;

        private Analyzer overrideAnalyzerOrNormalizer;

        private Builder(LuceneFieldCodec<F, String> codec, LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field) {
            super(scope, field);
            this.codec = codec;
            this.analysisDefinitionRegistry = scope.analysisDefinitionRegistry();
            this.minimumShouldMatchConstraints = new LuceneCommonMinimumShouldMatchConstraints();
        }

        @Override
        public void value(Object value, ValueModel valueModel) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void fuzzy(int maxEditDistance, int exactPrefixLength) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void analyzer(String analyzerName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void skipAnalysis() {
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
        public SearchPredicate build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Query buildQuery(PredicateRequestContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
