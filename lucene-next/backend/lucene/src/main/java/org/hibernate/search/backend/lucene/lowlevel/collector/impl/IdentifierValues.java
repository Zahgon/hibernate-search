/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.collector.impl;

import java.io.IOException;
import org.hibernate.search.backend.lucene.lowlevel.common.impl.MetadataFields;
import org.apache.lucene.index.BinaryDocValues;
import org.apache.lucene.index.DocValues;
import org.apache.lucene.index.LeafReaderContext;

public final class IdentifierValues implements Values<String> {

    private BinaryDocValues currentLeafIdDocValues;

    @Override
    public void context(LeafReaderContext context) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String get(int doc) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
