/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.predicate.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Predicate;
import org.hibernate.search.backend.lucene.analysis.impl.ScopedAnalyzer;
import org.hibernate.search.backend.lucene.analysis.model.impl.LuceneAnalysisDefinitionRegistry;
import org.hibernate.search.backend.lucene.logging.impl.AnalysisLog;
import org.hibernate.search.backend.lucene.lowlevel.common.impl.AnalyzerConstants;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.types.predicate.impl.LuceneCommonQueryStringPredicateBuilderFieldState;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.engine.search.common.BooleanOperator;
import org.hibernate.search.engine.search.common.spi.SearchIndexSchemaElementContextHelper;
import org.hibernate.search.engine.search.common.spi.SearchQueryElementTypeKey;
import org.hibernate.search.engine.search.predicate.spi.CommonQueryStringPredicateBuilder;
import org.hibernate.search.util.common.SearchException;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;

abstract class LuceneCommonQueryStringPredicate extends AbstractLuceneNestablePredicate {

    private final List<String> nestedPathHierarchy;

    private final List<String> fieldPaths;

    private final Builder builder;

    protected LuceneCommonQueryStringPredicate(Builder builder) {
        super(builder);
        nestedPathHierarchy = builder.firstFieldState.field().nestedPathHierarchy();
        fieldPaths = new ArrayList<>(builder.fieldStates.keySet());
        this.builder = builder;
    }

    static void checkFieldsAreAcceptable(String queryName, Map<String, LuceneCommonQueryStringPredicateBuilderFieldState> fieldStates) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static PredicateRequestContext contextForField(LuceneCommonQueryStringPredicateBuilderFieldState state) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Query doToQuery(PredicateRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected List<String> getNestedPathHierarchy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected List<String> getFieldPathsForErrorMessage() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public abstract static class Builder extends AbstractBuilder implements CommonQueryStringPredicateBuilder {

        private final LuceneAnalysisDefinitionRegistry analysisDefinitionRegistry;

        private LuceneCommonQueryStringPredicateBuilderFieldState firstFieldState;

        private final Map<String, LuceneCommonQueryStringPredicateBuilderFieldState> fieldStates = new LinkedHashMap<>();

        protected BooleanOperator defaultOperator = BooleanOperator.OR;

        protected String queryString;

        private Analyzer overrideAnalyzer;

        private boolean ignoreAnalyzer = false;

        protected final LuceneCommonMinimumShouldMatchConstraints minimumShouldMatchConstraints;

        Builder(LuceneSearchIndexScope<?> scope) {
            super(scope);
            this.analysisDefinitionRegistry = scope.analysisDefinitionRegistry();
            this.minimumShouldMatchConstraints = new LuceneCommonMinimumShouldMatchConstraints();
        }

        @Override
        public void defaultOperator(BooleanOperator operator) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public FieldState field(String fieldPath) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void queryString(String queryString) {
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

        protected Query addMatchAllForBoolMustNotOnly(Query query) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected abstract Query buildQuery(PredicateRequestContext context);

        protected abstract SearchQueryElementTypeKey<LuceneCommonQueryStringPredicateBuilderFieldState> typeKey();

        protected Analyzer buildAnalyzer() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected Map<String, Float> buildWeights() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected Map<String, LuceneCommonQueryStringPredicateBuilderFieldState> fieldStateLookup() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
