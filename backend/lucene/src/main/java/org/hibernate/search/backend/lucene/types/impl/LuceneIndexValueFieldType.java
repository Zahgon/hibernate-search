/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.impl;

import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexValueFieldContext;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexValueFieldTypeContext;
import org.hibernate.search.backend.lucene.types.codec.impl.LuceneFieldCodec;
import org.hibernate.search.engine.backend.types.IndexFieldType;
import org.hibernate.search.engine.backend.types.converter.spi.DslConverter;
import org.hibernate.search.engine.backend.types.converter.spi.ProjectionConverter;
import org.hibernate.search.engine.backend.types.spi.AbstractIndexValueFieldType;
import org.apache.lucene.analysis.Analyzer;

public final class LuceneIndexValueFieldType<F> extends AbstractIndexValueFieldType<LuceneSearchIndexScope<?>, LuceneSearchIndexValueFieldContext<F>, F> implements IndexFieldType<F>, LuceneSearchIndexValueFieldTypeContext<F> {

    private final LuceneFieldCodec<F, ?> codec;

    private final Analyzer indexingAnalyzerOrNormalizer;

    private final Analyzer searchAnalyzerOrNormalizer;

    private final boolean hasTermVectorsConfigured;

    private final ProjectionConverter<?, ?> rawProjectionConverter;

    private final DslConverter<?, ?> rawDslConverter;

    private LuceneIndexValueFieldType(Builder<F> builder) {
        super(builder);
        this.codec = builder.codec;
        this.indexingAnalyzerOrNormalizer = builder.indexingAnalyzerOrNormalizer;
        this.searchAnalyzerOrNormalizer = builder.searchAnalyzerOrNormalizer;
        this.hasTermVectorsConfigured = builder.hasTermVectorsConfigured;
        this.rawProjectionConverter = ProjectionConverter.passThrough(codec.encodedType());
        this.rawDslConverter = DslConverter.passThrough(codec.encodedType());
    }

    @Override
    public LuceneFieldCodec<F, ?> codec() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Analyzer indexingAnalyzerOrNormalizer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Analyzer searchAnalyzerOrNormalizer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean hasTermVectorsConfigured() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DslConverter<?, ?> rawDslConverter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectionConverter<?, ?> rawProjectionConverter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder<F> extends AbstractIndexValueFieldType.Builder<LuceneSearchIndexScope<?>, LuceneSearchIndexValueFieldContext<F>, F> {

        private LuceneFieldCodec<F, ?> codec;

        private Analyzer indexingAnalyzerOrNormalizer;

        private Analyzer searchAnalyzerOrNormalizer;

        private boolean hasTermVectorsConfigured;

        public Builder(Class<F> valueClass) {
            super(valueClass);
        }

        public void codec(LuceneFieldCodec<F, ?> codec) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void indexingAnalyzerOrNormalizer(Analyzer analyzer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Analyzer indexingAnalyzerOrNormalizer() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void searchAnalyzerOrNormalizer(Analyzer analyzer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void hasTermVectorsConfigured(boolean hasTermVectorsConfigured) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public LuceneIndexValueFieldType<F> build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
