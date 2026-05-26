/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.analysis.impl;

import java.util.Objects;
import org.hibernate.search.engine.backend.analysis.AnalyzerDescriptor;
import org.hibernate.search.engine.backend.analysis.NormalizerDescriptor;
import org.apache.lucene.analysis.Analyzer;

public class LuceneAnalysisDescriptor implements AnalyzerDescriptor, NormalizerDescriptor {

    protected final String name;

    protected final Analyzer analyzer;

    public LuceneAnalysisDescriptor(String name, Analyzer analyzer) {
        this.name = name;
        this.analyzer = analyzer;
    }

    @Override
    public String name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Analyzer analyzer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object object) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
