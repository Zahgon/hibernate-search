/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.common.spi;

import java.util.List;
import java.util.Objects;
import org.hibernate.search.engine.backend.types.converter.spi.DslConverter;
import org.hibernate.search.engine.backend.types.converter.spi.ProjectionConverter;
import org.hibernate.search.engine.search.highlighter.spi.SearchHighlighterType;

public abstract class AbstractMultiIndexSearchIndexValueFieldContext<S extends SearchIndexValueFieldContext<SC>, SC extends SearchIndexScope<?>, FT extends SearchIndexValueFieldTypeContext<SC, S, F>, F> extends AbstractMultiIndexSearchIndexNodeContext<S, SC, FT> implements SearchIndexValueFieldContext<SC>, SearchIndexValueFieldTypeContext<SC, S, F> {

    public AbstractMultiIndexSearchIndexValueFieldContext(SC scope, String absolutePath, List<? extends S> fieldForEachIndex) {
        super(scope, absolutePath, fieldForEachIndex);
    }

    @Override
    public final FT type() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final boolean isComposite() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isObjectField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final boolean isValueField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchIndexCompositeNodeContext<SC> toComposite() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchIndexCompositeNodeContext<SC> toObjectField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final S toValueField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    final SearchIndexSchemaElementContextHelper helper() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Class<F> valueClass() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final DslConverter<?, F> mappingDslConverter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final DslConverter<F, F> indexDslConverter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DslConverter<?, ?> rawDslConverter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final ProjectionConverter<F, ?> mappingProjectionConverter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final ProjectionConverter<F, F> indexProjectionConverter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectionConverter<?, ?> rawProjectionConverter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DslConverter<?, F> parserDslConverter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectionConverter<F, ?> formatterProjectionConverter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean highlighterTypeSupported(SearchHighlighterType type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
