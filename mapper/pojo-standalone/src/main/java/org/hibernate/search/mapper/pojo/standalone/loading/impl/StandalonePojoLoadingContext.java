/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.mapper.pojo.standalone.loading.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.hibernate.search.engine.tenancy.spi.TenancyMode;
import org.hibernate.search.mapper.pojo.loading.spi.PojoSelectionLoadingContext;
import org.hibernate.search.mapper.pojo.massindexing.MassIndexingDefaultCleanOperation;
import org.hibernate.search.mapper.pojo.massindexing.spi.PojoMassIndexingContext;
import org.hibernate.search.mapper.pojo.model.spi.PojoRuntimeIntrospector;
import org.hibernate.search.mapper.pojo.standalone.loading.MassLoadingOptions;
import org.hibernate.search.mapper.pojo.standalone.loading.SelectionLoadingOptions;
import org.hibernate.search.mapper.pojo.standalone.loading.dsl.SelectionLoadingOptionsStep;
import org.hibernate.search.mapper.pojo.standalone.massindexing.impl.StandalonePojoMassIndexingMappingContext;

public final class StandalonePojoLoadingContext implements PojoSelectionLoadingContext, PojoMassIndexingContext, MassLoadingOptions, SelectionLoadingOptions {

    private final StandalonePojoMassIndexingMappingContext mappingContext;

    private final Set<String> tenantIds;

    private final TenancyMode tenancyMode;

    private int batchSize = 10;

    private final Map<Class<?>, Object> contextData;

    private StandalonePojoLoadingContext(Builder builder) {
        this.mappingContext = builder.mappingContext;
        this.contextData = builder.contextData;
        this.tenantIds = builder.tenantIds == null ? Set.of() : builder.tenantIds;
        this.tenancyMode = builder.tenancyMode;
    }

    public void batchSize(int batchSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int batchSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <T> void context(Class<T> contextType, T context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T context(Class<T> contextType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void checkOpen() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PojoRuntimeIntrospector runtimeIntrospector() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public StandalonePojoMassIndexingMappingContext mapping() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<String> tenantIds() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TenancyMode tenancyMode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MassIndexingDefaultCleanOperation massIndexingDefaultCleanOperation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static final class Builder implements StandalonePojoSelectionLoadingContextBuilder, SelectionLoadingOptionsStep {

        private final StandalonePojoMassIndexingMappingContext mappingContext;

        private final Map<Class<?>, Object> contextData = new HashMap<>();

        private Set<String> tenantIds;

        private TenancyMode tenancyMode;

        public Builder(StandalonePojoMassIndexingMappingContext mappingContext) {
            this.mappingContext = mappingContext;
        }

        @Override
        public SelectionLoadingOptionsStep toAPI() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public <T> void context(Class<T> contextType, T context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder tenantIds(Set<String> tenantIds) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder tenancyMode(TenancyMode tenancyMode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public StandalonePojoLoadingContext build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
