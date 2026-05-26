/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.codec.impl;

import static org.apache.lucene.util.hnsw.HnswGraphBuilder.DEFAULT_BEAM_WIDTH;
import static org.apache.lucene.util.hnsw.HnswGraphBuilder.DEFAULT_MAX_CONN;
import java.io.IOException;
import java.util.Objects;
import org.apache.lucene.codecs.KnnVectorsFormat;
import org.apache.lucene.codecs.KnnVectorsReader;
import org.apache.lucene.codecs.KnnVectorsWriter;
import org.apache.lucene.codecs.lucene99.Lucene99HnswVectorsFormat;
import org.apache.lucene.index.SegmentReadState;
import org.apache.lucene.index.SegmentWriteState;

public class HibernateSearchKnnVectorsFormat extends KnnVectorsFormat {

    // OpenSearch has a limit of 16000
    public static final int DEFAULT_MAX_DIMENSIONS = 16000;

    private static final KnnVectorsFormat DEFAULT_KNN_VECTORS_FORMAT = new HibernateSearchKnnVectorsFormat();

    public static KnnVectorsFormat defaultFormat() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final KnnVectorsFormat delegate;

    private final int m;

    private final int efConstruction;

    public HibernateSearchKnnVectorsFormat() {
        this(DEFAULT_MAX_CONN, DEFAULT_BEAM_WIDTH);
    }

    public HibernateSearchKnnVectorsFormat(int m, int efConstruction) {
        this(new Lucene99HnswVectorsFormat(m, efConstruction), m, efConstruction);
    }

    public HibernateSearchKnnVectorsFormat(KnnVectorsFormat delegate, int m, int efConstruction) {
        super(delegate.getName());
        this.delegate = delegate;
        this.m = m;
        this.efConstruction = efConstruction;
    }

    @Override
    public KnnVectorsWriter fieldsWriter(SegmentWriteState state) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public KnnVectorsReader fieldsReader(SegmentReadState state) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int getMaxDimensions(String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public KnnVectorsFormat delegate() {
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

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
