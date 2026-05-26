/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.predicate.impl;

import org.hibernate.search.backend.lucene.search.common.impl.AbstractLuceneValueFieldSearchQueryElementFactory;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexValueFieldContext;
import org.hibernate.search.backend.lucene.search.predicate.impl.AbstractLuceneLeafSingleFieldPredicate;
import org.hibernate.search.backend.lucene.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.backend.lucene.types.predicate.parse.impl.LuceneWildcardExpressionHelper;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.WildcardPredicateBuilder;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.util.BytesRef;

public class LuceneTextWildcardPredicate extends AbstractLuceneLeafSingleFieldPredicate {

    private LuceneTextWildcardPredicate(Builder<?> builder) {
        super(builder);
    }

    public static class Factory<F> extends AbstractLuceneValueFieldSearchQueryElementFactory<WildcardPredicateBuilder, F> {

        @Override
        public Builder<F> create(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Builder<F> extends AbstractBuilder<F> implements WildcardPredicateBuilder {

        private final Analyzer analyzerOrNormalizer;

        private String pattern;

        private Builder(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field) {
            super(scope, field);
            this.analyzerOrNormalizer = field.type().searchAnalyzerOrNormalizer();
        }

        @Override
        public void pattern(String wildcardPattern) {
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
