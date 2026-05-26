/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.search.projection.dsl.impl;

import org.hibernate.search.backend.elasticsearch.search.projection.dsl.ElasticsearchSearchProjectionFactory;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ElasticsearchSearchProjectionIndexScope;
import org.hibernate.search.engine.search.projection.dsl.ExtendedSearchProjectionFactory;
import org.hibernate.search.engine.search.projection.dsl.ProjectionFinalStep;
import org.hibernate.search.engine.search.projection.dsl.spi.AbstractSearchProjectionFactory;
import org.hibernate.search.engine.search.projection.dsl.spi.SearchProjectionDslContext;
import org.hibernate.search.engine.search.projection.dsl.spi.StaticProjectionFinalStep;
import com.google.gson.JsonObject;

public class ElasticsearchSearchProjectionFactoryImpl<SR, R, E> extends AbstractSearchProjectionFactory<SR, ElasticsearchSearchProjectionFactory<SR, R, E>, ElasticsearchSearchProjectionIndexScope<?>, R, E> implements ElasticsearchSearchProjectionFactory<SR, R, E> {

    public ElasticsearchSearchProjectionFactoryImpl(SearchProjectionDslContext<ElasticsearchSearchProjectionIndexScope<?>> dslContext) {
        super(dslContext);
    }

    @Override
    public ElasticsearchSearchProjectionFactory<SR, R, E> withRoot(String objectFieldPath) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <SR2> ExtendedSearchProjectionFactory<SR2, ?, R, E> withScopeRoot(Class<SR2> scopeRootType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectionFinalStep<JsonObject> source() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectionFinalStep<JsonObject> explanation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectionFinalStep<JsonObject> jsonHit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
