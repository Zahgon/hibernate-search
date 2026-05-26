/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.predicate.impl;

import java.util.function.Function;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.engine.search.common.NamedValues;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.PredicateFinalStep;
import org.hibernate.search.engine.search.predicate.spi.WithParametersPredicateBuilder;
import org.apache.lucene.search.Query;

public class LuceneWithParametersPredicate extends AbstractLuceneSearchPredicate {

    private final LuceneSearchIndexScope<?> scope;

    private final Function<? super NamedValues, ? extends PredicateFinalStep> predicateCreator;

    private LuceneWithParametersPredicate(Builder builder) {
        super(builder);
        scope = builder.scope;
        predicateCreator = builder.predicateCreator;
    }

    @Override
    protected Query doToQuery(PredicateRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void checkNestableWithin(String expectedParentNestedPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder extends AbstractBuilder implements WithParametersPredicateBuilder {

        private Function<? super NamedValues, ? extends PredicateFinalStep> predicateCreator;

        Builder(LuceneSearchIndexScope<?> scope) {
            super(scope);
        }

        @Override
        public void creator(Function<? super NamedValues, ? extends PredicateFinalStep> creator) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchPredicate build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
