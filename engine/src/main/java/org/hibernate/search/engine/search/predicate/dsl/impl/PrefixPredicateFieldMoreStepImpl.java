/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.predicate.dsl.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.hibernate.search.engine.search.common.spi.SearchIndexScope;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.PrefixPredicateFieldMoreStep;
import org.hibernate.search.engine.search.predicate.dsl.PrefixPredicateOptionsStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.SearchPredicateDslContext;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;
import org.hibernate.search.engine.search.predicate.spi.PrefixPredicateBuilder;
import org.hibernate.search.util.common.impl.Contracts;

class PrefixPredicateFieldMoreStepImpl<SR> implements PrefixPredicateFieldMoreStep<SR, PrefixPredicateFieldMoreStepImpl<SR>, PrefixPredicateOptionsStep<?>>, AbstractBooleanMultiFieldPredicateCommonState.FieldSetState {

    private final CommonState<SR> commonState;

    private final List<PrefixPredicateBuilder> predicateBuilders = new ArrayList<>();

    private Float fieldSetBoost;

    PrefixPredicateFieldMoreStepImpl(CommonState<SR> commonState, List<String> fieldPaths) {
        this.commonState = commonState;
        this.commonState.add(this);
        SearchIndexScope<?> scope = commonState.scope();
        for (String fieldPath : fieldPaths) {
            predicateBuilders.add(scope.fieldQueryElement(fieldPath, PredicateTypeKeys.PREFIX));
        }
    }

    @Override
    public PrefixPredicateFieldMoreStepImpl<SR> fields(String... fieldPaths) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PrefixPredicateFieldMoreStepImpl<SR> boost(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PrefixPredicateOptionsStep<?> matching(String prefixPattern) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void contributePredicates(Consumer<SearchPredicate> collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class CommonState<SR> extends AbstractBooleanMultiFieldPredicateCommonState<CommonState<SR>, PrefixPredicateFieldMoreStepImpl<SR>> implements PrefixPredicateOptionsStep<CommonState<SR>> {

        CommonState(SearchPredicateDslContext<?> dslContext) {
            super(dslContext);
        }

        private PrefixPredicateOptionsStep<?> matching(String prefix) {
            Contracts.assertNotNull(prefix, "prefix");
            for (PrefixPredicateFieldMoreStepImpl<SR> fieldSetState : getFieldSetStates()) {
                for (PrefixPredicateBuilder predicateBuilder : fieldSetState.predicateBuilders) {
                    predicateBuilder.prefix(prefix);
                }
            }
            return this;
        }

        @Override
        protected CommonState<SR> thisAsS() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
