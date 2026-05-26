/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.query.impl;

import java.util.Arrays;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.ConstantScoreScorer;
import org.apache.lucene.search.ConstantScoreWeight;
import org.apache.lucene.search.DocIdSetIterator;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.QueryVisitor;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.ScoreMode;
import org.apache.lucene.search.Scorer;
import org.apache.lucene.search.Weight;

public final class ExplicitDocIdsQuery extends Query {

    private final int[] sortedDocIds;

    public ExplicitDocIdsQuery(ScoreDoc[] scoreDocs, int start, int end) {
        int size = end - start;
        int[] docIds = new int[size];
        for (int i = 0; i < size; i++) {
            docIds[i] = scoreDocs[start + i].doc;
        }
        Arrays.sort(docIds);
        this.sortedDocIds = docIds;
    }

    @Override
    public String toString(String field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void visit(QueryVisitor visitor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
