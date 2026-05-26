/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.predicate.dsl.impl;

import org.hibernate.search.backend.lucene.logging.impl.QueryLog;
import org.hibernate.search.backend.lucene.search.predicate.dsl.LuceneSearchPredicateFactory;
import org.hibernate.search.backend.lucene.search.predicate.impl.LuceneSearchPredicateIndexScope;
import org.hibernate.search.engine.search.common.NonStaticMetamodelScope;
import org.hibernate.search.engine.search.predicate.dsl.PredicateFinalStep;
import org.hibernate.search.engine.search.predicate.dsl.spi.AbstractSearchPredicateFactory;
import org.hibernate.search.engine.search.predicate.dsl.spi.SearchPredicateDslContext;
import org.hibernate.search.engine.search.predicate.dsl.spi.StaticPredicateFinalStep;
import org.apache.lucene.search.Query;

public class LuceneSearchPredicateFactoryImpl<SR> extends AbstractSearchPredicateFactory<SR, LuceneSearchPredicateFactory<SR>, LuceneSearchPredicateIndexScope<?>> implements LuceneSearchPredicateFactory<SR> {

    public LuceneSearchPredicateFactoryImpl(Class<SR> scopeRootType, SearchPredicateDslContext<LuceneSearchPredicateIndexScope<?>> dslContext) {
        super(scopeRootType, dslContext);
    }

    @Override
    public LuceneSearchPredicateFactory<SR> withRoot(String objectFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PredicateFinalStep fromLuceneQuery(Query luceneQuery) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // well because we check ;)
    @SuppressWarnings("unchecked")
    @Override
    public <SR2> LuceneSearchPredicateFactory<SR2> withScopeRoot(Class<SR2> scopeRootType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
