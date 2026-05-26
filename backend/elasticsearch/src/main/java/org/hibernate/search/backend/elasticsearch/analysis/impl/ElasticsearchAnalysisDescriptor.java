/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.analysis.impl;

import java.util.Objects;
import org.hibernate.search.engine.backend.analysis.AnalyzerDescriptor;
import org.hibernate.search.engine.backend.analysis.NormalizerDescriptor;

public class ElasticsearchAnalysisDescriptor implements AnalyzerDescriptor, NormalizerDescriptor {

    private final String name;

    public ElasticsearchAnalysisDescriptor(String name) {
        this.name = name;
    }

    @Override
    public String name() {
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
