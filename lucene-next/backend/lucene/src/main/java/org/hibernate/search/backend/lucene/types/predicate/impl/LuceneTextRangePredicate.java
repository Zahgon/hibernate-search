/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.predicate.impl;

import org.hibernate.search.backend.lucene.search.common.impl.AbstractLuceneCodecAwareSearchQueryElementFactory;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexValueFieldContext;
import org.hibernate.search.backend.lucene.search.predicate.impl.AbstractLuceneLeafSingleFieldPredicate;
import org.hibernate.search.backend.lucene.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.backend.lucene.types.codec.impl.LuceneFieldCodec;
import org.hibernate.search.engine.search.common.ValueModel;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.RangePredicateBuilder;
import org.hibernate.search.util.common.data.Range;
import org.hibernate.search.util.common.data.RangeBoundInclusion;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermRangeQuery;
import org.apache.lucene.util.BytesRef;

public class LuceneTextRangePredicate extends AbstractLuceneLeafSingleFieldPredicate {

    private LuceneTextRangePredicate(Builder<?> builder) {
        super(builder);
    }

    public static class Factory<F> extends AbstractLuceneCodecAwareSearchQueryElementFactory<RangePredicateBuilder, F, LuceneFieldCodec<F, String>> {

        public Factory(LuceneFieldCodec<F, String> codec) {
            super(codec);
        }

        @Override
        public Builder<F> create(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Builder<F> extends AbstractBuilder<F> implements RangePredicateBuilder {

        private final LuceneFieldCodec<F, String> codec;

        private Range<String> range;

        private Builder(LuceneFieldCodec<F, String> codec, LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field) {
            super(scope, field);
            this.codec = codec;
        }

        @Override
        public void within(Range<?> range, ValueModel lowerBoundModel, ValueModel upperBoundModel) {
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

        private BytesRef normalize(String value) {
            if (value == null) {
                return null;
            }
            Analyzer searchAnalyzerOrNormalizer = field.type().searchAnalyzerOrNormalizer();
            return searchAnalyzerOrNormalizer.normalize(absoluteFieldPath, value);
        }
    }
}
