/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.backend.types.spi;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import org.hibernate.search.engine.backend.metamodel.IndexValueFieldTypeDescriptor;
import org.hibernate.search.engine.backend.types.IndexFieldType;
import org.hibernate.search.engine.backend.types.converter.FromDocumentValueConverter;
import org.hibernate.search.engine.backend.types.converter.ToDocumentValueConverter;
import org.hibernate.search.engine.backend.types.converter.spi.DslConverter;
import org.hibernate.search.engine.backend.types.converter.spi.ProjectionConverter;
import org.hibernate.search.engine.search.common.spi.SearchIndexScope;
import org.hibernate.search.engine.search.common.spi.SearchIndexValueFieldContext;
import org.hibernate.search.engine.search.common.spi.SearchIndexValueFieldTypeContext;
import org.hibernate.search.engine.search.highlighter.spi.SearchHighlighterType;

public abstract class AbstractIndexValueFieldType<SC extends SearchIndexScope<?>, N extends SearchIndexValueFieldContext<SC>, F> extends AbstractIndexNodeType<SC, N> implements IndexValueFieldTypeDescriptor, IndexFieldType<F>, SearchIndexValueFieldTypeContext<SC, N, F> {

    private final Class<F> valueClass;

    private final DslConverter<F, F> indexDslConverter;

    private final ProjectionConverter<F, F> indexProjectionConverter;

    private final DslConverter<?, F> mappingDslConverter;

    private final ProjectionConverter<F, ?> mappingProjectionConverter;

    private final DslConverter<?, F> parseConverter;

    private final ProjectionConverter<F, ?> formatConverter;

    private final boolean searchable;

    private final boolean sortable;

    private final boolean projectable;

    private final boolean aggregable;

    private final boolean multivaluable;

    private final Set<SearchHighlighterType> allowedHighlighterTypes;

    private final String analyzerName;

    private final String searchAnalyzerName;

    private final String normalizerName;

    protected AbstractIndexValueFieldType(Builder<SC, N, F> builder) {
        super(builder);
        this.valueClass = builder.valueClass;
        this.indexDslConverter = builder.indexDslConverter;
        this.indexProjectionConverter = builder.indexProjectionConverter;
        this.mappingDslConverter = builder.mappingDslConverter != null ? builder.mappingDslConverter : indexDslConverter;
        this.mappingProjectionConverter = builder.mappingProjectionConverter != null ? builder.mappingProjectionConverter : indexProjectionConverter;
        this.parseConverter = builder.parser != null ? builder.parser : indexDslConverter;
        this.formatConverter = builder.formatter != null ? builder.formatter : indexProjectionConverter;
        this.searchable = builder.searchable;
        this.sortable = builder.sortable;
        this.projectable = builder.projectable;
        this.aggregable = builder.aggregable;
        this.multivaluable = builder.multivaluable;
        this.allowedHighlighterTypes = Collections.unmodifiableSet(builder.allowedHighlighterTypes);
        this.analyzerName = builder.analyzerName;
        this.searchAnalyzerName = builder.searchAnalyzerName != null ? builder.searchAnalyzerName : builder.analyzerName;
        this.normalizerName = builder.normalizerName;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Class<F> valueClass() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final boolean searchable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final boolean sortable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final boolean projectable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final boolean aggregable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean multivaluable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Class<?> dslArgumentClass() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final DslConverter<?, F> mappingDslConverter() {
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
    public final DslConverter<F, F> indexDslConverter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Class<?> projectedValueClass() {
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
    public final Optional<String> analyzerName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Optional<String> normalizerName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Optional<String> searchAnalyzerName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean highlighterTypeSupported(SearchHighlighterType type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public abstract static class Builder<SC extends SearchIndexScope<?>, N extends SearchIndexValueFieldContext<SC>, F> extends AbstractIndexNodeType.Builder<SC, N> {

        private final Class<F> valueClass;

        private final DslConverter<F, F> indexDslConverter;

        private final ProjectionConverter<F, F> indexProjectionConverter;

        private DslConverter<?, F> mappingDslConverter;

        private ProjectionConverter<F, ?> mappingProjectionConverter;

        private DslConverter<?, F> parser;

        private ProjectionConverter<F, ?> formatter;

        private boolean searchable;

        private boolean sortable;

        private boolean projectable;

        private boolean aggregable;

        private boolean multivaluable = true;

        private Set<SearchHighlighterType> allowedHighlighterTypes = Collections.emptySet();

        private String analyzerName;

        private String searchAnalyzerName;

        private String normalizerName;

        public Builder(Class<F> valueClass) {
            this.valueClass = valueClass;
            this.indexDslConverter = DslConverter.passThrough(valueClass);
            this.indexProjectionConverter = ProjectionConverter.passThrough(valueClass);
        }

        public final Class<F> valueClass() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public final <V> void dslConverter(Class<V> valueType, ToDocumentValueConverter<V, ? extends F> toIndexConverter) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public final <V> void projectionConverter(Class<V> valueType, FromDocumentValueConverter<? super F, V> fromIndexConverter) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public final void parser(ToDocumentValueConverter<String, ? extends F> parser) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public final void formatter(FromDocumentValueConverter<? super F, String> formatter) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public final void searchable(boolean searchable) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public final void sortable(boolean sortable) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public final void projectable(boolean projectable) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public final void aggregable(boolean aggregable) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public final void multivaluable(boolean multivaluable) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public final void allowedHighlighterTypes(Set<SearchHighlighterType> allowedHighlighterTypes) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public final void analyzerName(String analyzerName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public final void searchAnalyzerName(String searchAnalyzerName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public final void normalizerName(String normalizerName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public abstract AbstractIndexValueFieldType<SC, N, F> build();
    }
}
