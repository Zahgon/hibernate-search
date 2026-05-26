/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.codec.impl;

import java.util.Arrays;
import org.hibernate.search.engine.spatial.GeoPoint;
import org.apache.lucene.document.DoublePoint;
import org.apache.lucene.document.LatLonDocValuesField;
import org.apache.lucene.document.LatLonPoint;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.util.BytesRef;

public final class LuceneGeoPointFieldCodec implements LuceneFieldCodec<GeoPoint, byte[]> {

    private final Indexing indexing;

    private final DocValues docValues;

    private final Storage storage;

    private final GeoPoint indexNullAsValue;

    public LuceneGeoPointFieldCodec(Indexing indexing, DocValues docValues, Storage storage, GeoPoint indexNullAsValue) {
        this.indexing = indexing;
        this.docValues = docValues;
        this.storage = storage;
        this.indexNullAsValue = indexNullAsValue;
    }

    @Override
    public void addToDocument(LuceneDocumentContent documentBuilder, String absoluteFieldPath, GeoPoint value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public GeoPoint decode(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public byte[] raw(IndexableField field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public GeoPoint decode(byte[] field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public byte[] encode(GeoPoint value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Class<byte[]> encodedType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCompatibleWith(LuceneFieldCodec<?, ?> obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static BytesRef toStoredBytes(GeoPoint geoPoint) {
        byte[] bytes = new byte[2 * Double.BYTES];
        DoublePoint.encodeDimension(geoPoint.latitude(), bytes, 0);
        DoublePoint.encodeDimension(geoPoint.longitude(), bytes, Double.BYTES);
        return new BytesRef(bytes);
    }

    private static GeoPoint fromStoredBytes(BytesRef bytesRef) {
        double latitude = DoublePoint.decodeDimension(bytesRef.bytes, bytesRef.offset);
        double longitude = DoublePoint.decodeDimension(bytesRef.bytes, bytesRef.offset + Double.BYTES);
        return GeoPoint.of(latitude, longitude);
    }

    private static GeoPoint fromBytes(byte[] bytes) {
        double latitude = DoublePoint.decodeDimension(bytes, 0);
        double longitude = DoublePoint.decodeDimension(bytes, Double.BYTES);
        return GeoPoint.of(latitude, longitude);
    }
}
