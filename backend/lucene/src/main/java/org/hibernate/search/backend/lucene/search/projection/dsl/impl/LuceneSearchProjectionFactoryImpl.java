/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.search.projection.dsl.impl;

import org.hibernate.search.backend.lucene.search.projection.dsl.DocumentTree;
import org.hibernate.search.backend.lucene.search.projection.dsl.LuceneSearchProjectionFactory;
import org.hibernate.search.backend.lucene.search.projection.impl.LuceneSearchProjectionIndexScope;
import org.hibernate.search.engine.search.projection.dsl.ExtendedSearchProjectionFactory;
import org.hibernate.search.engine.search.projection.dsl.ProjectionFinalStep;
import org.hibernate.search.engine.search.projection.dsl.spi.AbstractSearchProjectionFactory;
import org.hibernate.search.engine.search.projection.dsl.spi.SearchProjectionDslContext;
import org.hibernate.search.engine.search.projection.dsl.spi.StaticProjectionFinalStep;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.Explanation;

public class LuceneSearchProjectionFactoryImpl<SR, R, E> extends AbstractSearchProjectionFactory<SR, LuceneSearchProjectionFactory<SR, R, E>, LuceneSearchProjectionIndexScope<?>, R, E> implements LuceneSearchProjectionFactory<SR, R, E> {

    public LuceneSearchProjectionFactoryImpl(SearchProjectionDslContext<LuceneSearchProjectionIndexScope<?>> dslContext) {
        super(dslContext);
    }

    @Override
    public LuceneSearchProjectionFactory<SR, R, E> withRoot(String objectFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <SR2> ExtendedSearchProjectionFactory<SR2, ?, R, E> withScopeRoot(Class<SR2> scopeRootType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectionFinalStep<Document> document() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectionFinalStep<Explanation> explanation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectionFinalStep<DocumentTree> documentTree() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
