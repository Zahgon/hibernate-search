/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.engine.search.predicate.dsl.spi;

import static org.hibernate.search.engine.search.predicate.dsl.impl.AbstractSimpleBooleanPredicateClausesStep.SimpleBooleanPredicateOperator.AND;
import static org.hibernate.search.engine.search.predicate.dsl.impl.AbstractSimpleBooleanPredicateClausesStep.SimpleBooleanPredicateOperator.OR;
import java.util.function.Consumer;
import java.util.function.Function;
import org.hibernate.search.engine.backend.common.spi.FieldPaths;
import org.hibernate.search.engine.common.dsl.spi.DslExtensionState;
import org.hibernate.search.engine.search.common.NamedValues;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.BooleanPredicateClausesStep;
import org.hibernate.search.engine.search.predicate.dsl.ExistsPredicateFieldStep;
import org.hibernate.search.engine.search.predicate.dsl.ExtendedSearchPredicateFactory;
import org.hibernate.search.engine.search.predicate.dsl.KnnPredicateFieldStep;
import org.hibernate.search.engine.search.predicate.dsl.MatchAllPredicateOptionsStep;
import org.hibernate.search.engine.search.predicate.dsl.MatchIdPredicateMatchingStep;
import org.hibernate.search.engine.search.predicate.dsl.MatchNonePredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.MatchPredicateFieldStep;
import org.hibernate.search.engine.search.predicate.dsl.NamedPredicateOptionsStep;
import org.hibernate.search.engine.search.predicate.dsl.NestedPredicateClausesStep;
import org.hibernate.search.engine.search.predicate.dsl.NotPredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.PhrasePredicateFieldStep;
import org.hibernate.search.engine.search.predicate.dsl.PredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.PrefixPredicateFieldStep;
import org.hibernate.search.engine.search.predicate.dsl.QueryStringPredicateFieldStep;
import org.hibernate.search.engine.search.predicate.dsl.RangePredicateFieldStep;
import org.hibernate.search.engine.search.predicate.dsl.RegexpPredicateFieldStep;
import org.hibernate.search.engine.search.predicate.dsl.SearchPredicateFactoryExtension;
import org.hibernate.search.engine.search.predicate.dsl.SearchPredicateFactoryExtensionIfSupportedStep;
import org.hibernate.search.engine.search.predicate.dsl.SimpleBooleanPredicateClausesStep;
import org.hibernate.search.engine.search.predicate.dsl.SimpleBooleanPredicateOptionsStep;
import org.hibernate.search.engine.search.predicate.dsl.SimpleQueryStringPredicateFieldStep;
import org.hibernate.search.engine.search.predicate.dsl.SpatialPredicateInitialStep;
import org.hibernate.search.engine.search.predicate.dsl.TermsPredicateFieldStep;
import org.hibernate.search.engine.search.predicate.dsl.WildcardPredicateFieldStep;
import org.hibernate.search.engine.search.predicate.dsl.impl.BooleanPredicateClausesStepImpl;
import org.hibernate.search.engine.search.predicate.dsl.impl.ExistsPredicateFieldStepImpl;
import org.hibernate.search.engine.search.predicate.dsl.impl.KnnPredicateFieldStepImpl;
import org.hibernate.search.engine.search.predicate.dsl.impl.MatchAllPredicateOptionsStepImpl;
import org.hibernate.search.engine.search.predicate.dsl.impl.MatchIdPredicateMatchingStepImpl;
import org.hibernate.search.engine.search.predicate.dsl.impl.MatchNonePredicateFinalStepImpl;
import org.hibernate.search.engine.search.predicate.dsl.impl.MatchPredicateFieldStepImpl;
import org.hibernate.search.engine.search.predicate.dsl.impl.NamedPredicateOptionsStepImpl;
import org.hibernate.search.engine.search.predicate.dsl.impl.NestedPredicateClausesStepImpl;
import org.hibernate.search.engine.search.predicate.dsl.impl.NotPredicateFinalStepImpl;
import org.hibernate.search.engine.search.predicate.dsl.impl.PhrasePredicateFieldStepImpl;
import org.hibernate.search.engine.search.predicate.dsl.impl.PrefixPredicateFieldStepImpl;
import org.hibernate.search.engine.search.predicate.dsl.impl.QueryStringPredicateFieldStepImpl;
import org.hibernate.search.engine.search.predicate.dsl.impl.RangePredicateFieldStepImpl;
import org.hibernate.search.engine.search.predicate.dsl.impl.RegexpPredicateFieldStepImpl;
import org.hibernate.search.engine.search.predicate.dsl.impl.SearchPredicateFactoryExtensionStep;
import org.hibernate.search.engine.search.predicate.dsl.impl.SimpleBooleanPredicateClausesStepImpl;
import org.hibernate.search.engine.search.predicate.dsl.impl.SimpleQueryStringPredicateFieldStepImpl;
import org.hibernate.search.engine.search.predicate.dsl.impl.SpatialPredicateInitialStepImpl;
import org.hibernate.search.engine.search.predicate.dsl.impl.TermsPredicateFieldStepImpl;
import org.hibernate.search.engine.search.predicate.dsl.impl.WildcardPredicateFieldStepImpl;
import org.hibernate.search.engine.search.predicate.dsl.impl.WithParametersPredicateFinalStep;
import org.hibernate.search.engine.search.predicate.spi.SearchPredicateIndexScope;
import org.hibernate.search.util.common.impl.Contracts;

