/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.predicate.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.search.backend.lucene.lowlevel.common.impl.MetadataFields;
import org.hibernate.search.backend.lucene.search.common.impl.AbstractLuceneCompositeNodeSearchQueryElementFactory;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexCompositeNodeContext;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexNodeContext;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.search.predicate.impl.AbstractLuceneSingleFieldPredicate;
import org.hibernate.search.backend.lucene.search.predicate.impl.LuceneSearchPredicate;
import org.hibernate.search.backend.lucene.search.predicate.impl.PredicateRequestContext;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.ExistsPredicateBuilder;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;

public class LuceneObjectExistsPredicate extends AbstractLuceneSingleFieldPredicate {

    private final List<LuceneSearchPredicate> children;

    private LuceneObjectExistsPredicate(Builder builder) {
        super(builder);
        children = builder.children;
        // Ensure illegal attempts to mutate the predicate will fail
        builder.children = null;
    }

    @Override
    protected Query doToQuery(PredicateRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Factory extends AbstractLuceneCompositeNodeSearchQueryElementFactory<ExistsPredicateBuilder> {

        public static final Factory INSTANCE = new Factory();

        private Factory() {
        }

        @Override
        public ExistsPredicateBuilder create(LuceneSearchIndexScope<?> scope, LuceneSearchIndexCompositeNodeContext node) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Builder extends AbstractBuilder implements ExistsPredicateBuilder {

        private List<LuceneSearchPredicate> children = new ArrayList<>();

        public Builder(LuceneSearchIndexScope<?> scope, LuceneSearchIndexCompositeNodeContext node) {
            super(scope, node);
        }

        public void addChild(LuceneSearchIndexNodeContext child) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchPredicate build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
