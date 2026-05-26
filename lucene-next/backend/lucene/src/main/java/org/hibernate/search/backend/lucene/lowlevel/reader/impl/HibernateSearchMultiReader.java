/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.reader.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.search.backend.lucene.logging.impl.LuceneMiscLog;
import org.hibernate.search.engine.reporting.spi.EventContexts;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.impl.SuppressingCloser;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.MultiReader;

/**
 * A {@link MultiReader} keeping references to {@link DirectoryReader}s to eventually close them,
 * and holding some additional metadata related to the targeted readers.
 * <p>
 * Ported from Search 5: {@code org.hibernate.search.reader.impl.ManagedMultiReader},
 * {@code org.hibernate.search.reader.impl.MultiReaderFactory}.
 *
 * @author Emmanuel Bernard
 * @author Sanne Grinovero (C) 2011 Red Hat Inc.
 */
public class HibernateSearchMultiReader extends MultiReader {

    public static HibernateSearchMultiReader open(Set<String> indexNames, Collection<? extends ReadIndexManagerContext> indexManagerContexts, Set<String> routingKeys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final List<DirectoryReader> directoryReaders;

    private final IndexReaderMetadataResolver metadataResolver;

    HibernateSearchMultiReader(List<DirectoryReader> directoryReaders, IndexReaderMetadataResolver metadataResolver) throws IOException {
        // If this flag isn't set to true, the MultiReader will increase the usage counter!
        super(toReaderArray(directoryReaders), true);
        this.directoryReaders = directoryReaders;
        this.metadataResolver = metadataResolver;
    }

    public IndexReaderMetadataResolver getMetadataResolver() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected synchronized void doClose() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static IndexReader[] toReaderArray(List<DirectoryReader> directoryReaders) {
        return directoryReaders.toArray(new DirectoryReader[0]);
    }

    public static class Builder implements DirectoryReaderCollector {

        private final List<DirectoryReader> directoryReaders = new ArrayList<>();

        private final Map<DirectoryReader, String> mappedTypeNameByDirectoryReader = new HashMap<>();

        private Builder() {
        }

        @Override
        public void collect(String mappedTypeName, DirectoryReader directoryReader) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        HibernateSearchMultiReader build() throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
