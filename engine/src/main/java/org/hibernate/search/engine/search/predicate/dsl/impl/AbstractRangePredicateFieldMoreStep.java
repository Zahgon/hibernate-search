/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.predicate.dsl.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import org.hibernate.search.engine.logging.impl.QueryLog;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.engine.search.common.ValueModel;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.RangePredicateFieldMoreGenericStep;
import org.hibernate.search.engine.search.predicate.dsl.RangePredicateFieldMoreStep;
import org.hibernate.search.engine.search.predicate.dsl.RangePredicateOptionsStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.SearchPredicateDslContext;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;
import org.hibernate.search.engine.search.predicate.spi.RangePredicateBuilder;
import org.hibernate.search.engine.search.reference.predicate.RangePredicateFieldReference;
import org.hibernate.search.util.common.data.Range;
import org.hibernate.search.util.common.impl.Contracts;
import org.hibernate.search.util.common.reporting.EventContext;

abstract class AbstractRangePredicateFieldMoreStep<SR, CS extends AbstractRangePredicateFieldMoreStep.GenericCommonState<SR, T, V, S>, S extends AbstractRangePredicateFieldMoreStep<SR, CS, S, T, V>, T, V> implements AbstractBooleanMultiFieldPredicateCommonState.FieldSetState {

    protected final CS commonState;

    private final List<V> fields;

    private final List<RangePredicateBuilder> predicateBuilders = new ArrayList<>();

    private Float fieldSetBoost;

    static <SR> RangePredicateFieldMoreStepString<SR> create(SearchPredicateDslContext<?> dslContext, String[] fields) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <SR, T> RangePredicateFieldMoreStepReference<SR, T> create(SearchPredicateDslContext<?> dslContext, RangePredicateFieldReference<? super SR, T>[] fields) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private AbstractRangePredicateFieldMoreStep(CS commonState, List<V> fields) {
        this.commonState = commonState;
        this.commonState.add(this);
        this.fields = fields;
        for (V field : fields) {
            // only check that the range predicate can be applied to the requested field:
            commonState.scope().fieldQueryElement(fieldPath(field), PredicateTypeKeys.RANGE);
        }
    }

    protected abstract String fieldPath(V field);

    protected abstract S thisAsS();

    public S boost(float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void contributePredicates(Consumer<SearchPredicate> collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class RangePredicateFieldMoreStepString<SR> extends AbstractRangePredicateFieldMoreStep<SR, RangePredicateFieldMoreStepString.CommonState<SR>, RangePredicateFieldMoreStepString<SR>, Object, String> implements RangePredicateFieldMoreStep<SR, RangePredicateFieldMoreStepString<SR>, RangePredicateFieldMoreStepString.CommonState<SR>> {

        private RangePredicateFieldMoreStepString(SearchPredicateDslContext<?> dslContext, List<String> fields) {
            this(new CommonState<>(dslContext), fields);
        }

        private RangePredicateFieldMoreStepString(CommonState<SR> commonState, List<String> fields) {
            super(commonState, fields);
        }

        @Override
        protected String fieldPath(String field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected RangePredicateFieldMoreStepString<SR> thisAsS() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public RangePredicateFieldMoreStepString<SR> fields(String... fieldPaths) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public CommonState<SR> within(Range<?> range, ValueModel convert) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public CommonState<SR> withinAny(Collection<? extends Range<?>> ranges, ValueModel valueModel) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public static class CommonState<SR> extends GenericCommonState<SR, Object, String, RangePredicateFieldMoreStepString<SR>> {

            CommonState(SearchPredicateDslContext<?> dslContext) {
                super(dslContext);
            }

            @Override
            protected String fieldPath(String field) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
    }

    private static class RangePredicateFieldMoreStepReference<SR, T> extends AbstractRangePredicateFieldMoreStep<SR, RangePredicateFieldMoreStepReference.CommonState<SR, T>, RangePredicateFieldMoreStepReference<SR, T>, T, RangePredicateFieldReference<? super SR, T>> implements RangePredicateFieldMoreGenericStep<SR, RangePredicateFieldMoreStepReference<SR, T>, RangePredicateFieldMoreStepReference.CommonState<SR, T>, RangePredicateFieldReference<? super SR, T>, T> {

        private RangePredicateFieldMoreStepReference(SearchPredicateDslContext<?> dslContext, List<RangePredicateFieldReference<? super SR, T>> fields) {
            this(new CommonState<>(dslContext), fields);
        }

        private RangePredicateFieldMoreStepReference(CommonState<SR, T> commonState, List<RangePredicateFieldReference<? super SR, T>> fields) {
            super(commonState, fields);
        }

        @Override
        protected String fieldPath(RangePredicateFieldReference<? super SR, T> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected RangePredicateFieldMoreStepReference<SR, T> thisAsS() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public RangePredicateFieldMoreStepReference<SR, T> field(RangePredicateFieldReference<? super SR, T> field) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        @SuppressWarnings("unchecked")
        public RangePredicateFieldMoreStepReference<SR, T> fields(RangePredicateFieldReference<? super SR, T>... fields) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public CommonState<SR, T> within(Range<? extends T> range) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public CommonState<SR, T> withinAny(Collection<? extends Range<?>> ranges, ValueModel valueModel) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public static class CommonState<SR, T> extends GenericCommonState<SR, T, RangePredicateFieldReference<? super SR, T>, RangePredicateFieldMoreStepReference<SR, T>> {

            CommonState(SearchPredicateDslContext<?> dslContext) {
                super(dslContext);
            }

            @Override
            protected String fieldPath(RangePredicateFieldReference<? super SR, T> field) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
    }

    abstract static class GenericCommonState<SR, T, V, S extends AbstractRangePredicateFieldMoreStep<SR, ?, S, T, V>> extends AbstractBooleanMultiFieldPredicateCommonState<GenericCommonState<SR, T, V, S>, AbstractRangePredicateFieldMoreStep<SR, ?, S, T, V>> implements RangePredicateOptionsStep<GenericCommonState<SR, T, V, S>> {

        GenericCommonState(SearchPredicateDslContext<?> dslContext) {
            super(dslContext);
        }

        @Override
        protected GenericCommonState<SR, T, V, S> thisAsS() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected abstract String fieldPath(V field);

        GenericCommonState<SR, T, V, S> within(Range<?> range, Function<V, ValueModel> valueModelFunction) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public GenericCommonState<SR, T, V, S> withinAny(Collection<? extends Range<?>> ranges, Function<V, ValueModel> valueModelFunction) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected final EventContext getEventContext() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
