/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.impl;

import java.lang.invoke.MethodHandles;
import java.util.Set;
import java.util.stream.Collectors;
import org.hibernate.search.SearchFactory;
import org.hibernate.search.backend.lucene.LuceneBackend;
import org.hibernate.search.backend.lucene.index.LuceneIndexManager;
import org.hibernate.search.mapper.orm.entity.SearchIndexedEntity;
import org.hibernate.search.mapper.orm.mapping.SearchMapping;
import org.hibernate.search.query.dsl.QueryContextBuilder;
import org.hibernate.search.spi.SearchIntegrator;
import org.hibernate.search.util.logging.impl.LoggerFactory;
import org.hibernate.search.util.logging.impl.MigrationHelperLog;
import org.apache.lucene.analysis.Analyzer;

/**
 * Implementation of the public API: a simple delegate to the actual implementor.
 *
 * @author Sanne Grinovero (C) 2014 Red Hat Inc.
 * @since 5.0
 */
final class SearchFactoryImpl implements SearchFactory {

    public static final MigrationHelperLog log = LoggerFactory.make(MethodHandles.lookup());

    private final V5MigrationOrmSearchIntegratorAdapter searchIntegrator;

    public SearchFactoryImpl(V5MigrationOrmSearchIntegratorAdapter searchIntegrator) {
        this.searchIntegrator = searchIntegrator;
    }

    @Override
    public void optimize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void optimize(Class<?> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Analyzer getAnalyzer(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Analyzer getAnalyzer(Class<?> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public QueryContextBuilder buildQueryBuilder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<Class<?>> getIndexedTypes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> T unwrap(Class<T> cls) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
