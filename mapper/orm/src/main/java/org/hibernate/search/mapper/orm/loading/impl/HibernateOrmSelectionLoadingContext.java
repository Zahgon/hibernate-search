/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.orm.loading.impl;

import jakarta.persistence.EntityGraph;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.graph.GraphSemantic;
import org.hibernate.graph.RootGraph;
import org.hibernate.search.mapper.orm.loading.spi.EntityGraphHint;
import org.hibernate.search.mapper.orm.loading.spi.HibernateOrmLoadingMappingContext;
import org.hibernate.search.mapper.orm.loading.spi.HibernateOrmLoadingSessionContext;
import org.hibernate.search.mapper.orm.loading.spi.MutableEntityLoadingOptions;
import org.hibernate.search.mapper.orm.logging.impl.OrmMiscLog;
import org.hibernate.search.mapper.orm.search.loading.EntityLoadingCacheLookupStrategy;
import org.hibernate.search.mapper.orm.search.loading.dsl.SearchLoadingOptionsStep;
import org.hibernate.search.mapper.pojo.loading.spi.PojoSelectionLoadingContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoSelectionLoadingContextBuilder;
import org.hibernate.search.mapper.pojo.model.spi.PojoRuntimeIntrospector;
import org.hibernate.search.util.common.impl.Contracts;

public final class HibernateOrmSelectionLoadingContext implements PojoSelectionLoadingContext {

    private final HibernateOrmLoadingSessionContext sessionContext;

    private final MutableEntityLoadingOptions loadingOptions;

    private final EntityLoadingCacheLookupStrategy cacheLookupStrategy;

    private HibernateOrmSelectionLoadingContext(Builder builder) {
        sessionContext = builder.sessionContext;
        loadingOptions = builder.loadingOptions;
        cacheLookupStrategy = builder.cacheLookupStrategy;
    }

    @Override
    public void checkOpen() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoRuntimeIntrospector runtimeIntrospector() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public HibernateOrmLoadingSessionContext sessionContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SessionImplementor sessionImplementor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MutableEntityLoadingOptions loadingOptions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public EntityLoadingCacheLookupStrategy cacheLookupStrategy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static final class Builder implements PojoSelectionLoadingContextBuilder<SearchLoadingOptionsStep>, SearchLoadingOptionsStep {

        private final HibernateOrmLoadingSessionContext sessionContext;

        private final MutableEntityLoadingOptions loadingOptions;

        private EntityLoadingCacheLookupStrategy cacheLookupStrategy;

        public Builder(HibernateOrmLoadingMappingContext mappingContext, HibernateOrmLoadingSessionContext sessionContext) {
            this.sessionContext = sessionContext;
            this.loadingOptions = new MutableEntityLoadingOptions(mappingContext);
            this.cacheLookupStrategy = mappingContext.cacheLookupStrategy();
        }

        @Override
        public SearchLoadingOptionsStep toAPI() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchLoadingOptionsStep fetchSize(int fetchSize) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchLoadingOptionsStep cacheLookupStrategy(EntityLoadingCacheLookupStrategy strategy) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchLoadingOptionsStep graph(EntityGraph<?> graph, GraphSemantic semantic) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public SearchLoadingOptionsStep graph(String graphName, GraphSemantic semantic) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public PojoSelectionLoadingContext build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
