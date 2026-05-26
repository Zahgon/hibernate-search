/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.types.predicate.parse.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.hibernate.search.backend.lucene.lowlevel.common.impl.AnalyzerConstants;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.BytesRefBuilder;

/**
 * Copied and adapted from {@code org.apache.lucene.queryparser.classic.QueryParserBase#analyzeWildcard}
 * of <a href="https://github.com/apache/lucene-solr">Apache Lucene and Solr</a>.
 * <p>
 * Allows to normalize a wildcard expression term.
 */
public class LuceneWildcardExpressionHelper {

    private static final Pattern WILDCARD_PATTERN = Pattern.compile("(\\\\.)|([?*]+)");

    private LuceneWildcardExpressionHelper() {
    }

    public static BytesRef analyzeWildcard(Analyzer analyzer, String field, String termStr) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
