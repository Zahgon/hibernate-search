/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.predicate.impl;

import org.hibernate.search.backend.lucene.search.common.impl.AbstractLuceneCodecAwareSearchQueryElementFactory;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexValueFieldContext;
import org.hibernate.search.backend.lucene.types.codec.impl.LuceneFieldCodec;
import org.hibernate.search.engine.search.predicate.spi.CommonQueryStringPredicateBuilder;

public final class LuceneCommonQueryStringPredicateBuilderFieldState implements CommonQueryStringPredicateBuilder.FieldState {

    private final LuceneSearchIndexValueFieldContext<?> field;

    private Float boost;

    private LuceneCommonQueryStringPredicateBuilderFieldState(LuceneSearchIndexValueFieldContext<?> field) {
        this.field = field;
    }

    @Override
    public void boost(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public LuceneSearchIndexValueFieldContext<?> field() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Float boost() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Factory<T, C extends LuceneFieldCodec<T, ?>> extends AbstractLuceneCodecAwareSearchQueryElementFactory<LuceneCommonQueryStringPredicateBuilderFieldState, T, C> {

        public Factory(C codec) {
            super(codec);
        }

        @Override
        public LuceneCommonQueryStringPredicateBuilderFieldState create(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<T> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
