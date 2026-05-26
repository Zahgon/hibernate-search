/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.analysis.impl;

import java.io.Reader;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharFilterFactory;
import org.apache.lucene.analysis.TokenFilterFactory;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.TokenizerFactory;

/**
 * Inspired by Apache Solr's org.apache.solr.analysis.TokenizerChain.TokenizerChain
 */
public final class TokenizerChain extends Analyzer {

    private final CharFilterFactory[] charFilters;

    private final TokenizerFactory tokenizer;

    private final TokenFilterFactory[] filters;

    TokenizerChain(CharFilterFactory[] charFilters, TokenizerFactory tokenizer, TokenFilterFactory[] filters) {
        this.charFilters = charFilters != null ? charFilters : new CharFilterFactory[0];
        this.tokenizer = tokenizer;
        this.filters = filters != null ? filters : new TokenFilterFactory[0];
    }

    @Override
    public Reader initReader(final String fieldName, final Reader reader) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Reader initReaderForNormalization(String fieldName, Reader reader) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected TokenStream normalize(String fieldName, TokenStream in) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