public abstract class AbstractSearchPredicateFactory<SR, S extends ExtendedSearchPredicateFactory<SR, S>, SC extends SearchPredicateIndexScope<?>> implements ExtendedSearchPredicateFactory<SR, S> {

    protected final Class<SR> scopeRootType;

    protected final SearchPredicateDslContext<SC> dslContext;

    public AbstractSearchPredicateFactory(Class<SR> scopeRootType, SearchPredicateDslContext<SC> dslContext) {
        this.scopeRootType = scopeRootType;
        this.dslContext = dslContext;
    }

    @Override
    public MatchAllPredicateOptionsStep<SR, ?> matchAll() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MatchNonePredicateFinalStep matchNone() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MatchIdPredicateMatchingStep<?> id() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BooleanPredicateClausesStep<SR, ?> bool() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SimpleBooleanPredicateClausesStep<SR, ?> and() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SimpleBooleanPredicateOptionsStep<?> and(SearchPredicate firstSearchPredicate, SearchPredicate... otherSearchPredicates) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SimpleBooleanPredicateOptionsStep<?> and(PredicateFinalStep firstSearchPredicate, PredicateFinalStep... otherSearchPredicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SimpleBooleanPredicateClausesStep<SR, ?> or() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SimpleBooleanPredicateOptionsStep<?> or(SearchPredicate firstSearchPredicate, SearchPredicate... otherSearchPredicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SimpleBooleanPredicateOptionsStep<?> or(PredicateFinalStep firstSearchPredicate, PredicateFinalStep... otherSearchPredicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public NotPredicateFinalStep not(SearchPredicate searchPredicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public NotPredicateFinalStep not(PredicateFinalStep searchPredicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    // javac warns about this method being deprecated, but we have to implement it
    @SuppressWarnings("deprecation")
    public PredicateFinalStep bool(Consumer<? super BooleanPredicateClausesStep<?, ?>> clauseContributor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MatchPredicateFieldStep<SR, ?> match() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RangePredicateFieldStep<SR, ?> range() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PhrasePredicateFieldStep<SR, ?> phrase() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public WildcardPredicateFieldStep<SR, ?> wildcard() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PrefixPredicateFieldStep<SR, ?> prefix() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RegexpPredicateFieldStep<SR, ?> regexp() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TermsPredicateFieldStep<SR, ?> terms() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @Deprecated(since = "6.2")
    public org.hibernate.search.engine.search.predicate.dsl.NestedPredicateFieldStep<SR, ?> nested() {
        return new org.hibernate.search.engine.search.predicate.dsl.impl.NestedPredicateFieldStepImpl<>(dslContext, this);
    }

    @Override
    public NestedPredicateClausesStep<SR, ?> nested(String objectFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SimpleQueryStringPredicateFieldStep<SR, ?> simpleQueryString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public QueryStringPredicateFieldStep<SR, ?> queryString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ExistsPredicateFieldStep<SR, ?> exists() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SpatialPredicateInitialStep<SR> spatial() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public NamedPredicateOptionsStep named(String path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public KnnPredicateFieldStep<SR> knn(int k) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PredicateFinalStep withParameters(Function<? super NamedValues, ? extends PredicateFinalStep> predicateCreator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> T extension(SearchPredicateFactoryExtension<T> extension) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SearchPredicateFactoryExtensionIfSupportedStep<SR> extension() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String toAbsolutePath(String relativeFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
