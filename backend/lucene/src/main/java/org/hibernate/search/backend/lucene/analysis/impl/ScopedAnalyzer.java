/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.analysis.impl;

import java.util.HashMap;
import java.util.Map;
import org.hibernate.search.backend.lucene.lowlevel.common.impl.AnalyzerConstants;
import org.hibernate.search.util.common.impl.CollectionHelper;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.DelegatingAnalyzerWrapper;

public final class ScopedAnalyzer extends DelegatingAnalyzerWrapper {

    private final Map<String, Analyzer> scopedAnalyzers;

    private ScopedAnalyzer(Map<String, Analyzer> scopedAnalyzers) {
        super(PER_FIELD_REUSE_STRATEGY);
        this.scopedAnalyzers = CollectionHelper.toImmutableMap(scopedAnalyzers);
    }

    @Override
    protected Analyzer getWrappedAnalyzer(String absoluteFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder {

        private final Map<String, Analyzer> scopedAnalyzers = new HashMap<>();

        public void setAnalyzer(String absoluteFieldPath, Analyzer analyzer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ScopedAnalyzer build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
