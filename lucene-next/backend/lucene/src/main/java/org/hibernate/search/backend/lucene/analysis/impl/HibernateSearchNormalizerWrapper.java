/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.analysis.impl;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.AnalyzerWrapper;

public final class HibernateSearchNormalizerWrapper extends AnalyzerWrapper {

    private final String normalizerName;

    private final Analyzer delegate;

    HibernateSearchNormalizerWrapper(String normalizerName, Analyzer delegate) {
        super(delegate.getReuseStrategy());
        this.normalizerName = normalizerName;
        this.delegate = delegate;
    }

    @Override
    protected Analyzer getWrappedAnalyzer(String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected TokenStreamComponents wrapComponents(String fieldName, TokenStreamComponents components) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
