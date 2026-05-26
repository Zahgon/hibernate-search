/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.analysis.model.dsl.impl;

import java.io.IOException;
import java.util.List;
import java.util.function.IntFunction;
import org.hibernate.search.backend.lucene.analysis.impl.LuceneAnalysisComponentFactory;

interface LuceneAnalysisComponentBuilder<T> {

    T build(LuceneAnalysisComponentFactory factory) throws IOException;

    static <T> T[] buildAll(List<? extends LuceneAnalysisComponentBuilder<T>> builders, IntFunction<T[]> arraySupplier, LuceneAnalysisComponentFactory factory) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
