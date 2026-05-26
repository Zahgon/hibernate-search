/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.predicate.dsl.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.hibernate.search.engine.logging.impl.QueryLog;
import org.hibernate.search.engine.search.common.ValueModel;
import org.hibernate.search.engine.search.common.spi.SearchIndexScope;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.MatchPredicateFieldMoreGenericStep;
import org.hibernate.search.engine.search.predicate.dsl.MatchPredicateFieldMoreStep;
import org.hibernate.search.engine.search.predicate.dsl.MatchPredicateOptionsStep;
import org.hibernate.search.engine.search.predicate.dsl.MinimumShouldMatchConditionStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.SearchPredicateDslContext;
import org.hibernate.search.engine.search.predicate.spi.MatchPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.MinimumShouldMatchBuilder;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;
import org.hibernate.search.engine.search.reference.predicate.MatchPredicateFieldReference;
import org.hibernate.search.util.common.impl.Contracts;

abstract class AbstractMatchPredicateFieldMoreStep<CS extends AbstractMatchPredicateFieldMoreStep.GenericCommonState<T, V, S>, S extends AbstractMatchPredicateFieldMoreStep<CS, S, T, V>, T, V> implements AbstractBooleanMultiFieldPredicateCommonState.FieldSetState {

    protected final CS commonState;

    protected final Map<V, MatchPredicateBuilder> predicateBuilders = new LinkedHashMap<>();

    private Float fieldSetBoost;

    public static MatchPredicateFieldMoreStep<?, ?> create(SearchPredicateDslContext<?> dslContext, String[] fields) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <SR, T> MatchPredicateFieldMoreGenericStep<?, ?, T, MatchPredicateFieldReference<? super SR, T>> create(SearchPredicateDslContext<?> dslContext, MatchPredicateFieldReference<? super SR, T>[] fields) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected AbstractMatchPredicateFieldMoreStep(CS commonState, List<V> fieldPaths) {
        this.commonState = commonState;
        this.commonState.add(thisAsS());
        SearchIndexScope<?> scope = commonState.scope();
        for (V fieldPath : fieldPaths) {
            predicateBuilders.put(fieldPath, scope.fieldQueryElement(fieldPath(fieldPath), PredicateTypeKeys.MATCH));
        }
    }

    protected abstract S thisAsS();

    protected abstract String fieldPath(V field);

    public S boost(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void contributePredicates(Consumer<SearchPredicate> collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class MatchPredicateFieldMoreStepString extends AbstractMatchPredicateFieldMoreStep<MatchPredicateFieldMoreStepString.CommonState, MatchPredicateFieldMoreStepString, Object, String> implements MatchPredicateFieldMoreStep<MatchPredicateFieldMoreStepString, MatchPredicateFieldMoreStepString.CommonState> {

        MatchPredicateFieldMoreStepString(SearchPredicateDslContext<?> dslContext, List<String> fieldPaths) {
            super(new CommonState(dslContext), fieldPaths);
        }

        private MatchPredicateFieldMoreStepString(CommonState commonState, List<String> fieldPaths) {
            super(commonState, fieldPaths);
        }

        @Override
        protected MatchPredicateFieldMoreStepString thisAsS() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String fieldPath(String field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public MatchPredicateFieldMoreStepString field(String field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public MatchPredicateFieldMoreStepString fields(String... fieldPaths) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public CommonState matching(Object value, ValueModel valueModel) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private static class CommonState extends GenericCommonState<Object, String, MatchPredicateFieldMoreStepString> {

            CommonState(SearchPredicateDslContext<?> dslContext) {
                super(dslContext);
            }

            CommonState matching(Object value, ValueModel valueModel) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
    }

    private static class MatchPredicateFieldMoreStepFieldReference<SR, T> extends AbstractMatchPredicateFieldMoreStep<MatchPredicateFieldMoreStepFieldReference.CommonState<SR, T>, MatchPredicateFieldMoreStepFieldReference<SR, T>, T, MatchPredicateFieldReference<? super SR, T>> implements MatchPredicateFieldMoreGenericStep<MatchPredicateFieldMoreStepFieldReference<SR, T>, MatchPredicateFieldMoreStepFieldReference.CommonState<SR, T>, T, MatchPredicateFieldReference<? super SR, T>> {

        MatchPredicateFieldMoreStepFieldReference(SearchPredicateDslContext<?> dslContext, List<MatchPredicateFieldReference<? super SR, T>> fieldPaths) {
            super(new CommonState<>(dslContext), fieldPaths);
        }

        private MatchPredicateFieldMoreStepFieldReference(CommonState<SR, T> commonState, List<MatchPredicateFieldReference<? super SR, T>> fieldPaths) {
            super(commonState, fieldPaths);
        }

        @Override
        public MatchPredicateFieldMoreStepFieldReference<SR, T> field(MatchPredicateFieldReference<? super SR, T> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        @SuppressWarnings("unchecked")
        public MatchPredicateFieldMoreStepFieldReference<SR, T> fields(MatchPredicateFieldReference<? super SR, T>... fieldPaths) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public CommonState<SR, T> matching(T value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected MatchPredicateFieldMoreStepFieldReference<SR, T> thisAsS() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String fieldPath(MatchPredicateFieldReference<? super SR, T> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private static class CommonState<SR, T> extends GenericCommonState<T, MatchPredicateFieldReference<? super SR, T>, MatchPredicateFieldMoreStepFieldReference<SR, T>> {

            CommonState(SearchPredicateDslContext<?> dslContext) {
                super(dslContext);
            }

            CommonState<SR, T> matching(T value) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
    }

    static class GenericCommonState<T, V, S extends AbstractMatchPredicateFieldMoreStep<?, S, T, V>> extends AbstractBooleanMultiFieldPredicateCommonState<GenericCommonState<T, V, S>, S> implements MatchPredicateOptionsStep<GenericCommonState<T, V, S>> {

        private final MinimumShouldMatchConditionStepImpl<? extends GenericCommonState<T, V, S>> minimumShouldMatchStep;

        GenericCommonState(SearchPredicateDslContext<?> dslContext) {
            super(dslContext);
            minimumShouldMatchStep = new MinimumShouldMatchConditionStepImpl<>(new MatchMinimumShouldMatchBuilder(), this);
        }

        @Override
        public GenericCommonState<T, V, S> fuzzy(int maxEditDistance, int exactPrefixLength) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public GenericCommonState<T, V, S> analyzer(String analyzerName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public GenericCommonState<T, V, S> skipAnalysis() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected GenericCommonState<T, V, S> thisAsS() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public MinimumShouldMatchConditionStep<? extends GenericCommonState<T, V, S>> minimumShouldMatch() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public GenericCommonState<T, V, S> minimumShouldMatch(Consumer<? super MinimumShouldMatchConditionStep<?>> constraintContributor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private class MatchMinimumShouldMatchBuilder implements MinimumShouldMatchBuilder {

            @Override
            public void minimumShouldMatchNumber(int ignoreConstraintCeiling, int matchingClausesNumber) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public void minimumShouldMatchPercent(int ignoreConstraintCeiling, int matchingClausesPercent) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
    }
}
