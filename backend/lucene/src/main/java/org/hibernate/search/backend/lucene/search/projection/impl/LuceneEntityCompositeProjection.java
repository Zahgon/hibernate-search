/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.projection.impl;

import org.hibernate.search.backend.lucene.reporting.impl.LuceneSearchHints;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.engine.search.projection.spi.ProjectionTypeKeys;

public class LuceneEntityCompositeProjection<E> extends AbstractLuceneProjection<E> {

    private final LuceneSearchProjection<E> delegate;

    public LuceneEntityCompositeProjection(LuceneSearchIndexScope<?> scope, LuceneSearchProjection<E> delegate) {
        super(scope);
        this.delegate = delegate;
    }

    @Override
    public Extractor<?, E> request(ProjectionRequestContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
