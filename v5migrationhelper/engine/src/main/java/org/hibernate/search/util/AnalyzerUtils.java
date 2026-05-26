/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.util;

import java.io.IOException;
import java.io.StringReader;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.search.util.logging.impl.LoggerFactory;
import org.hibernate.search.util.logging.impl.MigrationHelperLog;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

/**
 * Helper class to hide boilerplate code when using Lucene Analyzers.
 *
 * <p>Taken and modified from <i>Lucene in Action</i>.
 *
 * @author Hardy Ferentschik
 * @deprecated Will be removed without replacement.
 */
@Deprecated
public final class AnalyzerUtils {

    private AnalyzerUtils() {
        //not allowed
    }

    public static final MigrationHelperLog log = LoggerFactory.make(MethodHandles.lookup());

    public static List<String> tokenizedTermValues(Analyzer analyzer, String field, String text) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
