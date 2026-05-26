/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.predicate.impl;

import org.hibernate.search.backend.lucene.analysis.model.impl.LuceneAnalysisDefinitionRegistry;
import org.hibernate.search.backend.lucene.logging.impl.AnalysisLog;
import org.hibernate.search.backend.lucene.lowlevel.common.impl.AnalyzerConstants;
import org.hibernate.search.backend.lucene.search.common.impl.AbstractLuceneValueFieldSearchQueryElementFactory;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexValueFieldContext;
import org.hibernate.search.backend.lucene.search.predicate.impl.AbstractLuceneLeafSingleFieldPredicate;
import org.hibernate.search.backend.lucene.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.PhrasePredicateBuilder;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.MatchNoDocsQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.util.QueryBuilder;

public class LuceneTextPhrasePredicate extends AbstractLuceneLeafSingleFieldPredicate {

    private LuceneTextPhrasePredicate(Builder<?> builder) {
        super(builder);
    }

    public static class Factory<F> extends AbstractLuceneValueFieldSearchQueryElementFactory<PhrasePredicateBuilder, F> {

        @Override
        public Builder<F> create(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Builder<F> extends AbstractBuilder<F> implements PhrasePredicateBuilder {

        private final LuceneAnalysisDefinitionRegistry analysisDefinitionRegistry;

        private int slop;

        private String phrase;

        private Analyzer overrideAnalyzer;

        private Builder(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field) {
            super(scope, field);
            this.analysisDefinitionRegistry = scope.analysisDefinitionRegistry();
        }

        @Override
        public void slop(int slop) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void phrase(String phrase) {
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
        public SearchPredicate build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Query buildQuery(PredicateRequestContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
