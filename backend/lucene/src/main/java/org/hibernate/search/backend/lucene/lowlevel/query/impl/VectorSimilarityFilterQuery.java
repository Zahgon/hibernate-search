/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.query.impl;

import java.io.IOException;
import java.util.Objects;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.DocIdSetIterator;
import org.apache.lucene.search.Explanation;
import org.apache.lucene.search.FilterWeight;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.KnnByteVectorQuery;
import org.apache.lucene.search.KnnFloatVectorQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.QueryVisitor;
import org.apache.lucene.search.ScoreMode;
import org.apache.lucene.search.Scorer;
import org.apache.lucene.search.TwoPhaseIterator;
import org.apache.lucene.search.Weight;

public class VectorSimilarityFilterQuery extends Query {

    private final Query query;

    private final float similarityAsScore;

    public static VectorSimilarityFilterQuery create(KnnByteVectorQuery query, float requiredMinimumScore) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static VectorSimilarityFilterQuery create(KnnFloatVectorQuery query, float requiredMinimumScore) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private VectorSimilarityFilterQuery(Query query, float similarityAsScore) {
        this.query = query;
        this.similarityAsScore = similarityAsScore;
    }

    @Override
    public Query rewrite(IndexSearcher indexSearcher) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void visit(QueryVisitor visitor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString(String field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class SimilarityWeight extends FilterWeight {

        private final float similarityAsScore;

        protected SimilarityWeight(Weight weight, float similarityAsScore) {
            super(weight);
            this.similarityAsScore = similarityAsScore;
        }

        @Override
        public Explanation explain(LeafReaderContext context, int doc) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Scorer scorer(LeafReaderContext context) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    // An adapted version of `org.opensearch.common.lucene.search.function.MinScoreScorer`:
    private static class MinScoreScorer extends Scorer {

        private final Scorer in;

        private final float minScore;

        private float curScore;

        MinScoreScorer(Weight weight, Scorer scorer, float minScore) {
            super(weight);
            this.in = scorer;
            this.minScore = minScore;
        }

        @Override
        public int docID() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public float score() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int advanceShallow(int target) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public float getMaxScore(int upTo) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public DocIdSetIterator iterator() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public TwoPhaseIterator twoPhaseIterator() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
