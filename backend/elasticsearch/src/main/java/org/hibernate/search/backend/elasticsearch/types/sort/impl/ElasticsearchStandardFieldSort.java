/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.sort.impl;

import java.time.temporal.TemporalAccessor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.logging.impl.QueryLog;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.DataTypes;
import org.hibernate.search.backend.elasticsearch.search.common.impl.AbstractElasticsearchCodecAwareSearchQueryElementFactory;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexValueFieldContext;
import org.hibernate.search.backend.elasticsearch.search.sort.impl.ElasticsearchSearchSortCollector;
import org.hibernate.search.backend.elasticsearch.types.codec.impl.ElasticsearchFieldCodec;
import org.hibernate.search.engine.search.common.SortMode;
import org.hibernate.search.engine.search.common.ValueModel;
import org.hibernate.search.engine.search.sort.SearchSort;
import org.hibernate.search.engine.search.sort.dsl.SortOrder;
import org.hibernate.search.engine.search.sort.spi.FieldSortBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class ElasticsearchStandardFieldSort extends AbstractElasticsearchDocumentValueSort {

    private static final JsonAccessor<JsonElement> MISSING_ACCESSOR = JsonAccessor.root().property("missing");

    private static final JsonPrimitive MISSING_FIRST_KEYWORD_JSON = new JsonPrimitive("_first");

    private static final JsonPrimitive MISSING_LAST_KEYWORD_JSON = new JsonPrimitive("_last");

    private static final JsonPrimitive MISSING_HIGHEST_KEYWORD_JSON = new JsonPrimitive("_highest_wont_work");

    private static final JsonPrimitive MISSING_LOWEST_KEYWORD_JSON = new JsonPrimitive("_lowest_wont_work");

    private static final JsonAccessor<JsonElement> UNMAPPED_TYPE = JsonAccessor.root().property("unmapped_type");

    private final JsonElement missing;

    private final JsonPrimitive unmappedType;

    private ElasticsearchStandardFieldSort(Builder<?> builder) {
        super(builder);
        missing = builder.missing;
        unmappedType = builder.field.type().elasticsearchTypeAsJson();
    }

    @Override
    public void doToJsonSorts(ElasticsearchSearchSortCollector collector, JsonObject innerObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Factory<F> extends AbstractElasticsearchCodecAwareSearchQueryElementFactory<FieldSortBuilder, F> {

        public Factory(ElasticsearchFieldCodec<F> codec) {
            super(codec);
        }

        @Override
        public Builder<F> create(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<F> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Builder<F> extends AbstractBuilder<F> implements FieldSortBuilder {

        private final ElasticsearchFieldCodec<F> codec;

        private JsonElement missing;

        protected Builder(ElasticsearchFieldCodec<F> codec, ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<F> field) {
            super(scope, field);
            this.codec = codec;
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

        @Override
        public SearchSort build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class TemporalFieldFactory<F extends TemporalAccessor> extends Factory<F> {

        public TemporalFieldFactory(ElasticsearchFieldCodec<F> codec) {
            super(codec);
        }

        @Override
        public TemporalFieldBuilder<F> create(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<F> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class TemporalFieldBuilder<F extends TemporalAccessor> extends Builder<F> {

        private TemporalFieldBuilder(ElasticsearchFieldCodec<F> codec, ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<F> field) {
            super(codec, scope, field);
        }

        @Override
        public void mode(SortMode mode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class TextFieldFactory extends Factory<String> {

        public TextFieldFactory(ElasticsearchFieldCodec<String> codec) {
            super(codec);
        }

        @Override
        public TextFieldBuilder create(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<String> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class TextFieldBuilder extends Builder<String> {

        private TextFieldBuilder(ElasticsearchFieldCodec<String> codec, ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<String> field) {
            super(codec, scope, field);
        }

        @Override
        public void mode(SortMode mode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
