/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.common.impl;

import java.util.List;
import org.hibernate.search.backend.lucene.types.codec.impl.LuceneFieldCodec;
import org.hibernate.search.engine.search.common.spi.AbstractMultiIndexSearchIndexValueFieldContext;
import org.hibernate.search.engine.search.common.spi.SearchIndexSchemaElementContextHelper;
import org.apache.lucene.analysis.Analyzer;

public class LuceneMultiIndexSearchIndexValueFieldContext<F> extends AbstractMultiIndexSearchIndexValueFieldContext<LuceneSearchIndexValueFieldContext<F>, LuceneSearchIndexScope<?>, LuceneSearchIndexValueFieldTypeContext<F>, F> implements LuceneSearchIndexValueFieldContext<F>, LuceneSearchIndexValueFieldTypeContext<F> {

    public LuceneMultiIndexSearchIndexValueFieldContext(LuceneSearchIndexScope<?> scope, String absolutePath, List<? extends LuceneSearchIndexValueFieldContext<F>> fieldForEachIndex) {
        super(scope, absolutePath, fieldForEachIndex);
    }

    @Override
    protected LuceneSearchIndexValueFieldContext<F> self() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected LuceneSearchIndexValueFieldTypeContext<F> selfAsNodeType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected LuceneSearchIndexValueFieldTypeContext<F> typeOf(LuceneSearchIndexValueFieldContext<F> indexElement) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneSearchIndexCompositeNodeContext toComposite() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneSearchIndexCompositeNodeContext toObjectField() {
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
    public LuceneFieldCodec<F, ?> codec() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LuceneSearchEncodingContext<F> encodingContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
