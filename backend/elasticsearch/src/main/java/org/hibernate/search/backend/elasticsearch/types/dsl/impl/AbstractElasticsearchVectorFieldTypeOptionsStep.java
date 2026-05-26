/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.types.dsl.impl;

import org.hibernate.search.backend.elasticsearch.logging.impl.MappingLog;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.mapping.impl.PropertyMapping;
import org.hibernate.search.backend.elasticsearch.search.predicate.impl.ElasticsearchExistsPredicate;
import org.hibernate.search.backend.elasticsearch.search.projection.impl.ElasticsearchFieldProjection;
import org.hibernate.search.backend.elasticsearch.types.codec.impl.AbstractElasticsearchVectorFieldCodec;
import org.hibernate.search.backend.elasticsearch.types.impl.ElasticsearchIndexValueFieldType;
import org.hibernate.search.backend.elasticsearch.types.mapping.impl.ElasticsearchVectorFieldTypeMappingContributor;
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.VectorSimilarity;
import org.hibernate.search.engine.backend.types.dsl.VectorFieldTypeOptionsStep;
import org.hibernate.search.engine.search.predicate.spi.PredicateTypeKeys;
import org.hibernate.search.engine.search.projection.spi.ProjectionTypeKeys;
import org.hibernate.search.util.common.AssertionFailure;

abstract class AbstractElasticsearchVectorFieldTypeOptionsStep<S extends AbstractElasticsearchVectorFieldTypeOptionsStep<?, F>, F> extends AbstractElasticsearchIndexFieldTypeOptionsStep<S, F> implements VectorFieldTypeOptionsStep<S, F>, ElasticsearchVectorFieldTypeMappingContributor.Context {

    private final ElasticsearchVectorFieldTypeMappingContributor mappingContributor;

    protected VectorSimilarity vectorSimilarity = VectorSimilarity.DEFAULT;

    protected Integer dimension;

    protected Integer efConstruction;

    protected Integer m;

    protected F indexNullAs;

    private Projectable projectable = Projectable.DEFAULT;

    private Searchable searchable = Searchable.DEFAULT;

    AbstractElasticsearchVectorFieldTypeOptionsStep(ElasticsearchIndexFieldTypeBuildContext buildContext, Class<F> fieldType, ElasticsearchVectorFieldTypeMappingContributor mappingContributor) {
        super(buildContext, fieldType, new PropertyMapping());
        this.mappingContributor = mappingContributor;
    }

    @Override
    public S searchable(Searchable searchable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S projectable(Projectable projectable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S indexNullAs(F indexNullAs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S vectorSimilarity(VectorSimilarity vectorSimilarity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S efConstruction(int efConstruction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S m(int m) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S dimension(int dimension) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ElasticsearchIndexValueFieldType<F> toIndexFieldType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract AbstractElasticsearchVectorFieldCodec<F> createCodec(VectorSimilarity vectorSimilarity, int dimension, Integer m, Integer efConstruction, F indexNullAs);

    protected static boolean resolveDefault(Projectable projectable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static boolean resolveDefault(Searchable searchable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public abstract String type();

    @Override
    public boolean searchable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public VectorSimilarity vectorSimilarity() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int dimension() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Integer efConstruction() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Integer m() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
