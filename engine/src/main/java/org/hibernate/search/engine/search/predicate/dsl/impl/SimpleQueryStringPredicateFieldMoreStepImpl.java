/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.predicate.dsl.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.hibernate.search.engine.search.predicate.dsl.SimpleQueryFlag;
import org.hibernate.search.engine.search.predicate.dsl.SimpleQueryStringPredicateFieldMoreStep;
import org.hibernate.search.engine.search.predicate.dsl.SimpleQueryStringPredicateOptionsStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.SearchPredicateDslContext;
import org.hibernate.search.engine.search.predicate.spi.CommonQueryStringPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.SimpleQueryStringPredicateBuilder;

class SimpleQueryStringPredicateFieldMoreStepImpl<SR> implements SimpleQueryStringPredicateFieldMoreStep<SR, SimpleQueryStringPredicateFieldMoreStepImpl<SR>, SimpleQueryStringPredicateOptionsStep<?>> {

    private final CommonState commonState;

    private final List<CommonQueryStringPredicateBuilder.FieldState> fieldStates = new ArrayList<>();

    SimpleQueryStringPredicateFieldMoreStepImpl(CommonState commonState, List<String> fieldPaths) {
        this.commonState = commonState;
        for (String fieldPath : fieldPaths) {
            fieldStates.add(commonState.field(fieldPath));
        }
    }

    @Override
    public SimpleQueryStringPredicateFieldMoreStepImpl<SR> fields(String... fieldPaths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SimpleQueryStringPredicateFieldMoreStepImpl<SR> boost(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SimpleQueryStringPredicateOptionsStep<?> matching(String queryString) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class CommonState extends AbstractStringQueryPredicateCommonState<CommonState, SimpleQueryStringPredicateOptionsStep<CommonState>, SimpleQueryStringPredicateBuilder> implements SimpleQueryStringPredicateOptionsStep<CommonState> {

        CommonState(SearchPredicateDslContext<?> dslContext) {
            super(dslContext);
        }

        @Override
        protected SimpleQueryStringPredicateBuilder createBuilder(SearchPredicateDslContext<?> dslContext) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public CommonState flags(Set<SimpleQueryFlag> flags) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected CommonState thisAsT() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
