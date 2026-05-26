/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.sort.impl;

import java.time.temporal.TemporalAccessor;
import org.hibernate.search.backend.lucene.logging.impl.QueryLog;
import org.hibernate.search.backend.lucene.lowlevel.docvalues.impl.MultiValueMode;
import org.hibernate.search.backend.lucene.search.common.impl.AbstractLuceneCodecAwareSearchQueryElementFactory;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexValueFieldContext;
import org.hibernate.search.backend.lucene.types.codec.impl.AbstractLuceneNumericFieldCodec;
import org.hibernate.search.backend.lucene.types.codec.impl.LuceneFieldCodec;
import org.hibernate.search.backend.lucene.types.lowlevel.impl.LuceneNumericDomain;
import org.hibernate.search.backend.lucene.types.sort.comparatorsource.impl.LuceneFieldComparatorSource;
import org.hibernate.search.backend.lucene.types.sort.comparatorsource.impl.LuceneNumericFieldComparatorSource;
import org.hibernate.search.backend.lucene.types.sort.comparatorsource.impl.LuceneTextFieldComparatorSource;
import org.hibernate.search.engine.search.common.SortMode;
import org.hibernate.search.engine.search.common.ValueModel;
import org.hibernate.search.engine.search.sort.SearchSort;
import org.hibernate.search.engine.search.sort.dsl.SortOrder;
import org.hibernate.search.engine.search.sort.spi.FieldSortBuilder;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.SortField;
import org.apache.lucene.util.BytesRef;

public abstract class LuceneStandardFieldSort extends AbstractLuceneDocumentValueSort {

    private LuceneStandardFieldSort(AbstractBuilder<?, ?, ?> builder) {
        super(builder);
    }

    abstract static class AbstractFactory<F, E, C extends LuceneFieldCodec<F, E>> extends AbstractLuceneCodecAwareSearchQueryElementFactory<FieldSortBuilder, F, C> {

        protected AbstractFactory(C codec) {
            super(codec);
        }
    }

    /**
     * @param <F> The field type exposed to the mapper.
     * @param <E> The encoded type.
     * @param <C> The codec type.
     * @see LuceneFieldCodec
     */
    abstract static class AbstractBuilder<F, E, C extends LuceneFieldCodec<F, E>> extends AbstractLuceneDocumentValueSort.AbstractBuilder implements FieldSortBuilder {

        protected final LuceneSearchIndexValueFieldContext<F> field;

        protected final C codec;

        private final Object sortMissingValueFirstPlaceholder;

        private final Object sortMissingValueLastPlaceholder;

        protected Object missingValue = SortMissingValue.MISSING_LAST;

        protected AbstractBuilder(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field, C codec, Object sortMissingValueFirstPlaceholder, Object sortMissingValueLastPlaceholder) {
            super(scope, field);
            this.field = field;
            this.codec = codec;
            this.sortMissingValueFirstPlaceholder = sortMissingValueFirstPlaceholder;
            this.sortMissingValueLastPlaceholder = sortMissingValueLastPlaceholder;
        }

        @Override
        public void missingFirst() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void missingLast() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void missingHighest() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void missingLowest() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void missingAs(Object value, ValueModel valueModel) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected Object mapMissingAs(E encoded) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @SuppressWarnings("unchecked")
        protected final E getEffectiveMissingValue() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class NumericFieldFactory<F, E extends Number> extends AbstractFactory<F, E, AbstractLuceneNumericFieldCodec<F, E>> {

        public NumericFieldFactory(AbstractLuceneNumericFieldCodec<F, E> codec) {
            super(codec);
        }

        @Override
        public FieldSortBuilder create(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class NumericFieldBuilder<F, E extends Number> extends AbstractBuilder<F, E, AbstractLuceneNumericFieldCodec<F, E>> {

        private NumericFieldBuilder(AbstractLuceneNumericFieldCodec<F, E> codec, LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field) {
            super(scope, field, codec, codec.getDomain().getMinValue(), codec.getDomain().getMaxValue());
        }

        @Override
        public SearchSort build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class NumericFieldSort<E extends Number> extends LuceneStandardFieldSort {

        private final LuceneNumericDomain<E> domain;

        private final E effectiveMissingValue;

        private NumericFieldSort(NumericFieldBuilder<?, E> builder) {
            super(builder);
            domain = builder.codec.getDomain();
            effectiveMissingValue = builder.getEffectiveMissingValue();
        }

        @Override
        protected LuceneFieldComparatorSource doCreateFieldComparatorSource(String nestedDocumentPath, MultiValueMode multiValueMode, Query nestedFilter) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class TextFieldFactory<F> extends AbstractFactory<F, String, LuceneFieldCodec<F, String>> {

        public TextFieldFactory(LuceneFieldCodec<F, String> codec) {
            super(codec);
        }

        @Override
        public FieldSortBuilder create(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class TextFieldBuilder<F> extends AbstractBuilder<F, String, LuceneFieldCodec<F, String>> {

        private TextFieldBuilder(LuceneFieldCodec<F, String> codec, LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field) {
            super(scope, field, codec, SortField.STRING_FIRST, SortField.STRING_LAST);
        }

        @Override
        protected Object mapMissingAs(String encoded) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void mode(SortMode mode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private BytesRef normalize(String value) {
            if (value == null) {
                return null;
            }
            Analyzer searchAnalyzerOrNormalizer = field.type().searchAnalyzerOrNormalizer();
            return searchAnalyzerOrNormalizer.normalize(absoluteFieldPath, value);
        }

        @Override
        public SearchSort build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class TextFieldSort extends LuceneStandardFieldSort {

        private final Object effectiveMissingValue;

        private TextFieldSort(TextFieldBuilder<?> builder) {
            super(builder);
            effectiveMissingValue = builder.missingValue;
        }

        @Override
        protected LuceneFieldComparatorSource doCreateFieldComparatorSource(String nestedDocumentPath, MultiValueMode multiValueMode, Query nestedFilter) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class TemporalFieldFactory<F extends TemporalAccessor, E extends Number> extends AbstractFactory<F, E, AbstractLuceneNumericFieldCodec<F, E>> {

        public TemporalFieldFactory(AbstractLuceneNumericFieldCodec<F, E> codec) {
            super(codec);
        }

        @Override
        public FieldSortBuilder create(LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class TemporalFieldBuilder<F extends TemporalAccessor, E extends Number> extends NumericFieldBuilder<F, E> {

        private TemporalFieldBuilder(AbstractLuceneNumericFieldCodec<F, E> codec, LuceneSearchIndexScope<?> scope, LuceneSearchIndexValueFieldContext<F> field) {
            super(codec, scope, field);
        }

        @Override
        public void mode(SortMode mode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
