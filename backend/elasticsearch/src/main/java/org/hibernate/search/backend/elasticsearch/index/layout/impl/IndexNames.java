/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.index.layout.impl;

import java.util.Locale;
import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import org.hibernate.search.backend.elasticsearch.logging.impl.ElasticsearchMiscLog;

public final class IndexNames {

    public static String normalizeName(String indexName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static URLEncodedString encodeName(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final String hibernateSearch;

    private final URLEncodedString write;

    private final boolean writeIsAlias;

    private final URLEncodedString read;

    private final boolean readIsAlias;

    public IndexNames(String hibernateSearch, URLEncodedString write, boolean writeIsAlias, URLEncodedString read, boolean readIsAlias) {
        this.hibernateSearch = hibernateSearch;
        this.write = write;
        this.writeIsAlias = writeIsAlias;
        this.read = read;
        this.readIsAlias = readIsAlias;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The Hibernate Search index name,
     * i.e. the name that Hibernate Search uses internally to designate that index, for example in configuration files.
     */
    public String hibernateSearchIndex() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The write name,
     * i.e. the name that Hibernate Search is supposed to use when indexing or purging the index.
     */
    public URLEncodedString write() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return Whether the {@link #write write name} is an alias ({@code true}) or not ({@code false}).
     */
    public boolean writeIsAlias() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The read name,
     * i.e. the name that Hibernate Search is supposed to use when executing searches on the index.
     */
    public URLEncodedString read() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return Whether the {@link #write write name} is an alias ({@code true}) or not ({@code false}).
     */
    public boolean readIsAlias() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
