/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch;

import java.util.Optional;
import org.hibernate.search.backend.elasticsearch.logging.impl.ElasticsearchMiscLog;
import org.hibernate.search.backend.elasticsearch.schema.management.ElasticsearchIndexSchemaExport;
import org.hibernate.search.backend.elasticsearch.search.aggregation.dsl.ElasticsearchSearchAggregationFactory;
import org.hibernate.search.backend.elasticsearch.search.predicate.dsl.ElasticsearchSearchPredicateFactory;
import org.hibernate.search.backend.elasticsearch.search.projection.dsl.ElasticsearchSearchProjectionFactory;
import org.hibernate.search.backend.elasticsearch.search.query.ElasticsearchSearchQuery;
import org.hibernate.search.backend.elasticsearch.search.query.dsl.ElasticsearchSearchQuerySelectStep;
import org.hibernate.search.backend.elasticsearch.search.query.dsl.impl.ElasticsearchSearchQuerySelectStepImpl;
import org.hibernate.search.backend.elasticsearch.search.query.impl.ElasticsearchSearchQueryIndexScope;
import org.hibernate.search.backend.elasticsearch.search.sort.dsl.ElasticsearchSearchSortFactory;
import org.hibernate.search.backend.elasticsearch.types.dsl.ElasticsearchIndexFieldTypeFactory;
import org.hibernate.search.engine.backend.session.spi.BackendSessionContext;
import org.hibernate.search.engine.backend.types.dsl.IndexFieldTypeFactory;
import org.hibernate.search.engine.backend.types.dsl.IndexFieldTypeFactoryExtension;
import org.hibernate.search.engine.common.schema.management.SchemaExport;
import org.hibernate.search.engine.common.schema.management.SchemaExportExtension;
import org.hibernate.search.engine.search.aggregation.dsl.SearchAggregationFactory;
import org.hibernate.search.engine.search.aggregation.dsl.SearchAggregationFactoryExtension;
import org.hibernate.search.engine.search.loading.spi.SearchLoadingContext;
import org.hibernate.search.engine.search.loading.spi.SearchLoadingContextBuilder;
import org.hibernate.search.engine.search.predicate.dsl.SearchPredicateFactory;
import org.hibernate.search.engine.search.predicate.dsl.SearchPredicateFactoryExtension;
import org.hibernate.search.engine.search.projection.dsl.SearchProjectionFactory;
import org.hibernate.search.engine.search.projection.dsl.SearchProjectionFactoryExtension;
import org.hibernate.search.engine.search.query.SearchQuery;
import org.hibernate.search.engine.search.query.SearchQueryExtension;
import org.hibernate.search.engine.search.query.dsl.SearchQueryDslExtension;
import org.hibernate.search.engine.search.query.dsl.SearchQuerySelectStep;
import org.hibernate.search.engine.search.query.spi.SearchQueryIndexScope;
import org.hibernate.search.engine.search.sort.dsl.SearchSortFactory;
import org.hibernate.search.engine.search.sort.dsl.SearchSortFactoryExtension;

/**
 * An extension for the Elasticsearch backend, giving access to Elasticsearch-specific features.
 * <p>
 * <strong>WARNING:</strong> while this type is API, because instances should be manipulated by users,
 * all of its methods are considered SPIs and therefore should never be called directly by users.
 * In short, users are only expected to get instances of this type from an API and pass it to another API.
 *
 * @param <H> The type of query hits.
 * Users should not have to care about this, as the parameter will automatically take the appropriate value when calling
 * {@code .extension( ElasticsearchExtension.get() }.
 * @param <R> The entity reference type for projections.
 * Users should not have to care about this, as the parameter will automatically take the appropriate value when calling
 * {@code .extension( ElasticsearchExtension.get() }.
 * @param <E> The entity type for projections.
 * Users should not have to care about this, as the parameter will automatically take the appropriate value when calling
 * {@code .extension( ElasticsearchExtension.get() }.
 * @param <LOS> The type of the initial step of the loading options definition DSL.
 * Users should not have to care about this, as the parameter will automatically take the appropriate value when calling
 * {@code .extension( ElasticsearchExtension.get() }.
 *
 * @see #get()
 */
public final class ElasticsearchExtension<SR, H, R, E, LOS> implements SearchQueryDslExtension<SR, ElasticsearchSearchQuerySelectStep<SR, R, E, LOS>, R, E, LOS>, SearchQueryExtension<ElasticsearchSearchQuery<H>, H>, SearchPredicateFactoryExtension<ElasticsearchSearchPredicateFactory<SR>>, SearchSortFactoryExtension<ElasticsearchSearchSortFactory<SR>>, SearchProjectionFactoryExtension<ElasticsearchSearchProjectionFactory<SR, R, E>, R, E>, SearchAggregationFactoryExtension<ElasticsearchSearchAggregationFactory<SR>>, IndexFieldTypeFactoryExtension<ElasticsearchIndexFieldTypeFactory>, SchemaExportExtension<ElasticsearchIndexSchemaExport> {

    private static final ElasticsearchExtension<Object, Object, Object, Object, Object> INSTANCE = new ElasticsearchExtension<>();

    /**
     * Get the extension with generic parameters automatically set as appropriate for the context in which it's used.
     *
     * @param <SR> Scope root type.
     * @param <H> The type of query hits.
     * Users should not have to care about this, as the parameter will automatically take the appropriate value when calling
     * {@code .extension( ElasticsearchExtension.get() )}.
     * @param <R> The entity reference type for projections.
     * Users should not have to care about this, as the parameter will automatically take the appropriate value when calling
     * {@code .extension( ElasticsearchExtension.get() )}.
     * @param <E> The entity type for projections.
     * Users should not have to care about this, as the parameter will automatically take the appropriate value when calling
     * {@code .extension( ElasticsearchExtension.get() )}.
     * @param <LOS> The type of the initial step of the loading options definition DSL.
     * Users should not have to care about this, as the parameter will automatically take the appropriate value when calling
     * {@code .extension( ElasticsearchExtension.get() )}.
     * @return The extension.
     */
    // The instance works for any H, R, E and LOS
    @SuppressWarnings("unchecked")
    public static <SR, H, R, E, LOS> ElasticsearchExtension<SR, H, R, E, LOS> get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private ElasticsearchExtension() {
        // Private constructor, use get() instead.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<ElasticsearchSearchQuerySelectStep<SR, R, E, LOS>> extendOptional(SearchQuerySelectStep<SR, ?, R, E, LOS, ?, ?> original, SearchQueryIndexScope<SR, ?> scope, BackendSessionContext sessionContext, SearchLoadingContextBuilder<E, LOS> loadingContextBuilder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<ElasticsearchSearchQuery<H>> extendOptional(SearchQuery<H> original, SearchLoadingContext<?> loadingContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public Optional<ElasticsearchSearchPredicateFactory<SR>> extendOptional(SearchPredicateFactory original) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public Optional<ElasticsearchSearchSortFactory<SR>> extendOptional(SearchSortFactory original) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public Optional<ElasticsearchSearchProjectionFactory<SR, R, E>> extendOptional(SearchProjectionFactory<R, E> original) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public Optional<ElasticsearchSearchAggregationFactory<SR>> extendOptional(SearchAggregationFactory original) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ElasticsearchIndexFieldTypeFactory extendOrFail(IndexFieldTypeFactory original) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ElasticsearchIndexSchemaExport extendOrFail(SchemaExport original) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
