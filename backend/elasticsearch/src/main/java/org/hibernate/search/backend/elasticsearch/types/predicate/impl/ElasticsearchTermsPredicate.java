/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.predicate.impl;

import java.util.Collection;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonAccessor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonArrayAccessor;
import org.hibernate.search.backend.elasticsearch.gson.impl.JsonObjectAccessor;
import org.hibernate.search.backend.elasticsearch.search.common.impl.AbstractElasticsearchCodecAwareSearchQueryElementFactory;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexScope;
import org.hibernate.search.backend.elasticsearch.search.common.impl.ElasticsearchSearchIndexValueFieldContext;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.AbstractElasticsearchSingleFieldPredicate;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.backend.elasticsearch.types.codec.impl.ElasticsearchFieldCodec;
import org.hibernate.search.engine.search.common.ValueModel;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.TermsPredicateBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ElasticsearchTermsPredicate extends AbstractElasticsearchSingleFieldPredicate {

    private static final JsonObjectAccessor TERMS_ACCESSOR = JsonAccessor.root().property("terms").asObject();

    private static final JsonObjectAccessor TERM_ACCESSOR = JsonAccessor.root().property("term").asObject();

    // for boolean query:
    private static final JsonObjectAccessor BOOL_ACCESSOR = JsonAccessor.root().property("bool").asObject();

    private static final JsonArrayAccessor MUST_ACCESSOR = JsonAccessor.root().property("must").asArray();

    private static final JsonAccessor<JsonElement> VALUE_ACCESSOR = JsonAccessor.root().property("value");

    private final JsonElement term;

    private final JsonElement[] terms;

    private boolean allMatch;

    public ElasticsearchTermsPredicate(Builder<?> builder) {
        super(builder);
        this.term = builder.term;
        this.terms = builder.terms;
        this.allMatch = builder.allMatch;
    }

    @Override
    protected JsonObject doToJsonQuery(PredicateRequestContext context, JsonObject outerObject, JsonObject innerObject) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Factory<F> extends AbstractElasticsearchCodecAwareSearchQueryElementFactory<TermsPredicateBuilder, F> {

        public Factory(ElasticsearchFieldCodec<F> codec) {
            super(codec);
        }

        @Override
        public TermsPredicateBuilder create(ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<F> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Builder<F> extends AbstractBuilder implements TermsPredicateBuilder {

        private final ElasticsearchSearchIndexValueFieldContext<F> field;

        private final ElasticsearchFieldCodec<F> codec;

        private JsonElement term;

        private JsonElement[] terms;

        private boolean allMatch;

        private Builder(ElasticsearchFieldCodec<F> codec, ElasticsearchSearchIndexScope<?> scope, ElasticsearchSearchIndexValueFieldContext<F> field) {
            super(scope, field);
            // Score is always constant for this query
            constantScore();
            this.field = field;
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

        private void fillTerms(Collection<?> terms, ValueModel valueModel) {
            if (terms.size() == 1) {
                this.term = encode(terms.iterator().next(), valueModel);
                this.terms = null;
                return;
            }
            this.term = null;
            this.terms = encode(terms, valueModel);
        }

        private JsonElement[] encode(Collection<?> terms, ValueModel valueModel) {
            JsonElement[] result = new JsonElement[terms.size()];
            int i = 0;
            for (Object term : terms) {
                result[i++] = encode(term, valueModel);
            }
            return result;
        }

        private JsonElement encode(Object term, ValueModel valueModel) {
            return field.encodingContext().convertAndEncode(scope, field, term, valueModel, ElasticsearchFieldCodec::encode);
        }
    }
}
