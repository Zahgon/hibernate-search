/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.predicate.impl;

import org.hibernate.search.backend.lucene.lowlevel.query.impl.Queries;
import org.hibernate.search.backend.lucene.search.common.impl.AbstractLuceneCompositeNodeSearchQueryElementFactory;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexCompositeNodeContext;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.spi.NestedPredicateBuilder;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.join.BitSetProducer;
import org.apache.lucene.search.join.QueryBitSetProducer;
import org.apache.lucene.search.join.ScoreMode;
import org.apache.lucene.search.join.ToParentBlockJoinQuery;

public class LuceneNestedPredicate extends AbstractLuceneSingleFieldPredicate {

    private final LuceneSearchPredicate nestedPredicate;

    private LuceneNestedPredicate(Builder builder) {
        super(builder);
        nestedPredicate = builder.nestedPredicate;
    }

    @Override
    protected Query doToQuery(PredicateRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Query createNestedQuery(String parentNestedDocumentPath, String nestedDocumentPath, Query nestedQuery) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Factory extends AbstractLuceneCompositeNodeSearchQueryElementFactory<NestedPredicateBuilder> {

        public static final Factory INSTANCE = new Factory();

        private Factory() {
        }

        @Override
        public NestedPredicateBuilder create(LuceneSearchIndexScope<?> scope, LuceneSearchIndexCompositeNodeContext node) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Builder extends AbstractBuilder implements NestedPredicateBuilder {

        private LuceneSearchPredicate nestedPredicate;

        Builder(LuceneSearchIndexScope<?> scope, LuceneSearchIndexCompositeNodeContext node) {
            super(scope, node.absolutePath(), // nestedPathHierarchy includes absoluteFieldPath at the end, but here we don't want it to be included.
            node.nestedPathHierarchy().subList(0, node.nestedPathHierarchy().size() - 1));
        }

        @Override
        public void nested(SearchPredicate nestedPredicate) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchPredicate build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
