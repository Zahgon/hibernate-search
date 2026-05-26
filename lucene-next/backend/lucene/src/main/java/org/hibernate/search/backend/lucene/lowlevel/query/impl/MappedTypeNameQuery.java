/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.query.impl;

import java.io.IOException;
import org.hibernate.search.backend.lucene.lowlevel.reader.impl.IndexReaderMetadataResolver;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.ConstantScoreWeight;
import org.apache.lucene.search.DocIdSetIterator;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.QueryVisitor;
import org.apache.lucene.search.ScoreMode;
import org.apache.lucene.search.ScorerSupplier;
import org.apache.lucene.search.Weight;

public final class MappedTypeNameQuery extends Query {

    private final IndexReaderMetadataResolver metadataResolver;

    private final String mappedTypeName;

    public MappedTypeNameQuery(IndexReaderMetadataResolver metadataResolver, String mappedTypeName) {
        this.metadataResolver = metadataResolver;
        this.mappedTypeName = mappedTypeName;
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
