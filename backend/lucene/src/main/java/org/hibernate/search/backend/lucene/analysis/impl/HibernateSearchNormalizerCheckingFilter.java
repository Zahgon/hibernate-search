/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.analysis.impl;

import java.io.IOException;
import org.hibernate.search.backend.lucene.logging.impl.AnalysisLog;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

final class HibernateSearchNormalizerCheckingFilter extends TokenFilter {

    private static final char TOKEN_SEPARATOR = ' ';

    private final String normalizerName;

    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);

    private final StringBuilder concatenatedTokenBuilder = new StringBuilder();

    HibernateSearchNormalizerCheckingFilter(TokenStream input, String normalizerName) {
        super(input);
        this.normalizerName = normalizerName;
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
    public boolean incrementToken() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
