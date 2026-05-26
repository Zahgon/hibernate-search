/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.predicate.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.search.backend.lucene.search.common.impl.AbstractLuceneCodecAwareSearchQueryElementFactory;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexValueFieldContext;
import org.hibernate.search.backend.lucene.search.predicate.impl.AbstractLuceneLeafSingleFieldPredicate;
import org.hibernate.search.backend.lucene.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.backend.lucene.types.codec.impl.AbstractLuceneNumericFieldCodec;
import org.hibernate.search.engine.search.common.ValueModel;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.TermsPredicateBuilder;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;

public class LuceneNumericTermsPredicate extends AbstractLuceneLeafSingleFieldPredicate {

    private LuceneNumericTermsPredicate(Builder<?, ?> builder) {
        super(builder);
    }

    public static class Factory<F, E extends Number> extends AbstractLuceneCodecAwareSearchQueryElementFactory<TermsPredicateBuilder, F, AbstractLuceneNumericFieldCodec<F, E>> {

        public Factory(AbstractLuceneNumericFieldCodec<F, E> codec) {
            super(codec);
        }

        @Override
        public Builder<F, E> create(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Builder<F, E extends Number> extends AbstractBuilder<F> implements TermsPredicateBuilder {

        private final AbstractLuceneNumericFieldCodec<F, E> codec;

        private E term;

        private List<E> terms;

        private boolean allMatch;

        private Builder(AbstractLuceneNumericFieldCodec<F, E> codec, LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field) {
            super(scope, field);
            // Score is always constant for this query
            constantScore();
            this.codec = codec;
        }

        @Override
        public void matchingAny(Collection<?> terms, ValueModel valueModel) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void matchingAll(Collection<?> terms, ValueModel valueModel) {
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

        private void fillTerms(Collection<?> terms, ValueModel valueModel) {
            if (terms.size() == 1) {
                this.term = convertAndEncode(codec, terms.iterator().next(), valueModel);
                this.terms = null;
                return;
            }
            this.term = null;
            this.terms = new ArrayList<>(terms.size());
            for (Object termItem : terms) {
                this.terms.add(convertAndEncode(codec, termItem, valueModel));
            }
        }
    }
}
