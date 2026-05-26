/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.predicate.dsl.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import org.hibernate.search.engine.logging.impl.QueryLog;
import org.hibernate.search.engine.search.common.RewriteMethod;
import org.hibernate.search.engine.search.predicate.dsl.QueryStringPredicateFieldMoreStep;
import org.hibernate.search.engine.search.predicate.dsl.QueryStringPredicateOptionsStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.SearchPredicateDslContext;
import org.hibernate.search.engine.search.predicate.spi.CommonQueryStringPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.QueryStringPredicateBuilder;

class QueryStringPredicateFieldMoreStepImpl<SR> implements QueryStringPredicateFieldMoreStep<SR, QueryStringPredicateFieldMoreStepImpl<SR>, QueryStringPredicateOptionsStep<?>> {

    private final CommonState commonState;

    private final List<CommonQueryStringPredicateBuilder.FieldState> fieldStates = new ArrayList<>();

    QueryStringPredicateFieldMoreStepImpl(CommonState commonState, List<String> fieldPaths) {
        this.commonState = commonState;
        for (String fieldPath : fieldPaths) {
            fieldStates.add(commonState.field(fieldPath));
        }
    }

    @Override
    public QueryStringPredicateFieldMoreStepImpl<SR> fields(String... fieldPaths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public QueryStringPredicateFieldMoreStepImpl<SR> boost(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public QueryStringPredicateOptionsStep<?> matching(String queryString) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class CommonState extends AbstractStringQueryPredicateCommonState<CommonState, QueryStringPredicateOptionsStep<CommonState>, QueryStringPredicateBuilder> implements QueryStringPredicateOptionsStep<CommonState> {

        private static final Set<RewriteMethod> PARAMETERIZED_REWRITE_METHODS = EnumSet.of(RewriteMethod.TOP_TERMS_BOOST_N, RewriteMethod.TOP_TERMS_BLENDED_FREQS_N, RewriteMethod.TOP_TERMS_N);

        CommonState(SearchPredicateDslContext<?> dslContext) {
            super(dslContext);
        }

        @Override
        protected QueryStringPredicateBuilder createBuilder(SearchPredicateDslContext<?> dslContext) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public CommonState allowLeadingWildcard(boolean allowLeadingWildcard) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public CommonState enablePositionIncrements(boolean enablePositionIncrements) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public CommonState phraseSlop(Integer phraseSlop) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public CommonState rewriteMethod(RewriteMethod rewriteMethod) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public CommonState rewriteMethod(RewriteMethod rewriteMethod, int n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected CommonState thisAsT() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
