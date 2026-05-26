/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.query.dsl.impl;

import org.hibernate.search.engine.search.predicate.dsl.PhrasePredicateOptionsStep;
import org.hibernate.search.engine.search.predicate.dsl.SearchPredicateFactory;
import org.hibernate.search.query.dsl.PhraseTermination;

/**
 * @author Emmanuel Bernard
 */
public class ConnectedMultiFieldsPhraseQueryBuilder extends AbstractConnectedMultiFieldsQueryBuilder<PhraseTermination, PhrasePredicateOptionsStep<?>> implements PhraseTermination {

    private final PhraseQueryContext phraseContext;

    public ConnectedMultiFieldsPhraseQueryBuilder(QueryBuildingContext queryContext, QueryCustomizer queryCustomizer, FieldsContext fieldsContext, PhraseQueryContext phraseContext) {
        super(queryContext, queryCustomizer, fieldsContext);
        this.phraseContext = phraseContext;
    }

    @Override
    protected PhrasePredicateOptionsStep<?> createPredicate(SearchPredicateFactory factory, FieldContext fieldContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
